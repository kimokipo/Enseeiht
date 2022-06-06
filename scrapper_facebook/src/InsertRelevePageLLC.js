/**
 * @param {Connection} db
 * @param {Number} nb_abonnes
 * @param {Number} nb_likes
 * @param {Number} nb_vues
 * @param {string] date_releve
 * @param {Number} id_campagne
 * @returns {Promise<Error>}
*/
export default function InsertRelevePageLLC(db,nb_abonnes,nb_likes,nb_vues,date_releve,id_campagne){
     return new Promise(async resolve => {
        var data = []
        
                data = [nb_abonnes,nb_likes,nb_vues,date_releve,id_campagne]
                db.query('INSERT INTO Releve_page_lalachante SET nb_abonnes = ?, nb_likes = ?, nb_vues = ?, date_releve = ?, id_campagne = ?',data,(err,Releve_page_lalachante,field)=>{
                   
                                if (err ) resolve(err)
                })

        resolve(null)
                    
    })
   
} 



