import puppeteer from 'puppeteer'
console.log(5)
const browser =  puppeteer.launch({
            headless: false,
		args: ["--no-sandbox","--disable-notifications"]
        });

const page =  browser.newPage()
