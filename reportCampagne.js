import stocker from './src/stocker.js'
import puppeteer from 'puppeteer'
import loginGoogle from './src/loginGoogle.js'
import asyncForEach from '@pierreminiggio/async-foreach'

 (async function () {
	const browser = await puppeteer.launch({
            headless: false,
		args: ["--no-sandbox","--disable-notifications"]
        });
	
	const page = await browser.newPage()
	await loginGoogle(page)
	
	browser.close()
})();
