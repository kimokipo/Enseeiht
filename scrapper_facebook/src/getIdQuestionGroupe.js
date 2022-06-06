/**
 * @param {Connection} db
 * @param {string} question
 * @param {string} id_groupe
 * @returns {Promise<Number>}
*/
export default function getIdQuestionGroupe(db,question,id_groupe){
    return new Promise(async resolve => {  
        var data = [question,id_groupe]
    await db.query('SELECT Question_adhesion.id_question FROM Question_adhesion JOIN question_adhesion_groupe ON Question_adhesion.id_question = question_adhesion_groupe.id_question WHERE question = ? and id_groupe = ?' ,data,(err,table,field)=>{
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

