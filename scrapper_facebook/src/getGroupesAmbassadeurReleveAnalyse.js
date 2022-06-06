/**
 * @param {Connection} db
 * @param {Number} id_ambassadeur
 * @returns {Promise<string[]>}
*/
export default function getGroupesAmbassadeurReleveAnalyse(db,id_ambassadeur){
    return new Promise(async resolve => {  
        await db.query('SELECT * FROM Groupe JOIN ambassadeur_groupe ON Groupe.id_groupe = ambassadeur_groupe.id_groupe WHERE id_ambassadeur = ? and ambassadeur_groupe.releve_100_posts is NULL and format_groupe = "Classique"' ,id_ambassadeur,(err,Table,field)=>{
                    if (err) throw err
                    if (Table) {
                        resolve(Table)
                    }else { 
                        resolve(null)
                    }
                })
    }) 
    
    
}

