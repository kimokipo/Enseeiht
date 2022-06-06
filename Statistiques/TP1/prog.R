bissextiles=function(){
    Z = seq(1880,2022,1)
    resultat = Z[(Z%%4==0 & Z%%100!=0) | (Z%%400==0)]
    return (resultat)
}

loiUniforme=function(){
    U = runif(12000)
    result = matrix(U,nrow=12,ncol=1000)
    return (result)
}

loiExpo=function(){
    U = rexp(12000)
    result = matrix(U,nrow=12,ncol=1000)
    return (result)
}

moyennes = function(nom,indvar){
    data = eval(parse(text = nom))
    indices = which(duplicated(data$AN))
    annees = data3$AN[-indices]
    result = matrix(0,nrow = length(annees),ncol =13)
    for (i in 1:length(annees)){
        a = annees[i]
        for (m in 1:12){
            result[i,m] = mean(data[((data$AN == a) & (data$MOIS == m)),indvar])
        }
        result[i,13] = mean(result[i,1:12])
     }
     return (result)
}
           
    
