data=read.table(file="DataTP.txt",header=TRUE)

# 4 - ANOVA : prédicteurs qualitatifs et contraintes d'identification
anova1=lm(O3o ~ JJ,data)
summary(anova1)
model.matrix(anova1)[1:10,]
# l'influeunce de JJf inclue dans l'intercept.
 # contrainte imposé : alpha_f = 0
 # p_value de JJS est > alpha = 0.05, => JJS = 0, et jours feriers n'ont pas d'influeunce.
 
anova2=lm(O3o ~ C(JJ,sum),data)
summary(anova2)
model.matrix(anova2)[1:10,]

# le modele ne dépend pas de la contrainte imposé.

# 5. ANCOVA : modèle complet et sélection automatique des prédicteurs

regcomplet=lm(O3o~O3p+TEMPE+RMH2O+log(NO2)+FF+STATION+JJ,data)
summary(regcomplet)
model.matrix(regcomplet)[1:10,]

# les prédicteurs pertinents sont : intercept, O3p, TEMPE, RMH2O, log(NO2), FF, STATIONCad, STATIONPla. les autres : STATIONAls, STATIONRam et JJs n'ont pas d'influeunce. dans regmult : NO2 et FF n'ont pas d'effet.

# minimiser AIC => minimiser -logvraisemblance et le nombre de variables. il enleve les variables et il voit l'influence sur la vraisemblence qui décroit.
library(MASS)
regaic=stepAIC(regcomplet)


# BIC minimise aussi la taille des données. et selectionne moins de variables que AIC.
# BIC a selectionné moins de variables dans la formule qui sont differents par rapport à AIC. 
regbic=stepAIC(regcomplet,k=log(nrow(data)))

regbicint=stepAIC(lm(O3o~.*.,data),k=log(nrow(data)))

# BIC avec interaction d'ordre 2 sélectionne pas mal de variables dans la formule finale.




# 6. Evaluation des modèles 
x11()
plot(data$O3o,type ="l",lwd=2,main="Concentration d'ozone",xlab="Date",ylab="[O3]")
points(data$O3p,col="blue",pch="+")
points(fitted(regbicint),col="red",pch="+")
legend(0,268,lty=1,col=c("black"),legend=c("observée"),bty="n")
legend(0,256,pch="+",col=c("blue","red"),legend=c("prevue","BICreg"),bty="n") 

# la regression BIC simule bien les variations de O3o

score=function(Y,Y_chapeau){
    # à faire
    # biais = E(Y-Y_chapeau)
    biais = mean(Y-Y_chapeau)
    RMSE = sqrt(mean((Y-Y_chapeau)**2))
    return (round(c(biais,RMSE),3))
}

# modele complexe => RMSE faible.
# Problemes : on fait apprentissage sur data, en meme temps test sur data => surapprentissage


trainind = sample(1:nrow(data),floor(0.8*nrow(data)))
testind = setdiff(1:nrow(data),trainind)
 # fichier d'apprentissage
datapp = data[trainind,]
datatest = data[testind,]

regsimpleApp=lm(O3o~O3p,datapp)
regmultApp=lm(O3o~O3p+TEMPE+RMH2O+log(NO2)+FF,datapp)

score(datapp$O3o,fitted(regsimpleApp))
score(datapp$O3o,fitted(regmultApp))

# RMSE du mult est petit que simple donc RMSe est meilleure.

# modele complexe => surapprentissage, performance baisse, le modele Asbicint est le meilleure
 
