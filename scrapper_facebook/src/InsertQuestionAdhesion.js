/**
 * @param {Connection} db
 * @param {string} question
 * @param {string} reponse
 * @param {string} reponse2
 * @param {string} reponse3
*/
export default function InsertQuestionAdhesion(db,question ,reponse,reponse2,reponse3){
    return new Promise(async resolve => {
        var data = []
                data =  [question ,reponse,reponse2,reponse3]
                db.query('INSERT INTO Question_adhesion SET question = ?, reponse = ?, reponse2 = ?, reponse3 = ? ',data,(err,segment_groupe,field)=>{
                    
                                if (err )  resolve(err)
                })
                    
       resolve(null)
    })
       
}

