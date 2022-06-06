import scroll from '@pierreminiggio/puppeteer-page-scroller'
import asyncForEach from '@pierreminiggio/async-foreach'
import getLinkMobile from './getLinkMobile.js'
import getLinkMobileBasic from './getLinkMobileBasic.js'
import UpdatePostPartage from './UpdatePostPartage.js'
import UpdateDateAdhesionGroupeAmbassadeur from './UpdateDateAdhesionGroupeAmbassadeur.js'
import UpdateNomGroupe from './UpdateNomGroupe.js'
import getIdPost from './getIdPost.js'
import dbconnect from './dbconnection.js'
import UpdatePost from './UpdatePost.js'
import getIdPostCampagne from './getIdPostCampagne.js'
import getNomCampagne from './getNomCampagne.js'
import UpdateStatutAdhesionGroupe from './UpdateStatutAdhesionGroupe.js'

/**
 * @param {import("puppeteer").Page} page
 * @param {import("puppeteer").Browser} browser
 * @param {Number} id_ambassadeur
 * @param {Number} id_campagne
 * @param {string} rapport
 * @returns {Promise<string[[]]>}
 */

export default (page,browser,id_ambassadeur,id_campagne,rapport) => {
    return new Promise(async resolve => {
        const LinkGroup = []
	            var db = dbconnect()
	            var nomCampagne  = getNomCampagne(db,id_campagne)
	                    await page.waitForTimeout(3000)
                        await page.goto('https://m.facebook.com/notifications')
                        await scroll(page,3000)

                        const afficherPlusSelector = '#notifications_list > div > a > div > div > div > strong'
                        await page.waitForSelector(afficherPlusSelector)
                        await page.click(afficherPlusSelector)

                        await page.waitForTimeout(6000)
                        await scroll(page,30000)
                        await page.waitForTimeout(6000)

                        const NotificationSelector = 'div > a'
                        await page.waitForSelector(NotificationSelector)

                        const ContenusEtLinks = await page.evaluate((selector) => {
                            const contenusEtlinks = []
		                    const scrapedLinks = document.querySelectorAll(selector)
		                    scrapedLinks.forEach(scrapedLink =>{
                                        if (scrapedLink.innerText && scrapedLink.href){
                                            contenusEtlinks.push({link: scrapedLink.href,
                                                                contenu: scrapedLink.innerText})
                                        }
                                    
                            })
                            return contenusEtlinks
		                }, NotificationSelector)
		                
                        const page2 = await browser.newPage()
                        var avancement = 1
                        var notifications_traites = []
                        var notifications_non_traites = []
                        var notifications_change_nom = []
                        var notifications_comment_like = []
                        var notifications_groupe_membre = []
                        var notifications_post_accepte = []
                        var temps = 0
                        console.log('Nombre de notifications récuperés depuis la page des notifications : '+ContenusEtLinks.length+' notifications')
                        await asyncForEach(ContenusEtLinks,async contenulink =>{
                            var traite = false
                            var traitement = ''
                            var startTime = new Date().getTime();
                            var elapsedTime = 0
                           if (contenulink.contenu.indexOf('a commenté votre publication') != -1){
                                await page2.goto(contenulink.link)
                                var fini = false
                                var i = 1
                                do{
                                    var LikerSelector = 'div > div:nth-child('+i+') > div > div > a[data-sigil="touchable like-reaction-flyout"]'
                                    await page2.waitForSelector(LikerSelector,{timeout: 5000}).catch(error => fini = true)
                                    if (!fini){
                                        const style = await page2.evaluate((LikerSelector) => {
                                            const scrapedStyle = document.querySelector(LikerSelector)
                                            if (scrapedStyle.style && scrapedStyle.style[0]){
                                                return scrapedStyle.style[0].indexOf('color') != -1
                                            }else{
                                                return false
                                            }
                                        },LikerSelector)
                                        if (!style){
                                            await page2.click(LikerSelector).catch(error => null)
                                            await page2.waitForTimeout(1000)
                                        }
                                        i = i+1
                                    }
                                }while(!fini);
                                
                                traite = true
                                traitement = 'Mettre un like sur un commentaire de post d\'id : '+ contenulink.link 
                                notifications_traites.push({contenu: contenulink.contenu, traitement: traitement})
                                notifications_comment_like.push({contenu: contenulink.contenu, traitement: traitement})

                           }else if (contenulink.contenu.indexOf('Vous pouvez désormais publier') != -1) {      
                                const id_groupe = 'https://www.'+contenulink.link.split('/?')[0].split('m.')[1]
                                const date = contenulink.contenu.split('\n')[3]
                                var date_adhesion = ''
                                if (date){
                                    var jour = date.split(' ')[0]
                                    const jourInteger = parseInt(jour)
                                    if (jourInteger < 10){
                                        jour = '0' + jour
                                    }
                                    var mois = date.split(' ')[1]
                                    if (mois.indexOf('janvier') != -1) mois = '01'
                                    if (mois.indexOf('février') != -1) mois = '02'
                                    if (mois.indexOf('mars') != -1) mois = '03'
                                    if (mois.indexOf('avril') != -1) mois = '04'
                                    if (mois.indexOf('mai') != -1) mois = '05'
                                    if (mois.indexOf('juin') != -1) mois = '06'
                                    if (mois.indexOf('juil') != -1) mois = '07'
                                    if (mois.indexOf('août') != -1) mois = '08'
                                    if (mois.indexOf('septembre') != -1) mois = '09'
                                    if (mois.indexOf('octobre') != -1) mois = '10'
                                    if (mois.indexOf('novembre') != -1) mois = '11'
                                    if (mois.indexOf('décembre') != -1) mois = '12'

                                    const today = new Date()
                                
                                    date_adhesion = today.getFullYear()+'-'+mois+'-'+jour
                                }
			                    var err = await UpdateStatutAdhesionGroupe(db,id_ambassadeur,id_groupe,'membre')
                                err = await UpdateDateAdhesionGroupeAmbassadeur(db,id_groupe,id_ambassadeur,date_adhesion)
                                traite = true
                                traitement = 'Ajouter la date d\'dhésion : '+ date_adhesion+' au groupe d\'id : '+ id_groupe 
                                notifications_traites.push({contenu: contenulink.contenu, traitement: traitement})
                                notifications_groupe_membre.push({contenu: contenulink.contenu, traitement: traitement})
                                
                            }else if (contenulink.contenu.indexOf('Un administrateur a approuvé votre publication dans') != -1) {
                                const id_post = 'https://www.'+contenulink.link.split('/?')[0].split('m.')[1]
                                const groupLink = id_post.split('/permalink')[0]
                                const lienPost = id_post.split('permalink')[0]+'posts'+id_post.split('permalink')[1]
                                const idPost = await getIdPostCampagne(db,groupLink,id_campagne)
                                
                                if (idPost){
                                    var err = await UpdatePostPartage(db,idPost,'','acceptée',id_ambassadeur,groupLink)
                                    err = await UpdatePost(db,idPost,lienPost)
                                }
                                traite = true
                                traitement = 'Rendre le statut accepté pour le post d\'id : '+ lienPost+' dans le groupe d\'id : '+ groupLink 
                                notifications_traites.push({contenu: contenulink.contenu, traitement: traitement})
                                notifications_post_accepte.push({contenu: contenulink.contenu, traitement: traitement})
                                
                           }else if (contenulink.contenu.indexOf('Un administrateur a remplacé le nom du groupe') != -1){
                                const id_groupe = 'https://www.'+contenulink.link.split('/?')[0].split('m.')[1]
                                const nouveau_nom = contenulink.contenu.split('par ')[1].split('.')[0]
                                const err = await UpdateNomGroupe(db,id_groupe,nouveau_nom)
                                traite = true
                                traitement = 'Mettre à jour le nom de groupe d\'id : '+ id_groupe+' par ! '+nouveau_nom 
                                notifications_traites.push({contenu: contenulink.contenu, traitement: traitement})
                                notifications_change_nom.push({contenu: contenulink.contenu, traitement: traitement})
                           }else{
                                notifications_non_traites.push({contenu: contenulink.contenu})
                           }
                    elapsedTime = new Date().getTime() - startTime; 
                    temps = temps + elapsedTime/1000
                    const temps_estime = elapsedTime/1000 * (ContenusEtLinks.length-avancement)
                    var heures_estime =  Math.floor(temps_estime/3600)
                    var minutes_estime =  Math.floor((temps_estime-heures_estime*3600)/60)
                    if (traite){
                        console.log('La notification de contenu : '+contenulink.contenu+', est : traité, Traitement : '+traitement)
                    }else {
                        console.log('La notification de contenu : '+contenulink.contenu+', est : non traité')
                    }
                    console.log('Avancement des notifications traités : ' +avancement+' notifications sur le totale de : '+ContenusEtLinks.length+ ', Taux : '+Math.floor(avancement/ContenusEtLinks.length*100)+'%')
                    if (heures_estime == 0){
                        console.log('Temps estimé pour terminer le traitement des notifications : '+minutes_estime+' minutes')
                    }else{
                        console.log('Temps estimé pour terminer le traitement des notifications : '+heures_estime+' heures et '+minutes_estime+' minutes')
                    }
			        avancement = avancement + 1
 
	        })
	           
               await page.goto('https://m.facebook.com/notifications')
               await scroll(page,3000)
               
	           console.log('Fin Script')
	           var heures =  Math.floor(temps/3600)
               var minutes =  Math.floor((temps-heures*3600)/60)
	           if (ContenusEtLinks.length == 0){
	                rapport = rapport +'\nRapport'
	                rapport = rapport +'Aucun notification est récuperé depuis la page des notifications'
	           }else{ 
	                var today = new Date()
	               rapport = rapport +'\n| Report Traiter Notifications"'+today.toString()+'" |'
	               rapport = rapport +'        CAMPAGNE N° '+id_campagne+'\n        '
	               rapport = rapport +nomCampagne
	               rapport = rapport +'\n --  Notifications dans la liste : '+ContenusEtLinks.length
	               rapport = rapport +' Notifications traités : '+notifications_traites.length
	               rapport = rapport +' Notifications non traités : '+notifications_non_traites.length
	               
	               rapport = rapport +'\n       ++ ACTIVITE ++'
	               rapport = rapport +' Groupe Change de Nom : '+notifications_change_nom.length
                   rapport = rapport +' Commentaire Post Partagé Liké : '+notifications_comment_like.length
	               rapport = rapport +' POst Partagé accepté dans groupe : '+notifications_post_accepte.length
	               rapport = rapport +' Ambassadeur membre Groupe : '+notifications_groupe_membre.length
	               
	           }
	           rapport = rapport +'\nTemps totale de traitement des notifications : '+heures+' heures et '+heures+' minutes'
	             console.log(rapport)
        resolve(LinkGroup)
    })
}

