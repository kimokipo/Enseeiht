/**
 * @param {Connection} db
 * @param {Number} id_ambassadeur
 * @param {string} id_groupe
 * @param {string} notifications
 * @returns {Promise<string[]>}
*/
export default function UpdateNotificationsGroupe(db,id_ambassadeur,id_groupe,notifications){
    return new Promise(async resolve => {  
        var data = [notifications,id_ambassadeur,id_groupe]
        await db.query('UPDATE ambassadeur_groupe SET notifications = ? WHERE id_ambassadeur = ? and id_groupe = ?' ,data,(err,Table,field)=>{
                    if (err) throw err
                    
                })
        resolve(null)
    }) 
      
}

