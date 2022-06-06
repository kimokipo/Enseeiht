/**
 * @param {Connection} db
 * @param {Number} id_post
 * @param {string} url_post 
 * @returns {Promise<Error>}
*/
export default function UpdatePost(db,id_post,url_post){
    return new Promise(async resolve => {
        var data = []
        
                
                            data = [url_post,id_post]
                            db.query('UPDATE Post SET url_post = ? WHERE id_post = ?',data,(err,Post,field)=>{
                                if (err ){
                                    resolve(err)
                                }else{
                                    resolve(null)
                                }                                
                })
        
               
    })
   
} 
