import getMoyennesReactionsGroupes from './getMoyennesReactionsGroupes.js'
import getMoyennesReactionsPosteurs from './getMoyennesReactionsPosteurs.js'
import getTable from './getTable.js'

(async function () { 
            const nomTable = process.argv[2] 
            const nomParametre = process.argv[3] 
            if (nomTable.indexOf('Analyse_posts_groupe') != -1){
                if (nomParametre.indexOf('Groupe') != -1){
                    const moyennes = await getMoyennesReactionsGroupes(nomTable)
                    var resultat = ''
                    moyennes.forEach( moyenne => {
                            resultat = resultat + moyenne.moyenne_likes +' ' + moyenne.moyenne_comments + ' ' +moyenne.moyenne_shares+'; '
                    })
                    resultat = resultat.substr(0,resultat.length-2)
                    console.log(resultat)
                }else if (nomParametre.localeCompare('Post') == 0){
                    const posts = await getTable(nomTable)
                    var resultat = ''
                    posts.forEach( post => {
                            resultat = resultat + post.nb_likes + ' ' + post.nb_comments + ' ' + post.nb_shares +'; '
                    })
                    resultat = resultat.substr(0,resultat.length-2)
                    console.log(resultat)
                }else{
                    const moyennes = await getMoyennesReactionsPosteurs(nomTable)
                    var resultat = ''
                    moyennes.forEach( moyenne => {
                            resultat = resultat + moyenne.moyenne_likes +' ' + moyenne.moyenne_comments + ' ' +moyenne.moyenne_shares +'; '
                    })
                    resultat = resultat.substr(0,resultat.length-2)
                    console.log(resultat)
                }
            }else{
            
                const groupes = await getTable(nomTable)
                var resultat = ''
                groupes.forEach( groupe => {
                        resultat = resultat + groupe.nb_membres +' ' + groupe.frequence_post_mois +'; '
                })
                resultat = resultat.substr(0,resultat.length-2)
                console.log(resultat)
           }
            
})();
