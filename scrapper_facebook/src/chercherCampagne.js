import scroll from '@pierreminiggio/puppeteer-page-scroller'
import asyncForEach from '@pierreminiggio/async-foreach'
import getLinkMobile from './getLinkMobile.js'
import getGroupeCampagne from './getGroupeCampagne.js'
import InsertPost from './InsertPost.js'
import UpdatePost from './UpdatePost.js'
import InsertPostPartage from './InsertPostPartage.js'
import dbconnect from './dbconnection.js'
import getIdPost from './getIdPost.js'
import UpdateGroupeCampagneStatutRecherche from './UpdateGroupeCampagneStatutRecherche.js'
import getIdPostCampagne from './getIdPostCampagne.js'
import getNomCampagne from './getNomCampagne.js'
import UpdatePostPartage from './UpdatePostPartage.js'
import InsertPostMere from './InsertPostMere.js'
import getPostMere from './getPostMere.js'
import getContenuPostMere from './getContenuPostMere.js'
import UpdateContenuPostMere from './UpdateContenuPostMere.js'

/**
 * @param {var("puppeteer").Page} page
 * @param {Number} id_ambassadeur
 * @param {Number} id_campagne
 * @param {string} rapport
 * @returns {Promise<string[[]]>}
 */
export default (page,id_ambassadeur,id_campagne,rapport) => {
    return new Promise(async resolve => {
            const LinkGroup = []
	        var db = dbconnect()
	        var nomCampagne  = getNomCampagne(db,id_campagne)
	        var PostMere = await getPostMere(db,id_campagne)
	        if (!PostMere){
	            var contenu_post_mere = await getContenuPostMere(db,id_campagne) 
	            await page.goto('https://m.facebook.com/pg/lalachante.fr/posts')
                var resultat = {}
                do {
	                await scroll(page,3000)
			        resultat =  await page.evaluate( async (contenu) => {
				    const links = []
				    var contenu_post_mere = ''
				    var fini = false
				    const scrapedLinks = document.querySelectorAll('div')
				    
				    scrapedLinks.forEach(scrapedLink => {
				        	if (scrapedLink.querySelector('a')){
				        	     const postLink = scrapedLink.querySelector('a').href
					             const positionLink1 = postLink.indexOf("story_fbid")

				                if (! links.includes(postLink) && positionLink1 != -1 ){
				                    
					                const contenulink = scrapedLink.innerText
					                const positionContenu = contenulink.indexOf(contenu)
						            if (positionContenu != -1){
					                        links.push(postLink)
					                        contenu_post_mere = contenulink
						            }
                                    
				                }
                            }				       
				    })
				    if (links.length >= 1){
				        fini = true
				    }
				    return {
				        est_fini: fini,
				        links: links,
				        contenu_post_mere: contenu_post_mere
				      }
                    },contenu_post_mere)
                }while(!resultat.est_fini);
            
                PostMere = 'https://www.facebook.com/lalachante.fr/posts/'+resultat.links[0].split('story_fbid=')[1].split('&id')[0]
                var err = await InsertPost(db,PostMere,'','','','',id_campagne)
                await page.waitForTimeout(3000)
                var idPost = await getIdPost(db,PostMere)
                err = await InsertPostMere(db,idPost,0,0)
                err = UpdateContenuPostMere(db,id_campagne,resultat.contenu_post_mere)
            }
            const id_number = PostMere.split('posts/')[1]
            const url_insight = 'https://m.facebook.com/pages/insights/post_details/?page_id=211561366395565&post_feed_object_id=S%3A_I211561366395565%3A'+id_number+'&post_id=795278521357177'
            
            await page.goto(url_insight)
            var messageSelector = 'div > div > div > p'
            await page.waitForSelector(messageSelector,{timeout: 5000}).catch(async error => {
                    messageSelector = 'div > div > div > span > p'
                    await page.waitForSelector(messageSelector,{timeout: 5000}).catch(async error => {
                        messageSelector = 'div > div > div > span > span > p'
                        await page.waitForSelector(messageSelector,{timeout: 5000})
                    })
            })
            const message =  await page.evaluate( async (messageSelector) => {
				const messages = []
				const scrapedMessages = document.querySelectorAll(messageSelector)
				
				scrapedMessages.forEach(scrapedMessage => {
				    	messages.push(scrapedMessage.innerText)
                })
					
				return messages[0]
            },  messageSelector)
        
            console.log('message à chercher :')
            console.log(message)
            const contenu = message.split('\n').join(' ')
	        const motif = '/search?q='+message
	        
            var avancement = 1
            var groupes_trouves = []
            var groupes_non_trouves = []
            var temps = 0
            const groupes = await getGroupeCampagne(db,id_campagne)
            console.log('Nombre de groupes récuperés depuis la base de données : '+groupes.length+' groupes')
            
            await asyncForEach(groupes, async groupe => {
                    var startTime = new Date().getTime();
                    var elapsedTime = 0
                    var lienPost = ''
                    var trouve = 'echouée'
			         var groupLink = groupe.id_groupe
                     const nom = groupe.nom

                     const liencherche = groupLink + motif
			         await page.goto(liencherche,{timeout: 0})

			         await scroll(page,3000)

			        const links =  await page.evaluate( async (contenu) => {
				    const links = []
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
						    }
                            
				        }
				       
				    })
				    return links
               		   },  contenu)

                    console.log(links)
                    var err = await UpdateGroupeCampagneStatutRecherche(db,id_campagne,groupLink,'cherché')
                            
				    if (links[0]){
                            lienPost = links[0]
                            var idPost = await getIdPostCampagne(db,groupLink,id_campagne)
                            console.log(idPost)
                            if (!idPost){
                                idPost = await getIdPost(db,lienPost)
                            }
                            console.log(idPost)
                            if (!idPost) {

                                err = await InsertPost(db,lienPost,'','','','',id_campagne)
                                await page.waitForTimeout(3000)
                                idPost = await getIdPost(db,lienPost)
                            }
                            console.log(idPost)
                            err = await InsertPostPartage(db,idPost,'','acceptée',id_ambassadeur,groupLink)
                            if (err){
                                console.log('erreur : insert post partage')
                                err = await UpdatePostPartage(db,idPost,'','acceptée',id_ambassadeur,groupLink)
                            }
                            err = await UpdatePost(db,idPost,lienPost)
                            err = await UpdateGroupeCampagneStatutRecherche(db,id_campagne,groupLink,'trouvé')
                            trouve = 'réussite'
                            groupes_trouves.push({nom: nom,lien: groupLink, lienPost: lienPost})
                            
	                }else{
                        groupes_non_trouves.push({nom: nom,lien: groupLink})
                    }
	                    
                        elapsedTime = new Date().getTime() - startTime; 
                        temps = temps + elapsedTime/1000
                        const temps_estime = elapsedTime/1000 * (groupes.length-avancement)
                        var heures_estime =  Math.floor(temps_estime/3600)
                        var minutes_estime =  Math.floor((temps_estime-heures_estime*3600)/60)
                        console.log('La Recherche dans le groupe de lien : '+groupLink+', de nom : '+nom+' est '+trouve)
                        if(trouve.indexOf('réussite') != -1){
                            console.log('\nLe post d\'id :'+lienPost +' est trouvé')
                        }else{
                            console.log('\nLe post d\'id :'+lienPost +' est trouvé')
                        }
                        console.log('\nAvancement des groupes cherchés : ' +avancement+' groupes sur le totale de : '+groupes.length+ ', Taux : '+Math.floor(avancement/groupes.length*100)+'%, pour la campagne : '+id_campagne)
                        if (heures_estime == 0){
                            console.log('Temps estimé pour terminer la recherche : '+minutes_estime+' minutes')
                        }else{
                            console.log('Temps estimé pour terminer la recherche : '+heures_estime+' heures et '+minutes_estime+' minutes')
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
	               rapport = rapport +'\n-| Report Recherche Publication "'+today.toString()+'" |-'
	               rapport = rapport +'        CAMPAGNE N° '+id_campagne+'        '
	               rapport = rapport + nomCampagne
	               rapport = rapport +'\n --  Groupes dans la liste : '+groupes.length
	               rapport = rapport +' Groupes trouvés : '+groupes_trouves.length
	               rapport = rapport +' Posts trouvés : '+groupes_trouves.length
	               rapport = rapport +' Groupes non trouvés : '+groupes_non_trouves.length
	           }
	           rapport = rapport +'\nTemps totale de recherche : '+heures+' heures et '+heures+' minutes'
                console.log(rapport)
            resolve(LinkGroup)
    })
}


