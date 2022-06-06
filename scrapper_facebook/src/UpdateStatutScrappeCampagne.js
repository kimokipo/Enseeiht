/**
 * @param {Connection} db
 * @param {Number} id_campagne
 * @param {string} statut_scrappe
 * @returns {Promise<Error>}
*/
export default function UpdateStatutScrappeCampagne(db,id_campagne,statut_scrappe){
    return new Promise(async resolve => {
                            var data = [statut_scrappe,id_campagne]
                            db.query('UPDATE Post SET statut_scrappe = ? WHERE id_campagne = ? AND EXISTS (SELECT * FROM Post_partage WHERE Post.id_post = Post_partage.id_post AND statut = "acceptée")',data,(err,Groupe,field)=>{
                                if (err ){
                                    resolve(err)
                                }else{
                                    resolve(null)
                                }
                })
                   
    })
       
}
