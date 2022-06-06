/**
 * @param {Connection} db
 * @param {string} id_post 
 * @param {Number} nb_likes
 * @param {Number} nb_comments
 * @param {Number} nb_shares
 * @param {string} id_groupe
 * @param {string} nomPosteur
 * @param {string} linkPosteur
 * @param {string} date_heure_postage
 * @param {string} texte_post
 * @param {string} type_post
 * @returns {Promise<Error>}
*/

export default function InsertAnalysePostGroupe(db,id_post,nb_likes,nb_comments,nb_shares,id_groupe,nomPosteur,linkPosteur,date_heure_postage,texte_post,type_post){
     return new Promise(async resolve => {
        var data = []
        
                data = [id_post,nb_likes,nb_comments,nb_shares,id_groupe,nomPosteur,linkPosteur,date_heure_postage,texte_post,type_post]
                db.query('INSERT INTO Analyse_posts_groupe VALUES (?,?,?,?,?,?,?,?,?,?)',data,(err,Post_partage,field)=>{
                   
                                if (err ) {
                                    resolve( err)
                                }else{
                                    resolve(null)
                                }
                })

        
                    
    })
   
} 


