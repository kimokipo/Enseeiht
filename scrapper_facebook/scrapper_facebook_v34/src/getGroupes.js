/**
 * @param {Connection} db
 * @returns {Promise<string>}
*/
export default function getGroupes(db){
    return new Promise(async resolve => {
    await db.query('SELECT * FROM Groupe WHERE statut_releve is NULL',(err,Table,field)=>{
                if (err) throw err
                if (Table){
                    resolve(Table)
                }else{
                    resolve(null)
                }
            })
    }) 
    
    
}

