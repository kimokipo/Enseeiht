import dbconnect from './src/dbconnection.js'
  
/**
 * @param {string} nomTable
*/
export function deleteTable(nomTable){
    var db = dbconnect()     
   db.query('DELETE FROM '+nomTable,(err,Releve,field)=>{
                if (err) throw err
            }) 
} 

(async function () { 
            const nomTable = process.argv[2] 
            deleteTable(nomTable)
})();

 
        
