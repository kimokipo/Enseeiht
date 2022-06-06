import dbconnect from './dbconnection.js'
import cookies from '../cookies.js'

/**
 * @param {Number} id_ambassadeur
 * @param {string[]} cookies
 * @returns {Promise<string[]>}
*/
export default function UpdateCookiesAmbassadeur(id_ambassadeur,cookies){
     return new Promise(async resolve => {
    var db = dbconnect()
    db.query('DELETE FROM ambassadeur_cookies WHERE id_ambassadeur = ?',id_ambassadeur,(err,Table,field)=>{
                if (err) throw err
    })
    cookies.forEach(cookie => {
        db.query('INSERT INTO ambassadeur_cookies SET id_ambassadeur = ?,? ',[id_ambassadeur,cookie],(err,Table,field)=>{
                if (err) throw err
        })
    })
    }) 
    
}

(async function () { 
            UpdateCookiesAmbassadeur(2,cookies)
})();

