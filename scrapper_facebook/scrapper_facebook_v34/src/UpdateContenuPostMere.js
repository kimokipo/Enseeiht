/**
 * @param {Connection} db
 * @param {Number} id_campagne
 * @param {string} contenu_post_mere
 * @returns {Promise<error>}
*/
export default function UpdateContenuPostMere(db,id_campagne,contenu_post_mere){
    return new Promise(async resolve => {  
        await db.query('UPDATE Campagne SET contenu_post_mere = ? WHERE id_campagne = ?',[contenu_post_mere,id_campagne],(err,Table,field)=>{
                   if (err) {
                        resolve(err)
                    }else { 
                        resolve(null)
                    }
                })
    }) 
    
    
}

