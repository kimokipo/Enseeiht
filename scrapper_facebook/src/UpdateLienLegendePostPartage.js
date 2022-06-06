/**
 * @param {Connection} db
 * @param {Number} id_campagne
 * @param {Number} id_segment
 * @param {string} lien_legende_post_partage
 * @param {string} legende_post_partage
 * @returns {Promise<error>}
*/
export default function UpdateLienLegendePostPartage(db,id_campagne,id_segment,lien_legende_post_partage,legende_post_partage){
    return new Promise(async resolve => {  
        var data = [lien_legende_post_partage,legende_post_partage,id_campagne,id_segment]
        await db.query('UPDATE campagne_segment SET lien_legende_post_partage = ?, legende_post_partage = ? WHERE id_campagne = ? and id_segment = ?',data,(err,Table,field)=>{
                   if (err) {
                        resolve(err)
                    }else { 
                        resolve(null)
                    }
                })
    }) 
    
    
}

