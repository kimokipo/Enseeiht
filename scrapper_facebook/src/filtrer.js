import idsGroups from '../IdsGroups.js'
import scroll from '@pierreminiggio/puppeteer-page-scroller'
import asyncForEach from '@pierreminiggio/async-foreach'
import transpose from './transpose.js'
/**
 * @param {import("puppeteer").Page} page
 * @param {string[[]]} ids
 * @returns {Promise<string[[]]>}
 */
export default (page,ids) => {
    return new Promise(async resolve => {
        const LinkGroup = []
        await asyncForEach(ids, async Listlink => {
		const links = []
		await asyncForEach(Listlink, async link => {
	     		await page.goto(link)
			const authorSelector = 'h2 a'
			await page.waitForSelector(authorSelector)

			const scrapedAuthor = await page.evaluate((selector) => {
			    const scrapedAuthor = document.querySelector(selector)
			    
			    return scrapedAuthor.innerText
				
			   
			}, authorSelector)
			if (scrapedAuthor.localeCompare('Laura LalaChante') == 0) {
				links.push(link)
			}
		})
           	LinkGroup.push(links)
        })

        resolve(LinkGroup)
    })
}

