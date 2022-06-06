/**
 * @param {Connection} db
 * @param {string} url_post
 * @returns {Promise<Number>}
*/
export default function getIdPost(db,url_post){
    return new Promise(async resolve => { 
    await db.query('SELECT id_post FROM Post WHERE url_post = ?' ,url_post,(err,table,field)=>{
                if (err) throw err
                console.log(table)

                if (table && table[0]){
                    resolve(table[0].id_post)
                }else {
                    resolve(null)
                }
            })
    }) 
    
    
}

