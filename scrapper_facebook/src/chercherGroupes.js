import scroll from '@pierreminiggio/puppeteer-page-scroller'
import asyncForEach from '@pierreminiggio/async-foreach'
import getLinkMobile from './getLinkMobile.js'
import getGroupeCampagne from './getGroupeCampagne.js'
import InsertGroupe from './InsertGroupe.js'
import UpdateGroupeStatutIntegrationMotClee from './UpdateGroupeStatutIntegrationMotClee.js'
import dbconnect from './dbconnection.js'

/**
 * @param {var("puppeteer").Page} page
 * @param {string} mot_clee
 * @param {Number} nb_groupes
 * @param {string} rapport
 * @returns {Promise<string[[]]>}
 */
export default (page,mot_clee,nb_groupes,rapport) => {
    return new Promise(async resolve => {
            const LinkGroup = []
	        var db = dbconnect()
	        
            await page.goto('https://www.facebook.com/groups/search/groups_home/?q='+mot_clee+'&sde=AbotKqEx6VFO7Xg9wiFDgE3hDSnw1teizHLB49vZpXF3bLbxyZ0OOuvrfrGEGCpzofDakrn8opGG9ML5UM4eRoBs')
            
            var groupes_ajoutes = []
            var groupes_non_ajoutes = []
            var temps = 0
            var fini = false
		    do {
		        await scroll(page,3000)
                const groupeSelector = 'div > div:nth-child(1) > div > div > div > div > div > div > div > div > div > div > div > div > div > div'
                
                var groupes =  await page.evaluate( async (groupeSelector) => {
				    var groupes = []
				    const links = []
				    const groupeLinkSelector = 'div > div > div > div > div > div > div > div > div:nth-child(1) > h2 > span > span > span > a'
                    const membreSelector = 'div > div > div > div > div > div > div > div > div:nth-child(2) > span > span > span'
                    
				    const scrapedGroupes = document.querySelectorAll(groupeSelector)
				    scrapedGroupes.forEach(scrapedGroupe => {
				            if (scrapedGroupe.querySelector(groupeLinkSelector)){
				                const scrappedLink = scrapedGroupe.querySelector(groupeLinkSelector).href
				                if (scrappedLink.indexOf('groups') != -1 ){
				                    const scrapedNom = scrapedGroupe.querySelector(groupeLinkSelector).innerText
				                    if (scrapedGroupe.querySelector(membreSelector)){
				                        const scrapedMembre = scrapedGroupe.querySelector(membreSelector).innerText.split('\n')[2].split(' ')[2]
				                        var nb_membres = 0
                                        const MembreString = scrapedMembre
                                        if (MembreString.indexOf('K') != -1 ){
                                                const decimale = MembreString.split(' ')[0]
                                                if (decimale.indexOf(',') != -1 ){
                                                    const naturel = decimale.split(',')[0]
                                                    const aprèsvergule = decimale.split(',')[1]
                                                    nb_membres = parseInt(naturel)*1000 + parseInt(aprèsvergule)*100
                                                }else{
                                                    nb_membres = parseInt(decimale)*1000
                                                }
                                        }else{
                                            nb_membres = parseInt(MembreString)
                                        }
				                        if (!links.includes(scrappedLink) && nb_membres >= 20){
				                            links.push(scrappedLink)
				                            groupes.push({link: scrappedLink, nom: scrapedNom, nb_membres: nb_membres})
				                        }
				                    }
				               }  
				           }
                    })
					   
				        return groupes
                },  groupeSelector)
        
            console.log('groupes trouvés :')
            console.log(groupes)
            
            var avancement = 1
            console.log('Nombre de groupes trouvés dans la recherche : '+groupes.length+' groupes')
            
            await asyncForEach(groupes, async groupe => {
                    var startTime = new Date().getTime();
                    var elapsedTime = 0
                    var ajoute = ''
			         var groupLink = groupe.link.split('/').slice(0,5).join('/')
                     const nom = groupe.nom
                     const nb_membres = groupe.nb_membres
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
                     if (groupes_ajoutes.length < nb_groupes){
                         var err = await InsertGroupe(db,groupLink,nom,'',nb_membres,null,null,null,groupLink+'/about',null)
                         if(err){
                            groupes_non_ajoutes.push(groupLink)
                            ajoute = 'non ajouté'
                         }else{
                             groupes_ajoutes.push(groupLink)
                             ajoute = 'ajouté'
                             err = await UpdateGroupeStatutIntegrationMotClee(db,groupLink,'nouveau groupe',mot_clee,date_releve)
                         }
                     
                         
                        elapsedTime = new Date().getTime() - startTime; 
                        temps = temps + elapsedTime/1000
                        const temps_estime = elapsedTime/1000 * (groupes.length-avancement)
                        var heures_estime =  Math.floor(temps_estime/3600)
                        var minutes_estime =  Math.floor((temps_estime-heures_estime*3600)/60)
                        console.log('Le groupe de lien : '+groupLink+', de nom : '+nom+', est : '+ajoute+', Nombre de membre : '+nb_membres+'\nAvancement des groupes trouvés : ' +avancement+' groupes sur le totale de : '+groupes.length+ ', Taux : '+Math.floor(avancement/groupes.length*100)+'%, pour le mot clée : '+mot_clee)
                        if (heures_estime == 0){
                            console.log('\nTemps estimé pour terminer la recherche : '+minutes_estime+' minutes')
                        }else{
                            console.log('\nTemps estimé pour terminer la recherche : '+heures_estime+' heures et '+minutes_estime+' minutes')
                        }
                           
			            avancement = avancement + 1
			        }
			    
                
	        })
	        if (groupes_ajoutes.length >= nb_groupes){
	            fini = true
	        }
	           
		}while(!fini);
	           console.log('\nFin Script')
	           var heures =  Math.floor(temps/3600)
               var minutes =  Math.floor((temps-heures*3600)/60)
	           var today = new Date()
	           if (groupes.length == 0){
	                rapport = rapport +'\nRapport'
	                rapport = rapport +'Aucun groupe est trouvé dans la recherche'
	           }else{ 
	               rapport = rapport +'\n-| Report Recherche Nouveaux Groupes "'+today.toString()+'" |-'
	               rapport = rapport +'        Mot Clée : '+mot_clee
	               rapport = rapport +'\n --  Groupes trouvés : '+groupes.length
	               rapport = rapport +' Groupes ajoutés : '+groupes_ajoutes.length
	               rapport = rapport +' Groupes déja dans la base : '+(groupes.length-groupes_ajoutes.length)
	           }
	           rapport = rapport +'\nTemps totale de recherche : '+heures+' heures et '+heures+' minutes'
	            console.log(rapport)
            resolve(LinkGroup)
    })
}


