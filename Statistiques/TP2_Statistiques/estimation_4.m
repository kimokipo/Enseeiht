function [theta_Dorth_2,rho_Dorth_2] = estimation_4(x_donnees_bruitees,y_donnees_bruitees)
G_x=mean(x_donnees_bruitees);
G_y=mean(y_donnees_bruitees);
C=[transpose(y_donnees_bruitees-G_y) transpose(x_donnees_bruitees-G_x)];
[vecteurs_propres,valeurs_propres]=eig(transpose(C)*C);
[lambda,i]=min(valeurs_propres);
Y=vecteurs_propres(i);
theta_Dorth_2=acos(Y(1));
rho_Dorth_2=G_x*cos(theta_Dorth_2)+sin(theta_Dorth_2)*G_y;
end