/**
 * @param {Connection} db
 * @param {string} question
 * @returns {Promise<Number>}
*/
export default function getIdQuestion(db,question){
    return new Promise(async resolve => {    
    await db.query('SELECT id_question FROM Question_adhesion WHERE question = ?' ,question,(err,table,field)=>{
                if (err) throw err
                if (table && table[0]){
                        console.log(table)
                        resolve(table[0].id_question)
                }else{
                    resolve(null)
                }
            })
    }) 
    
    
}

