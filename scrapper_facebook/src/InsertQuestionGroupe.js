/**
 * @param {Connection} db
 * @param {string} linkGroup
 * @param {Number} id_question
 * @returns {Promise<Error>}
*/
export default function InsertQuestionGroupe(db,linkGroup ,id_question){
    return new Promise(async resolve => {
        var data = []
                data =  [linkGroup ,id_question]
                db.query('INSERT INTO question_adhesion_groupe VALUES (?,?) ',data,(err,segment_groupe,field)=>{
                    
                                if (err )  resolve(err)
                })
                    
        resolve(null)
    })
       
}


