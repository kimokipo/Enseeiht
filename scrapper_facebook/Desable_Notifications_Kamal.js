/* désactiver les notifications des groupes où Kamal est membre.
*/

import puppeteer from 'puppeteer'
import desactiverNotificationsKamal from './src/desactiverNotificationsKamal.js'
import loginKamal from './src/loginKamal.js'

 (async function () {
    
                console.log('\nDebut Script\n')
	            const browser = await puppeteer.launch({
                        headless: false,
		            args: ["--no-sandbox","--disable-notifications"]
                });
	            
                var page = await browser.newPage()
                
	            await loginKamal(page)
                console.log('\nfacebook')
	            const Ids = await desactiverNotificationsKamal(page)
	            
                console.log('\nfini\n')
                process.exit(1)
})();
