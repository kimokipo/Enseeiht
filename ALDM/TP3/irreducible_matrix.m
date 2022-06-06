function [A,err]=irreducible_matrix(P,alpha,v)
% Modification de rang 1 d'une matrice colonne stochastique afin de la rendre
% irr?ductible
% P est la matrice colonne stochastique.
% alpha est le param?tre de poids (0<alpha<1).
% v est le vecteur de personalisation (vi>0 et ||v||1=1)
% A est la matrice irr?ductible
% err vaut 1 si alpha et v ne respectent pas les contraintes.

% Initialisation
n=length(P(:,1));

% Tests sur alpha et v

% Calcul de A
A=alpha*P+(1-alpha)*v*ones(1,n);
err=0;
if (alpha<=0 || alpha >=1 || norm(v,1) ~= 1 || length(find(v<=0)) ~= 0)
    err = 1;
end

end