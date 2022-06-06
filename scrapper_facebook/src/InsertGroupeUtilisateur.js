/**
 * @param {Connection} db
 * @param {string} id_groupe
 * @param {Number} id_utilisateur
 * @returns {Promise<Error>}
*/

export default function InsertGroupeUtilisateur(db,id_groupe,id_utilisateur){
     return new Promise(async resolve => {
        var data = []
        
                data = [id_groupe,id_utilisateur]
                db.query('INSERT INTO groupe_facebook VALUES (?,?)',data,(err,Post_partage,field)=>{
                   
                                if (err ) resolve( err)
                })

        resolve(null)
                    
    })
   
} 


