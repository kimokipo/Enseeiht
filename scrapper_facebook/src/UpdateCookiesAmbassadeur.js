import dbconnect from './dbconnection.js'
import cookies from '../cookies.js'

/**
 * @param {Number} id_ambassadeur
 * @param {string} cookies
 * @returns {Promise<error>}
*/
export default function UpdateCookiesAmbassadeur(id_ambassadeur,cookies){
    return new Promise(async resolve => {
    var db = dbconnect()   
        db.query('UPDATE Ambassadeur SET cookies = ? WHERE id_utilisateur = ?',[cookies,id_ambassadeur],(err,Table,field)=>{
                if (err) throw err
        })
   
    resolve(null)
    }) 
}



