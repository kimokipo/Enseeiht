function [Q]=matrix_representation(A,n)
% Représentation sous forme de matrice du graphe Internet
% A contient les arcs du graphe orienté.
% n représente le nombre de sommets.
% Q est la matrice du graphe Internet.

% Initialisation
Q=zeros(n,n);
for i=1:n
    for j=1:n
        indices = find(A(1:end,1) == j);
        
        Nj = length(indices);
        Oj = A(indices,2);
        ind = find(Oj == i);
        if (length(ind) ~= 0)
            Q(i,j) = 1/Nj;
        end
    end
end
end
