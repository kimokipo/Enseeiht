function [C_estime,R_estime] = RANSAC_3(x_donnees_bruitees,y_donnees_bruitees,parametres,n_tests)
n=length(x_donnees_bruitees);
ecarts=zeros(parametres(3),1);
C_x=zeros(parametres(3),1);
C_y=zeros(parametres(3),1);
R=zeros(parametres(3),1);
for i=1:parametres(3) 
    tirage= randperm(n,3);
    sous_x=[x_donnees_bruitees(tirage(1)),x_donnees_bruitees(tirage(2)),x_donnees_bruitees(tirage(3))];
    sous_y =[y_donnees_bruitees(tirage(1)),y_donnees_bruitees(tirage(2)),y_donnees_bruitees(tirage(3))];
    [C,R] = cercle_3_points(sous_x,sous_y);
    Ecart_donnees=abs(sqrt((x_donnees_bruitees-C(1)).^2+(y_donnees_bruitees-C(2)).^2)-R);
    x_conformes=(Ecart_donnees<parametres(1)).*x_donnees_bruitees;
    y_conformes=(Ecart_donnees<parametres(1)).*y_donnees_bruitees;
    if length(x_conformes)/n>parametres(1) 
        [C_1,R_1]= estimation_2(x_conformes,y_conformes,n_tests);
        ecarts(i)=mean(sqrt((x_conformes-C_1(1)).^2+(y_conformes-C_1(2)).^2)-R_1);
        R(i)=R_1;
        C_x(i)=C_1(1);
        C_y(i)=C_1(2);
    end
end
[M,i]=min(ecarts);
C_estime=[C_x(i) C_y(i)];
R_estime=R(i);
end