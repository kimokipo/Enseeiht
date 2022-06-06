/**
 * @param {Connection} db
 * @param {Number} id_campagne
 * @param {Number} id_segment
 * @param {string} legende_post_partage
 * @returns {Promise<Error>}
*/
export default function InsertLegendePostPartageCampagneSegment(db,id_campagne,id_segment,legende_post_partage){
    return new Promise(async resolve => {
        var data = [id_segment,id_campagne,legende_post_partage]
    await db.query('INSERT INTO campagne_segment VALUES (?,?,NULL,?)',data,(err,Table,field)=>{
                if (err){
                     resolve(err)
                }else{
                    resolve(null)
                }
            })
    }) 
    
    
}

