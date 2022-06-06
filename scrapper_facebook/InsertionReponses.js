import puppeteer from 'puppeteer'
import loginGoogle from './src/loginGoogle.js'
import asyncForEach from '@pierreminiggio/async-foreach'
import insererReponses from './src/insererReponses.js'
import login from './src/login.js'
import loginKamal from './src/loginKamal.js'

 (async function () {
    
	const browser = await puppeteer.launch({
            headless: false,
		args: ["--no-sandbox","--disable-notifications"]
        });
	
	const page2 = await browser.newPage()
	await loginGoogle(page2)


	const Ids = await insererReponses(page2)

	await page2.waitForTimeout(30000)
	//browser.close()
    console.log('fini')
})();
