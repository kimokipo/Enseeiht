/**
 * @param {Connection} db
 * @param {string} url_post 
 * @param {string} titre
 * @param {string} type_media
 * @param {string} legende
 * @param {string} hashtag
 * @param {Number} id_campagne
 * @returns {Promise<Error>}
*/
export default function InsertPost(db,url_post,titre,type_media,legende,hashtag,id_campagne){
     return new Promise(async resolve => {
        var data = []
        
                data = [url_post,titre,type_media,legende,hashtag,id_campagne]
                db.query('INSERT INTO Post SET url_post = ?, titre = ?, type_media = ?, legende = ?, hashtag = ?, id_campagne = ?',data,(err,Post,field)=>{
                   
                                if (err ) resolve(err)
                })

        resolve(null)
                    
    })
   
} 


