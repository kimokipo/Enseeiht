/**
 * @param {Connection} db
 * @param {Number} id_question
 * @param {string} reponse2
 * @param {string} reponse3
*/
export default function InsertReponseAdhesion(db,id_question ,reponse2,reponse3){
    return new Promise(async resolve => {
        var data = []
                data =  [reponse2,reponse3,id_question]
                db.query('UPDATE Question_adhesion SET reponse2 = ?, reponse3 = ? WHERE id_question = ?',data,(err,segment_groupe,field)=>{
                    
                                if (err )  resolve(err)
                })
                    
       resolve(null)
    })
       
}

