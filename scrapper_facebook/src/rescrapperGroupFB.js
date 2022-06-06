import asyncForEach from '@pierreminiggio/async-foreach'
import getLinkMobile from './getLinkMobile.js'
import getLinkMobileBasic from './getLinkMobileBasic.js'
import getGroupeInfo from './getGroupeInfo.js'
import InsertGroupe from './InsertGroupe.js'
import UpdateGroupe from './UpdateGroupe.js'
import InsertUtilisateur from './InsertUtilisateur.js'
import getIdUtilisateur from './getIdUtilisateur.js'
import InsertGroupeUtilisateur from './InsertGroupeUtilisateur.js'
import InsertModerateurAdministrateur from './InsertModerateurAdministrateur.js'
import dbconnect from './dbconnection.js'
import getGroupesAmbassadeurReleve from './getGroupesAmbassadeurReleve.js'
import UpdateStatutReleveGroupe from './UpdateStatutReleveGroupe.js'
import UpdateActifSupprime from './UpdateActifSupprime.js'


/**
 * @param {import("puppeteer").Page} page
 * @param {Number} id_ambassadeur
 * @param {string} rapport
 * @returns {Promise<string[[]]>}
 */
export default (page,id_ambassadeur,rapport) => {
    return new Promise(async resolve => {
        const LinkGroup = []
	        var db = dbconnect()
                var avancement = 1
                var groupes_echoues = []
                var groupes_reussits = []
                var temps = 0
                
	            const groupes = await getGroupesAmbassadeurReleve(db,id_ambassadeur)
                console.log('\nNombre de groupes récuperés depuis la base de données : '+groupes.length+' groupes\n')

                await asyncForEach(groupes, async Groupe => {
			         var groupLink = Groupe.id_groupe
			         var nom = Groupe.nom
                     var startTime = new Date().getTime();
                    var elapsedTime = 0
                    var infos = 'existe pas'
                
                    var scrappe = 'echoué'
			        const groupe = await getGroupeInfo (db,groupLink,page,avancement)

				    if (groupe){
				        nom = groupe.nom
				        
				        var insertTheme = 'existe pas'
                        if (groupe.theme) { 
                            insertTheme = groupe.theme
                        }
                        var insertPostMois = 0
                        if (groupe.postMois) { 
                            insertPostMois = groupe.postMois
                        }
                        
                        var insertReglementation = 'existe pas'
                        if   (groupe.reglementation)  {insertReglementation = groupe.reglementation}
                        
                        var insertFormat = 'Classique'
                        if (groupe.format) { insertFormat = groupe.format}
                        
                        var insertLieu = 'existe pas'
                        if   (groupe.lieu)  {insertLieu = groupe.lieu}
                        infos = 'Nom : '+nom +', Nb_membres : '+ groupe.nb_membres+', Theme : '+insertTheme+', Type : '+groupe.type+', Reglementation : '+ insertReglementation +', Fréquence posts par mois : '+insertPostMois+', Format : '+insertFormat+', Lieu : '+insertLieu
                       
                        if (groupe.AdminEtMode) {
                                infos = infos + ', Administrateurs et modérateurs : '
                                await asyncForEach(groupe.AdminEtMode, async admin => {
                                    const nomAdmin = admin.nom.split(' ').slice(1).join(' ')
                                    const prenomAdmin = admin.nom.split(' ')[0]
                                     
                                    const linkAdmin = admin.link
                                    var id_utilisateur = await getIdUtilisateur(nomAdmin,db)

                                    if (!id_utilisateur){

                                        var err = await InsertUtilisateur(db,nomAdmin,prenomAdmin,'',linkAdmin)
                                        await page.waitForTimeout(3000) 
                                        id_utilisateur = await getIdUtilisateur(nomAdmin,db)
                                    }
                                        var err = await InsertGroupeUtilisateur(db,groupLink,id_utilisateur)
                                        err = await InsertModerateurAdministrateur(db,id_utilisateur,admin.role)
                                    infos = infos + '[Prenom : '+prenomAdmin+', Nom : '+nomAdmin+', Role : '+admin.role+', Lien : '+linkAdmin+'], ' 
                                })
                                infos = infos.substr(0,infos.length-2)
                        }
                        var today = new Date()
                        var jour = ''+(today.getDate())
					    var mois = ''+(today.getMonth()+1)
					     	if ((today.getDate())<10){
						           jour = '0'+jour
						    }

						    if ((today.getMonth()+1)<10){
						           mois = '0'+mois
						    }
                        const date_releve = today.getFullYear()+'-'+mois+'-'+jour+' '+today.getHours()+':'+today.getMinutes()+':'+today.getSeconds()
                        scrappe = 'réussit'
                        var err = await UpdateGroupe(db,groupLink,groupe.nom,'',groupe.nb_membres,insertTheme,groupe.type,insertReglementation,groupLink+'/about',insertPostMois,insertFormat,insertLieu,'scrappé',date_releve)
                        err = await UpdateStatutReleveGroupe(db,groupLink,'relevé')
                        err = await UpdateActifSupprime(db,groupLink,'actif')
                        groupes_reussits.push({nom: nom,lien: groupLink, infos: infos})
                    }else{
                        groupes_echoues.push({nom: nom,lien: groupLink})
                    }
                    elapsedTime = new Date().getTime() - startTime; 
                    temps = temps + elapsedTime/1000
                    const temps_estime = elapsedTime/1000 * (groupes.length-avancement)
                    var heures_estime =  Math.floor(temps_estime/3600)
                    var minutes_estime =  Math.floor((temps_estime-heures_estime*3600)/60)
                    console.log('\nLe releve des infos du groupe de lien : '+groupLink+', de nom : '+nom+' est '+scrappe)
                    console.log('\nInfos : '+infos+'\n')
                    console.log('Avancement des groupes relevés : ' +avancement+' groupes sur le totale de : '+groupes.length+ ', Taux : '+Math.floor(avancement/groupes.length*100)+'%\n')
                    if (heures_estime == 0){
                        console.log('Temps estimé pour terminer le releve : '+minutes_estime+' minutes\n')
                    }else{
                        console.log('Temps estimé pour terminer le releve : '+heures_estime+' heures et '+minutes_estime+' minutes\n')
                    }
                       
			        avancement = avancement + 1
 
	        })
	           
	           console.log('\nFin Script\n')
	           var heures =  Math.floor(temps/3600)
               var minutes =  Math.floor((temps-heures*3600)/60)
	           if (groupes.length == 0){
	                rapport = rapport +'\nRapport'
	                rapport = rapport +'Aucun groupe est récuperé depuis la base\n'
	           }else{
	               var today = new Date()
	               rapport = rapport +'\n| Report Releve Infos Groupes"'+today.toString()+'" |'
	               rapport = rapport +' --  Groupes dans la liste : '+groupes.length
	               rapport = rapport +' Groupes relevés : '+groupes_reussits.length
	               rapport = rapport +' Groupes non relevés : '+groupes_echoues.length
	               
	           }
	           rapport = rapport +'\nTemps totale de releve : '+heures+' heures et '+heures+' minutes\n'
	           console.log(rapport)
        resolve(LinkGroup)
    })
}

