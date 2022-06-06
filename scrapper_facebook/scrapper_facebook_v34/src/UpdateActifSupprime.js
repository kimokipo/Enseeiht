/**
 * @param {Connection} db
 * @param {string} link
 * @param {string} actif_supprime
 * @returns {Promise<Error>}
*/
export default function UpdateActifSupprime(db,link ,actif_supprime){
    return new Promise(async resolve => {
        var data = []
                            data = [actif_supprime,link]
                            db.query('UPDATE Groupe SET actif_supprime = ? WHERE id_groupe = ?',data,(err,Groupe,field)=>{
                               if (err ){
                                    resolve(err)
                                }else{
                                    resolve(null)
                                }
                })
                   
    })
       
}
