/**
 * @param {Connection} db
 * @param {Number} id_campagne
 * @param {Number} id_segment
 * @returns {Promise<Error>}
*/
export default function InsertGroupeCampagneSegment(db,id_campagne,id_segment){
    return new Promise(async resolve => {
        var data = [id_campagne,id_segment]
    await db.query('INSERT INTO campagne_groupe (SELECT id_groupe, ?, "non posté", NULL, "automatique" FROM segment_groupe WHERE id_segment = ?)',data,(err,Table,field)=>{
                if (err){
                     resolve(err)
                }else{
                    resolve(null)
                }
            })
    }) 
    
    
}

