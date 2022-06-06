/**
 * @param {Connection} db
 * @param {Number} id_post
 * @param {Number} portee
 * @param {Number} interaction
 * @returns {Promise<Error>}
*/
export default function InsertPostMere(db,id_post,portee,interaction){
     return new Promise(async resolve => {
        var data = []
        
                data = [id_post,portee,interaction]
                db.query('INSERT INTO Post_mere SET id_post = ?, portee = ?, interaction = ?',data,(err,Post_mere,field)=>{
                   
                                if (err ) resolve(err)
                })

        resolve(null)
                    
    })
   
} 



