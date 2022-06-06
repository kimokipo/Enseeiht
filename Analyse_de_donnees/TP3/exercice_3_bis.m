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





max_im = max(max(V_chrysanthemes,V_oeillets),V_pensees)
code_classe = 1*(max_im == V_chrysanthemes) + 2*(max_im == V_oeillets) + 3*(max_im == V_pensees);




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
pr_chrysanthemes = sum(sum(code_classe == 1))/size(code_classe,1)/size(code_classe,2);
pr_oeillets = sum(sum(code_classe == 2))/size(code_classe,1)/size(code_classe,2) ;
pr_pensees = sum(sum(code_classe == 3))/size(code_classe,1)/size(code_classe,2);