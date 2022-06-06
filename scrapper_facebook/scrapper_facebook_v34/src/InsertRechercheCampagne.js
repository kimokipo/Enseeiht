/**
 * @param {Connection} db
 * @param {Number} id_campagne
 * @returns {Promise<Error>}
*/
export default function InsertRechercheCampagne(db,id_campagne){
    return new Promise(async resolve => { 
    await db.query('INSERT INTO Recherche_campagne SET id_campagne = ?, statut_recherche = "non terminé"' ,id_campagne,(err,table,field)=>{
                if (err){
                    resolve(err)
                }else {
                    resolve(null)
                }
            })
    }) 
    
    
}

