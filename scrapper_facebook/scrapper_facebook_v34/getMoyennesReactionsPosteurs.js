import dbconnect from './src/dbconnection.js'
import child_process from 'child_process'

/**
 * @returns {Promise<string[]>}
*/
export default function getMoyennesReactionsPosteurs(nomTable){
     return new Promise(async resolve => {
    var db = dbconnect()    
    db.query('SELECT AVG(nb_likes) as moyenne_likes, AVG(nb_comments) as moyenne_comments, AVG(nb_shares) as moyenne_shares FROM Analyse_posts_groupe JOIN ( groupe_facebook JOIN Utilisateur ON Utilisateur.id_utilisateur = groupe_facebook.id_utilisateur) ON groupe_facebook.id_groupe = Analyse_posts_groupe.id_groupe WHERE INSTR(Analyse_posts_groupe.nom_posteur,Utilisateur.nom) = 0 GROUP BY Analyse_posts_groupe.nom_posteur',(err,Table,field)=>{
                if (err) throw err
                resolve(Table)
            })
    }) 
    
}



