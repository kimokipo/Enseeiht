function [beta, norm_grad_f_beta, f_beta, norm_delta, nb_it, exitflag] ...
          = Algo_Newton(Hess_f_C14, beta0, option)
%************************************************************
% Fichier  ~gergaud/ENS/Optim1a/TP-optim-20-21/Newton_ref.m *
% Novembre 2020                                             *
% Université de Toulouse, INP-ENSEEIHT                      *
%************************************************************
%
% Newton r�sout par l'algorithme de Newton les problemes aux moindres carres
% Min 0.5||r(beta)||^2
% beta \in R^p
%
% Parametres en entrees
% --------------------
% Hess_f_C14 : fonction qui code la hessiennne de f
%              Hess_f_C14 : R^p --> matrice (p,p)
%              (la fonction retourne aussi le residu et la jacobienne)
% beta0  : point de départ
%          real(p)
% option(1) : Tol_abs, tolérance absolue
%             real
% option(2) : Tol_rel, tolérance relative
%             real
% option(3) : nitimax, nombre d'itérations maximum
%             integer
%
% Parametres en sortie
% --------------------
% beta      : beta
%             real(p)
% norm_gradf_beta : ||gradient f(beta)||
%                   real
% f_beta    : f(beta)
%             real
% res       : r(beta)
%             real(n)
% norm_delta : ||delta||
%              real
% nbit       : nombre d'itérations
%              integer
% exitflag   : indicateur de sortie
%              integer entre 1 et 4
% exitflag = 1 : ||gradient f(beta)|| < max(Tol_rel||gradient f(beta0)||,Tol_abs)
% exitflag = 2 : |f(beta^{k+1})-f(beta^k)| < max(Tol_rel|f(beta^k)|,Tol_abs)
% exitflag = 3 : ||delta)|| < max(Tol_rel delta^k),Tol_abs)
% exitflag = 4 : nombre maximum d'itérations atteint
%      
% ---------------------------------------------------------------------------------

% TO DO %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

   beta = beta0;
    beta_pre= beta;
    [H_f_pre, res_pre, J_res_pre] = Hess_f_C14(beta_pre);
    beta = beta_pre -inv(H_f_pre)*transpose(J_res_pre)*res_pre;
    f_beta=0;
    f_beta_pre=f_beta;
    [H_f, res, J_res] = Hess_f_C14(beta);
    f_beta =  0.5*((res.')*res);
    norm_grad_f_beta = norm((transpose(J_res)*res));
    [H_f0, res0, J_res0] = Hess_f_C14(beta0);
    norm_grad_f_beta0 = norm((transpose(J_res0)*res0));
    norm_delta = norm((beta-beta_pre));
    nb_it = 1;
    exitflag = 0;
    Tol_abs = option(1);
    Tol_rel = option(2);
    n_itmax =option(3);
    while (norm_delta > max((Tol_rel*0.5*2*mean(beta_pre.*beta_pre)),Tol_abs)) & (abs(f_beta-f_beta_pre) > max((Tol_rel*f_beta_pre),Tol_abs)) & (norm_grad_f_beta > max((Tol_rel*norm_grad_f_beta0),Tol_abs)) & (nb_it < n_itmax)  
        beta_pre= beta;
        [H_f_pre, res_pre, J_res_pre] = Hess_f_C14(beta_pre);
        beta = beta_pre -inv(H_f)*transpose(J_res)*res;
        nb_it = nb_it +1;
        f_beta_pre=f_beta;
        [H_f, res, J_res] = Hess_f_C14(beta);
        f_beta =  0.5*((res.')*res);
        norm_grad_f_beta = norm((transpose(J_res)*res));
        norm_delta = norm((beta-beta_pre));
    end
    if (norm_delta <= max((Tol_rel*0.5*2*mean(beta_pre.*beta_pre)),Tol_abs))
        exitflag =3;
    end 
    if (abs(f_beta-f_beta_pre) <= max(Tol_rel*f_beta_pre,Tol_abs)) 
        exitflag=2;
    end 
    if (norm_grad_f_beta <= max(Tol_rel*norm_grad_f_beta0,Tol_abs))
        exitflag=1;
    end 
    if (nb_it >= n_itmax)
        exitflag=4;
    end

end
