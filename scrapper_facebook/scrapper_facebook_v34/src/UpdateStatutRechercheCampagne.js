/**
 * @param {Connection} db
 * @param {Number} id_campagne
 * @param {string} statut_recherche
 * @returns {Promise<Error>}
*/
export default function UpdateStatutRechecheCampagne(db,id_campagne,statut_recherche){
    return new Promise(async resolve => {
                            var data = [statut_recherche,id_campagne]
                            db.query('UPDATE campagne_groupe SET statut_recherche = ? WHERE id_campagne = ?',data,(err,Groupe,field)=>{
                                if (err ){
                                    resolve(err)
                                }else{
                                    resolve(null)
                                }
                })
                   
    })
       
}
