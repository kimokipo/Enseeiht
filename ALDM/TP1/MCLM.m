function [minimum_sortie,sol_sortie] = MCLM(n,chi,R,I,I_bar,Q,sol,minimum)
%UNTITLED4 Summary of this function goes here
%   Detailed explanation goes here
[N,~] = size(R);
minimum_sortie = minimum;
sol_sortie = sol;
if (n==0)
    p = phi(I,I_bar,Q);
    sol1 = I;
    if (p < minimum)
            minimum_sortie = p;
            sol_sortie = sol1;
    end
else
    terme = 0;
    for i=(n+1):N
        terme = terme+R(n,i)*(I(i)-I_bar(i));
    end
    g = ceil(-sqrt(chi)/R(n,n) + I_bar(n)-terme/R(n,n));
    d = floor(sqrt(chi)/R(n,n) + I_bar(n)+-terme/R(n,n));
    for i=g:d
        if (chi > (terme+R(n,n)*(i-I_bar(n)))^2)
            chi_new = chi - (terme+R(n,n)*(i-I_bar(n)))^2;
            I(n) = i;
            [minimum1,sol1] = MCLM(n-1,chi_new,R,I,I_bar,Q,sol_sortie,minimum_sortie);
            if (minimum1 < minimum)
                minimum_sortie = minimum1;
                sol_sortie = sol1;
            end
        end
    end
end   
end