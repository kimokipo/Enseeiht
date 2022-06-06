import scroll from '@pierreminiggio/puppeteer-page-scroller'
import asyncForEach from '@pierreminiggio/async-foreach'
import getLinkMobile from './getLinkMobile.js'
import getLinkMobileBasic from './getLinkMobileBasic.js'
import InsertAnalysePostGroupe from './InsertAnalysePostGroupe.js'
import UpdateAnalysePostGroupe from './UpdateAnalysePostGroupe.js'
import getGroupesAmbassadeurReleveAnalyse from './getGroupesAmbassadeurReleveAnalyse.js'
import dbconnect from './dbconnection.js'
import UpdateNombrePostsReleveAnalyseGroupe from './UpdateNombrePostsReleveAnalyseGroupe.js'
import UpdateReleve100PostsGroupe from './UpdateReleve100PostsGroupe.js'

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
            var avancement_groupe = 1
            var groupes_releves = []
            var temps = 0
            const groupes = await getGroupesAmbassadeurReleveAnalyse(db,id_ambassadeur)
            console.log('Nombre de groupes récuperés depuis la base de données : '+groupes.length+' groupes')

            await asyncForEach(groupes, async groupe => {
			    var groupLink = groupe.id_groupe
                var nom = groupe.nom
                var numero_post = 1
                if (groupe.nb_posts_releve_analyse){
                    numero_post = numero_post + groupe.nb_posts_releve_analyse
                }
                
                var posts_releves = []
                var temps_groupe = 0
                var nb_posts = Math.floor(groupe.frequence_post_mois/4)
                if (nb_posts > 100){
                     nb_posts = 100
                }
                
                const lienMobileGroupe = await getLinkMobile(groupLink)

                await page.goto(lienMobileGroupe,{timeout: 0})
                await page.waitForTimeout(1000)

			    var resultat = {}
		        do {
                    await scroll(page,3000)
			        resultat =  await page.evaluate( async (groupLink,nb_posts) => {
				        var linksReactions = []
                        var fini = false
                        const posteurSelector = 'div > header > div > div > div > div > h3'

                        const TexteSelector1 = 'div > div > div > div > span > p'
                        const TexteSelector2 = 'div > div > div > div > span > span > span'
                        const TexteSelector3 = 'div > div > div > div > div > span > p'
                       
                        const linkEtReactionsSelector = 'footer > div > div > a'
                        const Heure_postageSelector = 'div > header > div > div > div > div > div > a > abbr'
				        const scrapedLinks = document.querySelectorAll('article')
				        
				        scrapedLinks.forEach(scrapedLink => {
                                if (scrapedLink.querySelector(posteurSelector)){
                                    var texte = ''
                                    var type = ''
                                    if (scrapedLink.querySelector(TexteSelector1) && scrapedLink.querySelector(TexteSelector1).innerText.localeCompare('') != 0){
                                        texte = texte + scrapedLink.querySelector(TexteSelector1).innerText
                                        type = type + 'Publié directement'
                                    }
                                    if (scrapedLink.querySelector(TexteSelector2)){
                                        texte = texte + scrapedLink.querySelector(TexteSelector2).innerText
                                        type = type + 'Texte dans une image'
                                    }
                                    if (scrapedLink.querySelector(TexteSelector3)){
                                        if (texte.indexOf(scrapedLink.querySelector(TexteSelector3).innerText) == -1){
                                            texte = texte + scrapedLink.querySelector(TexteSelector3).innerText
                                            type = type + 'Paratgé depuis un autre source'
                                        }
                                    }
                                    const scrapedHeure = scrapedLink.querySelector(Heure_postageSelector).innerText
                                    var jour = scrapedHeure.split(' ')[0]
                                    
                                    const jourInteger = parseInt(jour)
                                    if (jourInteger < 10){
                                        jour = '0' + jour
                                    }
                                    var mois = scrapedHeure.split(' ')[1]
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
                                    const date_postage = new Date()
                                    

                                    var heure_postage = date_postage.getFullYear()+'-'+mois+'-'+jour +' '+ scrapedHeure.split(' ')[2] + ':00'
                                
                                    const scrapedPosteur = scrapedLink.querySelector(posteurSelector)
                                    const nomPosteur = scrapedPosteur.querySelector('strong > a').innerText
                                    const linkPosteur = scrapedPosteur.querySelector('strong > a').href

                                    if (scrapedLink.querySelector(linkEtReactionsSelector)){
                                        var likes = '0'
                                        var comments = '0'
                                        var shares = '0'
                                                        
                                        if (scrapedLink.querySelectorAll(linkEtReactionsSelector+' > div > div')){
                                             const Reactions = scrapedLink.querySelectorAll(linkEtReactionsSelector+' > div > div')
                                             if(Reactions[0]){
                                                    const jaime = Reactions[0].innerText.split('\n')
                                                    if (jaime[jaime.length-1].localeCompare('') != 0){
                                                        likes = jaime[jaime.length-1]
                                                    }
                                             }
                                             if (Reactions[1]){
                                                if (Reactions[1].innerText.split(' ')[1] && Reactions[1].innerText.split(' ')[1].indexOf('commentaires') != -1){
                                                    comments = Reactions[1].innerText.split(' ')[0]
                                                    if (Reactions[1].innerText.split(' ')[1].split('commentaires')[1].localeCompare('') != 0){
                                                        shares = Reactions[1].innerText.split(' ')[1].split('commentaires')[1]
                                                    }
                                                }else{
                                                    if (Reactions[1].innerText.split(' ')[0].localeCompare('') != 0){
                                                        shares = Reactions[1].innerText.split(' ')[0]
                                                    }
                                                }
                                             }
                                             
                                        }
                    
				                    	const split = scrapedLink.querySelector(linkEtReactionsSelector).href.split('?')[0].split('/')
					                    split.pop()
					                    const postLink = split.join('/')
					                    const positionLink1 = postLink.indexOf("permalink/")
                                        const positionLink2 = postLink.indexOf("posts/")

				                        if (positionLink1 != -1 | positionLink2 != -1){
				                               
					                           linksReactions.push({link: postLink, contenu: [likes,comments,shares], posteur: [nomPosteur,linkPosteur], Heure: heure_postage, texte_type_Postage: [texte,type]})
				                        }
                                    }
                                }
				        })

                        if (linksReactions.length == 0){ 
                            fini = true
                        }else if (linksReactions.length >= nb_posts) { 
                            fini = true
                            linksReactions = linksReactions.slice(0,nb_posts)
                        }
                        
				        return {
                                    est_fini: fini,
                                    linksReactions: linksReactions
                        }
           		    },  groupLink,nb_posts)

		        }while(!resultat.est_fini);

                const linksReactions = resultat.linksReactions

                if (linksReactions ){
                    

                    var avancement_post = 1
                    
                    const posts = linksReactions.slice(numero_post-1)
                    console.log('Début relevé posts de groupe numero : '+avancement_groupe+', de Nom : '+nom+', de Lien : '+groupLink)
                    console.log('Nombre de posts à relever : '+posts.length+' posts\nlinks et reactions : ')
                    console.log(posts)                    
                    await asyncForEach(posts, async linksEtreaction => {
                            var data_scrappe_post = ''
                             var startTime = new Date().getTime();
                             var elapsedTime = 0
			                 var scrapedlink = 'https://www.'+ linksEtreaction.link.split('m.')[1]
                             const posteurNom = linksEtreaction.posteur[0]
                             const posteurLink = 'https://www.'+linksEtreaction.posteur[1].split('?')[0].split('m.')[1]
                             const heure_postage = linksEtreaction.Heure
                             const texte = linksEtreaction.texte_type_Postage[0]
                             
                             const type = linksEtreaction.texte_type_Postage[1]
                             
                             const likes = linksEtreaction.contenu[0]
                             const comments = linksEtreaction.contenu[1]
                             const shares = linksEtreaction.contenu[2]

                            
                            var nb_likes = 0

                            if (likes && likes.indexOf('K') != -1 ){
                                    const decimale = likes.split(' ')[0]
                                    if (decimale.indexOf('.') != -1 ){
                                        const naturel = decimale.split('.')[0]
                                        const aprèsvergule = decimale.split('.')[1]
                                        nb_likes = parseInt(naturel)*1000 + parseInt(aprèsvergule)*100
                                    }else{
                                        nb_likes = parseInt(decimale)*1000
                                    }
                            }else if (likes){
                                nb_likes = parseInt(likes)
                            }
                            
                            var nb_comments = 0
                            if (comments){
                                nb_comments = parseInt(comments)
                            }
                               
                            var nb_shares = 0
                            if (shares){
                                nb_shares =  parseInt(shares)
                            }

                        var err = await InsertAnalysePostGroupe(db,scrapedlink,nb_likes,nb_comments,nb_shares,groupLink,posteurNom,posteurLink,heure_postage,texte,type)
                        if (err) {
                                err = await UpdateAnalysePostGroupe(db,scrapedlink,nb_likes,nb_comments,nb_shares,posteurNom,posteurLink,heure_postage,texte,type)
                        }
                        err = await UpdateNombrePostsReleveAnalyseGroupe(db,groupLink,avancement_post+numero_post-1)
                        data_scrappe_post = 'Nom du Posteur : '+posteurNom+', Lien du posteur : '+posteurLink+', Date et Heure de Publication : '+heure_postage+', Texte du Post : '+texte+', Type du Post : '+type+', Nombre de Likes : '+nb_likes+', Nombre de Comments : '+ nb_comments+', Nombre de shares : '+nb_shares
                    posts_releves.push({lien : scrapedlink, data_scrappe: data_scrappe_post})
                    
                    elapsedTime = new Date().getTime() - startTime; 
                    temps_groupe = temps_groupe + elapsedTime/1000
                    const temps_estime_groupe = elapsedTime/1000 * (posts.length-avancement_post)
                    var heures_estime_groupe =  Math.floor(temps_estime_groupe/3600)
                    var minutes_estime_groupe =  Math.floor((temps_estime_groupe-heures_estime_groupe*3600)/60)
                    
                    console.log('Le post d\id : '+scrapedlink+', est : relevé, Data relevé : '+data_scrappe_post)
                    
                    console.log('Avancement des posts relevés : ' +avancement_post+' posts sur le totale de : '+posts.length+ ', Taux : '+Math.floor(avancement_post/posts.length*100)+'%')
                    if (heures_estime_groupe == 0){
                        console.log('Temps estimé pour terminer le relevé des posts : '+minutes_estime_groupe+' minutes')
                    }else{
                        console.log('Temps estimé pour terminer le releve des posts : '+heures_estime_groupe+' heures et '+minutes_estime_groupe+' minutes')
                    }
			        avancement_post = avancement_post + 1
 
	        })
	          var err = await UpdateReleve100PostsGroupe(db,groupLink,'relevé')
	        }
	           groupes_releves.push({lien : groupLink, nom : nom, nb_posts : posts_releves.length}) 
	           console.log('Fin Releve Groupe')
	           var heures_groupe =  Math.floor(temps_groupe/3600)
               var minutes_groupe=  Math.floor((temps_groupe-heures_groupe*3600)/60)
	           if (posts_releves.length == 0){
	                console.log('\nRapport Groupe')
	                console.log('Aucun post est récuperé depuis le groupe')
	           }else{
	               console.log('\n| Report Groupe "'+groupLink+'" |')
	               console.log(' --  Posts dans la liste : '+posts_releves.length)
	               console.log(' Posts relevés : '+posts_releves.length) 
	           }
	           console.log('\nTemps totale de relevé des posts : '+heures_groupe+' heures et '+minutes_groupe+' minutes\n')
                
              
                    temps = temps + temps_groupe
                    const temps_estime = temps_groupe* (groupes.length-avancement_groupe)
                    var heures_estime =  Math.floor(temps_estime/3600)
                    var minutes_estime =  Math.floor((temps_estime-heures_estime*3600)/60)
                    console.log('Avancement des groupes relevés : ' +avancement_groupe+' groupes sur le totale de : '+groupes.length+ ', Taux : ' +avancement_groupe/groupes.length*100+'%')

			        avancement_groupe = avancement_groupe + 1
			      
            })
               console.log('Fin Script')
	           var heures =  Math.floor(temps/3600)
               var minutes =  Math.floor((temps-heures*3600)/60)
	           if (groupes.length == 0){
	                rapport = rapport +'\nRapport'
	                rapport = rapport +'Aucun groupe est récuperé depuis la base'
	           }else{ 
	               var today = new Date()
	               rapport = rapport +'\n| Report Relever 100 Posts Groupe "'+today.toString()+'" |'
	               rapport = rapport +' --  Groupes dans la liste : '+groupes.length
	               rapport = rapport +' Groupes relevés : '+groupes_releves.length
	           }
	           rapport = rapport +'\nTemps totale de relevé : '+heures+' heures et '+heures+' minutes'
               console.log(rapport)
	    resolve(LinkGroup)
    })
}

