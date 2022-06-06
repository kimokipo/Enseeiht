import dbconnect from './dbconnection.js'

/**
 * @param {Number} id_ambassadeur
 * @returns {Promise<string[]>}
*/
export default function getCookiesAmbassadeur(id_ambassadeur){
    return new Promise(async resolve => {
    var db = dbconnect()    
    db.query('SELECT cookies FROM Ambassadeur WHERE id_utilisateur = ?',id_ambassadeur,(err,Table,field)=>{
                if (err) throw err
                if (Table && Table[0]){
                    resolve(Table[0].cookies)
                }else{
                    resolve(null)
                }
        })
   }) 
}


