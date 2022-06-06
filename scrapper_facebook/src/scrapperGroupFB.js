
import asyncForEach from '@pierreminiggio/async-foreach'
import stocker from './stocker.js'
import getLinkMobile from './getLinkMobile.js'
import getLinkMobileBasic from './getLinkMobileBasic.js'
import getGroupeInfo from './getGroupeInfo.js'
import InsertGroupe from './InsertGroupe.js'
import UpdateGroupe from './UpdateGroupe.js'
import InsertUtilisateur from './InsertUtilisateur.js'
import getIdUtilisateur from './getIdUtilisateur.js'
import InsertGroupeUtilisateur from './InsertGroupeUtilisateur.js'
import InsertModerateurAdministrateur from './InsertModerateurAdministrateur.js'
import dbconnect from './dbconnection.js'


/**
 * @param {string} lienGoogleSheet
 * @param {string} colonne
 * @param {string} ligne1
 * @param {import("puppeteer").Page} page
 * @param {import("puppeteer").Page} page2
 * @returns {Promise<string[[]]>}
 */
export default (lienGoogleSheet,colonne,ligne1,page,page2) => {
    return new Promise(async resolve => {
        const LinkGroup = []
	        var db = dbconnect()
	var ligne = parseInt(ligne1)
	await page2.goto(lienGoogleSheet)
    await page.waitForTimeout(6000)
	while(true){
		
		await page2.goto(lienGoogleSheet+'&range='+colonne+ligne)
		
		const linkSelector = '#t-formula-bar-input'
		await page2.waitForSelector(linkSelector,{timeout: 0})

		var groupLink = await page2.evaluate((selector) => {
		    const scrapedlink = document.querySelector(selector)
		    return scrapedlink.innerText.split('\n')[0]
                	
		    
		}, linkSelector)
		if (groupLink.localeCompare('') == 0){
			break;
		}else{
			     const tab = groupLink.split('/')
			     const tab2 = tab.slice(0,5)
			     groupLink = tab2.join('/')

			    const groupe = await getGroupeInfo (groupLink,page,ligne)

                if (groupe.nom){
                    null
                }else{
                    ligne = ligne+1
                    continue
                }

				var insertTheme = ''
                if (groupe.theme) { insertTheme = groupe.theme}
                
                var insertReglementation = ''
                if   (groupe.reglementation)  {insertReglementation = groupe.reglementation}
                
                if (groupe.AdminEtMode) {
                        await asyncForEach(groupe.AdminEtMode, async admin => {
                                const nomAdmin = admin.nom.split(' ').slice(1).join(' ')
                                const prenomAdmin = admin.nom.split(' ')[0]
                                var id_utilisateur = await getIdUtilisateur(nomAdmin,db)
                                if (!id_utilisateur){
                                    var err = await InsertUtilisateur(db,nomAdmin,prenomAdmin,'')
                                    await page.waitForTimeout(3000) 
                                    id_utilisateur = await getIdUtilisateur(nomAdmin,db)
                                }

                                err = await InsertGroupeUtilisateur(db,groupLink,id_utilisateur)
                                err = await InsertModerateurAdministrateur(db,id_utilisateur,admin.role)
                        })
                }

                 const err = await InsertGroupe(db,groupLink,groupe.nom,'',groupe.nb_membres,insertTheme,groupe.type,insertReglementation,'',groupLink+'/about',groupe.postMois)
                 
                console.log('La ligne de dernier groupe scrappé : ' +ligne)
                await page.waitForTimeout(6000)
	     
		}
		ligne = ligne+1
	}  
        resolve(LinkGroup)
    })
}

