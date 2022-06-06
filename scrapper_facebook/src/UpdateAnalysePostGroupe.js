/**
 * @param {Connection} db
 * @param {string} id_post 
 * @param {Number} nb_likes
 * @param {Number} nb_comments
 * @param {Number} nb_shares
 * @param {string} nomPosteur
 * @param {string} linkPosteur
 * @param {string} date_heure_postage
 * @param {string} texte_post
 * @param {string} type_post
 * @returns {Promise<Error>}
*/

export default function UpdateAnalysePostGroupe(db,id_post,nb_likes,nb_comments,nb_shares,nomPosteur,linkPosteur,date_heure_postage,texte_post,type_post){
     return new Promise(async resolve => {
        var data = []
        
                data = [nb_likes,nb_comments,nb_shares,nomPosteur,linkPosteur,date_heure_postage,texte_post,type_post,id_post]
                db.query('UPDATE Analyse_posts_groupe SET nb_likes = ?, nb_comments = ?, nb_shares = ?, nom_posteur = ?, id_posteur = ?, date_heure_postage = ?, texte_post = ?, type_post = ? WHERE id_post_groupe = ?',data,(err,Post_partage,field)=>{
                   
                                if (err ) {
                                    resolve( err)
                                }else{
                                    resolve(null)
                                }
                })

        
                    
    })
   
} 
