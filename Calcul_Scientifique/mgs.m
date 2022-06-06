%--------------------------------------------------------------------------
% ENSEEIHT - 1SN - Calcul scientifique
% TP1 - Orthogonalisation de Gram-Schmidt
% mgs.m
%--------------------------------------------------------------------------

function Q = mgs(A)

    % Recuperation du nombre de colonnes de A
    [~, m] = size(A);
    
    % Initialisation de la matrice Q avec la matrice A
    Q = A;
    Q(:,1) = 1/sqrt(sum(A(:,1).^2))*A(:,1);
    %------------------------------------------------
    for i=1:(m-1) 
        y = A(:,i+1);
        for j =1:i
            y = y- sum(y.*Q(:,j))*Q(:,j);
        end 
        y = 1/sqrt(sum(y.^2)) * y;
        Q(:,i+1) = y;
    end
    % Algorithme de Gram-Schmidt modifie
    %------------------------------------------------

end