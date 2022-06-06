/**
 * @param {Connection} db
 * @param {string} link
 * @param {string} traitement_publication
 * @returns {Promise<Error>}
*/
export default function UpdateGroupeCampagneTraitementPublication(db,link ,traitement_publication){
    return new Promise(async resolve => {
        var data = []
                            data = [traitement_publication,link]
                            db.query('UPDATE campagne_groupe SET traitement_publication = ? WHERE id_groupe = ?',data,(err,Groupe,field)=>{
                                if (err ){
                                    resolve(err)
                                }else{
                                    resolve(null)
                                }
                })
                   
    })
       
}
