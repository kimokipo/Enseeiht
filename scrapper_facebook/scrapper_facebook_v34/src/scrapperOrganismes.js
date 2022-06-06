import scroll from '@pierreminiggio/puppeteer-page-scroller'
import asyncForEach from '@pierreminiggio/async-foreach'
import stocker from './stocker.js'
import getLinkMobile from './getLinkMobile.js'
import getLinkMobileBasic from './getLinkMobileBasic.js'
import getTable from '../getTable.js'
import InsertQuestionAdhesion from './InsertQuestionAdhesion.js'
import getIdQuestion from './getIdQuestion.js'
import InsertQuestionGroupe from './InsertQuestionGroupe.js'

/**
 * @param {import("puppeteer").Page} page
 * @param {import("puppeteer").Page} page2
 * @returns {Promise<string[[]]>}
 */

export default (page,page2) => {
    return new Promise(async resolve => {
        const LinkGroup = []
	
		await page.goto('https://www.pagesjaunes.fr/annuaire/chercherlespros?quoiqui=estheticienne&ou=Autour+de+moi&univers=pagesjaunes&idOu=&accuracy=519360&latitude=43.6011008&longitude=1.441792')
            const linksOrganismeSelector = 'div > header > div > div > h3 > a'
			const linksOrganismes = await page.evaluate((selector) => {
                        const links = []
		                const scrapedLinks = document.querySelectorAll(selector)
		                scrapedLinks.forEach(scrapedLink=>{
                                links.push(scrapedLink.href)
                        })
                        return links
		    }, linksOrganismeSelector)

            console.log(linksOrganismes)

            const SitesOfficielsOrganismes = []
            await asyncForEach(linksOrganismes, async link => {
                await page2.goto(link)
                
                const SiteOfficielOrganismeSelector = '#teaser-footer > div > div > div > a'
			    const SiteOfficielOrganisme = await page2.evaluate((selector) => {
                            const links = []
		                    const scrapedSiteOfficielOrganismes = document.querySelectorAll(selector)
		                    scrapedSiteOfficielOrganismes.forEach(scrapedSiteOfficielOrganisme=>{
                                    links.push(scrapedSiteOfficielOrganisme.href)
                            })
                            return links[0]
		        }, SiteOfficielOrganismeSelector)

                SitesOfficielsOrganismes.push(SiteOfficielOrganisme)
            })

            console.log(SitesOfficielsOrganismes)
                    


             
	     
        resolve(LinkGroup)
    })
}

