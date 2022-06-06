/**
 * @param  {string[[]]} tableau
 * @param {Number} NbColonnes
 * @returns {Promise<string[[]]>}
 */
export default (tableau, NbColonnes) => {
    const newTableau = []
    for(var i = 0; i < tableau.length; i++){
        newTableau.push([]);
    };

    for(var i = 0; i < tableau.length; i++){
        for(var j = 0; j < NbColonnes; j++){
            newTableau[j].push(tableau[i][j]);
        };
    };

    return newTableau;

}