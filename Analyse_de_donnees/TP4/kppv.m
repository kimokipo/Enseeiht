%--------------------------------------------------------------------------
% ENSEEIHT - 1SN - Analyse de donnees
% TP4 - Reconnaissance de chiffres manuscrits par k plus proches voisins
% fonction kppv.m
%
% Données :
% DataA      : les données d'apprentissage (connues)
% LabelA     : les labels des données d'apprentissage
%
% DataT      : les données de test (on veut trouver leur label)
% Nt_test    : nombre de données tests qu'on veut labelliser
%
% K          : le K de l'algorithme des k-plus-proches-voisins
% ListeClass : les classes possibles (== les labels possibles)
%
% Résultat :
% Partition : pour les Nt_test données de test, le label calculé
%
%--------------------------------------------------------------------------
function [Partition] = kppv(DataA, labelA, DataT, Nt_test, K, ListeClass)

[Na,~] = size(DataA);

% Initialisation du vecteur d'étiquetage des images tests
Partition = zeros(Nt_test,1);

disp(['Classification des images test dans ' num2str(length(ListeClass)) ' classes'])
disp(['par la methode des ' num2str(K) ' plus proches voisins:'])
lesmin = zeros(28,1);
% Boucle sur les vecteurs test de l'ensemble de l'évaluation
for i = 1:Nt_test
    
    disp(['image test n°' num2str(i)])

    % Calcul des distances entre les vecteurs de test 
    % et les vecteurs d'apprentissage (voisins)
    distance = sqrt(mean((kron(DataT(i),ones(1,28*28))-DataA).^2));
    
    % On ne garde que les indices des K + proches voisins
   for k = 1:K
        [x,j] = min(distance);
            distance = [distance(1:j) distance(j+1:end)];
               lesmin(k) = j;
   end
   
   
    
    % Comptage du nombre de voisins appartenant à chaque classe
    classes = labelA(lesmin);
    
    % Recherche de la classe contenant le maximum de voisins
    frequences = zeros(length(ListeClass),1);
    for  l=1:length(ListeClass)
            indices = find(ListeClass(l) == classes);
                frequences(l) = length(indices);
    end
    [y,indice]= max(frequences);
    NumClass = ListeClass(indice);
    % Si l'image test a le plus grand nombre de voisins dans plusieurs  
    % classes différentes, alors on lui assigne celle du voisin le + proche,
    % sinon on lui assigne l'unique classe contenant le plus de voisins 
    if length(NumClass) >1
           for p =1:K 
              r = find(classes(p) == NumClass);
              if r~=0
                  partition(i) = NumClass(r);
              end
           end
    else 
        partition(i) = NumClass;
    end
        
    
    % Assignation de l'étiquette correspondant à la classe trouvée au point 
    % correspondant à la i-ème image test dans le vecteur "Partition" 
    
    
    
end
confusion = zeros(10,10);
erreur = 0;
for i = 1:10
        for j = 1:10
             confusion(i,j) = length(find(Partition == ListeClass(j) & labelA(1:Nt_test) == ListeClass(i)));
             if i~=j && confusion(i,j)>0
                 erreur =erreur+1;
             end
        end
end
erreur = erreur / Nt_test;
   disp(erreur);
