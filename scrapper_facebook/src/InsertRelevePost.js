/**
 * @param {Connection} db
 * @param {string} date_releve
 * @param {Number} nb_likes
 * @param {Number} nb_comments
 * @param {Number} nb_shares
 * @param {Number} portee
 * @param {Number} interaction
 * @param {Number} clicks
 * @param {Number} id_post
 * @param {Number} id_releve_campagne
 * @returns {Promise<Error>}
*/
export default function InsertRelevePost(db,date_releve,nb_likes,nb_comments,nb_shares,portee,interaction,clicks,id_post,id_releve_campagne){
    return new Promise(async resolve => {
        var data = []
                data = [date_releve,nb_likes,nb_comments,nb_shares,portee,interaction,clicks,id_post,id_releve_campagne]
                db.query('INSERT INTO Releve_post SET date_releve = ?, nb_likes = ?, nb_comments = ?, nb_shares = ?, portee = ?, interaction = ?, clicks = ?, id_post = ?, id_releve_campagne = ?',data,(err,Releve_post,field)=>{
                    
                                if (err ) resolve(err)
                })
                    
        
        resolve(null)
    })
   
} 



