/**
 * @param {Connection} db
 * @param {Number} id_campagne
 * @param {Number} id_segment
 * @returns {Promise<string[]>}
*/
export default function getLienLegendePostPartage(db,id_campagne,id_segment){
    return new Promise(async resolve => {  
        await db.query('SELECT lien_legende_post_partage FROM campagne_segment WHERE id_campagne = ? and id_segment = ?',[id_campagne,id_segment],(err,Table,field)=>{
                    if (err) throw err
                    if (Table && Table[0]) {
                        resolve(Table[0].lien_legende_post_partage)
                    }else { 
                        resolve(null)
                    }
                })
    }) 
    
    
}

