import dbconnect from './dbconnection.js'

/**
 * @param {string} login
 * @returns {Promise<string[]>}
*/
export default function getAuthentificationAmbassadeur(login){
     return new Promise(async resolve => {
    var db = dbconnect()    
   db.query('SELECT authentification_facebook FROM Ambassadeur WHERE login = ?',login,(err,Table,field)=>{
                if (err) throw err
                if (Table && Table[0]){
                    resolve(Table[0].authentification_facebook)
                }else{
                    resolve(null)
                }
            })
    }) 
    
}



