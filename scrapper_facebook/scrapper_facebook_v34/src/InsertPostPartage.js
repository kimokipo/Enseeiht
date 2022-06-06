/**
 * @param {Connection} db
 * @param {Number} id_post 
 * @param {string} message_personnalise
 * @param {string} statut
 * @param {Number} id_utilisateur
 * @param {string} id_groupe
 * @returns {Promise<Error>}
*/

export default function InsertPostPartage(db,id_post,message_personnalise,statut,id_utilisateur,id_groupe){
     return new Promise(async resolve => {
        var data = []
        
                data = [id_post,message_personnalise,statut,id_utilisateur,id_groupe]
                db.query('INSERT INTO Post_partage VALUES (?,?,?,?,?)',data,(err,Post_partage,field)=>{
                   
                                if (err ) {
                                    resolve( err)
                                }else{
                                    resolve(null)
                                }
                })

                    
    })
   
} 


