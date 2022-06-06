/**
 * @param {Connection} db
 * @param {string} id_groupe
 * @param {Number} id_ambassadeur
 * @param {string} statut_adhesion
 * @returns {Promise<Error>}
*/

export default function InsertGroupeAmbassadeur(db,id_groupe,id_ambassadeur,statut_adhesion){
     return new Promise(async resolve => {
        
                var data = [id_ambassadeur,id_groupe,statut_adhesion]
                db.query('INSERT INTO ambassadeur_groupe VALUES (?,?,?,NULL,"activés","automatique",NULL,NULL,NULL)',data,(err,Post_partage,field)=>{
                   
                                if (err ) {
                                    resolve( err)
                                }else{
                                    resolve(null)
                                }
                })              

                    
    })
   
} 


