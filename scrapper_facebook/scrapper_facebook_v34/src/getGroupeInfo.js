import puppeteer from 'puppeteer'
import scroll from '@pierreminiggio/puppeteer-page-scroller'
import UpdateActifSupprime from './UpdateActifSupprime.js'
/**
 * @param {Connection} db
 * @param {string} groupLink
 * @param {import("puppeteer").Page} page
 * @param {Number} avancement
 * @returns {Promise<string{}>}
 */
export default (db,groupLink,page,avancement) => {
    return new Promise(async resolve => {
                await page.goto(groupLink+'/about',{timeout: 0})
			     await scroll(page,3000)
    
                const nomSelector = 'div > div:nth-child(1) > div > div > div > div > div > div > div:nth-child(1) > div > div > div > div > div > div:nth-child(1) > div > div > div > div > div > div:nth-child(1) > h1 > span'
                await page.waitForSelector(nomSelector,{timeout: 10000}).catch(async error => {
                         const err = await UpdateActifSupprime(db,groupLink,'supprimé')
                         resolve(null)
                })

			    const nom =  await page.evaluate( async (nomSelector) => {
				
				const scrapedNoms = document.querySelectorAll(nomSelector)
				       const noms = []
				scrapedNoms.forEach(scrapedNom => {
				        if (scrapedNom.innerText){
    				    	noms.push(scrapedNom.innerText)
    				    }
				   
				})
				return noms[0]
           		   },  nomSelector)
        
                console.log('\nnom '+avancement)
            
                console.log(nom)

                const AfficherSuitSelector = 'div > div:nth-child(1) > div > div > div > div > div > div > div > div > div:nth-child(2) > div > div > div > div:nth-child(1) > div > div > div > div > div > div:nth-child(2) > div > div > div > span > div > div > div'
                var rien_a_propos = false
                await page.waitForSelector(AfficherSuitSelector,{timeout: 10000}).catch(error => rien_a_propos = true)
                if (!rien_a_propos) {
                    await page.click(AfficherSuitSelector)
                    await page.waitForTimeout(3000)
                }
                

                const themeSelector = 'div > div:nth-child(1) > div > div > div > div > div > div > div > div > div:nth-child(2) > div > div > div > div:nth-child(1) > div > div > div > div > div > div:nth-child(2) > div > div > div > span > div'
                       
                 
                await page.waitForSelector(themeSelector,{timeout: 10000}).catch(error => null)
                
			    var theme =  await page.evaluate( async (themeSelector) => {
				
				const scrapedThemes = document.querySelectorAll(themeSelector)
				       const Themes = []
				scrapedThemes.forEach(scrapedTheme => {
				    	Themes.push(scrapedTheme.innerText)
				   
				})

                
				return Themes.join('\n')
           		   },  themeSelector).catch(error => null)
                
                const typeSelector =  'div > div:nth-child(1) > div > div > div > div > div > div > div:nth-child(1) > div > div > div > div > div > div:nth-child(1) > div > div > div > div > div > div:nth-child(2) > span > div > div:nth-child(1) > div > div:nth-child(2)'
                await page.waitForSelector(typeSelector)

                const type =  await page.evaluate( async (typeSelector) => {

                const scrapedTypes = document.querySelectorAll(typeSelector)
				       const Types = []
				scrapedTypes.forEach(scrapedType => {
				    	Types.push(scrapedType.innerText)
				   
				})
				return Types[0].split(' ')[1]
           		   },  typeSelector)
                
                if (theme){
                        theme = theme.substr(0,theme.length - 10)
                }
                console.log('theme '+avancement)
                
                console.log(theme)
                
                console.log('type '+avancement)

                if (type) {
                    console.log(type)
                }
                
        
                const postMoisSelector = 'div > div:nth-child(2) > span'
        
                await page.waitForSelector(postMoisSelector)

                const postMois =  await page.evaluate( async (postMoisSelector) => {
				
				const scrapedpostMoiss = document.querySelectorAll(postMoisSelector)
				       const postMoiss = []
				scrapedpostMoiss.forEach(scrapedpostMois => {
				    	postMoiss.push(scrapedpostMois.innerText)
				   
				})
                var resultat = ''
                postMoiss.forEach(postMois => {
				    	if (postMois.indexOf('le mois dernier') != -1){
                                    resultat = postMois.split(' ')[0]
                                
                        }
				   
				})
				return parseInt(resultat.split(' ')[0]+resultat.split(' ')[1])
           		   },  postMoisSelector)
        
                console.log('postMois '+avancement) 
                console.log(postMois)

               const  membresSelector = 'div > div:nth-child(1) > span'
                
                   
        
                await page.waitForSelector(membresSelector)

                const membres =  await page.evaluate( async (membresSelector) => {
				
				const scrapedmembres = document.querySelectorAll(membresSelector)
				       const membres = []
				scrapedmembres.forEach(scrapedmembre => {
				    	membres.push(scrapedmembre.innerText)
				   
				})
                var resultat = ''
                membres.forEach(membre => {
				    	if (membre.indexOf('membres au total') != -1){
                            resultat = membre.split(' ')[0]
                        }
				   
				})

				return parseInt(resultat.split(' ')[0]+resultat.split(' ')[1])
           		   },  membresSelector)
        
                console.log('membres '+avancement)
                console.log(membres)

                const reglementationSelector = 'div > div:nth-child(1) > div > div > div > div > div > div > div > div > div:nth-child(2) > div > div > div > div:nth-child(4) > div > div > div > div > div > div > div'
                await page.waitForSelector(reglementationSelector,{timeout: 10000}).catch(error => null)
                const reglementation =  await page.evaluate( async (reglementationSelector) => {
				
				const scrapedReglementations = document.querySelectorAll(reglementationSelector)
				       const reglementations = []
				scrapedReglementations.forEach(scrapedReglementation => {
				    	reglementations.push(scrapedReglementation.innerText)
				   
				})
				return reglementations.join('\n')
           		   }, reglementationSelector).catch(error => null)
        
                console.log('reglementation '+avancement)
                console.log(reglementation)
                
                
                
                 const FormatSelector = 'div > div:nth-child(1) > div > div > div > div > div > div > div > div > div:nth-child(2) > div > div > div > div:nth-child(1) > div > div > div > div > div > div:nth-child(2) > div > div > div > div > div > div > span > span'
                 await page.waitForSelector(FormatSelector,{timeout: 10000}).catch(error => null)
                const formatEtlieus =  await page.evaluate( async (FormatSelector) => {
				
				const scrapedFormats = document.querySelectorAll(FormatSelector)
				       const formats = []
				scrapedFormats.forEach(scrapedFormat => {
				    	    formats.push(scrapedFormat.innerText)
				    	
				})
				return formats
           		   }, FormatSelector)
           		   
           		var lieu = ''
           		var format = 'Classique'
           	    if (formatEtlieus){
           	        var i = 0
           	        formatEtlieus.forEach(formatEtlieu =>{
           	            if (formatEtlieu.indexOf('Achats/Ventes') != -1){
           	                format = formatEtlieu
           	                lieu = formatEtlieus[i-1]
           	            }
           	            i = i+1
           	        })
           	    }
                
                console.log('lieu '+avancement)
                console.log(lieu)
                
                console.log('format '+avancement)
                console.log(format)
                
                 await page.goto(groupLink+'/members/admins',{timeout: 0})
			     await scroll(page,3000)

                 const adminmodeSelector = 'div:nth-child(1) > span > span > span > a'
                const roleAdminModeSelector = 'div:nth-child(2) > span > span > span:nth-child(1) > span > div > span > span > div > span'

                 await page.waitForSelector(adminmodeSelector,{timeout: 10000}).catch(error => resolve({no: nom, theme: theme, type: type, reglementation: reglementation, nb_membres: membres, postMois: postMois, format: format, lieu: lieu, AdminEtMode: null }))

                 await page.waitForSelector(roleAdminModeSelector,{timeout: 10000}).catch(error => resolve({nom: nom, theme: theme, type: type, reglementation: reglementation, nb_membres: membres, postMois: postMois, format: format, lieu: lieu, AdminEtMode: null }))

                const adminmodeEtrole =  await page.evaluate( async (adminmodeSelector,roleAdminModeSelector) => {
				
				const scrapedAdminModesEtRoles = document.querySelectorAll('div > div:nth-child(1) > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div:nth-child(2) > div > div > div:nth-child(2) > div > div > div > div > div> div > div > div')

				       const adminmodesEtroles = []
				scrapedAdminModesEtRoles.forEach(scrapedAdminModesEtRole => {
                        const nom = scrapedAdminModesEtRole.querySelector(adminmodeSelector)
                        const role = scrapedAdminModesEtRole.querySelector(roleAdminModeSelector)
                        if (nom && role && nom.innerText && role.innerText){ 
				    	    adminmodesEtroles.push({nom: nom.innerText, role: role.innerText, link: nom.href })
                        }
				   
				})
				return adminmodesEtroles
           		   }, adminmodeSelector,roleAdminModeSelector)

                console.log('adminmodeEtrole '+avancement)
                console.log(adminmodeEtrole)
                 
                
                resolve({nom: nom, theme: theme, type: type, reglementation: reglementation, nb_membres: membres, postMois: postMois, format: format, lieu: lieu, AdminEtMode: adminmodeEtrole })
    })
}
