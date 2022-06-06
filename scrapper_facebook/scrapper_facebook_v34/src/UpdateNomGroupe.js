/**
 * @param {Connection} db
 * @param {string} link
 * @param {string} nom
 * @returns {Promise<Error>}
*/
export default function UpdateNomGroupe(db,link ,nom){
    return new Promise(async resolve => {
        var data = []
                            data = [nom,link]
                            db.query('UPDATE Groupe SET nom = ? WHERE id_groupe = ?',data,(err,Groupe,field)=>{
                                if (err ) resolve(err)
                })
                   
        resolve(null)
    })
       
}
