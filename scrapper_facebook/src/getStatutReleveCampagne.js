import dbconnect from './dbconnection.js'
/**
 * @param {Number} id_releve_campagne
 * @returns {Promise<string[]>}
*/
export default function getStatutReleveCampagne(id_releve_campagne){
    return new Promise(async resolve => { 
        var db = dbconnect()
    await db.query('SELECT statut_releve FROM Releve_campagne WHERE id_releve_campagne = ?' ,id_releve_campagne,(err,table,field)=>{
                if (err) throw err
                if (table && table[0]){
                    resolve(table[0].statut_releve)
                }else {
                    resolve(null)
                }
            })
    }) 
    
    
}

