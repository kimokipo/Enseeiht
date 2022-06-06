import dbconnect from './dbconnection.js' 

/**
 * @param {string} nom
 * @param {Connection} db
 * @returns {Promise<Number>}
*/
export default function getIdUtilisateur(nom,db){
    return new Promise(async resolve => {   
        var database = null
        if (db){
            database = db
        }else{
            database = dbconnect()
        }
        await database.query('SELECT id_utilisateur FROM Utilisateur WHERE nom = ?' ,nom,(err,Table,field)=>{
                    if (err) throw err
                    
                    if (Table && Table[0]) { 
                        resolve(Table[0].id_utilisateur) 
                    }else{
                        resolve(null)
                    }
                })
    
    }) 
    
    
}

