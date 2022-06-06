/**
 * @param {Connection} db
 * @param {Number} id_ambassadeur
 * @returns {Promise<string[]>}
*/
export default function getGroupesAmbassadeurReleve(db,id_ambassadeur){
    return new Promise(async resolve => {  
        await db.query('SELECT * FROM Groupe JOIN ambassadeur_groupe ON Groupe.id_groupe = ambassadeur_groupe.id_groupe WHERE id_ambassadeur = ? and ambassadeur_groupe.statut_releve is NULL and (actif_supprime is NULL or actif_supprime = "actif")' ,id_ambassadeur,(err,Table,field)=>{
                    if (err) throw err
                    if (Table) {
                        resolve(Table)
                    }else { 
                        resolve(null)
                    }
                })
    }) 
    
    
}

