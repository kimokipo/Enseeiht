function [rho_F_1,theta_F_1] = RANSAC_2(rho,theta,parametres)
n=length(theta);
ecarts=zeros(parametres(3),1);
rhos=zeros(parametres(3),1);
thetas=zeros(parametres(3),1);
for i=1:parametres(3) 
    tirage= randperm(n,2)
    sous_rho=[rho(tirage(1)),rho(tirage(2))];
    sous_theta=[theta(tirage(1)),theta(tirage(2))];
    [rho_F,theta_F] = estimation_F(sous_rho,sous_theta);
    Ecart_donnees=abs(rho-rho_F*cos(theta-theta_F));
    rho_conformes=(Ecart_donnees<parametres(1)).*rho;
    theta_conformes=(Ecart_donnees<parametres(1)).*theta;
    if length(rho_conformes)/n>parametres(1) 
        [rho_F,theta_F] = estimation_F(rho_conformes,theta_conformes);
        ecarts(i)=mean(abs(rho_conformes-rho_F*cos(theta_conformes-theta_F)));
        rhos(i)=rho_F;
        thetas(i)=theta_F;
    end
end
[M,i]=min(ecarts);
rho_F_1=rhos(i);
theta_F_1=thetas(i);
end