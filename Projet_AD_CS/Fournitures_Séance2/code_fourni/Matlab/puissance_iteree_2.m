clear variables;clc
% tolerance relative minimum pour l'ecart entre deux iteration successives 
% de la suite tendant vers la valeur propre dominante 
% (si |lambda-lambda_old|/|lambda_old|<eps, l'algo a converge)
eps = 1e-8;
% nombre d iterations max pour atteindre la convergence 
% (si i > kmax, l'algo finit)
imax = 5000; 

% Generation d une matrice rectangulaire aleatoire A de taille n x p.
% On cherche le vecteur propre et la valeur propre dominants de AA^T
n = 1500; p = 500; m = 50;
A = 5*randn(n,p);

% AAt est la matrice carree de taille (n x n).
 AAt = A*A';

%% Methode de la puissance iteree pour la matrice AAt de taille nxn
% Point de depart de l'algorithme de la puissance iteree : une matrice
% aleatoire, normalise
V = ones(n,m); V = V./sqrt(sum(V.^2));

cv = false;
iv1 = 0;  % pour compter le nombre d'iterations effectuees
t_v1 =  cputime; % pour calculer le temps d execution de l'algo
err1 = 0; % residu de la norme du vecteur propre. On sort de la boucle 
          % quand err1 <eps 
disp('** A COMPLETER ** CONSIGNES EN COMMENTAIRE **')
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% CODER L'ALGORITHME DE LA PUISSANCE ITEREE TEL QUE DONNE DANS L'ENONCE
% POUR LA MATRICE AAt
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
lambda1 = V' * AAt * V;
while(~cv)
   nu1 = lambda1;
   V = AAt * V;
   V = V./sqrt(sum(V.^2));
   lambda1  = V'* AAt * V;
   iv1 = iv1 + 1;
   err1 = abs(lambda1 - nu1)/abs(nu1);
   cv = ( err1 <= eps) | (iv1 > imax); 
   % /!\ Ce break sert a eviter que vous rentriez dans une boucle infini 
   % si vous lancez ce script avant de l'avoir modifier. Pensez a le 
   % supprimer quand vous coderez la puissance iteree
end
t_v1 = cputime-t_v1; % t_version1 : temps d execution de l algo de la 
                     % puissance iteree pour la matrice AAt




%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
fprintf('Erreur relative pour la methode avec la grande matrice = %0.3e\n',err1);
fprintf('Ecart relatif entre les deux valeurs propres trouvees = %1.2e\n', 0);
fprintf('Temps pour une ite avec la grande matrice = %0.3e\n',t_v1/iv1);

[W,D] = eig(AAt);

fprintf('\nValeur propre dominante (methode avec la grande matrice) = %0.3e\n',lambda1);
fprintf('Valeur propre dominante (fonction eig) = %0.3e\n',D(end));
