import scroll from '@pierreminiggio/puppeteer-page-scroller'
import asyncForEach from '@pierreminiggio/async-foreach'
import getLinkMobile from './getLinkMobile.js'
import getLinkMobileBasic from './getLinkMobileBasic.js'

/**
 * @param {import("puppeteer").Page} page
 * @returns {Promise<string[[]]>}
 */
export default (page) => {
    return new Promise(async resolve => {
        const LinkGroup = []
	        
                var PostMere = 'https://m.facebook.com/permalink.php?story_fbid=1575741899431666&id=100009876136894'
                
                var message = ''
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
            const groupes = []
            console.log('Nombre de groupes à poster : '+groupes.length+' groupes')
            
            await asyncForEach(groupes, async groupe => {
                var traite = false
                var traitement = ''
                var startTime = new Date().getTime();
                var elapsedTime = 0
                
                var poste = 'echouée'
                const groupLink = groupe.id_groupe
                const nom = groupe.nom
			        
                    await page.goto(PostMere)
                
			        var shareButtonSelector = 'footer > div > div > div:nth-child(3) > a'
			        
                    await page.waitForSelector(shareButtonSelector)
                        
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
                        groupes_echoues.push({nom: nom,lien: groupLink})
                    }else{
                       poste = 'réussite'
                       groupes_reussits.push({nom: nom,lien: groupLink})
                    } 
                    await page.waitForTimeout(1000)
              
              
                    
                    elapsedTime = new Date().getTime() - startTime; 
                    temps = temps + elapsedTime/1000
                    const temps_estime = elapsedTime/1000 * (groupes.length-avancement)
                    var heures_estime =  Math.floor(temps_estime/3600)
                    var minutes_estime =  Math.floor((temps_estime-heures_estime*3600)/60)
                    console.log('La publication dans le groupe de lien : '+groupLink+', de nom : '+nom+' est '+poste)
                    
                    console.log('Avancement des groupes postés : ' +avancement+' groupes sur le totale de : '+groupes.length+ ', Taux : '+Math.floor(avancement/groupes.length*100)+'%')
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
                         traitement = 'Le nom est mis à jour car il n\'était pas correcte'
                         groupes_change_nom.push({nom: infos.nom,lien: groupLink, traitement: traitement})
                         groupes_traites.push({nom: infos.nom,lien: groupLink, traitement: traitement})
                    }else if (!infos || !infos.nom){
                         traitement = 'Le groupe est supprimé'
                         groupes_supprimes.push({nom: nom,lien: groupLink, traitement: traitement})
                         groupes_traites.push({nom: nom,lien: groupLink, traitement: traitement})
                    }else{ 
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
                    console.log('Avancement des groupes postés : ' +avancement+' groupes sur le totale de : '+groupes.length+ ', Taux : '+Math.floor(avancement/groupes.length*100)+'%')
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

                    await page.goto(PostMere)
                
			        var shareButtonSelector = 'footer > div > div > div:nth-child(3) > a'
			        
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
                        groupes_traites_echoues.push({nom: nom,lien: groupLink})
                    }else{
                       poste = 'réussite'
                       groupes_reussits.push({nom: nom,lien: groupLink})
                    } 
                    
                    await page.waitForTimeout(1000)
              
                    elapsedTime = new Date().getTime() - startTime; 
                    temps = temps + elapsedTime/1000
                    const temps_estime = elapsedTime/1000 * (groupes.length-avancement)
                    var heures_estime =  Math.floor(temps_estime/3600)
                    var minutes_estime =  Math.floor((temps_estime-heures_estime*3600)/60)
                    
                    console.log('La publication dans le groupe de lien : '+groupLink+', de nom : '+nom+' est '+poste)
                    console.log('Avancement des groupes postés : ' +avancement+' groupes sur le totale de : '+groupes.length+ ', Taux : '+Math.floor(avancement/groupes.length*100)+'%')
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
	                rapport = rapport +'Aucun groupe est dans la liste'
	           }else{ 
	               rapport = rapport +'\n| Report Publications Post Intikhabat "'+today.toString()+'" |'       '
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

