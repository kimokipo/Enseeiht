/**
 * @param {Connection} db
 * @param {Number} id_campagne
 * @returns {Promise<string>}
*/
export default function getPostsCampagne(db,id_campagne){
    return new Promise(async resolve => {   
    await db.query('SELECT * FROM Post JOIN Post_partage on Post.id_post = Post_partage.id_post WHERE id_campagne = ? and (statut_scrappe is NULL or statut_scrappe = "non trouvé") and statut = "acceptée"',id_campagne,(err,Table,field)=>{
                if (err) throw err
                if (Table){
                    resolve(Table)
                }else{
                    resolve(null)
                }
            })
    }) 
    
    
}

