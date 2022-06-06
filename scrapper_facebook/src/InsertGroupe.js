/**
 * @param {Connection} db
 * @param {string} link
 * @param {string} nom
 * @param {string} personnalisation
 * @param {Number} nb_membres
 * @param {string} theme
 * @param {string} type
 * @param {string} reglementation
 * @param {string} url_a_propos
 * @param {Number} post_mois
 * @returns {Promise<Error>}
*/
export default function InsertGroupe(db,link ,nom,personnalisation,nb_membres,theme,type,reglementation,url_a_propos,post_mois){
    return new Promise(async resolve => {
        var data = []
                data =  [link,nom,personnalisation,nb_membres,theme,type,reglementation,url_a_propos,post_mois]
                db.query('INSERT INTO Groupe VALUES (?,?,?,?,?,?,?,?,?,NULL,NULL,NULL,NULL,NULL,NULL,NULL) ',data,(err,Groupe,field)=>{
                    
                                if (err ){
                                      resolve(err)
                                }else{
                                    resolve(null)
                                }
                                
                })
                    
      
       
    })
       
}
