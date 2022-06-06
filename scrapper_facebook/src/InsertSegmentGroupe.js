/**
 * @param {Connection} db
 * @param {string} linkGroup
 * @param {Number} id_campagne
 * @returns {Promise<Error>}
*/
export default function InsertSegmentGroupe(db,linkGroup ,id_campagne){
    return new Promise(async resolve => {
        var data = []
                data =  [linkGroup ,id_campagne]
                db.query('INSERT INTO segment_groupe VALUES (?,?) ',data,(err,segment_groupe,field)=>{
                    
                                if (err )  resolve(err)
                })
                    
       
    })
       
}


