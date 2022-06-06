import scroll from '@pierreminiggio/puppeteer-page-scroller'
import asyncForEach from '@pierreminiggio/async-foreach'
import getLinkMobile from './getLinkMobile.js'
import getLinkMobileBasic from './getLinkMobileBasic.js'
import dbconnect from './dbconnection.js'
import getGroupeCampagneSegment from './getGroupeCampagneSegment.js'
import UpdateGroupeCampagneStatutPublication from './UpdateGroupeCampagneStatutPublication.js'
import getGroupeInfo from './getGroupeInfo.js'
import UpdateNomGroupe from './UpdateNomGroupe.js'
import UpdateActifSupprime from './UpdateActifSupprime.js'
import getIdPostCampagne from './getIdPostCampagne.js'
import InsertPostPartage from './InsertPostPartage.js'
import InsertPost from './InsertPost.js'
import UpdateGroupeCampagneTraitementPublication from './UpdateGroupeCampagneTraitementPublication.js'
import getNomCampagne from './getNomCampagne.js'
import InsertPostMere from './InsertPostMere.js'
import getPostMere from './getPostMere.js'
import getContenuPostMere from './getContenuPostMere.js'
import UpdateContenuPostMere from './UpdateContenuPostMere.js'
import getLienLegendePostPartage from './getLienLegendePostPartage.js'
import getLegendePostPartage from './getLegendePostPartage.js'
import UpdateLienLegendePostPartage from './UpdateContenuPostMere.js'
import InsertGroupeCampagneSegment from './InsertGroupeCampagneSegment.js'
import InsertLegendePostPartageCampagneSegment from './InsertLegendePostPartageCampagneSegment.js'


/**
 * @param {import("puppeteer").Page} page
 * @param {Number} id_ambassadeur
 * @param {Number} id_campagne
 * @param {Number} id_segment
 * @param {string} semi_legende
 * @param {string} groupLink_probleme
 * @param {string} rapport
 * @returns {Promise<string[[]]>}
 */
export default (page,id_ambassadeur,id_campagne,id_segment,semi_legende,groupLink_probleme,rapport) => {
    return new Promise(async resolve => {
        const LinkGroup = []
	        var db = dbconnect()
	        var err = await InsertGroupeCampagneSegment(db,id_campagne,id_segment)
	        var nomCampagne  = await getNomCampagne(db,id_campagne)
	        
            var lien_legende_post_partage = semi_legende
            if (semi_legende.indexOf('https://www.facebook.com/groups/402132164459012') == -1){
                lien_legende_post_partage = await getLienLegendePostPartage(db,id_campagne,id_segment)
	            if (!lien_legende_post_partage){
	                var legende_post_partage = await getLegendePostPartage(db,id_campagne,id_segment) 
	                if (!legende_post_partage){
	                    var err = await InsertLegendePostPartageCampagneSegment(db,id_campagne,id_segment,semi_legende)
	                    legende_post_partage = semi_legende
	                }
	                await page.goto('https://www.facebook.com/groups/402132164459012'+'/search/?q='+legende_post_partage)
                    var resultat = {}
                    do {
	                    await scroll(page,3000)
			            resultat =  await page.evaluate( async (contenu) => {
				        const links = []
				        var legende_post_partage = ''
				        var fini = false
				        const scrapedLinks = document.querySelectorAll('a')
				        
				        scrapedLinks.forEach(scrapedLink => {
				            	const split = scrapedLink.href.split('?')[0].split('/')
					        split.pop()
					        const postLink = split.join('/')
					        const positionLink1 = postLink.indexOf("permalink")
                            const positionLink2 = postLink.indexOf("posts")

						        
				           if (! links.includes(postLink) && (positionLink1 != -1 | positionLink2 != -1) ){
				                
					            const contenulink = scrapedLink.innerText
					            const positionContenu = contenulink.indexOf(contenu)
						        if (positionContenu != -1){
					                    links.push(postLink)
					                    legende_post_partage = contenulink
						        }
                           }				       
				        })
				        if (links.length >= 1){
				            fini = true
				        }
				        return {
				            est_fini: fini,
				            links: links,
				            legende_post_partage: legende_post_partage
				          }
                        },legende_post_partage)
                        console.log(resultat)
                    }while(!resultat.est_fini);
                
                    lien_legende_post_partage = resultat.links[0]
                    var err = await UpdateLienLegendePostPartage(db,id_campagne,id_segment,lien_legende_post_partage,resultat.legende_post_partage)
                }
            }
            
            const lienMessage = await getLinkMobile(lien_legende_post_partage)
            await page.goto(lienMessage)
            const messageSelector = 'div.story_body_container > div > div'
            const message =  await page.evaluate( async (messageSelector) => {
				const messages = []
				const scrapedMessages = document.querySelectorAll(messageSelector)
				
				scrapedMessages.forEach(scrapedMessage => {
				    	messages.push(scrapedMessage.innerText)
                })
					
				return messages[0]
            },  messageSelector)
        
            console.log('message à partager:')
            console.log(message)
						

            var avancement = 1
            var groupes_echoues = []
            var groupes_reussits = []
            var temps = 0
            const groupes = await getGroupeCampagneSegment(db,id_campagne,id_segment)
            console.log('Nombre de groupes récuperés depuis la base de données : '+groupes.length+' groupes')
            
            await asyncForEach(groupes, async groupe => {
                var echoue = false
                var startTime = new Date().getTime();
                var elapsedTime = 0
                
                var publie = 'echouée'
                const groupLink = groupe.id_groupe
                groupLink_probleme = groupLink
                const nom = groupe.nom
                const statut_publication = groupe.statut_publication
                const traitement_publication = groupe.traitement_publication

                if (statut_publication.indexOf('non posté') != -1 && traitement_publication.indexOf('automatique') != -1){
			        
                    await page.goto(await getLinkMobile(groupLink))
                
			        var ExprimerSelector = '#MRoot > div > div._3iyw > div > div._7om2._3gim._7cdk > div:nth-child(2) > div'
			        
                    await page.waitForSelector(ExprimerSelector).catch(error => {
                        page.reload()
                        ExprimerSelector = '#MRoot > div > div > div > div > div:nth-child(2) > div'
                        page.waitForSelector(ExprimerSelector).catch(async error => {
                            echoue = true
                            err = await UpdateGroupeCampagneStatutPublication(db,id_campagne,groupLink,'non trouvé')
                            groupes_echoues.push({nom: nom,lien: groupLink})
                        })
                    })
                    
                    if (!echoue){
                        await page.click(ExprimerSelector)
                
                        const imputMessageSelector = '#uniqid_1'
			            await page.waitForSelector(imputMessageSelector)
			            
                        await page.evaluate(( message, imputMessageSelector) => {
                            document.querySelector(imputMessageSelector).value = message
                        }, message, imputMessageSelector)

                        await page.waitForTimeout(1000)
                        await page.waitForSelector(imputMessageSelector)
                        await page.click(imputMessageSelector)

                        await page.waitForTimeout(1000)
                        const publierButtonSelector = '#composer-main-view-id > div._52z5._451a._9dr8 > div > div:nth-child(3) > div > div > button'            
			            await page.waitForSelector(publierButtonSelector)
                        await page.click(publierButtonSelector)
                        
                        await page.waitForTimeout(3000)
                        
                           var err = await UpdateGroupeCampagneStatutPublication(db,id_campagne,groupLink,'posté')
                           publie = 'réussite'
                           err = await InsertPost(db,groupLink,'','','','',id_campagne)
                           await page.waitForTimeout(3000)
                           const idPost = await getIdPostCampagne(db,groupLink,id_campagne)
                           err = await InsertPostPartage(db,idPost,'','en attente',id_ambassadeur,groupLink)
                           groupes_reussits.push({nom: nom,lien: groupLink})
                        
                        await page.waitForTimeout(6000)
                    }
               }
                    elapsedTime = new Date().getTime() - startTime; 
                    temps = temps + elapsedTime/1000
                    const temps_estime = elapsedTime/1000 * (groupes.length-avancement)
                    var heures_estime =  Math.floor(temps_estime/3600)
                    var minutes_estime =  Math.floor((temps_estime-heures_estime*3600)/60)
                    
                    console.log('La publication dans le groupe de lien : '+groupLink+', de nom : '+nom+' est '+publie)
                    
                    console.log('Avancement des groupes postés de segment '+ id_segment + ' : ' +avancement+' groupes sur le totale de : '+groupes.length+ ', Taux : '+Math.floor(avancement/groupes.length*100)+'%, pour la campagne : '+id_campagne)
                    if (heures_estime == 0){
                        console.log('Temps estimé pour terminer la publication : '+minutes_estime+' minutes')
                    }else{
                        console.log('Temps estimé pour terminer la publication : '+heures_estime+' heures et '+minutes_estime+' minutes')
                    }
                       
			        avancement = avancement + 1
 
	        })
	        
	           console.log('Fin Script')
	           var heures =  Math.floor(temps/3600)
               var minutes =  Math.floor((temps-heures*3600)/60)
	           var today = new Date()
	           if (groupes.length == 0){
	                rapport = rapport +'\nRapport'
	                rapport = rapport +'Aucun groupe est récuperé depuis la base'
	           }else{ 
	               rapport = rapport +'\n| Report Publications dans Groupes "'+today.toString()+'" |'
	               rapport = rapport +'        CAMPAGNE N° '+id_campagne+'        '
	               rapport = rapport +nomCampagne
	               rapport = rapport +'        SEGMENT N° '+id_segment+'        '
	               rapport = rapport +'\n    Groupes Listés : '+groupes.length
	               rapport = rapport +'    Groupes postés : '+groupes_reussits.length
	               rapport = rapport +'    Groupes Non postés : '+groupes_echoues.length
	           }
	           rapport = rapport +'\nTemps totale de publication : '+heures+' heures et '+heures+' minutes'
	            console.log(rapport)
        resolve(LinkGroup)
    })
}

