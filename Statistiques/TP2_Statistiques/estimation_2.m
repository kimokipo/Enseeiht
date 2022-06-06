function [a_DYX_2,b_DYX_2] = estimation_2(x_donnees_bruitees,y_donnees_bruitees)
n_points=length(x_donnees_bruitees);
A=[transpose(x_donnees_bruitees) ones(n_points,1)];
B=transpose(y_donnees_bruitees);
X=inv(transpose(A)*A)*transpose(A)*B;
a_DYX_2=X(1);
b_DYX_2=X(2);
end