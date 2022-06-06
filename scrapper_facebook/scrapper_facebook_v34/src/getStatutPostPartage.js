/**
 * @param {Connection} db
 * @param {Number} id_post
 * @returns {Promise<Number>}
*/
export default function getStatutPostPartage(db,id_post){
    return new Promise(async resolve => {    
    await db.query('SELECT accepte_supprime, statut FROM Post_partage WHERE id_post = ?' ,id_post,(err,table,field)=>{
                if (err) throw err
                console.log(table)
                if (table[0].accepte_supprime.indexOf('acceptée') != -1){ resolve('acceptée')}
                else if (table[0].statut.indexOf('en attente') != -1){ resolve('en attente')}
            })
    resolve ('')
    }) 
    
    
}

