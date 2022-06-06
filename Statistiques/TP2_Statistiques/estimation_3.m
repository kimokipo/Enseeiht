function [theta_Dorth_1,rho_Dorth_1] = estimation_3(x_donnees_bruitees,y_donnees_bruitees,n_tests)
G_x=mean(x_donnees_bruitees);
G_y=mean(y_donnees_bruitees);
theta=pi*rand(n_tests,1);
Cos_theta=diag(cos(theta));
Sin_theta=diag(sin(theta));
C_x=repmat(x_donnees_bruitees-G_x,n_tests,1);
C_y=repmat(y_donnees_bruitees-G_y,n_tests,1);
distances=(Cos_theta*C_x+Sin_theta*C_y).^2;
somme=sum(transpose(distances));
[M,i]=min(somme);
theta_Dorth_1=theta(i);
rho_Dorth_1=G_x*cos(theta_Dorth_1)+sin(theta_Dorth_1)*G_y;
end