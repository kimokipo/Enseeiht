/**
 * @param {Connection} db
 * @param {Number} id_post
 * @param {Number} id_utilisateur
 * @param {Number} type_reaction
 * @returns {Promise<Error>}
*/

export default function InsertUtilisateurInteractionPost(db,id_post,id_utilisateur,type_reaction){
     return new Promise(async resolve => {
        var data = []
        
                data = [id_post,id_utilisateur,type_reaction]
                db.query('INSERT INTO interaction SET id_post = ?, id_utilisateur = ?, type_reaction = ?',data,(err,interaction,field)=>{
                   
                                if (err ){
                                    resolve( err)
                                }else{
                                    resolve(null)
                                }
                })         
    })
   
} 


