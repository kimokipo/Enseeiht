import scroll from '@pierreminiggio/puppeteer-page-scroller'
import asyncForEach from '@pierreminiggio/async-foreach'
import getLinkMobile from './getLinkMobile.js'
import getLinkMobileBasic from './getLinkMobileBasic.js'
import getGroupesAmbassadeurAdhesion from './getGroupesAmbassadeurAdhesion.js'
import dbconnect from './dbconnection.js'

/**
 * @param {import("puppeteer").Page} page
 * @returns {Promise<string[[]]>}
 */

export default (page) => {
    return new Promise(async resolve => {
        const LinkGroup = []
	        var db = dbconnect()

            var avancement = 1
            var groupes_notification_desactives = []
            var temps = 0
            var groupes = await getGroupesAmbassadeurAdhesion(db,155)
            console.log('\nNombre de groupes récuperés depuis la base de données : '+groupes.length+' groupes\n')
            
            await asyncForEach(groupes, async groupe => {
                    var notification_desactives = false
                    var startTime = new Date().getTime();
                    var elapsedTime = 0
			        var groupLink = groupe.id_groupe
                        await page.goto(await getLinkMobile(groupLink))
                        var probleme = false
                        var PlusButtonSelector = '#MRoot > div > div > div > div > div > div:nth-child(4) > a'
                        await page.waitForSelector(PlusButtonSelector,{timeout: 5000}).catch(error => probleme = true)
                        if (!probleme){         
                                await page.click(PlusButtonSelector)
                                var infoGroupButtonSelector = '#root > div > div > div > div > a:nth-child(4)'
			                    await page.waitForSelector(infoGroupButtonSelector).catch(async error => {
			                           infoGroupButtonSelector = '#root > div > div > div > div > a:nth-child(3)'
			                           await page.waitForSelector(infoGroupButtonSelector)
			                    })
                                await page.click(infoGroupButtonSelector)
                                await page.waitForTimeout(1000)
                    
                                var signaler = false
                                var SettingGroupButtonSelector = '#root > div > div > div:nth-child(2) > div > div > a'
                                await page.waitForSelector(SettingGroupButtonSelector,{timeout: 10000}).catch (error => signaler = true)

                                if (!signaler){
                                    await page.click(SettingGroupButtonSelector)
                                    await page.waitForTimeout(1000)
                                }
                               
                                const desableNotificationButtonSelector = '#groupsNotificationSubscriptionSettings > section > div > div > fieldset > label:nth-child(4) > div > div'

			                    if (!signaler){
                                    await page.waitForSelector(desableNotificationButtonSelector,{timeout: 10000}).catch (error => signaler = true)
                                    if (!signaler){
                                        await page.click(desableNotificationButtonSelector)
                                        await page.waitForTimeout(1000)
                                    }
                                }
                            }
                            
                    elapsedTime = new Date().getTime() - startTime; 
                    temps = temps + elapsedTime/1000
                    const temps_estime = elapsedTime/1000 * (groupes.length-avancement)
                    var heures_estime =  Math.floor(temps_estime/3600)
                    var minutes_estime =  Math.floor((temps_estime-heures_estime*3600)/60)
                    if (notification_desactives){
                        console.log('\nLes notifications sont désactivés pour le groupe de lien : '+groupLink+'\n')
                    }
                    console.log('Avancement des groupes notifications désactivés : ' +avancement+' groupes sur le totale de : '+groupes.length+ ', Taux : '+Math.floor(avancement/groupes.length*100)+'%\n')
                    if (heures_estime == 0){
                        console.log('Temps estimé pour terminer la désactivation des notifications : '+minutes_estime+' minutes\n')
                    }else{
                        console.log('\nTemps estimé pour terminer la désactivation des notifications : '+heures_estime+' heures et '+minutes_estime+' minutes\n')
                    }
			        avancement = avancement + 1
 
	        })
	           
	           console.log('\nFin Script')
	           var rapport = ''
	           var heures =  Math.floor(temps/3600)
               var minutes =  Math.floor((temps-heures*3600)/60)
	           if (groupes.length == 0){
	                rapport = rapport +'\nRapport\n'
	                rapport = rapport + '\nAucun groupe est récuperé depuis la base\n'
	           }else{ 
	               var today = new Date()
	                rapport = rapport + '\n| Report Releve Desable Notifications Groupes"'+today.toString()+'" |'
	                rapport = rapport +' --  Groupes dans la liste : '+groupes.length
	                rapport = rapport +' Groupes notifications désactivés : '+groupes_notification_desactives.length
	               
	           }
	            rapport = rapport + '\nTemps totale de la désactivation des notifications : '+heures+' heures et '+heures+' minutes\n'
                console.log(rapport)
        resolve(LinkGroup)
    })
}

