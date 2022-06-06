
import puppeteer from 'puppeteer'
import loginGoogle from './src/loginGoogle.js'
import scrapperSiteLlc from './src/scrapperSiteLlc.js'

 (async function () {
	const browser = await puppeteer.launch({
            headless: false,
		args: ["--no-sandbox","--disable-notifications"]
        });
	
	const page2 = await browser.newPage()
	await loginGoogle(page2)
    const page3 = await browser.newPage()
	


	const Ids = await scrapperSiteLlc(page2,page3)
	
	//browser.close()
})();
