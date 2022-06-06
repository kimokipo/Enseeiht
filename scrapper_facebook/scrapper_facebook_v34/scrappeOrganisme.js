import stocker from './src/stocker.js'
import chercher from './src/chercher.js'
import puppeteer from 'puppeteer'
import loginGoogle from './src/loginGoogle.js'
import asyncForEach from '@pierreminiggio/async-foreach'
import scrapperOrganismes from './src/scrapperOrganismes.js'
import login from './src/login.js'
import loginKamal from './src/loginKamal.js'

 (async function () {
    
	const browser = await puppeteer.launch({
            headless: false,
		args: ["--no-sandbox","--disable-notifications"]
        });
	
	const page = await browser.newPage()
    const page2 = await browser.newPage()
	
	const Ids = await scrapperOrganismes(page, page2)

	await page2.waitForTimeout(30000)
	//browser.close()
    console.log('fini')
})();
