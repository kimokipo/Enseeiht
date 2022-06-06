%--------------------------------------------------------------------------
% ENSEEIHT - 1SN - Analyse de données
% TP3 - Classification bayésienne
% exercice_3.m
%--------------------------------------------------------------------------

clear
close all
clc

% Chargement des données de l'exercice 2
load resultats_ex2

%% Classifieur par maximum de vraisemblance
% code_classe est la matrice contenant des 1 pour les chrysanthemes
%                                          2 pour les oeillets
%                                          3 pour les pensees
% l'attribution de 1,2 ou 3 correspond au maximum des trois vraisemblances





code_classe = ones(size(V_oeillets));
code_classe(code_classe < V_chrysanthemes) = 1;
max_temp = V_chrysanthemes;
code_classe(max_temp < V_oeillets) = 2;
max_temp = max(max_temp, V_oeillets);
code_classe(max_temp < V_pensees) = 3;



%% Affichage des classes

figure('Name','Classification par maximum de vraisemblance',...
       'Position',[0.25*L,0.1*H,0.5*L,0.8*H])
axis equal ij
axis([r(1) r(end) v(1) v(end)]);
hold on
imagesc(r,v,code_classe)
carte_couleurs = [.45 .45 .65 ; .45 .65 .45 ; .65 .45 .45];
colormap(carte_couleurs)
hx = xlabel('$\overline{r}$','FontSize',20);
set(hx,'Interpreter','Latex')
hy = ylabel('$\bar{v}$','FontSize',20);
set(hy,'Interpreter','Latex')
view(-90,90)

%% Comptage des images correctement classees
res = 0;
for i=1:nb_images_chrysanthemes
    [~, ind_r] = min(abs(r - X_chrysanthemes(i,1)));
    [~, ind_v] = min(abs(v - X_chrysanthemes(i,2)));
    if code_classe(ind_v, ind_r) == 1
        res = res + 1;
    end
end
taux_chrysanthemes = res/10


res = 0;
for i=1:nb_images_chrysanthemes
    [~, ind_r] = min(abs(r - X_oeillets(i,1)));
    [~, ind_v] = min(abs(v - X_oeillets(i,2)));
    if code_classe(ind_v, ind_r) == 2
        res = res + 1;
    end
end
taux_oeillets = res/10


res = 0;
for i=1:nb_images_chrysanthemes
    [~, ind_r] = min(abs(r - X_pensees(i,1)));
    [~, ind_v] = min(abs(v - X_pensees(i,2)));
    if code_classe(ind_v, ind_r) == 3
        res = res + 1;
    end
end
taux_pensees = res/10
