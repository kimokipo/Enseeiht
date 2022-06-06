import scroll from '@pierreminiggio/puppeteer-page-scroller'
import asyncForEach from '@pierreminiggio/async-foreach'
import getLinkMobile from './getLinkMobile.js'
import child_process from 'child_process'
import getLinkMobileBasic from './getLinkMobileBasic.js'
import getGroupesAmbassadeurAdhesion from './getGroupesAmbassadeurAdhesion.js'
import InsertQuestionAdhesion from './InsertQuestionAdhesion.js'
import getIdQuestion from './getIdQuestion.js'
import InsertQuestionGroupe from './InsertQuestionGroupe.js'
import dbconnect from './dbconnection.js'
import getReponseQuestion from './getReponseQuestion.js'
import UpdateStatutAdhesionGroupe from './UpdateStatutAdhesionGroupe.js'
import UpdateNotificationsGroupe from './UpdateNotificationsGroupe.js'
import getIdQuestionGroupe from './getIdQuestionGroupe.js'
import UpdateTraitementAdhesionGroupe from './UpdateTraitementAdhesionGroupe.js'

/**
 * @param {import("puppeteer").Page} page
 * @param {Number} id_ambassadeur
 * @param {string} rapport
 * @returns {Promise<string[[]]>}
 */

export default (page,id_ambassadeur,rapport) => {
    return new Promise(async resolve => {
        const LinkGroup = []
	        var db = dbconnect()

            var avancement = 1
            var groupes_adheres = []
            var groupes_en_attente = []
            var groupes_notification_desactives = []
            var temps = 0
            var groupes = await getGroupesAmbassadeurAdhesion(db,id_ambassadeur)
            console.log('\nNombre de groupes récuperés depuis la base de données : '+groupes.length+' groupes\n')
            
            await asyncForEach(groupes, async groupe => {
                    var notification_desactives = false
                    var n_etait_pas_adhere = false
                    var adhere = false
                    var en_attente = false
                    var startTime = new Date().getTime();
                    var elapsedTime = 0
			        var groupLink = groupe.id_groupe
                    const statut_adhesion = groupe.statut_adhesion
                    var traitement = groupe.traitement
                    if (statut_adhesion.indexOf('membre') != -1){
                        await page.goto(await getLinkMobile(groupLink))
                        
                        var PlusButtonSelector = '#MRoot > div > div > div > div > div > div:nth-child(4) > a'
                        var groupe_supprime = false
                        await page.waitForSelector(PlusButtonSelector,{timeout: 10000}).catch(async error => {
                                   const rejoindreSelector = '#MRoot > div > div > div > div:nth-child(1) > div'
                                   await page.waitForSelector(rejoindreSelector).catch(error => groupe_supprime = true)
                                   if (!groupe_supprime){
                                       await page.click(rejoindreSelector)
                                       await page.waitForTimeout(1000)
                                       const err = await UpdateStatutAdhesionGroupe(db,id_ambassadeur,groupLink,'membre')
                                       n_etait_pas_adhere = true
                                       groupes_en_attente.push({lien: groupLink, traitement: traitement})
                                    }
                        })
                        if (!n_etait_pas_adhere && !groupe_supprime){
                            var groupe_visible = false
                            await page.waitForSelector(PlusButtonSelector,{timeout: 10000}).catch(error => groupe_visible = true)
                            if (!groupe_visible){
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
                            const err = await UpdateNotificationsGroupe(db,id_ambassadeur,groupLink,'désactivés')
                            notification_desactives = true
                            groupes_notification_desactives.push(groupLink)
                        }
                        
                    }else{
                            await page.goto(await getLinkMobileBasic(groupLink))

			                const submitButtonSelector = '#root > div.bj > form > input.bu.bv.bw'
			                await page.waitForSelector(submitButtonSelector,{timeout: 10000}).catch( async error => {
			                            adhere = true
			                            const err = await UpdateStatutAdhesionGroupe(db,id_ambassadeur,groupLink,'membre')
                                        groupes_adheres.push(groupLink)
                            }) 
                            
                            const rejoindre = await page.evaluate((selector) => {
		                           const scrapedsubmit = document.querySelector(selector)
		                           return scrapedsubmit.value
		                           
                        	}, submitButtonSelector).catch(error => null)

                            if (rejoindre ){
                                if  (rejoindre.localeCompare('Rejoindre le groupe') == 0){
                                    await page.click(submitButtonSelector)
                                    await page.waitForTimeout(1000)
                                    const Controle = await page.evaluate((ContenuBlockeSelector) => {
                                        const scrapedBlocke = document.querySelector('head > title')
                                        return scrapedBlocke.innerText.indexOf('Contrôle de sécurité') != - 1
                                    }, '').catch(error => null)

                                    if (Controle){
                                            console.log('\nFacebook veut savoir si on est Robot ou non\n')
                                            resolve(null)
                                    }
                                    const Blocke = await page.evaluate((ContenuBlockeSelector) => {
                                        const scrapedBlocke = document.querySelector('head > title')
                                        return scrapedBlocke.innerText.indexOf('Vous ne pouvez pas utiliser cette fonctionnalité pour le moment') != - 1
                                    }, '').catch(error => null)

                                    if (Blocke){
                                            console.log('\nL\'adhésion dans les Groupes est temporairement blocké par Facebook\n')
                                            resolve(null)
                                    }
                                    
                                    
                                }else if (rejoindre.indexOf('Annuler l’invitation') != -1){
                                    const RepondreSelector = '#root > div.bj > div.br.bx > a'
                                    await page.waitForSelector(RepondreSelector,{timeout: 10000}).catch(error => null)
                                    await page.click(RepondreSelector).catch(error => null)
                                    await page.waitForTimeout(1000)
                                
                                }

                                const QuestionsSelector = '#group-membership-criteria-answer-form > div > div:nth-child(3)'
                                await page.waitForSelector(QuestionsSelector,{timeout: 10000}).catch(error => null)

                                const questions = await page.evaluate((selector) => {
                                    const questions = []
		                            const scrapedQuestions = document.querySelectorAll(selector)
		                            scrapedQuestions.forEach(scrapedQuestion=>{
                                            questions.push(scrapedQuestion.innerText)
                                    })
                                    return questions[0].split('Écrivez une réponse...')
		                        }, QuestionsSelector).catch( error => null)
                                if (questions && questions.length != 0){
                                    var numero_question = 1
                                    var les_questions = ''
                                    await asyncForEach(questions, async question => {
                                        if (question.localeCompare('') != 0){
                                            var Question = question
                                            Question.trim()
                                            var  id_question = await getIdQuestionGroupe(db,Question,groupLink)
                                            if (!id_question){
                                                const err = await InsertQuestionAdhesion(db,Question,'')
                                                await page.waitForTimeout(3000)
                                                id_question = await getIdQuestion(db,Question)
                                            }else{
                                                const reponse = await getReponseQuestion(db,id_question)
                                                if (reponse && reponse.localeCompare('') != 0){
                                                    const ReponseSelector = '#group-membership-criteria-answer-form > div > div:nth-child(3) > div:nth-child('+numero_question+') > div:nth-child(2) > div > textarea'
                                                    await page.waitForSelector(ReponseSelector)

                                                    await page.evaluate((selector,reponse) => {
                                                        document.querySelector(selector).innerHTML = reponse
		                                            }, ReponseSelector,reponse)
                                               }else{
                                                    les_questions = les_questions+'id de la question :'+id_question+', '
                                               }
                                            }
                                            numero_question = numero_question + 1
                                            await page.waitForTimeout(1000)
                                            const err2 = await InsertQuestionGroupe(db,groupLink,id_question)
                                        }
                                    })
                                    const ButtonSubmitSelector = '#group-membership-criteria-answer-form > div > div > input[value="Envoyer la réponse"]'
                                    await page.waitForSelector(ButtonSubmitSelector)
                                    await page.click(ButtonSubmitSelector)
                                    
                                    if (les_questions.localeCompare('') != 0){
                                            les_questions = les_questions.substr(0,les_questions.length-2)
                                            traitement = 'Repondre aux questions : '+les_questions
                                            await UpdateTraitementAdhesionGroupe(db,groupLink,traitement)
                                    }
                                }
                                en_attente = true
                                const err = await UpdateStatutAdhesionGroupe(db,id_ambassadeur,groupLink,'en attente')
                                groupes_en_attente.push({lien: groupLink, traitement: traitement})
                            }
                        
                    }
                    elapsedTime = new Date().getTime() - startTime; 
                    temps = temps + elapsedTime/1000
                    const temps_estime = elapsedTime/1000 * (groupes.length-avancement)
                    var heures_estime =  Math.floor(temps_estime/3600)
                    var minutes_estime =  Math.floor((temps_estime-heures_estime*3600)/60)
                    if (notification_desactives){
                        console.log('\nLes notifications sont désactivés pour le groupe de lien : '+groupLink+'\n')
                    }else if(n_etait_pas_adhere){
                        console.log('\nIl était mentionné que L\'ambassadeur est membre du groupe de lien : '+groupLink+', mais ce n\'était pas le cas, il est adhéré maintenant\n')
                    }else if(adhere){
                        console.log('\nL\'ambassadeur est désormais membre du groupe de lien : '+groupLink+'\n')
                    } else if (en_attente){
                        console.log('\nLa demande pour adhérer au groupe de lien : '+groupLink+', est envoyé. On est en attente d\'acceptation\n')
                    }
                    console.log('Avancement des groupes adhéres : ' +avancement+' groupes sur le totale de : '+groupes.length+ ', Taux : '+Math.floor(avancement/groupes.length*100)+'%\n')
                    if (heures_estime == 0){
                        console.log('Temps estimé pour terminer l\'adhésion : '+minutes_estime+' minutes\n')
                    }else{
                        console.log('\nTemps estimé pour terminer l\'adhésion : '+heures_estime+' heures et '+minutes_estime+' minutes\n')
                    }
			        avancement = avancement + 1
 
	        })
	           
	           console.log('\nFin Script')
	           var heures =  Math.floor(temps/3600)
               var minutes =  Math.floor((temps-heures*3600)/60)
	           if (groupes.length == 0){
	                rapport = rapport +'\nRapport\n'
	                rapport = rapport + '\nAucun groupe est récuperé depuis la base\n'
	           }else{ 
	               var today = new Date()
	                rapport = rapport + '\n| Report Releve Infos Groupes"'+today.toString()+'" |'
	                rapport = rapport +' --  Groupes dans la liste : '+groupes.length
	                rapport = rapport +' Groupes notifications désactivés : '+groupes_notification_desactives.length
	                rapport = rapport +' Groupes ambassadeur membre : '+groupes_adheres.length
	                rapport = rapport +' Groupes demande adhésion en attente : '+groupes_en_attente.length+'\n'
	               
	           }
	            rapport = rapport + '\nTemps totale d\'adhésion : '+heures+' heures et '+heures+' minutes\n'
                console.log(rapport)
        resolve(LinkGroup)
    })
}

