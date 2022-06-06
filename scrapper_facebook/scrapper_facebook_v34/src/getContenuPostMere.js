/**
 * @param {Connection} db
 * @param {Number} id_campagne
 * @returns {Promise<string[]>}
*/
export default function getContenuPostMere(db,id_campagne){
    return new Promise(async resolve => {  
        await db.query('SELECT contenu_post_mere FROM Campagne WHERE id_campagne = ?',id_campagne,(err,Table,field)=>{
                    if (err) throw err
                    if (Table && Table[0]) {
                        resolve(Table[0].contenu_post_mere)
                    }else { 
                        resolve(null)
                    }
                })
    }) 
    
    
}

