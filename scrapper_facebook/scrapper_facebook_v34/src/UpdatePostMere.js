import dbconnect from './dbconnection.js' 

/**
 * @param {string} url_post
 * @param {Number} portee
 * @param {Number} interaction
 * @returns {Promise<Error>}
*/
export default function UpdatePostMere(url_post,portee,interaction){
    return new Promise(async resolve => {
        var data = []
        var db = dbconnect()
        
                
                            data = [portee,interaction,url_post]
                            db.query('UPDATE Post_mere SET portee = ?, interaction = ? WHERE url_post = ?',data,(err,Post_mere,field)=>{
                                if (err ) resolve(err)
                })
        resolve(null)
               
    })
   
} 
