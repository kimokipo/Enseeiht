/**
 * @param {Connection} db
 * @param {string} link
 * @param {string} releve_100_posts
 * @returns {Promise<Error>}
*/
export default function UpdateReleve100PostsGroupe(db,link ,releve_100_posts){
    return new Promise(async resolve => {
        var data = []
                            data = [releve_100_posts,link]
                            db.query('UPDATE ambassadeur_groupe SET releve_100_posts = ? WHERE id_groupe = ?',data,(err,Groupe,field)=>{
                                if (err ) resolve(err)
                })
                   
        resolve(null)
    })
       
}
