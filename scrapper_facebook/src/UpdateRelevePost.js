import dbconnect from './dbconnection.js' 

/**
 * @param {Number} id 
 * @param {string} link
 * @param {string} date
 * @param {Number} likes
 * @param {Number} comments
 * @param {Number} shares
 * @param {Number} portee
 * @param {Number} clicks
 * @returns {Promise<Error>}
*/
export default function UpdateRelevePost(id,link,date,likes,comments,shares,portee,clicks){
    return new Promise(async resolve => {
        var data = []
        var db = dbconnect()
         if (portee){
                
                            data = [link,date,likes,comments,shares,portee,clicks,id]
                            db.query('UPDATE Releve SET id_post = ?, date_releve = ?, nb_likes = ?, nb_comments = ?, nb_shares = ?, portee = ?, clicks = ? WHERE id_releve = ?',data,(err,Groupe,field)=>{
                                if (err ) resolve(err)
                })
                    
        }else{
            
                            data = [link,date,likes,comments,shares,id]
                            db.query('UPDATE Releve SET id_post = ?, date_releve = ?, nb_likes = ?, nb_comments = ?, nb_shares = ?, portee = NULL, clicks = NULL WHERE id_releve = ?',data,(err,Groupe,field)=>{
                                if (err ) resolve(err)
                })
                    
        }
        resolve(null)
    })
   
} 
