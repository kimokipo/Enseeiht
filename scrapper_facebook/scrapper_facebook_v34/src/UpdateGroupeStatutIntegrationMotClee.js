/**
 * @param {Connection} db
 * @param {string} link
 * @param {string} statut_integration
 * @param {string} tag_recherche
 * @param {string} date_releve
 * @returns {Promise<Error>}
*/
export default function UpdateGroupeStatutIntegrationMotClee(db,link ,statut_integration,tag_recherche,date_releve){
    return new Promise(async resolve => {
        var data = []
                            data = [statut_integration,tag_recherche,date_releve,link]
                            db.query('UPDATE Groupe SET statut_integration = ?, tag_recherche = ?, date_releve = ? WHERE id_groupe = ?',data,(err,Groupe,field)=>{
                               if (err ){
                                    resolve(err)
                                }else{
                                    resolve(null)
                                }
                })
                   
    })
       
}
