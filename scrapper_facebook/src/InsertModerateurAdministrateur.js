/**
 * @param {Connection} db
 * @param {Number} id_utilisateur
 * @param {string} role
 * @returns {Promise<Error>}
*/

export default function InsertModerateurAdministrateur(db,id_utilisateur,role){
     return new Promise(async resolve => {
        var data = []
        
                data = [id_utilisateur,role]
                db.query('INSERT INTO Moderateur_administrateur VALUES (?,?)',data,(err,Post_partage,field)=>{
                   
                                if (err ) resolve( err)
                })

        resolve(null)
                    
    })
   
} 


