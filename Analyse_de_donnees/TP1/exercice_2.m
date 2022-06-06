clear;
close all;
taille_ecran = get(0,'ScreenSize');
L = taille_ecran(3);
H = taille_ecran(4);
figure('Name','Separation des canaux RVB','Position',[0,0,0.67*L,0.67*H]);
figure('Name','Nuage de pixels dans le repere RVB','Position',[0.67*L,0,0.33*L,0.45*H]);

% Lecture et affichage d'une image RVB :
I = imread('ishihara-48.png');
figure(1);				% Premiere fenetre d'affichage
subplot(2,2,1);				% La fenetre comporte 2 lignes et 2 colonnes
imagesc(I);
axis off;
axis equal;
title('Image RVB','FontSize',20);

% Decoupage de l'image en trois canaux et conversion en doubles :
R = double(I(:,:,1));
V = double(I(:,:,2));
B = double(I(:,:,3));

% Affichage du canal R :
colormap gray;				% Pour afficher les images en niveaux de gris
subplot(2,2,2);
imagesc(R);
axis off;
axis equal;
title('Canal R','FontSize',20);

% Affichage du canal V :
subplot(2,2,3);
imagesc(V);
axis off;
axis equal;
title('Canal V','FontSize',20);

% Affichage du canal B :
subplot(2,2,4);
imagesc(B);
axis off;
axis equal;
title('Canal B','FontSize',20);

% Affichage du nuage de pixels dans le repere RVB :
figure(2);				% Deuxieme fenetre d'affichage
plot3(R,V,B,'b.');
axis equal;
xlabel('R');
ylabel('V');
zlabel('B');
rotate3d;

% Matrice des donnees :
X = [R(:) V(:) B(:)];			% Les trois canaux sont vectorises et concatenes

% Matrice de variance/covariance :
X_c = [(R(:) - mean(R(:))) (V(:) - mean(V(:))) (B(:) - mean(B(:)))];
Sigma = 1 / length(R(:)) * transpose(X_c) * X_c;

% Coefficients de correlation lineaire :
r_R_V = Sigma(1,2) / (sqrt(Sigma(1,1)) * sqrt(Sigma(2,2)));
r_R_B = Sigma(1,3) / (sqrt(Sigma(1,1)) * sqrt(Sigma(3,3)));
r_V_B = Sigma(2,3) / (sqrt(Sigma(2,2)) * sqrt(Sigma(3,3)));

% Proportions de contraste :
c_R = Sigma(1,1) / (Sigma(1,1) + Sigma(2,2) + Sigma(3,3));
c_V = Sigma(2,2) / (Sigma(1,1) + Sigma(2,2) + Sigma(3,3));
c_B = Sigma(3,3) / (Sigma(1,1) + Sigma(2,2) + Sigma(3,3));

% Calcul des couples propres :
[W,D] = eig(Sigma);
[D,Indices] = sort(diag(D), "descend");
W = W(:,Indices);
C = X_c * W;
Sigma = 1 / length(R(:)) * transpose(C) * C;
C = reshape(C,size(I));

% Coefficients de correlation lineaire :
r_R_V = Sigma(1,2) / (sqrt(Sigma(1,1)) * sqrt(Sigma(2,2)));
r_R_B = Sigma(1,3) / (sqrt(Sigma(1,1)) * sqrt(Sigma(3,3)));
r_V_B = Sigma(2,3) / (sqrt(Sigma(2,2)) * sqrt(Sigma(3,3)));

% Proportions de contraste :
c_R = Sigma(1,1) / (Sigma(1,1) + Sigma(2,2) + Sigma(3,3));
c_V = Sigma(2,2) / (Sigma(1,1) + Sigma(2,2) + Sigma(3,3));
c_B = Sigma(3,3) / (Sigma(1,1) + Sigma(2,2) + Sigma(3,3));

% Affichage du canal 1 :
figure(3);
colormap gray;				% Pour afficher les images en niveaux de gris
subplot(2,2,2);
imagesc(C(:,:,1));
axis off;
axis equal;
title('Canal 1','FontSize',20);

% Affichage du canal V :
subplot(2,2,3);
imagesc(C(:,:,2));
axis off;
axis equal;
title('Canal 2','FontSize',20);

% Affichage du canal B :
subplot(2,2,4);
imagesc(C(:,:,3));
axis off;
axis equal;
title('Canal 3','FontSize',20);

% Affichage du nuage de pixels dans le repere RVB :
figure(4);				% Deuxieme fenetre d'affichage
plot3(C(:,:,1),C(:,:,2),C(:,:,3),'b.');
axis equal;
xlabel('canal 1');
ylabel('canal 2');
zlabel('canal 3');
rotate3d;
