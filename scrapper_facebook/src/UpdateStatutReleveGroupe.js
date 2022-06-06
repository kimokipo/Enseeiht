/**
 * @param {Connection} db
 * @param {string} link
 * @param {string} statut_releve
 * @returns {Promise<Error>}
*/
export default function UpdateStatutReleveGroupe(db,link,statut_releve){
    return new Promise(async resolve => {
        var data = []
                            data = [statut_releve,link]
                            db.query('UPDATE ambassadeur_groupe SET statut_releve = ? WHERE id_groupe = ? ',data,(err,Groupe,field)=>{
                                if (err ) resolve(err)
                })
                   
        resolve(null)
    })
       
}
