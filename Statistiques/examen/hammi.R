# Script TP4 HPC-BigData - Examen Pratique
# Author : KAMAL HAMMI


# 1 - Chargement librairies et donnees

data=read.table(file="DataTP4.txt",header=TRUE)

names(data)
summary(data)
dim(data)

data$color = as.factor(data$color)


# 2 - Etude preliminaire et regression simple

lm.out1=lm(quality~alcohol,data=data)
summary(lm.out1)
# -> les p_values des 2 parametres sont tres faibles (< alpha = 0.05) donc l'hypothèse H0 (coef_Beta_corresp = 0) est rejeté et les 2 parametres du modele sont jugés significativement differents de 0
# -> la regression simple n'explique que 22% de la variance totale du predictand
# en considerant d'autres predicteurs, le modele statistique peut certainement etre ameliore

x11()
plot(data$alcohol,data$quality,xlab="alcohol",ylab="quality",pch='+')
abline(lm.out1,col="red")

x11()
plot(data$quality,type ="l",lwd=2,main="indice de quality",xlab="Date",ylab="quality")
points(fitted(lm.out1),col="red",pch="+")
legend(0,268,lty=1,col=c("black"),legend=c("quality"),bty="n")
legend(0,256,pch="+",col=c("red"),legend=c("       ASsimple"),bty="n") 

# -> le modele arrive à predire les valeurs proches de la moyenne de predictand quality mais est incapable d'atteindre les valeurs extremes
# la variabilité du predictand est mal reproduite, il faut enrichir la regression pour atteindre une variabilite du modele plus forte


# 3 - Modeles sans interaction

lm.out2=lm(quality~facid + vacid + cacid + sugar+  chlorides+ fsulf +tsulf+ density +pH +sulphates +alcohol +color,data)
summary(lm.out2)
# -> l'analyse des tests de Student montre que l'influence de sugar n'est pas significative, puisque sa p_value > alpha = 0.05.

# -> la p_value du parametre colorW qui est la moyenne des differences entre la modalité de color W par rapport à la modalité de reference color R est tres faible, ce que signifie que ce parametre est different de 0, d'ou les deux modalites de color ont des effets differents.

# le % de variance expliquée passe à 38%

# l'analyse des tests de Student nous permet de conserver les predicteurs : vacid, chlorides, fsulf, tsulf, sulphates, alcohol, et color.


# Selection automatique des predicteurs

library(MASS)

lm.outAIC=stepAIC(lm.out2)
summary(lm.outAIC)
formula(lm.outAIC)
# la sélection automatique descendante utilisant le critere AIC conserve les predicteurs  cités avant, mais en plus il conserve le pH, mais cà n'a rien changé en terme de R^2, puisque il reste à 38% d'explication.  


# 4 Modeles avec interactions :
    
lm.outint=lm(quality~.*.,data)
summary(lm.outint)

lm.outAICint=stepAIC(lm.outint)
summary(lm.outAICint)
formula(lm.outAICint)

lm.outBICint=stepAIC(lm.outint,k=log(nrow(data)))
summary(lm.outBICint)
formula(lm.outBICint)
   
dim(lm.outAICint)
dim(lm.outBICint)
# les dimensions respectifs des deux modeles lm.outAICint et lm.outBICint sont :  45 et 22. Les deux modeles ont des grandes dimensions. mais il semble que la regression BIC est meilleure puisque il a la dimension la plus petite.

lm.outINT=stepAIC(lm.outint,k=10)
summary(lm.outINT)
formula(lm.outINT)


# 5 Visualisation des prévisions : 

x11()
plot(data$quality[1:200],type ="l",main="quality",xlab="Indice",ylab="indice de quality")
points(fitted(lm.outAICint),col="red",pch="+",cex=1.2)

# On voit que le modele lm.outAICint en rouge arrive à atteindre des valeurs extremes de predictand quality plus que la regression simple vue precedement.


# 6 Evaluation des modeles :

# Calcul des scores :

# fonction calculant le biais et le RMSE
score=function(obs,prev) {
rmse=sqrt(mean((prev-obs)**2))
biais=mean(prev-obs)
print("Biais  RMSE") 
return(round(c(biais,rmse),3))
}

nappr=ceiling(0.8*nrow(data))
ii=sample(1:nrow(data),nappr)
jj=setdiff(1:nrow(data),ii)
datatest=data[jj,]
datapp=data[ii,]

lm.outAIC=lm(formula(lm.outAIC),datapp)
lm.outAICint=lm(formula(lm.outAICint),datapp)
lm.outBICint=lm(formula(lm.outBICint),datapp)

score(datapp$quality,fitted(lm.outAIC)) 
score(datapp$quality,fitted(lm.outAICint))
score(datapp$quality,fitted(lm.outBICint))

# le biais est nul par construction.
# modele :  lm.outAIC       lm.outAICint       lm.outBICint 
# RMSE   :  0.63            0.587              0.605
# le modele lm.outAICint a le RMSe le plus petit, il est le plus performant sur les datapp

score(datatest$quality,predict(lm.outAIC,datatest))
score(datatest$quality,predict(lm.outAICint,datatest))
score(datatest$quality,predict(lm.outBICint,datatest))

# modele :  lm.outAIC       lm.outAICint       lm.outBICint 
# Biais  :  -0.019          0.002              -0.015
# RMSE   :  0.658           0.640              0.636
# Sur le fichier test, les biais se degradent mais aussi les RMSE qui augmente pour tous les modeles. 

# fichier CV.R

library(MASS)

data=read.table(file="DataTP4.txt",header=TRUE)

RMSE=function(obs,pr){
return(sqrt(mean((pr-obs)^2)))}

# Choix automatique de predicteurs a partir du modele complet sans puis avec interactions
lm.outAIC=stepAIC(lm(quality~.,data),trace=0)
lm.outBICint=stepAIC(lm(quality~.*.,data),trace=0)
lm.outBICint=stepAIC(lm(quality~.*.,data),k=log(nrow(data)),trace=0)


k=100

tab=matrix(nrow=k,ncol=8)

for (i in 1:k) {

nappr=ceiling(0.8*nrow(data))
ii=sample(1:nrow(data),nappr)
jj=setdiff(1:nrow(data),ii)
datatest=data[jj,]
datapp=data[ii,]

# Estimation des modeles
lm.outAIC=lm(formula(lm.outAIC),datapp)
lm.outAICint=lm(formula(lm.outAICint),datapp)
lm.outBICint=lm(formula(lm.outBICint),datapp)
regsurap=lm(quality~.*.*.,datapp) # modele volontairement sur-apprenti (interactions d'ordre 3), sans selection automatique des predicteurs

# Scores sur apprentissage
tab[i,1]=RMSE(datapp$quality,predict(lm.outAIC))
tab[i,2]=RMSE(datapp$quality,predict(lm.outAICint))
tab[i,3]=RMSE(datapp$quality,predict(lm.outBICint))
tab[i,4]=RMSE(datapp$quality,predict(regsurap))

# Scores sur test
tab[i,5]=RMSE(datatest$quality,predict(lm.outAIC,datatest))
tab[i,6]=RMSE(datatest$quality,predict(lm.outAICint,datatest))
tab[i,7]=RMSE(datatest$quality,predict(lm.outBICint,datatest))
tab[i,8]=RMSE(datatest$quality,predict(regsurap,datatest))

}

x11()
boxplot(tab,col=c(rep("blue",4),rep("red",4)),xlab="bleu=apprentissage - rouge=test",
names=c("ASaic","ASaicint","ASbicint","AScomplexe","ASaic","ASaicint","ASbicint","AScomplexe"),main="Modele lineaire gaussien - Score RMSE")

# Sur le graphe genere, le modele complexe avec interactions est clairement sur-apprenti car il a la plus grand valeur de RMSE sur test, 
# les modeles aic, aicint et bicint sont robustes,
# le modele à proposer reste entre aicint ou bicint qui ont pratiquement le meme biais sur fichier apprentissage, mais bicint etant significativement le meilleur sur test car il a la RMSE la plus petite. c'est le modele a proposer au final.
#
