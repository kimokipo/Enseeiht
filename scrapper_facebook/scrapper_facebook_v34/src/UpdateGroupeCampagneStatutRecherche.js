/**
 * @param {Connection} db
 * @param {Number} id_campagne
 * @param {string} link
 * @param {string} statut_recherche
 * @returns {Promise<Error>}
*/
export default function UpdateGroupeCampagneStatutRecherche(db,id_campagne,link ,statut_recherche){
    return new Promise(async resolve => {
        var data = []
                            data = [statut_recherche,link,id_campagne]
                            db.query('UPDATE campagne_groupe SET statut_recherche = ? WHERE id_groupe = ? and id_campagne = ?',data,(err,Groupe,field)=>{
                                if (err ){
                                    resolve(err)
                                }else{
                                    resolve(null)
                                }
                })
                   
    })
       
}
