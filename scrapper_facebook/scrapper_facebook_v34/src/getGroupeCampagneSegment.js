/**
 * @param {Connection} db
 * @param {Number} id_campagne
 * @param {Number} id_segment
 * @returns {Promise<string[]>}
*/
export default function getGroupeCampagneSegment(db,id_campagne,id_segment){
    return new Promise(async resolve => {
        var data = [id_campagne,id_segment]
    await db.query('SELECT * FROM Groupe JOIN (segment_groupe JOIN campagne_groupe ON segment_groupe.id_groupe = campagne_groupe.id_groupe) ON segment_groupe.id_groupe = Groupe.id_groupe WHERE id_campagne = ? and id_segment = ? and statut_publication != "posté" and actif_supprime = "actif" ',data,(err,Table,field)=>{
                if (err) throw err
                if (Table){
                     resolve(Table)
                }else{
                    resolve(null)
                }
            })
    }) 
    
    
}

