/**
 * @param {Connection} db
 * @param {Number} id_campagne
 * @returns {Promise<string[]>}
*/
export default function getGroupeCampagne(db,id_campagne){
    return new Promise(async resolve => {
        var data = [id_campagne]
    await db.query('SELECT * FROM Groupe JOIN campagne_groupe ON Groupe.id_groupe = campagne_groupe.id_groupe WHERE id_campagne = ? and statut_publication = "posté" and statut_recherche is NULL and actif_supprime = "actif"',data,(err,Table,field)=>{
                if (err) throw err
                if (Table){
                     resolve(Table)
                }else{
                    resolve(null)
                }
            })
    }) 
       
}
