import dbconnect from './src/dbconnection.js'
import child_process from 'child_process'

/**
 * @param {string} nomTable
 * @returns {Promise<string[]>}
*/
export default function getMoyennesReactionsGroupes(nomTable){
     return new Promise(async resolve => {
    var db = dbconnect()    
   db.query('SELECT AVG(nb_likes) as moyenne_likes, AVG(nb_comments) as moyenne_comments, AVG(nb_shares) as moyenne_shares FROM '+nomTable+ ' GROUP BY '+nomTable+'.id_groupe',(err,Table,field)=>{
                if (err) throw err
                resolve(Table)
            })
    }) 
    
}



