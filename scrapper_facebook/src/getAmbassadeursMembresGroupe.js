/**
 * @param {Connection} db
 * @param {string} id_groupe
 * @returns {Promise<string[]>}
*/
export default function getAmbassadeursMembresGroupe(db,id_groupe){
    return new Promise(async resolve => {  
        await db.query('SELECT prenom FROM ambassadeur_groupe JOIN (Ambassadeur JOIN Utilisateur ON Ambassadeur.id_utilisateur = Utilisateur.id_utilisateur) ON ambassadeur_groupe.id_ambassadeur = Ambassadeur.id_utilisateur WHERE id_groupe = ?' ,id_groupe,(err,Table,field)=>{
                    if (err) throw err
                    if (Table) {
                        resolve(Table)
                    }else { 
                        resolve(null)
                    }
                })
    }) 
    
    
}

