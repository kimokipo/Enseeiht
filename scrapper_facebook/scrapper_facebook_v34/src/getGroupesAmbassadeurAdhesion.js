/**
 * @param {Connection} db
 * @param {Number} id_ambassadeur
 * @returns {Promise<string[]>}
*/
export default function getGroupesAmbassadeurAdhesion(db,id_ambassadeur){
    return new Promise(async resolve => {  
        await db.query('SELECT * FROM ambassadeur_groupe WHERE id_ambassadeur = ? and notifications = "activés" and traitement = "automatique"' ,id_ambassadeur,(err,Table,field)=>{
                    if (err) throw err
                    if (Table) {
                        resolve(Table)
                    }else { 
                        resolve(null)
                    }
                })
    }) 
    
    
}

