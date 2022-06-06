
/**
 * @param {Connection} db
 * @param {Number} id_recherche_campagne
 * @param {string} statut_recherche
 * @param {string} date_recherche
 * @returns {Promise<Error>}
*/
export default function UpdateStatutRechercheCampagne(db,id_recherche_campagne,statut_recherche,date_recherche){
    return new Promise(async resolve => { 
    await db.query('UPDATE Recherche_campagne SET statut_recherche = ?, date_recherche = ? WHERE id_recherche_campagne = ?' ,[statut_recherche,date_recherche,id_recherche_campagne],(err,table,field)=>{
                if (err){
                    resolve(err)
                }else {
                    resolve(null)
                }
            })
    }) 
    
    
}

