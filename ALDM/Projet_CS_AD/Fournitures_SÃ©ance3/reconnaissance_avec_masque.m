clear;
close all;

load eigenfaces;

% Tirage aleatoire d'une image de test :
personne_masque = randi(nb_personnes)
posture_masque = randi(nb_postures)
% si on veut tester/mettre au point, on fixe l'individu
%individu = 10
%posture = 6

ficF = strcat('./Data/', liste_personnes{personne_masque}, liste_postures{posture_masque}, '-300x400.gif')
img = imread(ficF);
img(ligne_min:ligne_max,colonne_min:colonne_max) = 0;
image_test_masque = double(transpose(img(:)));
 

% Pourcentage d'information 
per = 0.95;

% Nombre N de composantes principales a prendre en compte 
% [dans un second temps, N peut etre calcule pour atteindre le pourcentage
% d'information avec N valeurs propres (contraste)] :
N = 8;


% pour l'affichage (A CHANGER)
personne_proche_masque = 1;
posture_proche_masque = 1;

[personne_calcule_masque] = kppv(X_masque, 1:nb_personnes_base*nb_postures_base, image_test_masque, 1, 1, 1:nb_personnes_base*nb_postures_base);
if (personne_calcule_masque~= 16)
       
       if (mod(personne_calcule_masque,nb_postures_base)~=0)
           personne_proche_masque = fix(personne_calcule_masque/nb_postures_base)+1;
           posture_proche_masque = mod(personne_calcule_masque,nb_postures_base);
       else
           personne_proche_masque = fix(personne_calcule_masque/nb_postures_base);
           posture_proche_masque = nb_postures_base;
       end
else
    personne_proche_masque = nb_personnes_base;
    posture_proche_masque = nb_postures_base;
end
figure('Name','Image tiree aleatoirement','Position',[0.2*L,0.2*H,0.8*L,0.5*H]);

subplot(1, 2, 1);
% Affichage de l'image de test :
colormap gray;
imagesc(img);
title({['Individu de test : posture ' num2str(posture_masque) ' de ', liste_personnes{personne_masque}]}, 'FontSize', 20);
axis image;


ficF = strcat('./Data/', liste_personnes_base{personne_proche_masque}, liste_postures{posture_proche_masque}, '-300x400.gif')
img = imread(ficF);
img(ligne_min:ligne_max,colonne_min:colonne_max) = 0;

subplot(1, 2, 2);
imagesc(img);
title({['Individu la plus proche : posture ' num2str(posture_proche_masque) ' de ', liste_personnes_base{personne_proche_masque}]}, 'FontSize', 20);
axis image;
