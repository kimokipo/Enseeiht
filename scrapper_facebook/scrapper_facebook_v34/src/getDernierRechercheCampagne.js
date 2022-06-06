
/**
 * @param {Connection} db
 * @param {Number} id_campagne
 * @returns {Promise<string[]>}
*/
export default function getDernierRechercheCampagne(db,id_campagne){
    return new Promise(async resolve => { 
    await db.query('SELECT * FROM Recherche_campagne WHERE id_campagne = ?' ,id_campagne,(err,table,field)=>{
                if (err) throw err
                if (table && table[table.length-1]){
                    resolve(table[table.length-1])
                }else {
                    resolve(null)
                }
            })
    }) 
    
    
}

