/**
 * @param {Connection} db
 * @param {Number} id_campagne
 * @returns {Promise<string[]>}
*/
export default function getNomCampagne(db,id_campagne){
    return new Promise(async resolve => {  
        await db.query('SELECT nom FROM Campagne WHERE id_campagne = ?',id_campagne,(err,Table,field)=>{
                    if (err) throw err
                    if (Table && Table[0]) {
                        resolve(Table[0].nom)
                    }else { 
                        resolve(null)
                    }
                })
    }) 
    
    
}

