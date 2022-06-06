function [P]=columnstochastic_matrix(Q)
% Modification par une matrice de rang 1 afin d'obtenir une matrice
% stochastique par colonne
% Q est la matrice carr?e du graphe d'internet. 
% P est la matrice carr?e du graphe d'internet modifi?.


% Initialisation
n=length(Q(:,1));
P=Q;
d = sparse(n,1);
for j =1:n
    if (sum(Q(1:end,j)) == 0)
        d(j) = 1;
    end
end
P = P +1/n*ones(n,1)*d';
end