/* Scrapper les informations générales des groupes à partir d'un Google Sheet,
     en désactivant les notifications des groupes où l'ambassadeur est membre ,
    et relever les questions d'adhésion s'ells éxistent, en plus des noms et roles des administrateurs, après 
    les stocker dans la base de données
*/

import puppeteer from 'puppeteer'
import loginGoogle from './src/loginGoogle.js'
import scrapperGroupFB from './src/scrapperGroupFB.js'
import getLoginAmbassadeur from './src/getLoginAmbassadeur.js'
import login from './src/login.js'

 (async function () {

    const prenom = process.argv[2]
	const lienGoogleSheet = process.argv[3]
	const colonne = process.argv[4]
    const ligne = process.argv[5]

    if (process.argv.length < 6) {

            console.log('Nombre d\'arguments est trop petit !\n')
            await AfficherMenu()

    }else {
        
        if (prenom && (await getLoginAmbassadeur(prenom)) && lienGoogleSheet && colonne && ligne) {

                const loginPassword = await getLoginAmbassadeur(prenom)

	            const browser = await puppeteer.launch({
                        headless: false,
		            args: ["--no-sandbox","--disable-notifications"]
                    });
	            
	            const page2 = await browser.newPage()
	            await loginGoogle(page2)

                const page = await browser.newPage()

                await login(page,prenom,loginPassword)

	            const Ids = await scrapperGroupFB(lienGoogleSheet,colonne,ligne,page,page2).catch(error => console.log('fini'))
                await page.waitForTimeout(30000)
      }else{
            console.log('Arguments non valides !\n')
            await AfficherMenu()
        }
    }
    console.log('fini')
    
})();

function AfficherMenu(){

            console.log('How To Use :\n')
            console.log('node scrappeGroupFB.js Prenom lienGoogleSheet colonne ligne\n')
            console.log('Prenom : prenom de l\'ambassadeur de scrappe \nlienGoogleSheet : le lien de Google Sheet contenant les id des groupes \ncolonne : la colonne des id des groupes \nligne : la ligne des id de groupes de début de scrappe')
}
