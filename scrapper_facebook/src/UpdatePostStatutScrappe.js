/**
 * @param {Connection} db
 * @param {Number} id_post
 * @param {string} statut_scrappe
 * @returns {Promise<Error>}
*/
export default function UpdatePostStatutScrappe(db,id_post,statut_scrappe){
    return new Promise(async resolve => {
        var data = []
                            data = [statut_scrappe,id_post]
                            db.query('UPDATE Post SET statut_scrappe = ? WHERE id_post = ?',data,(err,Groupe,field)=>{
                                if (err ){
                                    resolve(err)
                                }else{
                                    resolve(null)
                                }
                })
                   
    })
       
}
