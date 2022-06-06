/**
 * @param {Connection} db
 * @param {string} url_post
 * @param {Number} id_campagne
 * @returns {Promise<Number[]>}
*/
export default function getIdPostCampagne(db,url_post,id_campagne){
    return new Promise(async resolve => { 
        var data = [url_post,id_campagne]
    await db.query('SELECT id_post FROM Post WHERE url_post = ? and id_campagne = ?' ,data,(err,table,field)=>{
                if (err) throw err

                if (table && table[0]){
                    resolve(table[0].id_post)
                }else {
                    resolve(null)
                }
            })
    }) 
    
    
}

