clear;
close all;

load eigenfaces;

% Tirage aleatoire d'une image de test :
personne = randi(nb_personnes)
posture = randi(nb_postures)
% si on veut tester/mettre au point, on fixe l'individu
%individu = 10
%posture = 6

ficF = strcat('./Data/', liste_personnes{personne}, liste_postures{posture}, '-300x400.gif')
img = imread(ficF);
image_test = double(transpose(img(:)));
 

% Pourcentage d'information 
per = 0.95;

% Nombre N de composantes principales a prendre en compte 
% [dans un second temps, N peut etre calcule pour atteindre le pourcentage
% d'information avec N valeurs propres (contraste)] :
N = 8;


% pour l'affichage (A CHANGER)
personne_proche = 1;
posture_proche = 1;

[personne_calcule] = kppv(X, 1:nb_personnes_base*nb_postures_base, image_test, 1, 1, 1:nb_personnes_base*nb_postures_base);
if (personne_calcule~= 16)
       
       if (mod(personne_calcule,nb_postures_base)~=0)
           personne_proche = fix(personne_calcule/nb_postures_base)+1;
           posture_proche = mod(personne_calcule,nb_postures_base);
       else
           personne_proche = fix(personne_calcule/nb_postures_base);
           posture_proche = nb_postures_base;
       end
else
    personne_proche = nb_personnes_base;
    posture_proche = nb_postures_base;
end
figure('Name','Image tiree aleatoirement','Position',[0.2*L,0.2*H,0.8*L,0.5*H]);

subplot(1, 2, 1);
% Affichage de l'image de test :
colormap gray;
imagesc(img);
title({['Individu de test : posture ' num2str(posture) ' de ', liste_personnes{personne}]}, 'FontSize', 20);
axis image;


ficF = strcat('./Data/', liste_personnes_base{personne_proche}, liste_postures{posture_proche}, '-300x400.gif')
img = imread(ficF);
        
subplot(1, 2, 2);
imagesc(img);
title({['Individu la plus proche : posture ' num2str(posture_proche) ' de ', liste_personnes_base{personne_proche}]}, 'FontSize', 20);
axis image;
