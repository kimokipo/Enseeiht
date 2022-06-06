/**
 * @param {Connection} db
 * @param {Number} id_campagne
 * @returns {Promise<string[]>}
*/
export default function getPostMere(db,id_campagne){
    return new Promise(async resolve => {   
    await db.query('SELECT * FROM Post JOIN Post_mere ON Post.id_post = Post_mere.id_post WHERE id_campagne = ' +id_campagne,(err,Table,field)=>{
                if (err) throw err
                if (Table && Table[0]){
                    resolve(Table[0].url_post)
                }else{
                    resolve(null)
                }
            })
    }) 
    
    
}

