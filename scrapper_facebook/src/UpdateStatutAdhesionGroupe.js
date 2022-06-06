/**
 * @param {Connection} db
 * @param {Number} id_ambassadeur
 * @param {string} id_groupe
 * @param {string} statut_adhesion
 * @returns {Promise<string[]>}
*/
export default function UpdateStatutAdhesionGroupe(db,id_ambassadeur,id_groupe,statut_adhesion){
    return new Promise(async resolve => {  
        var data = [statut_adhesion,id_ambassadeur,id_groupe]
        await db.query('UPDATE ambassadeur_groupe SET statut_adhesion = ? WHERE id_ambassadeur = ? and id_groupe = ?' ,data,(err,Table,field)=>{
                    if (err) throw err
                    
                    
         })
        resolve(null)
    }) 
      
}

