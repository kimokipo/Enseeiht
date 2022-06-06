/**
 * @param {Connection} db
 * @param {Number} id_campagne
 * @param {string} link
 * @param {string} traitement_publication
 * @returns {Promise<Error>}
*/
export default function UpdateGroupeCampagneTraitementPublication(db,id_campagne,link,traitement_publication){
    return new Promise(async resolve => {
        var data = []
                            data = [traitement_publication,link,id_campagne]
                            db.query('UPDATE campagne_groupe SET traitement_publication = ? WHERE id_groupe = ? and id_campagne = ?',data,(err,Groupe,field)=>{
                                if (err ){
                                    resolve(err)
                                }else{
                                    resolve(null)
                                }
                })
                   
    })
       
}
