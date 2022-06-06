/**
 * @param {Connection} db
 * @param {Number} id_post 
 * @param {string} message_personnalise
 * @param {string} statut
 * @param {Number} id_utilisateur
 * @param {string} id_groupe
 * @returns {Promise<Error>}
*/
export default function UpdatePostPartage(db,id_post,message_personnalise,statut,id_utilisateur,id_groupe){
    return new Promise(async resolve => {
        var data = []
        
                
                            data = [message_personnalise,statut,id_utilisateur,id_groupe,id_post]
                            db.query('UPDATE Post_partage SET message_personnalise = ?, statut = ?, id_utilisateur = ?, id_groupe = ? WHERE id_post = ?',data,(err,Post_partage,field)=>{
                                if (err ) resolve(err)
                })
        resolve(null)
               
    })
   
} 
