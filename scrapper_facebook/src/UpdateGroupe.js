/**
 * @param {Connection} db
 * @param {string} link
 * @param {string} nom
 * @param {string} personnalisation
 * @param {Number} nb_membres
 * @param {string} theme
 * @param {string} type
 * @param {string} reglementation
 * @param {string} url_a_propos
 * @param {Number} post_mois
 * @param {string} format_groupe
 * @param {string} lieu
 * @param {string} statut_releve
 * @param {string} date_releve
 * @returns {Promise<Error>}
*/
export default function UpdateGroupe(db,link ,nom,personnalisation,nb_membres,theme,type,reglementation,url_a_propos,post_mois,format_groupe,lieu,statut_releve,date_releve){
    return new Promise(async resolve => {
        var data = []
                            data = [nom,personnalisation,nb_membres,theme,type,reglementation,url_a_propos,post_mois,format_groupe,lieu,statut_releve,date_releve,link]
                            db.query('UPDATE Groupe SET nom = ?, personnalisation = ?, nb_membres = ?, theme = ?, type = ?, reglementation = ?, url_a_propos = ?, frequence_post_mois = ?, format_groupe = ?, lieu = ?, statut_releve = ?, date_releve = ? WHERE id_groupe = ?',data,(err,Groupe,field)=>{
                                if (err ) throw err

                })
                   
        resolve(null)
    })
       
}


