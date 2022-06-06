import scroll from '@pierreminiggio/puppeteer-page-scroller'
import asyncForEach from '@pierreminiggio/async-foreach'
import stocker from './stocker.js'
import getLinkMobile from './getLinkMobile.js'
import getLinkMobileBasic from './getLinkMobileBasic.js'
import getTable from '../getTable.js'
import InsertPost from './InsertPost.js'
import UpdatePost from './UpdatePost.js'
import InsertPostPartage from './InsertPostPartage.js'
import UpdatePostPartage from './UpdatePostPartage.js'
import InsertSegmentGroupe from './InsertSegmentGroupe.js'

/**
 * @param {Number[]} liste
 * @param {import("puppeteer").Page} page
 * @param {import("puppeteer").Page} page2
 * @param {string} motif
 * @param {string} contenu
 * @param {string} contenu2
 * @param {Number} id_campagne
 * @returns {Promise<string[[]]>}
 */
export default (liste,page,page2,motif,contenu,contenu2,id_campagne) => {
    return new Promise(async resolve => {
        const LinkGroup = []
	var i = 4
	await page2.goto('https://docs.google.com/spreadsheets/d/1c3jcXVoq__-DwRqUyl2Agjz_MGCo6dyA/edit#gid=580556643',{timeout: 0})
    await page.waitForTimeout(6000)
	while(true){
		
		await page2.goto('https://docs.google.com/spreadsheets/d/1c3jcXVoq__-DwRqUyl2Agjz_MGCo6dyA/edit#gid=580556643&range=C'+i,{timeout: 0})
		
		const linkSelector = '#t-formula-bar-input'
		await page2.waitForSelector(linkSelector,{timeout: 0})

		var groupLink = await page2.evaluate((selector) => {
		    const scrapedlink = document.querySelector(selector)
		    return scrapedlink.innerText.split('\n')[0]
                	
		    
		}, linkSelector)
		if (groupLink.localeCompare('') == 0){
			break;
		}else{
		
			const tab = groupLink.split('/')
			const tab2 = tab.slice(0,5)
			groupLink = tab2.join('/')
            
            await page2.goto('https://docs.google.com/spreadsheets/d/1c3jcXVoq__-DwRqUyl2Agjz_MGCo6dyA/edit#gid=580556643&range=J'+i,    {timeout: 0})
		
		const linkSelector = '#t-formula-bar-input'
		await page2.waitForSelector(linkSelector,{timeout: 0})

		var segment = await page2.evaluate((selector) => {
		    const scrapedlink = document.querySelector(selector)
		    return scrapedlink.innerText.split('\n')[0]
                	
		    
		}, linkSelector)

         const id_segment = parseInt(segment)      
                console.log(i,groupLink,id_segment)
            
                    var err = await InsertSegmentGroupe(groupLink,id_segment)
			 		if (err){
                        console.log(err,typeof(err))
                        i = i+1
                        continue	 		
                    }
                    //await page.waitForTimeout(1000)
			
			
			
		}
		i = i+1
	}
	     
        
        
        resolve(LinkGroup)
    })
}

