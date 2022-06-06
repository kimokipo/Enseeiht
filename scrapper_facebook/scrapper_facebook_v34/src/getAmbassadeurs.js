/**
 * @param {Connection} db
 * @returns {Promise<string[]>}
*/
export default function getAmbassadeurs(db){
    return new Promise(async resolve => {  
        await db.query('SELECT prenom,nom FROM Utilisateur JOIN Ambassadeur ON Utilisateur.id_utilisateur = Ambassadeur.id_utilisateur',(err,Table,field)=>{
                    if (err) throw err
                    if (Table) {
                        resolve(Table)
                    }else { 
                        resolve(null)
                    }
                })
    }) 
    
    
}

