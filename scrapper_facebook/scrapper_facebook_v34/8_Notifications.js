/* Traiter les notifications reçu par un ambassadeur (prenom),
     Mettre un like sur un commentaire d'un post, 
    Relever l'id du post accepté dans un groupe, 
   stocker la date d'adhésion dans un groupe dans la base de données.
*/

import puppeteer from 'puppeteer'
import child_process from 'child_process'
import UpdateCookiesAmbassadeur from './src/UpdateCookiesAmbassadeur.js'
import getCookiesAmbassadeur from './src/getCookiesAmbassadeur.js'
import traiterNotifications from './src/traiterNotifications.js'
import getIdAmbassadeur from './src/getIdAmbassadeur.js'
import getLoginAmbassadeur from './src/getLoginAmbassadeur.js'
import login from './src/login.js'

 (async function () {
    const prenom = process.argv[2]
    const nom = process.argv[3]
    var id_campagne = parseInt(process.argv[4])
    
    var id_ambassadeur = 1
    var page = null
    var rapport = ''
    process.stdin.resume();
    
    process.stdin.on('data', async ( chunk) => {             
          const text = chunk.toString();                  
          if (text.indexOf('quitter') != -1){
            var cookies = await page.cookies()
            await UpdateCookiesAmbassadeur(id_ambassadeur,JSON.stringify(cookies, null, 2))
            await page.waitForTimeout(3000)
            console.log(rapport)
            console.log('\nAu revoir\n')
            process.exit(1)
          }
    });
    
    process.on('unhandledRejection', async (reason, promise) => {
            var cookies = await page.cookies()
            if (JSON.stringify(cookies, null, 2).localeCompare('[]') != 0){
                await UpdateCookiesAmbassadeur(id_ambassadeur,JSON.stringify(cookies, null, 2))
                await page.waitForTimeout(3000)
            }
            console.log('Unhandled Rejection at:', promise, 'reason:', reason);
            const message = 'Il y a une crache. Relancer le script'
	                await page.evaluate(async message => {
        
                        await window.alert(message)
                   
                    }, message)
                    const spawn = child_process.spawn
                    if (OS.indexOf('Linux') != -1){
                        const fini_spawn = spawn('notify-send', ['Script Craché']);
                    }else{
                        const exec = child_process.exec
                        const fini_exec = exec('start cmd /C "echo Script Craché && pause"')
                    }
            console.log(rapport)
            console.log('\nAu revoir\n')
            process.exit(1)
        
    });
    
    if (process.argv.length < 3) {

            console.log('Nombre d\'arguments est trop petit !\n')
            await AfficherMenu()

    }else {
        
        if (nom && (await getIdAmbassadeur(prenom,nom)) && prenom && (await getLoginAmbassadeur(prenom,nom))) {
                id_ambassadeur = await getIdAmbassadeur(prenom,nom)
                const loginPassword = await getLoginAmbassadeur(prenom,nom)

                console.log('Debut Script')
	            const browser = await puppeteer.launch({
                        headless: false,
		            args: ["--no-sandbox","--disable-notifications"]
                    });

                page = await browser.newPage()
                const cookiestring = await getCookiesAmbassadeur(id_ambassadeur)
                if (cookiestring){
                    var cookies = JSON.parse(cookiestring)
                    await page.setCookie(...cookies);
                }
                
                var OS = await page.evaluate(async message => {
                        var OS = "OS Inconnu"; 
                        if (navigator.appVersion.indexOf("Win")!=-1) OS = "Windows"; 
                        if (navigator.appVersion.indexOf("Mac")!=-1) OS = "MacOS"; 
                        if (navigator.appVersion.indexOf("X11")!=-1) OS = "Unix"; 
                        if (navigator.appVersion.indexOf("Linux")!=-1) OS = "Linux";
                        return OS
                   
                }, '')
                
	    await login(page,prenom,loginPassword)
	    console.log('\nfacebook')

                if (!id_campagne){
                    id_campagne = 0
                }
                
	            const Ids = await traiterNotifications(page,browser,id_ambassadeur,id_campagne,rapport)
	            
                var cookies = await page.cookies();
                await UpdateCookiesAmbassadeur(id_ambassadeur,JSON.stringify(cookies, null, 2))
	            const message = 'Script Fini'
	            await page.evaluate(async message => {
        
                        await window.alert(message)
                   
                }, message)
                const spawn = child_process.spawn
                if (OS.indexOf('Linux') != -1){
                    const fini_spawn = spawn('notify-send', ['Script Fini']);
                }else{
                    const exec = child_process.exec
                    const fini_exec = exec('start cmd /C "echo Script Fini && pause"')
                }
                await page.waitForTimeout(30000)

	    }else{
            console.log('Arguments non valides !\n')
            await AfficherMenu()
        }
    }
    console.log('\nfini\n')
    process.exit(1)
    
})();

function AfficherMenu(){

            console.log('How To Use :\n')
            console.log('node traiteNotifications.js Prenom nom id_campagne \n')
            console.log('Prenom : prenom de l\'ambassadeur \nnom : nom de l\'ambassadeur \nid_campagne : (facultatif) id de la campagne \n')
}