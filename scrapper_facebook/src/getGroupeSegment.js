/**
 * @param {Connection} db
 * @param {Number} id_segment
 * @returns {Promise<string>}
*/
export default function getGroupeSegment(db,id_segment){
    return new Promise(async resolve => {
    await db.query('SELECT * FROM segment_groupe JOIN Groupe ON segment_groupe.id_groupe = Groupe.id_groupe WHERE id_segment = ' +id_segment,(err,Table,field)=>{
                if (err) throw err
                resolve(Table)
            })
    }) 
    
    
}

