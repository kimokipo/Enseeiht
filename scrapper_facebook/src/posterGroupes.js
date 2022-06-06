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
import getIdPost from './getIdPost.js' 
import getPostMere from './getPostMere.js'
import getContenuPostMere from './getContenuPostMere.js'
import UpdateContenuPostMere from './UpdateContenuPostMere.js'
import getLienLegendePostPartage from './getLienLegendePostPartage.js'
import getLegendePostPartage from './getLegendePostPartage.js'
import UpdateLienLegendePostPartage from './UpdateContenuPostMere.js'


/**
 * @param {import("puppeteer").Page} page
 * @param {Number} id_ambassadeur
 * @param {Number} id_campagne
 * @param {Number} id_segment
 * @param {string} message
 * @param {string} rapport
 * @returns {Promise<string[[]]>}
 */
export default (page,id_ambassadeur,id_campagne,id_segment,message,rapport) => {
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
                    console.log(resultat)
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
            
        
            console.log('message à partager:')
            console.log(message)
						
            var avancement = 1
            var groupes_echoues = []
            var groupes_reussits = []
            var groupes_change_nom = []
            var groupes_supprimes = []
            var groupes_manuelles = []
            var groupes_traites = []
            var groupes_traites_echoues = []
            var temps = 0
            const groupes = await getGroupeCampagneSegment(db,id_campagne,id_segment)
            console.log('Nombre de groupes récuperés depuis la base de données : '+groupes.length+' groupes')
            
            await asyncForEach(groupes, async groupe => {
                var traite = false
                var traitement = ''
                var startTime = new Date().getTime();
                var elapsedTime = 0
                
                var poste = 'echouée'
                const groupLink = groupe.id_groupe
                const nom = groupe.nom
                const statut_publication = groupe.statut_publication
                const traitement_publication = groupe.traitement_publication

                if (statut_publication.indexOf('non posté') != -1 && traitement_publication.indexOf('automatique') != -1){
			        
                    await page.goto(url_insight)
                
			        var shareButtonSelector = '#feedback_inline_'+id_number+' > div._52jh._7om2._15kk._15ks._15km._4b47._4b46 > div:nth-child(3) > a'
			        
                    await page.waitForSelector(shareButtonSelector).catch(error => {
                        page.reload()
                        shareButtonSelector = '#feedback_inline_'+id_number+' > div > div:nth-child(3) > a'
                        page.waitForSelector(shareButtonSelector)
                    })
                        
                    await page.click(shareButtonSelector)
            
                    const shareGroupButtonSelector = '#share-in-a-group-button'
			        await page.waitForSelector(shareGroupButtonSelector)
                    await page.click(shareGroupButtonSelector)

                    const imputGroupeSelector = 'input[placeholder="Entrer un nom de groupe"]'
                    const imputMessageSelector = '#share_msg_input'
                    await page.waitForSelector(imputGroupeSelector)
                    await page.waitForSelector(imputMessageSelector)

                    await page.evaluate((nom_groupe, imputGroupeSelector) => {
                        document.querySelector(imputGroupeSelector).value = nom_groupe
                    }, nom, imputGroupeSelector)

                    await page.waitForTimeout(1000)
                    await page.waitForSelector(imputGroupeSelector)
                    await page.click(imputGroupeSelector)
                    
                    await page.waitForTimeout(1000)
			        await page.keyboard.press('Enter')
                    await page.waitForTimeout(1000)
			        await page.keyboard.press('ArrowDown')
                    await page.waitForTimeout(1000)
			        await page.keyboard.press('Enter')
                    await page.waitForTimeout(1000)

                    await page.evaluate(( message, imputMessageSelector) => {
                        document.querySelector(imputMessageSelector).innerHTML = message
                    }, message, imputMessageSelector)

                    await page.waitForTimeout(1000)
                    await page.waitForSelector(imputMessageSelector)
                    await page.click(imputMessageSelector)

                    await page.waitForTimeout(1000)
                    const posterButtonSelector = '#share_submit'            
			        await page.waitForSelector(posterButtonSelector)
                    await page.click(posterButtonSelector)
                    
                    await page.waitForTimeout(3000)
                    const titreSelector = 'head > title'
                    const titre = await page.evaluate( titreSelector => {
                        return document.querySelector(titreSelector).innerText
                    }, titreSelector)
                    if (titre.indexOf('Contenu introuvable') != -1){
                        const err = await UpdateGroupeCampagneStatutPublication(db,id_campagne,groupLink,'non trouvé')
                        groupes_echoues.push({nom: nom,lien: groupLink})
                    }else{
                       var err = await UpdateGroupeCampagneStatutPublication(db,id_campagne,groupLink,'posté')
                       poste = 'réussite'
                       err = await InsertPost(db,groupLink,'','','','',id_campagne)
                       await page.waitForTimeout(3000)
                       const idPost = await getIdPostCampagne(db,groupLink,id_campagne)
                       err = await InsertPostPartage(db,idPost,'','en attente',id_ambassadeur,groupLink)
                       groupes_reussits.push({nom: nom,lien: groupLink})
                    } 
                    await page.waitForTimeout(6000)
               }else if (statut_publication.indexOf('non trouvé') != -1 && traitement_publication.indexOf('automatique') != -1){
                    const infos = await getGroupeInfo(db,groupLink,page,avancement)
                    if (infos && infos.nom && infos.nom.localeCompare(nom) != 0){
                         var err = await UpdateNomGroupe(db,groupLink,infos.nom)
                         traitement = 'Le nom est mis à jour car il n\'était pas correcte'
                         groupes_change_nom.push({nom: infos.nom,lien: groupLink, traitement: traitement})
                         groupes_traites.push({nom: infos.nom,lien: groupLink, traitement: traitement})
                         err = await UpdateGroupeCampagneStatutPublication(db,id_campagne,groupLink,'non posté')
                    }else if (!infos || !infos.nom){
                         var err = await UpdateActifSupprime(db,groupLink,'supprimé')
                         traitement = 'Le groupe est supprimé'
                         groupes_supprimes.push({nom: nom,lien: groupLink, traitement: traitement})
                         groupes_traites.push({nom: infos.nom,lien: groupLink, traitement: traitement})
                         err = await UpdateGroupeCampagneStatutPublication(db,id_campagne,groupLink,'non posté')
                    }else{ 
                         const err = await UpdateGroupeCampagneTraitementPublication(db,id_campagne,groupLink,'manuelle')
                         traitement = 'Le traitement ne peut pas se faire automatiquement'
                         groupes_manuelles.push({nom: nom,lien: groupLink, traitement: traitement})
                         groupes_traites.push({nom: infos.nom,lien: groupLink, traitement: traitement})
                    }
                    traite = true
              }
              
              
                    
                    elapsedTime = new Date().getTime() - startTime; 
                    temps = temps + elapsedTime/1000
                    const temps_estime = elapsedTime/1000 * (groupes.length-avancement)
                    var heures_estime =  Math.floor(temps_estime/3600)
                    var minutes_estime =  Math.floor((temps_estime-heures_estime*3600)/60)
                    if (traite){
                        console.log('Le groupe de lien : '+groupLink+', de nom : '+nom+' est non trouvé et a été traité\n'+traitement)
                    }else{
                        console.log('La publication dans le groupe de lien : '+groupLink+', de nom : '+nom+' est '+poste)
                    }
                    console.log('Avancement des groupes postés de segment '+ id_segment + ' : ' +avancement+' groupes sur le totale de : '+groupes.length+ ', Taux : '+Math.floor(avancement/groupes.length*100)+'%, pour la campagne : '+id_campagne)
                    if (heures_estime == 0){
                        console.log('Temps estimé pour terminer la publication : '+minutes_estime+' minutes')
                    }else{
                        console.log('Temps estimé pour terminer la publication : '+heures_estime+' heures et '+minutes_estime+' minutes')
                    }
                       
			        avancement = avancement + 1
 
	        })
	        
	        await asyncForEach(groupes_echoues, async groupe => {
                var traite = false
                var traitement = ''
                var startTime = new Date().getTime();
                var elapsedTime = 0
                
                const groupLink = groupe.lien
                const nom = groupe.nom

                const infos = await getGroupeInfo(db,groupLink,page,avancement)
                    if (infos && infos.nom && infos.nom.localeCompare(nom) != 0){
                         var err = await UpdateNomGroupe(db,groupLink,infos.nom)
                         traitement = 'Le nom est mis à jour car il n\'était pas correcte'
                         groupes_change_nom.push({nom: infos.nom,lien: groupLink, traitement: traitement})
                         groupes_traites.push({nom: infos.nom,lien: groupLink, traitement: traitement})
                         err = await UpdateGroupeCampagneStatutPublication(db,id_campagne,groupLink,'non posté')
                    }else if (!infos || !infos.nom){
                         var err = await UpdateActifSupprime(db,groupLink,'supprimé')
                         traitement = 'Le groupe est supprimé'
                         groupes_supprimes.push({nom: nom,lien: groupLink, traitement: traitement})
                         groupes_traites.push({nom: nom,lien: groupLink, traitement: traitement})
                         err = await UpdateGroupeCampagneStatutPublication(db,id_campagne,groupLink,'non posté')
                    }else{ 
                         const err = await UpdateGroupeCampagneTraitementPublication(db,id_campagne,groupLink,'manuelle')
                         traitement = 'Le traitement ne peut pas se faire automatiquement'
                         groupes_manuelles.push({nom: infos.nom,lien: groupLink, traitement: traitement})
                         groupes_traites.push({nom: infos.nom,lien: groupLink, traitement: traitement})
                    }
                    traite = true
              
                    elapsedTime = new Date().getTime() - startTime; 
                    temps = temps + elapsedTime/1000
                    const temps_estime = elapsedTime/1000 * (groupes.length-avancement)
                    var heures_estime =  Math.floor(temps_estime/3600)
                    var minutes_estime =  Math.floor((temps_estime-heures_estime*3600)/60)
                    if (traite){
                        console.log('Le groupe de lien : '+groupLink+', de nom : '+nom+' est non trouvé et a été traité\n'+traitement)
                    }else{
                        console.log('La publication dans le groupe de lien : '+groupLink+', de nom : '+nom+' est '+poste)
                    }
                    console.log('Avancement des groupes postés de segment '+ id_segment + ' : ' +avancement+' groupes sur le totale de : '+groupes.length+ ', Taux : '+Math.floor(avancement/groupes.length*100)+'%, pour la campagne : '+id_campagne)
                    if (heures_estime == 0){
                        console.log('Temps estimé pour terminer la publication : '+minutes_estime+' minutes')
                    }else{
                        console.log('Temps estimé pour terminer la publication : '+heures_estime+' heures et '+minutes_estime+' minutes')
                    }
                       
			        avancement = avancement + 1
 
	        })
	        
	        await asyncForEach(groupes_traites, async groupe => {
	            var poste = 'echouée'
                var traitement = ''
                var startTime = new Date().getTime();
                var elapsedTime = 0
                
                const groupLink = groupe.lien
                const nom = groupe.nom

                    await page.goto(url_insight)
                
			        var shareButtonSelector = '#feedback_inline_'+id_number+' > div._52jh._7om2._15kk._15ks._15km._4b47._4b46 > div:nth-child(3) > a'
			        
                    await page.waitForSelector(shareButtonSelector).catch(error => {
                        page.reload()
                        shareButtonSelector = '#feedback_inline_'+id_number+' > div > div:nth-child(3) > a'
                        page.waitForSelector(shareButtonSelector)
                    })
                        
                    await page.click(shareButtonSelector)
            
                    const shareGroupButtonSelector = '#share-in-a-group-button'
			        await page.waitForSelector(shareGroupButtonSelector)
                    await page.click(shareGroupButtonSelector)

                    const imputGroupeSelector = 'input[placeholder="Entrer un nom de groupe"]'
                    const imputMessageSelector = '#share_msg_input'
                    await page.waitForSelector(imputGroupeSelector)
                    await page.waitForSelector(imputMessageSelector)

                    await page.evaluate((nom_groupe, imputGroupeSelector) => {
                        document.querySelector(imputGroupeSelector).value = nom_groupe
                    }, nom, imputGroupeSelector)

                    await page.waitForTimeout(1000)
                    await page.waitForSelector(imputGroupeSelector)
                    await page.click(imputGroupeSelector)
                    
                    await page.waitForTimeout(1000)
			        await page.keyboard.press('Enter')
                    await page.waitForTimeout(1000)
			        await page.keyboard.press('ArrowDown')
                    await page.waitForTimeout(1000)
			        await page.keyboard.press('Enter')
                    await page.waitForTimeout(1000)

                    await page.evaluate(( message, imputMessageSelector) => {
                        document.querySelector(imputMessageSelector).innerHTML = message
                    }, message, imputMessageSelector)

                    await page.waitForTimeout(1000)
                    await page.waitForSelector(imputMessageSelector)
                    await page.click(imputMessageSelector)

                    await page.waitForTimeout(1000)
                    const posterButtonSelector = '#share_submit'            
			        await page.waitForSelector(posterButtonSelector)
                    await page.click(posterButtonSelector)
                    
                    await page.waitForTimeout(3000)
                    const titreSelector = 'head > title'
                    const titre = await page.evaluate( titreSelector => {
                        return document.querySelector(titreSelector).innerText
                    }, titreSelector)
                    if (titre.indexOf('Contenu introuvable') != -1){
                        const err = await UpdateGroupeCampagneStatutPublication(db,id_campagne,groupLink,'non trouvé')
                        groupes_traites_echoues.push({nom: nom,lien: groupLink})
                    }else{
                       var err = await UpdateGroupeCampagneStatutPublication(db,id_campagne,groupLink,'posté')
                       poste = 'réussite'
                       err = await InsertPost(db,groupLink,'','','','',id_campagne)
                       await page.waitForTimeout(3000)
                       const idPost = await getIdPostCampagne(db,groupLink,id_campagne)
                       await page.waitForTimeout(1000)
                       if (idPost){
                            err = await InsertPostPartage(db,idPost,'','en attente',id_ambassadeur,groupLink)
                       }
                       groupes_reussits.push({nom: nom,lien: groupLink})
                    } 
                    
                    await page.waitForTimeout(6000)
              
                    elapsedTime = new Date().getTime() - startTime; 
                    temps = temps + elapsedTime/1000
                    const temps_estime = elapsedTime/1000 * (groupes.length-avancement)
                    var heures_estime =  Math.floor(temps_estime/3600)
                    var minutes_estime =  Math.floor((temps_estime-heures_estime*3600)/60)
                    
                    console.log('La publication dans le groupe de lien : '+groupLink+', de nom : '+nom+' est '+poste)
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
	               rapport = rapport +'\n| Report Publications Post Partagés "'+today.toString()+'" |'
	               rapport = rapport +'        CAMPAGNE N° '+id_campagne+'        '
	               rapport = rapport +nomCampagne
	               rapport = rapport +'        SEGMENT N° '+id_segment+'        '
	               rapport = rapport +'\n    Groupes Listés : '+groupes.length
	               rapport = rapport +'    Groupes postés : '+groupes_reussits.length
	               rapport = rapport +'    Groupes Non trouvés et traités : '+groupes_traites.length
	               rapport = rapport +'    Groupes Non postés aprés avoir traités : '+groupes_traites_echoues.length
	               rapport = rapport +'\n       ++ ACTIVITE ++'
	               rapport = rapport +' Groupe Change de Nom : '+groupes_change_nom.length
	               rapport = rapport +' Groupe supprimé : '+groupes_supprimes.length
	               rapport = rapport +' Groupe poster manuellement : '+groupes_manuelles.length
	           }
	           rapport = rapport +'\nTemps totale de publication : '+heures+' heures et '+heures+' minutes'
	            console.log(rapport)
        resolve(LinkGroup)
    })
}

