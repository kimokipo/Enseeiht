
/**
 * @param {Connection} db
 * @param {Number} id_releve_campagne
 * @param {string} statut_releve
 * @param {string} date_releve
 * @returns {Promise<Error>}
*/
export default function UpdateStatutReleveCampagne(db,id_releve_campagne,statut_releve,date_releve){
    return new Promise(async resolve => { 
    await db.query('UPDATE Releve_campagne SET statut_releve = ?, date_releve = ? WHERE id_releve_campagne = ?' ,[statut_releve,date_releve,id_releve_campagne],(err,table,field)=>{
                if (err){
                    resolve(err)
                }else {
                    resolve(null)
                }
            })
    }) 
    
    
}

