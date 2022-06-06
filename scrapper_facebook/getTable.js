import dbconnect from './src/dbconnection.js'
import child_process from 'child_process'

/**
 * @param {string} nomTable
 * @returns {Promise<string[]>}
*/
export default function getTable(nomTable){
     return new Promise(async resolve => {
    var db = dbconnect()    
   db.query('SELECT * FROM '+nomTable,(err,Table,field)=>{
                if (err) throw err
                resolve(Table)
            })
    }) 
    
}



