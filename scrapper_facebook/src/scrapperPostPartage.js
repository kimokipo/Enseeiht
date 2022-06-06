import puppeteer from 'puppeteer'
import login from './login.js'
import asyncForEach from '@pierreminiggio/async-foreach'
import getPostContent from './getPostContent.js'
import getPostsCampagne from './getPostsCampagne.js'
import InsertRelevePost from './InsertRelevePost.js'
import dbconnect from './dbconnection.js'
import UpdatePostStatutScrappe from './UpdatePostStatutScrappe.js'
import getIdUtilisateur from './getIdUtilisateur.js'
import InsertUtilisateurInteractionPost from './InsertUtilisateurInteractionPost.js'
import InsertUtilisateur from './InsertUtilisateur.js'
import getAmbassadeursMembresGroupe from './getAmbassadeursMembresGroupe.js'
import getNomCampagne from './getNomCampagne.js'
import UpdateStatutDateReleveCampagne from './UpdateStatutDateReleveCampagne.js'
import UpdateStatutScrappeCampagne from './UpdateStatutScrappeCampagne.js'

/**
 * @param {import("puppeteer").Page} page
 * @param {string} prenom
 * @param {string[]} loginPassword 
 * @param {Number} id_campagne
 * @param {Number} id_releve_campagne
 * @param {string} rapport
 */
export default async function (page,prenom,loginPassword,id_campagne,id_releve_campagne,rapport) {

	await login(page,prenom,loginPassword)
        
                console.log('\nfacebook')
                const postsIds = []
	            var db = dbconnect()
	            var nomCampagne  = getNomCampagne(db,id_campagne)
                var avancement = 1
                var posts_scrappes = []
                var posts_non_scrappes = []
                var posts_traites = []
                var posts_ambassadeur_non_membre = []
                var posts_supprimes = []
                var temps = 0
                const posts = await getPostsCampagne(db,id_campagne)
                console.log('Nombre de posts récuperés depuis la base de données : '+posts.length+' posts')

                await asyncForEach(posts, async Post => {
                        var traite = false
                        var traitement = ''
                        var engagements = ''
                        var ambassadeurs = []
                        var startTime = new Date().getTime();
                        var elapsedTime = 0
                        var scrappe = 'echoué'
			 var scrapedlink = Post.url_post
                        const idPost = Post.id_post
                        const groupLink = Post.id_groupe
                        const statut_scrappe = Post.statut_scrappe
                        if (!statut_scrappe){
				            const post = await getPostContent(page, scrapedlink)
				            if (post.contenu.localeCompare('error') == 0){
						            const err = await UpdatePostStatutScrappe(db,idPost,'non trouvé')	
						            posts_non_scrappes.push({id: idPost,lien: scrapedlink})	
				            }else{			
					            var today = new Date()
					            var jour = ''+(today.getDate())
					            var mois = ''+(today.getMonth()+1)
					             	if ((today.getDate())<10){
						                   jour = '0'+jour
						            }

						            if ((today.getMonth()+1)<10){
						                   mois = '0'+mois
						            }
                                const date = today.getFullYear()+'-'+mois+'-'+jour
                                
                                var err = await InsertRelevePost(db,date,post.likeurs.length,post.comments.length,post.partageurs.length,null,null,null,idPost,id_releve_campagne)
                                err = await UpdatePostStatutScrappe(db,idPost,'scrappé')
                                await asyncForEach(post.likeurs, async likeur => {
                                    const prenom = likeur.name.split(' ')[0]
                                    const nom =  likeur.name.split(' ').slice(1).join(' ')
                                    const lien = likeur.link
                                    var id_utilisateur = await getIdUtilisateur(nom,db)

                                    if (!id_utilisateur){

                                        var err = await InsertUtilisateur(db,nom,prenom,'',lien)
                                        await page.waitForTimeout(3000) 
                                        id_utilisateur = await getIdUtilisateur(nom,db)
                                    }
                                    var err = await InsertUtilisateurInteractionPost(db,idPost,id_utilisateur,'a Liké')
                                })
                                
                                await asyncForEach(post.comments, async comment => {
                                    const prenom = comment.author.name.split(' ')[0]
                                    const nom =  comment.author.name.split(' ').slice(1).join(' ')
                                    const lien = comment.author.link
                                    var id_utilisateur = await getIdUtilisateur(nom,db)

                                    if (!id_utilisateur){

                                        var err = await InsertUtilisateur(db,nom,prenom,'',lien)
                                        await page.waitForTimeout(3000) 
                                        id_utilisateur = await getIdUtilisateur(nom,db)
                                    }
                                    var err = await InsertUtilisateurInteractionPost(db,idPost,id_utilisateur,'a Commenté')
                                })
                                await asyncForEach(post.partageurs, async partageur => {
                                    const prenom = partageur.name.split(' ')[0]
                                    const nom =  partageur.name.split(' ').slice(1).join(' ')
                                    const lien = partageur.link
                                    var id_utilisateur = await getIdUtilisateur(nom,db)

                                    if (!id_utilisateur){

                                        var err = await InsertUtilisateur(db,nom,prenom,'',lien)
                                        await page.waitForTimeout(3000) 
                                        id_utilisateur = await getIdUtilisateur(nom,db)
                                    }
                                    var err = await InsertUtilisateurInteractionPost(db,idPost,id_utilisateur,'a Partagé')
                                })
                                scrappe = 'réussit'
                                engagements = 'Nombre de likes : '+post.likeurs.length+', Nombre de comments : '+post.comments.length+', Nombre de shares : '+post.partageurs.length
						        posts_scrappes.push({id: idPost,lien: scrapedlink, engagements: engagements})
                            }
                        }else {
                            ambassadeurs = await getAmbassadeursMembresGroupe(db,groupLink)
                            if (!ambassadeurs){
                                traitement = 'Aucun ambassadeur ne peut pas relever les engagements de ce post car n\'est pas membre du groupe coresspondant de lien : '+groupLink
                                posts_ambassadeur_non_membre.push({id: idPost,lien: scrapedlink,traitement: traitement})
                            }else {
                                traitement = 'Essayer le releve par l\'un des ambassadeurs suivant : '
                                ambassadeurs.forEach(ambassadeur => {
                                    if (prenom.localeCompare(ambassadeur.prenom) == 0){
                                        traitement = 'Le post est supprimé'
                                        posts_supprimes.push({id: idPost,lien: scrapedlink,traitement: traitement})
                                    }else{
                                        if (traitement.indexOf('Le post est supprimé') == -1){
                                            traitement = traitement + ambassadeur.prenom + ', '
                                        }
                                    } 
                                })
                                if (traitement.indexOf('Le post est supprimé') == -1){
                                            traitement = traitement.substr(0,traitement.length-2)
                                }    
                            }
                            err = await UpdatePostStatutScrappe(db,idPost,null)
                            traite = true
                            posts_traites.push({id: idPost,lien: scrapedlink,traitement: traitement})	
                        }
                    elapsedTime = new Date().getTime() - startTime; 
                    temps = temps + elapsedTime/1000
                    const temps_estime = elapsedTime/1000 * (posts.length-avancement)
                    var heures_estime =  Math.floor(temps_estime/3600)
                    var minutes_estime =  Math.floor((temps_estime-heures_estime*3600)/60)
                    if (traite){
                        console.log('Le post d\id : '+idPost+', de lien : '+scrapedlink+' est non trouvé et a été traité\n'+traitement)
                    }else{
                        console.log('Le relevé des engagements du post d\'id : '+idPost+', de lien : '+scrapedlink+' est '+scrappe)
                        console.log(engagements)
                    }
                    console.log('Avancement des posts scrappés de la campagne : '+id_campagne+' : ' +avancement+' posts sur le totale de : '+posts.length+ ', Taux : '+Math.floor(avancement/posts.length*100)+'%')
                    if (heures_estime == 0){
                        console.log('Temps estimé pour terminer le releve : '+minutes_estime+' minutes')
                    }else{
                        console.log('Temps estimé pour terminer le releve : '+heures_estime+' heures et '+minutes_estime+' minutes')
                    }
			        avancement = avancement + 1
 
	        })
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
	           var err = await UpdateStatutDateReleveCampagne(db,id_releve_campagne,'terminé',date_releve)
	           err = UpdateStatutScrappeCampagne(db,id_campagne,null)
	           console.log('Fin Script')
	           var heures =  Math.floor(temps/3600)
               var minutes =  Math.floor((temps-heures*3600)/60)
	           var today = new Date()
	           if (posts.length == 0){
	                rapport = rapport +'\nRapport'
	                rapport = rapport +'Aucun post est récuperé depuis la base'
	           }else{
	               rapport = rapport +'\n| Report Releve Engagements Posts Partagés "'+today.toString()+'" |'
	               rapport = rapport +'        CAMPAGNE N° '+id_campagne
	               rapport = rapport +'        '+nomCampagne+'\n'
	               rapport = rapport +'        Releve CAMPAGNE N° '+id_releve_campagne
	               rapport = rapport +'    Posts Listés : '+posts.length
	               rapport = rapport +'    Posts relevé réussit : '+posts_scrappes.length
	               rapport = rapport +'    Posts relevé Non réussit : '+posts_non_scrappes.length
	               rapport = rapport +'    Posts Non trouvés et traités : '+posts_traites.length
	               rapport = rapport +'\n       ++ ACTIVITE ++'
	               rapport = rapport +' Post Ambassadeur non membre : '+posts_ambassadeur_non_membre.length
	               rapport = rapport +' Post supprimé : '+posts_supprimes.length
	               
	           }
	           rapport = rapport +'\nTemps totale de releve : '+heures+' heures et '+heures+' minutes'
	            console.log(rapport)
        await page.waitForTimeout(30000)
}
