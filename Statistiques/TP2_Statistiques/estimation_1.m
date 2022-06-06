function [a_DYX_1,b_DYX_1] = estimation_1(x_donnees_bruitees,y_donnees_bruitees,n_tests)
G_x=mean(x_donnees_bruitees);
G_y=mean(y_donnees_bruitees);
phi=pi*(-0.5+rand(n_tests,1));
C_phi=diag(tan(phi));
C_x=repmat(x_donnees_bruitees-G_x,n_tests,1);
C_y=repmat(y_donnees_bruitees-G_y,n_tests,1);
distances=(C_y-C_phi*C_x).^2;
somme=sum(transpose(distances));
[M,i]=min(somme);
a_DYX_1=tan(phi(i));
b_DYX_1=G_y-a_DYX_1*G_x;
end