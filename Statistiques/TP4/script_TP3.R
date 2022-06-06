 # 1. Phase préliminaire 
 data=read.table("DataTP.txt", header=TRUE)
library(MASS) ; library(verification)

data$OCC = as.factor(as.numeric(data$O3o >180))
data$OCCp = as.factor(as.numeric(data$O3p <180))
summary(data)

# OCC a une moyenne faible <=> moins de depassement de seuil, OCCp a une moyenne plus grande que OCC <=< on a plus de depassements.

source("scores.R")

# Régression logistique : modèle de discrimination

glm.out=glm(OCC~.,data[,-2],family=binomial)
glm.outBIC=stepAIC(glm.out,k=log(nrow(data)))

summary(glm.out)
summary(glm.outBIC)

scores(data$OCCp,data$OCC)
scores(fitted(glm.outBIC),data$OCC)

roc.plot(as.numeric(data$OCC),as.numeric(data$OCCp))
roc.plot(as.numeric(data$OCC),as.numeric(fitted(glm.outBIC)))

# seuil choisi = 0.1
