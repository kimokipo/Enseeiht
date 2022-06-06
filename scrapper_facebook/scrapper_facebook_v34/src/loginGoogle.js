import googleAccount from '../googleIds.js'

/**
 * @param {import("puppeteer").Page} page 
 * 
 * @returns {Promise<>}
 */
export default function (page) {
    return new Promise(async resolve => {
        await page.goto('https://accounts.google.com')
        const loginInputSelector = 'input[type="email"]'
        const passwordInputSelector = 'input[type="password"]'
        await page.waitForSelector(loginInputSelector)
        

        await page.evaluate((login, loginInputSelector) => {
            document.querySelector(loginInputSelector).value = login
        }, googleAccount.login, loginInputSelector)

        await page.waitForTimeout(1000)
        
        const submitLoginButtonSelector = '#identifierNext > div > button'
        await page.waitForSelector(submitLoginButtonSelector)
        await page.click(submitLoginButtonSelector)

        
	await page.waitForTimeout(3000)
	await page.waitForSelector(passwordInputSelector)

	await page.evaluate((password, passwordInputSelector) => {
            document.querySelector(passwordInputSelector).value = password
        }, googleAccount.password, passwordInputSelector)

	await page.waitForTimeout(1000)
        
        const submitpasswordButtonSelector = '#passwordNext > div > button'
        await page.waitForSelector(submitpasswordButtonSelector)
        await page.click(submitpasswordButtonSelector)

        await page.waitForTimeout(3000)
        
        resolve()
    })
}
