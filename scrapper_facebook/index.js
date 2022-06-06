import stocker from './src/stocker.js'
import chercher from './src/chercher.js'
import puppeteer from 'puppeteer'
import loginGoogle from './src/loginGoogle.js'
import asyncForEach from '@pierreminiggio/async-foreach'
import login from './src/login.js'

 (async function () {
	const browser = await puppeteer.launch({
            headless: false,
		args: ["--no-sandbox","--disable-notifications"]
        });
        const page = await browser.newPage()
	const page2 = await browser.newPage()
	await loginGoogle(page2)
	await login(page)
	lien_google = 'https://docs.google.com/spreadsheets/d/13_kT0QfjXlGcrOp5xb11VeJDhbEG-WljvKpZUv3_ZKM/edit#gid=0'
	
	const Ids = await chercher(page,'/search/?q=laura%20lalaChante')
	var i = 2
	await asyncForEach(Ids, async grouplinks => {
		await asyncForEach(grouplinks, async link =>{
			await stocker(page2,lien_google+'&range=A'+i,link)
			i=i+1
		})
	})
	browser.close()
})();
