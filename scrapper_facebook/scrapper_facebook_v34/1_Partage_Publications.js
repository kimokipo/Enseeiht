/* Partager automatiquement par l'ambassadeur (prenom) un post Mère de la campagne (id_campagne), 
     dans les groupes d'un segment (id_segment), 
    avec un message spécifique (lienMessage)
*/

import puppeteer from 'puppeteer'
import child_process from 'child_process'
import UpdateCookiesAmbassadeur from './src/UpdateCookiesAmbassadeur.js'
import getCookiesAmbassadeur from './src/getCookiesAmbassadeur.js'
import posterGroupes from './src/posterGroupes.js'
import getIdAmbassadeur from './src/getIdAmbassadeur.js'
import getLoginAmbassadeur from './src/getLoginAmbassadeur.js'
import login from './src/login.js'

 (async function () {
    const prenom = process.argv[2]
    const nom = process.argv[3]
    const id_campagne = parseInt(process.argv[4])
    const id_segment = parseInt(process.argv[5])
    const contenu = process.argv.slice(6).join(' ')
    var semi_legende = contenu.split(' /// ')[1] +''
    var contenu_post_mere = contenu.split(' /// ')[0] +''
    
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
    
    if (process.argv.length < 7) {

            console.log('Nombre d\'arguments est trop petit !\n')
            await AfficherMenu()

    }else {
        
        if (nom && (await getIdAmbassadeur(prenom,nom)) && prenom && (await getLoginAmbassadeur(prenom,nom)) && id_campagne != null && id_segment && contenu_post_mere && semi_legende) {
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
                
	            const Ids = await posterGroupes(page,id_ambassadeur,id_campagne,id_segment,contenu_post_mere,semi_legende,rapport)
	            
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
            console.log('node 1_Partage_Publications.js Prenom nom id_campagne id_segment lien/contenu_post_mere /// lien/legende_post_partage \n')
            console.log('Prenom : prenom de l\'ambassadeur de Partage \nnom : nom de l\'ambassadeur de Partage \nid_campagne : id de la campagne \nid_segment : id de segment \nlien/contenu_post_mere : lien du post mere ou la phrase la plus longue du post mere sans emoji \n/// : est obligatoire \nlien/contenu_legende_post_partage : lien de la legende ou la phrase la plus longue de la legende du post partage sans emoji')
}
