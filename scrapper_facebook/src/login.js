import getLoginAmbassadeur from './getLoginAmbassadeur.js'
import getAuthentificationAmbassadeur from './getAuthentificationAmbassadeur.js'
import UpdateAuthentificationAmbassadeur from './UpdateAuthentificationAmbassadeur.js'


/**
 * @param {import("puppeteer").Page} page
 * @param {string} prenom
 * @param {string[]} loginPassword 
 * @returns {Promise<boolean>}
 */
export default function (page,prenom,loginPassword) {
    return new Promise(async resolve => {
        var authentification = await getAuthentificationAmbassadeur(loginPassword[0].login)
        await page.goto('https://www.facebook.com')
	    await page.waitForTimeout(3000)
        if (authentification.indexOf('non') != -1){
            const cookieButtonSelector = '[data-cookiebanner="accept_button"]'
            await page.waitForSelector(cookieButtonSelector)
            await page.click(cookieButtonSelector)
	        await page.waitForTimeout(3000)

            const loginInputSelector = 'input[type="text"]'
            const passwordInputSelector = 'input[type="password"]'
            await page.waitForSelector(loginInputSelector)
            await page.waitForSelector(passwordInputSelector)

            await page.evaluate((login, password, loginInputSelector, passwordInputSelector) => {
                document.querySelector(loginInputSelector).value = login
                document.querySelector(passwordInputSelector).value = password
            }, loginPassword[0].login, loginPassword[0].mdp, loginInputSelector, passwordInputSelector)

            await page.waitForTimeout(3000)
            
            const submitButtonSelector = 'button[type="submit"]'
            await page.waitForSelector(submitButtonSelector)
            await page.click(submitButtonSelector)
            await page.waitForTimeout(60000)
            await UpdateAuthentificationAmbassadeur(loginPassword[0].login,'oui')
        }

        resolve()
    })
}
