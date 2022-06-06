/* chercher par les posts partagés d'une campagne (id_campagne) 
    dans les groupes d'un segment (id_segment) qui ont des mots clés spécifiques dans son contenu
   et stocker les id Post scrappés dans la base de données
*/

import puppeteer from 'puppeteer'
import child_process from 'child_process'
import UpdateCookiesAmbassadeur from './src/UpdateCookiesAmbassadeur.js'
import getCookiesAmbassadeur from './src/getCookiesAmbassadeur.js'
import chercherGroupes from './src/chercherGroupes.js'
import getIdAmbassadeur from './src/getIdAmbassadeur.js'
import getLoginAmbassadeur from './src/getLoginAmbassadeur.js'
import login from './src/login.js'


 (async function () {
    const prenom = process.argv[2]
    const nom = process.argv[3]
    const mot_clee = process.argv[4]
    var nb_groupes = parseInt(process.argv[5])

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
                        const fini_exec = exec('start cmd /C "echo Script Fini && pause"')
                    }
            console.log(rapport)
            console.log('\nAu revoir\n')
            process.exit(1)
        
    });
    
    if (process.argv.length < 5) {

            console.log('Nombre d\'arguments est trop petit !\n')
            await AfficherMenu()

    }else {
        
        if (nom && (await getIdAmbassadeur(nom)) && prenom && (await getLoginAmbassadeur(prenom)) && mot_clee ){
                id_ambassadeur = await getIdAmbassadeur(nom)
                const loginPassword = await getLoginAmbassadeur(prenom)

                console.log('\nDebut Script')
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
	            
	            if (!nb_groupes){
	                nb_groupes = 30
	            }
                const Ids = await chercherGroupes(page,mot_clee,nb_groupes,rapport)
	            
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
    console.log('fini')
    process.exit(1)
    
})();

function AfficherMenu(){

            console.log('How To Use :\n')
            console.log('node 10_Chercher_Nouveaux_Groupes.js Prenom nom mot_clee nb_groupes \n')
            console.log('Prenom : prenom de l\'ambassadeur de recherche \nnom : nom de l\'ambassadeur de scrappe \nmot_clee : mot clée de recherche des groupes \nnb_groupes : Nombre de groupes maximale à trouver \n')
}
