/**
 * @param {Connection} db
 * @param {string} link
 * @param {Number} id_ambassadeur
 * @param {string} date_adhesion
 * @returns {Promise<Error>}
*/
export default function UpdateDateAdhesionGroupeAmbassadeur(db,link ,id_ambassadeur,date_adhesion){
    return new Promise(async resolve => {
        var data = []
                            data = [date_adhesion,link,id_ambassadeur]
                            db.query('UPDATE ambassadeur_groupe SET date_adhesion = ? WHERE id_groupe = ? and id_ambassadeur = ?',data,(err,Groupe,field)=>{
                                if (err ) resolve(err)
                })
                   
        resolve(null)
    })
       
}
