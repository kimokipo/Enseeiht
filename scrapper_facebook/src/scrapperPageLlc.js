import scroll from '@pierreminiggio/puppeteer-page-scroller'
import getLinkMobile from './getLinkMobile.js'
import getLinkMobileBasic from './getLinkMobileBasic.js'
import InsertRelevePageLLC from './InsertRelevePageLLC.js'
import dbconnect from './dbconnection.js'
/**
 * @param {import("puppeteer").Page} page
 * @param {Number} id_campagne
 * @param {string} rapport
 * @returns {Promise<string[[]]>}
 */
export default (page,id_campagne,rapport) => {
    return new Promise(async resolve => {
        const LinkGroup = []
	        var db = dbconnect()
		    var startTime = new Date().getTime();
            var elapsedTime = 0
            var scrappe = 'echoué'
	    await page.goto('https://www.facebook.com/lalachante.fr')
        await page.waitForTimeout(3000)
        await scroll(page,1000)
        await page.waitForTimeout(3000)
		const couverture = await page.evaluate( async (contenu,contenu2) => {
				const links = []
				const scrapedLinks = document.querySelectorAll('a')
				
				scrapedLinks.forEach(scrapedLink => {
				    	const split = scrapedLink.href
					const postLink = split
					const contenulink = scrapedLink.innerText
					const positionlink = postLink.indexOf('insights')
						
				  if (! links.includes(postLink) ){
				        
					    
						if (positionlink != -1){
					            links.push(contenulink)
						}
                        
				    }
				   
				})
				return links[2].split('\n')[1].replace(',','')
           	},  '','')
           	console.log('couverture '+couverture)
		await page.waitForTimeout(3000)
		await page.goto('https://mbasic.facebook.com/pages/context/hidden/?page_id=211561366395565&pager_id=u_0_1_kp&start_index=3&after_cursor=2%3Afriend_inviter%3Aadmin_weekly_new_follows%3Apage_categories&ref=page_internal',{timeout: 0})

		const  indiqueSelector = '#pages_mbasic_context_items_id > div:nth-child(5) > a > table > tbody > tr > td.m.ba.x > header > div'
		await page.waitForTimeout(3000)
		await page.waitForSelector(indiqueSelector,{timeout: 0})
		
		const indique = await page.evaluate(selectorIndique => {
		    const scrapedindique = document.querySelector(selectorIndique)
		    return scrapedindique.innerText
		    
		}, indiqueSelector)
		await page.waitForTimeout(3000)
		
		const indiques =  indique.split(' ')[0]
		
		console.log('indiques '+indiques)
		await page.goto('https://mbasic.facebook.com/pg/lalachante.fr/community',{timeout: 0})
	
		const likesAbonnesSelector = '#unit_id_778910625538060'
		
		await page.waitForTimeout(3000)
		await page.waitForSelector(likesAbonnesSelector)
		

		const likesEtabonnes = await page.evaluate(selectorLikesAbonnes => {
		    const scrapedlikesAbonnes = document.querySelector(selectorLikesAbonnes)
		    
		    return  scrapedlikesAbonnes.innerText
			
                     
		    
		}, likesAbonnesSelector)

		const likes = parseInt(likesEtabonnes.split(' ')[0].split('\n')[0])
		const abonnes = parseInt(likesEtabonnes.split(' ')[3].split('\n')[1])
		
		console.log('likes '+likes)
		console.log('abonnes '+abonnes)
		scrappe = 'réussit'
		elapsedTime = new Date().getTime() - startTime; 
        elapsedTime = elapsedTime /1000
		await page.waitForTimeout(3000)
		
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

        const err = await InsertRelevePageLLC(db,abonnes,likes,0,date_releve,id_campagne)
               console.log('Fin Script')
	           var heures =  Math.floor(elapsedTime/3600)
               var minutes =  Math.floor((elapsedTime-heures*3600)/60)
	           var today = new Date()
	           rapport = rapport +'\n| Report Releve Insights Page LLC "'+today.toString()+'" |'
	               rapport = rapport +'    Couverture : '+couverture
	               rapport = rapport +'    Personnes Indiqués leur présence : '+indiques
	               rapport = rapport +'    Likes : '+likes
	               rapport = rapport +'    Abonnés : '+abonnes
	           
	           rapport = rapport +'\nTemps totale de releve : '+heures+' heures et '+heures+' minutes'
	           console.log(rapport)
		resolve(LinkGroup)
    })
}

