% Ce programme est le script principal permettant d'illustrer
% un algorithme de reconnaissance de chiffres.

% Nettoyage de l'espace de travail
clear all; close all;

% Repertories contenant les donnees et leurs lectures
addpath('Data');
addpath('Utils')

rng('shuffle')

% Bruit
sig0=0.2;

%tableau des csores de classification
% intialisation aléatoire pour affichage
r=rand(6,5);
r2=rand(6,5);

for k=1:5
% Definition des donnees
file=['D' num2str(k)]

% Recuperation des donnees
disp('Generation de la base de donnees');
sD=load(file);
D=sD.(file);
%

% Bruitage des données
Db= D+sig0*randn(size(D));

% PrecApprox
PrecApprox = 1-10^-1;
epsilon = 10^-6;
%%%%%%%%%%%%%%%%%%%%%%%
% Analyse des donnees 
%%%%%%%%%%%%%%%%%%%%%%%
disp('PCA : calcul du sous-espace');
%%%%%%%%%%%%%%%%%%%%%%%%% TO DO %%%%%%%%%%%%%%%%%%
%disp('TO DO')
[m,n] = size(Db);
X = Db;
x_moyen = (mean(X'))';
X_centre = X-kron(ones(1,n),x_moyen);

Sigma = 1/n*X_centre*X_centre';
[U,DV] = eig(Sigma);

[D_sorted,I] = sort(diag(DV),'descend');
U_sorted = U(:,I);
approxs = zeros(m,1);
for i=1:m
    approxs(i,1) = abs((1-sqrt(D_sorted(i)/D_sorted(1)))-PrecApprox);
end
[~,k_cherche] = sort(approxs);
k_cherche = k_cherche(1);


%%%%%%%%%%%%%%%%%%%%%%%%% FIN TO DO %%%%%%%%%%%%%%%%%%

disp('kernel PCA : calcul du sous-espace');
%%%%%%%%%%%%%%%%%%%%%%%%% TO DO %%%%%%%%%%%%%%%%%%
disp('TO DO')

K = zeros(n,n);
A = 1/n*ones(n,n);
for i=1:n
    for j=1:n
        K(i,j) = X_centre(:,i)'*X_centre(:,j);
    end
end
K = K-A*K-K*A+A*k*A;
[U2,DV2] = eig(K);

[D_sorted2,I2] = sort(diag(DV2),'descend');
U_sorted2 = U2(:,I2);
rang_K = rank(K);
alphas = zeros(n,n);
for j=1:rang_K
    alphas(:,j) = 1/real(sqrt(D_sorted2(j))) * U_sorted2(:,j);
end

%%%%%%%%%%%%%%%%%%%%%%%%% FIN TO DO %%%%%%%%%%%%%%%%%%

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Reconnaissance de chiffres
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

 % Lecture des chiffres à reconnaitre
 disp('test des chiffres :');
 tes(:,1) = importerIm('test1.jpg',1,1,16,16);
 tes(:,2) = importerIm('test2.jpg',1,1,16,16);
 tes(:,3) = importerIm('test3.jpg',1,1,16,16);
 tes(:,4) = importerIm('test4.jpg',1,1,16,16);
 tes(:,5) = importerIm('test5.jpg',1,1,16,16);
 tes(:,6) = importerIm('test9.jpg',1,1,16,16);


 for tests=1:6
    % Bruitage
    tes(:,tests)=tes(:,tests)+sig0*randn(length(tes(:,tests)),1);

    % Classification depuis ACP
     %%%%%%%%%%%%%%%%%%%%%%%%% TO DO %%%%%%%%%%%%%%%%%%
     disp('PCA : classification');
     x = tes(:,tests);
     C = U_sorted'*(x-x_moyen);
     distances = zeros(k_cherche,1);
     for i=1:k_cherche
         distances(i,1) = norm((eye(m)-U_sorted(i)*U_sorted(i)')*C)/norm(C);
     end
     [r_k,i0] = sort(distances);
     i0 = i0(1);
     r(tests,k) = r_k(1);
     %resultat = D(i0);
     resultat = U_sorted*U_sorted(:,i0)+x_moyen;
     if(tests==k)
       figure(100+k)
       subplot(1,2,1); 
       imshow(reshape(resultat,[16,16]));
       subplot(1,2,2);
     end  
    %%%%%%%%%%%%%%%%%%%%%%%%% FIN TO DO %%%%%%%%%%%%%%%%%%
  
   % Classification depuis kernel ACP
     %%%%%%%%%%%%%%%%%%%%%%%%% TO DO %%%%%%%%%%%%%%%%%%
     disp('kernel PCA : classification');
     disp('TO DO')
     x = tes(:,tests);
     phi_x = x-x_moyen;
     y_x = zeros(n,1);
     for i=1:n
        for j=1:n
            y_x(i,1) = y_x(i,1) + alphas(i,j)*(phi_x'*X_centre(:,j));
        end
     end
     V = zeros(m,k_cherche);
     for j=1:k_cherche
         for i=1:n
            V(:,j) = V(:,j) + alphas(i,j)*(X_centre(:,i));
         end
     end
     C_k_x = zeros(m);
     for j=1:k_cherche
        C_k_x = C_k_x + y_x(j)*V(:,j);
     end
     
     distances2 = zeros(k_cherche,1);
     for i=1:k_cherche
         distances2(i,1) = norm(C_k_x-X_centre(:,i));
     end
     [~,i02] = sort(distances2);
     i02 = i02(1);
     resultat2 = X(:,i02);
%      gama = zeros(n,1);
%      for i=1:n
%         for j=1:k_cherche
%             gama(i,1) = gama(i,1) + alphas(i,j)*y_x(j);
%         end
%      end
%     z_old = X_centre(:,1);
%     z = zeros(m,1);
%     descriminant = 0;
%     for i=1:n
%         descriminant = descriminant + gama(i,1)*((z_old-x_moyen)'*X_centre(:,i));
%         z = z + gama(i,1)*((z_old-x_moyen)'*X_centre(:,i))*X(:,i);
%     end
%     z = z/descriminant;
%     while(norm(z-z_old) > epsilon)
%         z_old = z;
%         z = zeros(m,1);
%         descriminant = 0;
%         for i=1:n
%                 descriminant = descriminant + gama(i,1)*((z_old-x_moyen)'*X_centre(:,i));
%                 z = z + gama(i,1)*((z_old-x_moyen)'*X_centre(:,i))*X(:,i);
%         end
%         z = z/descriminant;
%     end
%     resultat2 = z;

%     rhos = zeros(n,1);
%     for i=1:n
%         somme_j = 0;
%         for j = 1:k_cherche
%             somme_l = 0;
%             for l=1:n
%                 somme_l = somme_l +alphas(j,l)*K(l,i);
%             end
%             somme_j = somme_j + phi_x'*V(:,j)*somme_l;
%         end
%         rhos(i,1) = K(i,i) - 2 *somme_j;
%     end
%     [~,i02] = sort(rhos);
%     i02 = i02(1);
%     resultat2 = X(:,i02);
    if(tests==k)
       imshow(reshape(resultat2,[16,16]));
    end  
    %%%%%%%%%%%%%%%%%%%%%%%%% FIN TO DO %%%%%%%%%%%%%%%%%%    
 end
 
end


% Affichage du résultat de l'analyse par PCA
couleur = hsv(6);

figure(11)
for tests=1:6
     hold on
     plot(1:5, r(tests,:),  '+', 'Color', couleur(tests,:));
     hold off
 
     for i = 1:4
        hold on
         plot(i:0.1:(i+1),r(tests,i):(r(tests,i+1)-r(tests,i))/10:r(tests,i+1), 'Color', couleur(tests,:),'LineWidth',2)
         hold off
     end
     hold on
     if(tests==6)
       testa=9;
     else
       testa=tests;  
     end
     text(5,r(tests,5),num2str(testa));
     hold off
 end

% Affichage du résultat de l'analyse par kernel PCA
figure(12)
for tests=1:6
     hold on
     plot(1:5, r2(tests,:),  '+', 'Color', couleur(tests,:));
     hold off
 
     for i = 1:4
        hold on
         plot(i:0.1:(i+1),r2(tests,i):(r2(tests,i+1)-r2(tests,i))/10:r2(tests,i+1), 'Color', couleur(tests,:),'LineWidth',2)
         hold off
     end
     hold on
     if(tests==6)
       testa=9;
     else
       testa=tests;  
     end
     text(5,r2(tests,5),num2str(testa));
     hold off
 end
