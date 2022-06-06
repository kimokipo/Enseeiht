/**
 * @param {Connection} db
 * @param {Number} id_question
 *
*/
export default function getReponseQuestion(db,id_question){
    return new Promise(async resolve => {
        var data = []
                data =  [id_question]
                db.query('SELECT * FROM Question_adhesion WHERE id_question = ?',data,(err,table,field)=>{
                    
                                if (table && table[0] ){
                                    console.log(table)
                                    resolve(table[0].reponse)
                                }else{
                                    resolve(null)
                                }
                })
                  
    })
       
}

