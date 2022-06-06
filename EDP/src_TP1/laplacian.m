function L = laplacian(nu,dx1,dx2,N1,N2)
%
%  Cette fonction construit la matrice de l'opérateur Laplacien 2D anisotrope
%
%  Inputs
%  ------
%
%  nu : nu=[nu1;nu2], coefficients de diffusivité dans les dierctions x1 et x2. 
%
%  dx1 : pas d'espace dans la direction x1.
%
%  dx2 : pas d'espace dans la direction x2.
%
%  N1 : nombre de points de grille dans la direction x1.
%
%  N2 : nombre de points de grilles dans la direction x2.
%
%  Outputs:
%  -------
%
%  L      : Matrice de l'opérateur Laplacien (dimension N1N2 x N1N2)
%
% 

% Initialisation


    a = 2*nu(1)/dx1^2 + 2*nu(2)/dx2^2;
    e1 = (-nu(1)/dx1^2);
    e2 = (-nu(2)/dx2^2);
    diag_e2 = repmat([e2*ones(1,N2-1) 0], 1, N1);
    diags = [e1*ones(1,N2*N1)' diag_e2' a*ones(1,N2*N1)' flip(diag_e2)' e1*ones(1,N2*N1)'];
    L = spdiags(diags, [-N2, -1, 0, 1, N2], N1*N2, N1*N2);   

end    
