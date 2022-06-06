
import asyncForEach from '@pierreminiggio/async-foreach'
import stocker from './stocker.js'
import getLinkMobile from './getLinkMobile.js'
import getLinkMobileBasic from './getLinkMobileBasic.js'
import getTable from '../getTable.js'
import getGroupeInfo from './getGroupeInfo.js'
import InsertRelevePost from './InsertRelevePost.js'
import getNewId from './getNewId.js'


/**
 * @param {import("puppeteer").Page} page
 * @returns {Promise<string[[]]>}
 */
export default (page) => {
    return new Promise(async resolve => {
        const LinkGroup = []
        var i = 1
	    /*await page.goto('https://docs.google.com/spreadsheets/d/1dXs2CrFwpkcO6BcxmEue1RKf33GpDbcpYSDTBlb3Fac/edit#gid=0',{timeout: 0})
    await page.waitForTimeout(6000)
	while(true){
		
		await page.goto('https://docs.google.com/spreadsheets/d/1dXs2CrFwpkcO6BcxmEue1RKf33GpDbcpYSDTBlb3Fac/edit#gid=0&range=A'+i,{timeout: 0})
		
		const linkSelector = '#t-formula-bar-input'
		await page.waitForSelector(linkSelector,{timeout: 0})

		var portee_string = await page.evaluate((selector) => {
		    const scrapedlink = document.querySelector(selector)
		    return scrapedlink.innerText.split('\n')[0]
                	
		    
		}, linkSelector)
		if (url_post.localeCompare('') == 0){
			break;
		}else{
                await page.goto('https://docs.google.com/spreadsheets/d/1dXs2CrFwpkcO6BcxmEue1RKf33GpDbcpYSDTBlb3Fac/edit#gid=0&range=F'+i,{timeout: 0})
		
		const linkSelector = '#t-formula-bar-input'
		await page.waitForSelector(linkSelector,{timeout: 0})

		var id_campagne_string = await page.evaluate((selector) => {
		    const scrapedlink = document.querySelector(selector)
		    return scrapedlink.innerText.split('\n')[0]
                	
		    
		}, linkSelector)
                 const id_campagne = parseInt(id_campagne_string)-2
                const err2 = await InsertPostMere(url_post,'','','','',id_campagne)
                 console.log('Post insertion fait')
       }*/
                const RelevePostTable = await getTable('Releve_post')
                const releves = RelevePostTable.slice(71)
                await asyncForEach(releves, async releve => {
			            const idnewPost = await getNewId(releve.url_post)
                         
                        console.log('idnewPost de releve ' +i+' : ' +idnewPost)
                        i = i +1
                 const err2 = await InsertRelevePost(releve.date_releve,releve.nb_likes,releve.nb_comments,releve.nb_shares,releve.portee,releve.interaction,releve.clicks,idnewPost)
                 console.log('Releve insertion fait')
                })
                 /*const PostTable = await getTable('Post')
                await asyncForEach(PostTable, async post => {
			     
                 const err2 = await InsertPost(post.url_post,post.titre,post.type_media,post.legende,post.hashtag,post.id_campagne-2)
                 console.log('Post insertion fait')
                })
                 const PostTable = await getTable('Post')
                await asyncForEach(PostTable, async post => {
			     
                 const err2 = await InsertPost(post.url_post,post.titre,post.type_media,post.legende,post.hashtag,post.id_campagne-2)
                 console.log('Post insertion fait')
                })
                
                

				 	
			*/    
		
	       
	     
        resolve(LinkGroup)
    })
}

