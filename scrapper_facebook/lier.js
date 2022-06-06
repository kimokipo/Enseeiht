/* chercher un post partagé dans les groupes qui a des mots clés spécifiques dans son contenu
   et stocker les id Post scrappés dans Google Sheet
*/
import stocker from './src/stocker.js'
import chercher from './src/chercher.js'
import puppeteer from 'puppeteer'
import loginGoogle from './src/loginGoogle.js'
import asyncForEach from '@pierreminiggio/async-foreach'
import lierSegmentGroupe from './src/lierSegmentGroupe.js'
import login from './src/login.js'

 (async function () {
	const liste = [1,9,10,13,17,25,26,27,28,43,50,52,54,55,58,74,75,81,82,83,84,86,88,89,90,91,92,97,99,102,105,116,119,120,125,126,127,128,129,130,131,142,143,144,145]
	const browser = await puppeteer.launch({
            headless: false,
		args: ["--no-sandbox","--disable-notifications"]
        });
	
	const page2 = await browser.newPage()
	await loginGoogle(page2)

    const page = await browser.newPage()
	//await login(page)

	
	const Ids = await lierSegmentGroupe(liste,page,page2,'/search?q=Laura%20LalaChante&filters=eyJycF9jaHJvbm9fc29ydDowIjoie1wibmFtZVwiOlwiY2hyb25vc29ydFwiLFwiYXJnc1wiOlwiXCJ9IiwicnBfYXV0aG9yOjAiOiJ7XCJuYW1lXCI6XCJhdXRob3JcIixcImFyZ3NcIjpcIjEwMDA0OTM4ODI5MjA2N1wifSJ9','','',0)
	
	browser.close()
    console.log('fini')
    
})();
