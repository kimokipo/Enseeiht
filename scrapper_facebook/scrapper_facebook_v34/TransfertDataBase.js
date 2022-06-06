/* scrapper les informations générales des groupes 
   et les stocker dans Google Sheet
*/

import puppeteer from 'puppeteer'
import loginGoogle from './src/loginGoogle.js'
import asyncForEach from '@pierreminiggio/async-foreach'
import transfererDataBase from './src/transfererDataBase.js'
import login from './src/login.js'

 (async function () {

	const browser = await puppeteer.launch({
            headless: false,
		args: ["--no-sandbox","--disable-notifications"]
        });

    const page = await browser.newPage()
    //await loginGoogle(page)
	
    const Ids = await transfererDataBase(page)
    
	//browser.close()
    console.log('fini')
})();
