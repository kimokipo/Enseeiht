/**
 * @param {Connection} db
 * @param {Number} id_campagne
 * @param {string} link
 * @param {string} statut_publication
 * @returns {Promise<Error>}
*/
export default function UpdateGroupeCampagneStatutPublication(db,id_campagne,link ,statut_publication){
    return new Promise(async resolve => {
        var data = []
                            data = [statut_publication,link,id_campagne]
                            db.query('UPDATE campagne_groupe SET statut_publication = ? WHERE id_groupe = ? and id_campagne = ?',data,(err,Groupe,field)=>{
                                if (err ){
                                    resolve(err)
                                }else{
                                    resolve(null)
                                }
                })
                   
    })
       
}
