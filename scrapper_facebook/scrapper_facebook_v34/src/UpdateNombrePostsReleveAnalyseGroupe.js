/**
 * @param {Connection} db
 * @param {string} link
 * @param {Number} nb_posts_releves_analyse
 * @returns {Promise<Error>}
*/
export default function UpdateNombrePostsReleveAnalyseGroupe(db,link,nb_posts_releves_analyse){
    return new Promise(async resolve => {
        var data = []
                            data = [nb_posts_releves_analyse,link]
                            db.query('UPDATE ambassadeur_groupe SET nb_posts_releves_analyse = ? WHERE id_groupe = ?',data,(err,Groupe,field)=>{
                                if (err ) resolve(err)
                })
                   
        resolve(null)
    })
       
}
