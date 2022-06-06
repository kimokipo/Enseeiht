import dbconnect from './dbconnection.js'

/**
 * @param {string} login
 * @param {string} authentification_facebook
 * @returns {Promise<string[]>}
*/
export default function UpdateAuthentificationAmbassadeur(login,authentification_facebook){
     return new Promise(async resolve => {
    var db = dbconnect()    
   db.query('UPDATE Ambassadeur SET authentification_facebook = ? WHERE login = ?',[authentification_facebook,login],(err,Table,field)=>{
                if (err) 
                if (err){
                    resolve(err)
                }else{
                    resolve(null)
                }
            })
    }) 
    
}



