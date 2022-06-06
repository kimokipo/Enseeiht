import idsGroups from '../IdsGroups.js'
import scroll from '@pierreminiggio/puppeteer-page-scroller'
import asyncForEach from '@pierreminiggio/async-foreach'
/**
 * @param {import("puppeteer").Page} page
 * @param {string[[]]} ids
 * @param {string} compagnie
 * @returns {Promise<string[[]]>}
 */
export default (page,ids,compagnie) => {
    return new Promise(async resolve => {
        const LinkGroup = []
        await asyncForEach(ids, async Listlink => {
		await asyncForEach(Listlink, async link => {
	     		await page.goto(link)
			const authorSelector = 'h2 a'
			await page.waitForSelector(authorSelector)

			const scrapedAuthor = await page.evaluate((selector) => {
			    const scrapedAuthor = document.querySelector(selector)
			    
			    return scrapedAuthor.innerText
				
			   
			}, authorSelector)
			 const contenuSelector = '#jsc_c_u'
		     	 await page.waitForSelector(contenuSelector)

		
			 const scrapedContenu = await page.evaluate((selector) => {
			    const scrapedContenu = document.querySelector(selector)
			    
			    return  scrapedContenu.innerText,
				
			}, contenuSelector)
			if (scrapedAuthor.localeCompare('Laura LalaChante') == 0) && (scrapedContenu.localeCompare(compagnie) = 0){
				LinkGroup.push(link)
				break;
				
			}
		})
           	
        })

        resolve(LinkGroup)
    })
}

