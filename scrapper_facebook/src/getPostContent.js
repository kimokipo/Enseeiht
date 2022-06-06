import scroll from '@pierreminiggio/puppeteer-page-scroller'
import Author from './Entity/Author.js'
import Likeur from './Entity/Likeur.js'
import Partageur from './Entity/Partageur.js'
import Comment from './Entity/Comment.js'
import Post from './Entity/Post.js'
//import Compagnes from '../Compagnes.js'

/**
 * @param {import("puppeteer").Page} page
 * @param {string} link
 * 
 * @returns {Promise<Post>}
 */
export default (page, link) => {
    console.log('Scraping ... ' + link)
    return new Promise(async resolve => {
        await page.goto(link,{timeout: 0})
	const id_number = link.split('/')[6]
	const url_like = 'https://mbasic.facebook.com/ufi/reaction/profile/browser/?ft_ent_identifier='+id_number+'&refid=18'
	const url_share = 'https://mbasic.facebook.com/browse/shares?id='+id_number

        const authorSelector = 'h2 a'
        await page.waitForSelector(authorSelector).catch(error => resolve(new Post(null, null, null, null, null, 'error')))

	
        const scrapedAuthor = await page.evaluate((selector) => {
            const scrapedAuthor = document.querySelector(selector)
            
            return {
                name: scrapedAuthor.innerText,
                link: scrapedAuthor.href.split('?')[0]
            }
        }, authorSelector).catch(error => resolve(new Post(null, null, null, null, null, 'error')))
	         
            var postAuthor = null
            if (scrapedAuthor){
                postAuthor = new Author(scrapedAuthor.name, scrapedAuthor.link)
            }else{
                resolve(new Post(null, null, null, null, null, 'error'))
            }
          
            const commentSelector = 'div > div:nth-child(1) > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div:nth-child(2) > div > div:nth-child(4) > div > div > div > ul > li'
            
            const commentAuthorSelector = 'div > div > div > div > div:nth-child(1) > div > div > div > span > span > a'
            
            const AfficherPlusSelector = 'div > div:nth-child(1) > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div:nth-child(2) > div > div:nth-child(4) > div > div > div > div:nth-child(5) > div > div > span > span'
            
            await scroll(page,3000)
			await page.waitForSelector(AfficherPlusSelector,{timeout: 5000}).catch(error => null)
       	    await page.click(AfficherPlusSelector).catch(error => null)
			await page.waitForTimeout(1000)
			
            const scrapedComments = await page.evaluate((commentSelector,commentAuthorSelector) => {
                const comments = []
                const scrapedComments = document.querySelectorAll(commentSelector)

                scrapedComments.forEach(scrapedComment => {
                        const scrappedAuthor = scrapedComment.querySelector(commentAuthorSelector)
                        if (scrappedAuthor){
                            comments.push({
                                authorName: scrappedAuthor.innerText,
                                authorLink: scrappedAuthor.href,
                                commentLink: ''
                            })
                        }
                    
                })

                return comments
            },commentSelector,commentAuthorSelector)

            const comments = []
            
            scrapedComments.forEach(scrapedComment => {
                comments.push(new Comment(
                    new Author(scrapedComment.authorName, scrapedComment.authorLink),
                    scrapedComment.commentLink
                ))
            })
		
	    await page.goto(url_like)
	    const likeurSelector = 'h3 a'
	    const Likeurs = []
	    var fini = false
		do {
			const SuivantSelector = '#root > table > tbody > tr > td > div > ul > li:nth-child(11) > table > tbody > tr > td > div > a'
			 const scrapedLikeurs = await page.evaluate((likeurSelector) => {
                const Likeurs = []
                const scrapedLikeurs = document.querySelectorAll(likeurSelector)

                scrapedLikeurs.forEach(scrapedLikeur => {

                    if (scrapedLikeur) {
			const lien_likeur = 'https://www.'+scrapedLikeur.href.split('?')[0].split('mbasic.')[1]
			
                        Likeurs.push({
                            authorName: scrapedLikeur.innerText,
                            authorLink: lien_likeur,
                        })
                    }
                })

                return Likeurs
                     
		    }, likeurSelector)
			await page.waitForTimeout(1000)
			await page.waitForSelector(SuivantSelector,{timeout: 5000}).catch(error => fini = true)
       	    if (!fini){
       	        await page.click(SuivantSelector)
			    await page.waitForTimeout(2000)
			}
            scrapedLikeurs.forEach( scrapedLikeur =>{
                       Likeurs.push(scrapedLikeur)
            })
		}while(!fini);

            const likeurs = []

            Likeurs.forEach(scrapedLikeur => {
                likeurs.push(
                    new Likeur(scrapedLikeur.authorName, scrapedLikeur.authorLink))
            })
            
        await page.goto(url_share)

        const Blocke = await page.evaluate((ContenuBlockeSelector) => {
                                const scrapedBlocke = document.querySelector('head > title')
                                return scrapedBlocke.innerText.indexOf('Cette fonction est temporairement bloquée') != - 1
        }, '').catch(error => null)

        if (Blocke){
                
                resolve(new Post(postAuthor, link, comments, likeurs, null, ''))
        }
       

	    const shareSelector = 'a'
	    const Partageurs = []
	    fini = false
		do {
			const SuivantSelector = '#m_more_item'
		    const scrapedPartageurs = await page.evaluate((shareSelector) => {
                const Partageurs = []
                const scrapedPartageurs = document.querySelectorAll(shareSelector)

                scrapedPartageurs.forEach(scrapedPartageur => {

                    if (scrapedPartageur) {
			const lien_partageur = 'https://www.'+scrapedPartageur.href.split('?')[0].split('mbasic.')[1]
			if (scrapedPartageur.innerText && (scrapedPartageur.innerText.localeCompare('') != 0) && (scrapedPartageur.innerText.localeCompare('Accéder à l’Accueil') != 0) && (scrapedPartageur.innerText.localeCompare('Ajouter') != 0)){
		                Partageurs.push({
		                    authorName: scrapedPartageur.innerText,
		                    authorLink: lien_partageur,
		                })
			}
                    }
                })

                return Partageurs
            }, shareSelector)
            await page.waitForTimeout(1000)
			await page.waitForSelector(SuivantSelector,{timeout: 5000}).catch(error => fini = true)
       	    await page.click(SuivantSelector).catch(error => null)
			await page.waitForTimeout(2000)
            scrapedPartageurs.forEach( scrapedPartageur =>{
                       Partageurs.push(scrapedPartageur)
            })
		}while(!fini);

            const partageurs = []

            Partageurs.forEach(scrapedPartageur => {
                partageurs.push(
                    new Author(scrapedPartageur.authorName, scrapedPartageur.authorLink))
            })
            
            console.log('Scraped !')
            resolve(new Post(postAuthor, link, comments, likeurs, partageurs, ''))
	    
       
    })
}
