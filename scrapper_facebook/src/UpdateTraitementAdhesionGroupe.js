/**
 * @param {Connection} db
 * @param {string} id_groupe
 * @param {string} traitement
 * @returns {Promise<string[]>}
*/
export default function UpdateTraitementAdhesionGroupe(db,id_groupe,traitement){
    return new Promise(async resolve => {  
        var data = [traitement,id_groupe]
        await db.query('UPDATE ambassadeur_groupe SET traitement = ? WHERE id_groupe = ?' ,data,(err,Table,field)=>{
                    if (err) throw err
                    
                    
         })
        resolve(null)
    }) 
      
}

