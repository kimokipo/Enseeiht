/**
 * @param {Connection} db
 * @returns {Promise<string>}
*/
export default function getGroupeQuestionAdhesion(db){
    return new Promise(async resolve => {
    await db.query('SELECT * FROM question_adhesion_groupe',(err,Table,field)=>{
                if (err) throw err
                console.log(Table)
                resolve(Table)
            })
    }) 
    
    
}

