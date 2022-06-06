import scroll from '@pierreminiggio/puppeteer-page-scroller'
import getLinkMobile from './getLinkMobile.js'
import getLinkMobileBasic from './getLinkMobileBasic.js'
import asyncForEach from '@pierreminiggio/async-foreach'
import InsertRelevePost from './InsertRelevePost.js'
import UpdateRelevePost from './UpdateRelevePost.js'
import InsertPost from './InsertPost.js'
import UpdatePost from './UpdatePost.js'
import InsertPostMere from './InsertPostMere.js'
import UpdatePostMere from './UpdatePostMere.js'
import getIdPost from './getIdPost.js'
import dbconnect from './dbconnection.js'
import getAmbassadeurs from'./getAmbassadeurs.js'
import UpdatePostStatutScrappe from './UpdatePostStatutScrappe.js'
import getIdUtilisateur from './getIdUtilisateur.js'
import InsertUtilisateurInteractionPost from './InsertUtilisateurInteractionPost.js'
import InsertUtilisateur from './InsertUtilisateur.js'
import getNomCampagne from './getNomCampagne.js'
import getPostMere from './getPostMere.js'
import getContenuPostMere from './getContenuPostMere.js'
import UpdateContenuPostMere from './UpdateContenuPostMere.js'

/**
 * @param {import("puppeteer").Page} page
 * @param {Number} id_campagne
 * @param {Number} id_releve_campagne
 * @param {string} rapport
 * @returns {Promise<string[[]]>}
*/
export default (page,id_campagne,id_releve_campagne,rapport) => {
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
		
		const url_like = 'https://mbasic.facebook.com/ufi/reaction/profile/browser/?ft_ent_identifier='+id_number+'&ref=page_internal'
		const url_share = 'https://mbasic.facebook.com/browse/shares?id='+id_number+'&ref=page_internal' 
        const url_insight = 'https://mbasic.facebook.com/pages/insights/post_details/?page_id=211561366395565&post_feed_object_id=S%3A_I211561366395565%3A'+id_number+'&post_id=795278521357177'
	    var startTime = new Date().getTime();
        var elapsedTime = 0
        var scrappe = 'echoué'
		await page.goto(url_insight)

		const couverturePostMere = await page.evaluate( async (contenu,contenu2) => {
				const links = []
				const scrapedLinks = document.querySelectorAll('div > span')
				
				scrapedLinks.forEach(scrapedLink => {
					const contenulink = scrapedLink.innerText
					
						
				  if (! links.includes(contenulink) && contenulink.indexOf('personnes touchées') != -1 ){
				        
					    
					            links.push(contenulink.split(' ')[0])
						
                        
				    }
				   
				})
				return parseInt(links[0].split(' ')[0]+links[0].split(' ')[1])
           	},  '','')
           	console.log('couverturePostMere')
           	console.log(couverturePostMere)
		
	
		 const clicksSelector = '#root > table > tbody > tr > td > div > div > div:nth-child(3)'
		  await page.waitForSelector(clicksSelector)

		    const Clicks = await page.evaluate(( clicksSelector) => {
                const Clicks = []
		        
                const scrapedClicks = document.querySelectorAll(clicksSelector)
		        scrapedClicks.forEach(scrapedClick => {
		            
		                Clicks.push(scrapedClick.innerText)
		                    
		            
		        })

		        return Clicks[0].split('\n')[0]
		    }, clicksSelector)
		    
		    var clicks = 0
            const clicksString = Clicks
            if (clicksString.indexOf('K') != -1 ){
                    const decimale = clicksString.split(' ')[0]
                    if (decimale.indexOf('.') != -1 ){
                        const naturel = decimale.split('.')[0]
                        const aprèsvergule = decimale.split('.')[1]
                        clicks = parseInt(naturel)*1000 + parseInt(aprèsvergule)*100
                    }else{
                        clicks = parseInt(decimale)*1000
                    }
            }else{
                clicks = parseInt(clicksString)
            }
            
           	console.log('clicks')
           	console.log(clicks)
           	
            await page.goto(PostMere)
            
		     const commentSelector = 'div > div:nth-child(1) > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div:nth-child(2) > div > div:nth-child(4) > div > div > div > ul > li'
    
            const commentAuthorSelector = 'div > div > div > div > div:nth-child(1) > div > div > div > span > span > a'
            
            const AfficherPlusSelector = 'div > div:nth-child(1) > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div:nth-child(2) > div > div:nth-child(4) > div > div > div > div:nth-child(5) > div > div > span > span'
            
			await page.waitForSelector(AfficherPlusSelector,{timeout: 5000}).catch(error => null)
       	    await page.click(AfficherPlusSelector).catch(error => null)
			await page.waitForTimeout(1000)
			
            const Comments = await page.evaluate((commentSelector,commentAuthorSelector) => {
                const comments = []
                const scrapedComments = document.querySelectorAll(commentSelector)

                scrapedComments.forEach(scrapedComment => {
                        const scrappedAuthor = scrapedComment.querySelector(commentAuthorSelector)
                        if (scrappedAuthor){
                            comments.push({
                                name: scrappedAuthor.innerText,
                                link: scrappedAuthor.href
                            })
                        }
                })

                return comments
            },commentSelector,commentAuthorSelector)
            
           	console.log('Comments')
           	console.log(Comments)

    
            
		    

		  await page.goto(url_like)
        const likeurSelector = 'h3 a'
	    const Likeurs = []
	    var fini = false
		do {
			const SuivantSelector = '#root > table > tbody > tr > td > div > ul > li:nth-child(11) > table > tbody > tr > td > div > a'
			 const scrapedLikeurs = await page.evaluate((likeurSelector) => {
                const Likeurs = []
                const scrapedLikeurs = document.querySelectorAll(likeurSelector)

                scrapedLikeurs.forEach(scrapedLikeur => {

                    if (scrapedLikeur) {
			const lien_likeur = 'https://www.'+scrapedLikeur.href.split('?')[0].split('mbasic.')[1]
			
                        Likeurs.push({
                            name: scrapedLikeur.innerText,
                            link: lien_likeur,
                        })
                    }
                })

                return Likeurs
            }, likeurSelector)
            await page.waitForTimeout(1000)
			await page.waitForSelector(SuivantSelector,{timeout: 5000}).catch(error => fini = true)
       	    if (!fini){
       	        await page.click(SuivantSelector)
			    await page.waitForTimeout(2000)
			}
            scrapedLikeurs.forEach( scrapedLikeur =>{
                       Likeurs.push(scrapedLikeur)
            })
		}while(!fini);
                  
           	console.log('Likeurs')
           	console.log(Likeurs)
                
		const ambassadeurs = await getAmbassadeurs(db)
	    await page.goto(url_share)
	
	    const shareSelector = 'a'
	    const Partageurs = []
		var fini = false
		do {
			const SuivantSelector = '#m_more_item > a'
			const scrapedPartageurs = await page.evaluate((shareSelector,ambassadeurs) => {
		        
		        const scrapedPartageurs = document.querySelectorAll(shareSelector)
			    const Partageurs = []
		        scrapedPartageurs.forEach( scrapedPartageur => {
                    
		            if (scrapedPartageur) {
		                
                        var trouve = false
                        ambassadeurs.forEach(ambassadeur => {
                            if (scrapedPartageur.innerText.localeCompare(ambassadeur.prenom+' '+ambassadeur.nom) == 0){ 
                                trouve = true
                            }
                        })
                    
			    const lien_partageur = 'https://www.'+scrapedPartageur.href.split('?')[0].split('mbasic.')[1]
				if (!trouve && scrapedPartageur.innerText && (scrapedPartageur.innerText.localeCompare('') != 0) && (scrapedPartageur.innerText.localeCompare('Accéder à l’Accueil') != 0) && (scrapedPartageur.innerText.localeCompare('Ajouter') != 0) && (scrapedPartageur.innerText.localeCompare('En afficher davantage') != 0)){
                        
				        Partageurs.push({
				            name: scrapedPartageur.innerText,
				            link: lien_partageur})
				}
		            }
		        })

		     	return Partageurs
		     	
		    }, shareSelector,ambassadeurs)
		    
			await page.waitForTimeout(1000)
			await page.waitForSelector(SuivantSelector,{timeout: 5000}).catch(error => fini = true)
       	    if (!fini){
       	        await page.click(SuivantSelector)
			    await page.waitForTimeout(2000)
            }
            scrapedPartageurs.forEach( scrapedPartageur =>{
                       Partageurs.push(scrapedPartageur)
            })
            
		}while(!fini);
            
           	console.log('Partgeurs')
           	console.log(Partageurs)
    elapsedTime = new Date().getTime() - startTime; 
    elapsedTime = elapsedTime /1000
    var today = new Date()
        var jour = ''+(today.getDate())
					var mois = ''+(today.getMonth()+1)
					 	if ((today.getDate())<10){
						       jour = '0'+jour
						}

						if ((today.getMonth()+1)<10){
						       mois = '0'+mois
						}
                        const date = today.getFullYear()+'-'+mois+'-'+jour+today.getHours()+':'+today.getMinutes()+':'+today.getSeconds()

                    const interaction = clicks+Partageurs.length+Comments.length+Likeurs.length
                    
                    var idPost = await getIdPost(db,PostMere)
                    if (!idPost){
                        var err = await InsertPost(db,PostMere,'','','','',id_campagne)
			     		await page.waitForTimeout(3000)
                        idPost = await getIdPost(db,PostMere)
                    }
                    
                    var err = await InsertPostMere(db,idPost,couverturePostMere,interaction)
			 		
	                await page.waitForTimeout(3000)
	                scrappe = 'réussit'
	                err = await UpdatePostStatutScrappe(db,idPost,'scrappé')
                                await asyncForEach(Likeurs, async likeur => {
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
                                
                                await asyncForEach(Comments, async comment => {
                                    const prenom = comment.name.split(' ')[0]
                                    const nom =  comment.name.split(' ').slice(1).join(' ')
                                    const lien = comment.link
                                    var id_utilisateur = await getIdUtilisateur(nom,db)

                                    if (!id_utilisateur){

                                        var err = await InsertUtilisateur(db,nom,prenom,'',lien)
                                        await page.waitForTimeout(3000) 
                                        id_utilisateur = await getIdUtilisateur(nom,db)
                                    }
                                    var err = await InsertUtilisateurInteractionPost(db,idPost,id_utilisateur,'a Commenté')
                                })
                                await asyncForEach(Partageurs, async partageur => {
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
					err = await InsertRelevePost(db,date,Likeurs.length,Comments.length,Partageurs.length,couverturePostMere,interaction,clicks,idPost,id_releve_campagne)
			   console.log('Fin Script')
	           var heures =  Math.floor(elapsedTime/3600)
               var minutes =  Math.floor((elapsedTime-heures*3600)/60)
	           var today = new Date()
	               rapport = rapport +'\n| Report Releve Insights Post Mère "'+today.toString()+'" |'
	               rapport = rapport +'        CAMPAGNE N° '+id_campagne+'        '
	               rapport = rapport +nomCampagne
	               rapport = rapport +'        Releve CAMPAGNE N° '+id_releve_campagne
	               rapport = rapport +'\n    Couverture : '+couverturePostMere
	               rapport = rapport +'    Clicks : '+clicks
	               rapport = rapport +'    Interaction : '+interaction
	               rapport = rapport +'    Likes : '+Likeurs.length
	               rapport = rapport +'    Comments : '+Comments.length
	               rapport = rapport +'    Shares : '+Partageurs.length
	           rapport = rapport +'\nTemps totale de releve : '+heures+' heures et '+heures+' minutes'
	               console.log(rapport)
        resolve(LinkGroup)
    })
}

