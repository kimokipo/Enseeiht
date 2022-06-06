/* Partager automatiquement par kamal le post nlinitikhabat n nabil, 
     dans les groupes n tinghir.
*/

import puppeteer from 'puppeteer'
import posterGroupes from './posterIntikhabat.js'
import loginKamal from './scrapper_facebook/src/loginKamal.js'

 (async function () {
                
                console.log('Debut Script')
	            const browser = await puppeteer.launch({
                        headless: false,
		            args: ["--no-sandbox","--disable-notifications"]
                    });
	            
	            const page = await browser.newPage()
	            await loginKamal(page)
                console.log('\nfacebook')
               
	            const Ids = await posterIntikhabat(page)
	            
	            
    console.log('\nfini\n')
    
})();
