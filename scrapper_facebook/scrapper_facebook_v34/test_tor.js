/* Tester la navigation avec tor
*/

import puppeteer from 'puppeteer'

 (async function () {
    
    
    if (process.argv.length < 2) {

            console.log('Nombre d\'arguments est trop petit !\n')
            await AfficherMenu()

    }else {


	            const args = [];
	            const browser = await puppeteer.launch({headless: false, ignoreDefaultArgs: ["--disable-extensions"],args });
	            const page = await browser.newPage();
                await page.waitForTimeout(10000)
                await page.evaluate(async message => {
        
                    await window.alert(message)
                
                }, message)
                
	            /*await page.goto('https://chrome.google.com/webstore/detail/urban-free-vpn-proxy-unbl/eppiocemhmnlbhjplcgkofciiegomcon');
                const AjouterExtensionSelector = 'body > div > div > div > div > div > div > div > div > div > div'
                await page.waitForSelector(AjouterExtensionSelector)
                await page.click(AjouterExtensionSelector)*/
	            const isUsingTor = await page.$eval('body', el =>
		            el.innerHTML.includes('Congratulations. This browser is configured to use Tor')
	            );

	            if (!isUsingTor) {
		            console.log('Not using Tor. Closing...');
		            //return await browser.close();
	            }

	            console.log('Using Tor. Continuing... ');

	            // Now you can go wherever you want

                    // You would add additional code to do stuff... 

	            // Then when you're done, just close
	            //await browser.close();
        
    }
    console.log('fini')
    
})();

function AfficherMenu(){

            console.log('How To Use :\n')
            console.log('node test_tor.js')
}
