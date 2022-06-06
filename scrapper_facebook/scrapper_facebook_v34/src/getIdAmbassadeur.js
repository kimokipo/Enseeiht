import dbconnect from './dbconnection.js' 

/**
 * @param {string} prenom
 * @param {string} nom
 * @param {Connection} db
 * @returns {Promise<Number>}
*/
export default function getIdAmbassadeur(prenom,nom,db){
    return new Promise(async resolve => {   
        var database = null
        if (db){
            database = db
        }else{
            database = dbconnect()
        }
        await database.query('SELECT * FROM Utilisateur JOIN Ambassadeur ON Utilisateur.id_utilisateur = Ambassadeur.id_utilisateur WHERE prenom = ? and nom = ?' ,[prenom,nom],(err,Table,field)=>{
                    if (err) throw err
                    
                    if (Table && Table[0]) { 
                        resolve(Table[0].id_utilisateur) 
                    }else{
                        resolve(null)
                    }
                })
    
    }) 
    
    
}

