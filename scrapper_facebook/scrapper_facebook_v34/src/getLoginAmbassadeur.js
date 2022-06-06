import dbconnect from './dbconnection.js' 

/**
 * @param {string} prenom
 * @param {string} nom
 * @returns {Promise<string[]>}
*/
export default function getLoginAmbassadeur(prenom,nom){
    return new Promise(async resolve => {    
        var db = dbconnect()
        await db.query('SELECT * FROM Ambassadeur JOIN Utilisateur ON Ambassadeur.id_utilisateur = Utilisateur.id_utilisateur WHERE prenom = ? and nom = ?' ,[prenom,nom],(err,Table,field)=>{
                    if (err) throw err
                    if (Table.length !=0) {
                        resolve(Table)
                    }else { 
                        resolve(null)
                    }
                })
    }) 
    
    
}

