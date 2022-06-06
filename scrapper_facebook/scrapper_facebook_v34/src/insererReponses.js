import scroll from '@pierreminiggio/puppeteer-page-scroller'
import asyncForEach from '@pierreminiggio/async-foreach'
import stocker from './stocker.js'
import getLinkMobile from './getLinkMobile.js'
import getLinkMobileBasic from './getLinkMobileBasic.js'
import getTable from '../getTable.js'
import InsertReponseAdhesion from './InsertReponseAdhesion.js'
import dbconnect from './dbconnection.js'
import InsertQuestionAdhesion from './InsertQuestionAdhesion.js'
import getIdQuestion from './getIdQuestion.js'
import InsertQuestionGroupe from './InsertQuestionGroupe.js'

/**
 * @param {import("puppeteer").Page} page
 * @returns {Promise<string[[]]>}
 */

export default (page) => {
    return new Promise(async resolve => {
        const LinkGroup = []
	        var db = dbconnect()
	var i = 2
    await page.goto('https://docs.google.com/spreadsheets/d/1OnwgxjrdE2AZvlIO3ShmyoNGRLDrqGpfVOBx525bzlU/edit#gid=1776021983')
     await page.waitForTimeout(6000)
    while(true){
		await page.goto('https://docs.google.com/spreadsheets/d/1OnwgxjrdE2AZvlIO3ShmyoNGRLDrqGpfVOBx525bzlU/edit#gid=1776021983&range=A'+i,{timeout: 0})
		
		const linkSelector = '#t-formula-bar-input'
		await page.waitForSelector(linkSelector,{timeout: 0})

		var id_question = await page.evaluate((selector) => {
		    const scrapedlink = document.querySelector(selector)
		    return scrapedlink.innerText.split('\n')[0]
                	
		    
		}, linkSelector)
		if (id_question.localeCompare('') == 0){
			break;
		}else{  
                           await page.goto('https://docs.google.com/spreadsheets/d/1OnwgxjrdE2AZvlIO3ShmyoNGRLDrqGpfVOBx525bzlU/edit#gid=1776021983&range=B'+i)
                        const linkSelector = '#t-formula-bar-input'
		                await page.waitForSelector(linkSelector,{timeout: 0})

		                var Question = await page.evaluate((selector) => {
		                    const scrapedlink = document.querySelector(selector)
		                    return scrapedlink.innerText.split('\n')[0]
                                	
		                }, linkSelector)
		                
		                 await page.goto('https://docs.google.com/spreadsheets/d/1OnwgxjrdE2AZvlIO3ShmyoNGRLDrqGpfVOBx525bzlU/edit#gid=1776021983&range=F'+i)
		                await page.waitForSelector(linkSelector,{timeout: 0})

		                var Reponse = await page.evaluate((selector) => {
		                    const scrapedlink = document.querySelector(selector)
		                    return scrapedlink.innerText.split('\n')[0]
                                	
		                }, linkSelector)
		               
		                await page.goto('https://docs.google.com/spreadsheets/d/1OnwgxjrdE2AZvlIO3ShmyoNGRLDrqGpfVOBx525bzlU/edit#gid=1776021983&range=G'+i)
		                await page.waitForSelector(linkSelector,{timeout: 0})

		                var reponse2 = await page.evaluate((selector) => {
		                    const scrapedlink = document.querySelector(selector)
		                    return scrapedlink.innerText.split('\n')[0]
                                	
		                }, linkSelector)
		                
		                await page.goto('https://docs.google.com/spreadsheets/d/1OnwgxjrdE2AZvlIO3ShmyoNGRLDrqGpfVOBx525bzlU/edit#gid=1776021983&range=H'+i)
		                await page.waitForSelector(linkSelector,{timeout: 0})

		                var reponse3 = await page.evaluate((selector) => {
		                    const scrapedlink = document.querySelector(selector)
		                    return scrapedlink.innerText.split('\n')[0]
                                	
		                }, linkSelector)
		                
		                
		               await page.goto('https://docs.google.com/spreadsheets/d/1OnwgxjrdE2AZvlIO3ShmyoNGRLDrqGpfVOBx525bzlU/edit#gid=1776021983&range=D'+i)
		                
		                await page.waitForSelector(linkSelector,{timeout: 0})

		                var id_groupe = await page.evaluate((selector) => {
		                    const scrapedlink = document.querySelector(selector)
		                    return scrapedlink.innerText.split('\n')[0]
                                	
		                }, linkSelector)
		                
		                    var err = await InsertQuestionAdhesion(db,Question,Reponse,reponse2,reponse3)
		                    await page.waitForTimeout(3000)
		                    var id_question = await getIdQuestion(db,Question)
		                    err = await InsertQuestionGroupe(db,id_groupe,id_question)
                        
                     
                     
        }
        i = i+1
    }
        resolve(LinkGroup)
    })
}

