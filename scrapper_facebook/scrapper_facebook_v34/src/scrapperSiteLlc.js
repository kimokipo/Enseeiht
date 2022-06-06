import scroll from '@pierreminiggio/puppeteer-page-scroller'
import stocker from './stocker.js'
import getLinkMobile from './getLinkMobile.js'
import getLinkMobileBasic from './getLinkMobileBasic.js'
/**
 * @param {import("puppeteer").Page} page2
 * @param {import("puppeteer").Page} page3
 * @returns {Promise<string[[]]>}
 */
export default (page2,page3) => {
    return new Promise(async resolve => {
        const LinkGroup = []
        var today = new Date()
        var hier = new  Date()
        var dateOffset1 = (24*60*60*1000) * 1 
        hier.setTime(today.getTime() - dateOffset1)

       var date_Avant = new Date()
         var dateOffset2 = (24*60*60*1000) * 28
        date_Avant.setTime(hier.getTime() - dateOffset2)

        var mois = ''+(hier.getMonth()+1)
        var jour = ''+(hier.getDate())
        var jourAvant = ''+(date_Avant.getDate())
        var moisAvant = ''+(date_Avant.getMonth()+1)
        
        if ((hier.getDate())<10){
               jour = '0'+jour
        }

        if ((hier.getMonth()+1)<10){
               mois = '0'+mois
        }
        
        if ((date_Avant.getDate())<10){
               jourAvant = '0'+jourAvant
        }

        if ((date_Avant.getMonth()+1)<10){
               moisAvant = '0'+moisAvant
        }

        const date = '_u.date00='+date_Avant.getFullYear()+moisAvant+jourAvant+'&_u.date01='+today.getFullYear()+mois+jour 

		   const site = 'https://analytics.google.com/analytics/web/#/report/acquisition-channels/a131013704w190554367p186689523/'+date+'&_r.drilldown=analytics.trafficChannel:Social'
	    await page3.goto(site)
        await scroll(page3,1000)
        /*const visitFBSelector = 'div'
		const visiteFB = await page3.evaluate(  visitFBSelector => {
				const visites = []
				const scrapedVisites = document.querySelectorAll(visitFBSelector)
				scrapedVisites.forEach( scrapedVisite =>{
                        //if (scrapedVisite.innerText.indexOf('Canaux') != -1 ){
                                visites.push(scrapedVisite.innerText.split(' ')[2])
                        //}else{
                        //null    
                          // }
                })
                return visites
           	},  visitFBSelector)

           	console.log('visiteFB ')
            console.log(visiteFB)
		

		/*const  nouveauxUsersSelector = '#ID-rowTable > thead > tr._GAgNb > td.ACTION-change.TARGET-1.ID-1-0._GAU2b > div.C_DATATABLE_SCORECARD_CARD > div'

		await page3.waitForSelector(nouveauxUsersSelector)
		
		const nouveauxUsers = await page3.evaluate(nouveauxUsersSelector => {
		    const scrapednouveauxUsers = document.querySelector(nouveauxUsersSelector)
		    return scrapednouveauxUsers.innerText
		    
		}, nouveauxUsersSelector)

		
		console.log('nouveauxUsers '+nouveauxUsers)

		const  sessionsSelector = 'div > div:nth-child(1) > div'

		
		
		const sessions = await page3.evaluate(sessionsSelector => {
            const sessions = []
		    const scrapedsessions = document.querySelectorAll(sessionsSelector)
		     scrapedsessions.forEach(scrapedsession =>{
                    sessions.push(scrapedsession.innerText)
               })
            return sessions[16].split('\n')[0]
		    
		}, sessionsSelector)

		
		console.log('sessions ')
        console.log(sessions)


        /*const  dureeSessionSelector = '#ID-rowTable > thead > tr._GAgNb > td.ACTION-change.TARGET-5.ID-5-0._GAU2b > div.C_DATATABLE_SCORECARD_CARD > div'

		await page3.waitForSelector(dureeSessionSelector)
		
		const dureeSession = await page3.evaluate(dureeSessionSelector => {
		    const scrapeddureeSession = document.querySelector(dureeSessionSelector)
		    return scrapeddureeSession.innerText
		    
		}, dureeSessionSelector)

		
		console.log('dureeSession '+dureeSession)
		
		
		/*await stocker(page2,'https://docs.google.com/spreadsheets/d/13_kT0QfjXlGcrOp5xb11VeJDhbEG-WljvKpZUv3_ZKM/edit#gid=675578645&range=B1',today.toString())			
		
		await stocker(page2,'https://docs.google.com/spreadsheets/d/13_kT0QfjXlGcrOp5xb11VeJDhbEG-WljvKpZUv3_ZKM/edit#gid=675578645&range=B2',couverture)			
		
		await stocker(page2,'https://docs.google.com/spreadsheets/d/13_kT0QfjXlGcrOp5xb11VeJDhbEG-WljvKpZUv3_ZKM/edit#gid=675578645&range=B3',likes)			
		
		await stocker(page2,'https://docs.google.com/spreadsheets/d/13_kT0QfjXlGcrOp5xb11VeJDhbEG-WljvKpZUv3_ZKM/edit#gid=675578645&range=B4',abonnes)			
		
		await stocker(page2,'https://docs.google.com/spreadsheets/d/13_kT0QfjXlGcrOp5xb11VeJDhbEG-WljvKpZUv3_ZKM/edit#gid=675578645&range=B5',indiques)
			
			
		
		
	   
            
         */
	
        resolve(LinkGroup)
    })
}

