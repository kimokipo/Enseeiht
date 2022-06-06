/**
 * @param {import("puppeteer").Page} page
 * @param {string} link
 * @param {string} text
 */		
export default async function (page,link,text) {
			if (text && (text.localeCompare('0') != 0)){
			await page.goto(link,{timeout: 0})
			await page.waitForTimeout(3000)
			await page.keyboard.press('Enter')
			const textInputSelector = '#waffle-rich-text-editor'
			await page.waitForSelector(textInputSelector,{timeout: 0})
			
			await page.evaluate((text, textInputSelector) => {
			    document.querySelector(textInputSelector).innerHTML = text
			}, text, textInputSelector)

			await page.waitForTimeout(1000)
			await page.keyboard.press('Enter')
			}
}
