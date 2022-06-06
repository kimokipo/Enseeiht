/**
 * @param {Connection} db
 * @param {string} nom 
 * @param {string} prenom
 * @param {string} genre
 * @returns {Promise<Error>}
*/
export default function InsertUtilisateur(db,nom,prenom,genre){
     return new Promise(async resolve => {
        var data = []
        
                data = [nom,prenom,genre]
                db.query('INSERT INTO Utilisateur SET nom = ?, prenom = ?, genre = ?',data,(err,Post,field)=>{
                   
                                if (err ) resolve(err)
                })

        resolve(null)
                    
    })
   
} 


