function [C_renconstruction,r_e] = renconstruction2(D,epsilon)
    [n,m] = size(D); 
    J = log(m)/log(2);
    D_new = zeros(2^J,2^J);
    N_e = 0;
    N = 2^J;
    for j=1:2^J
        for k=1:2^J
            if ((j > 1) && (k > 1) && abs(D(j,k))>epsilon)
                D_new(j,k) = D(j,k);
                N_e = N_e + 1;
            end
        end
    end
    r_e = (N-N_e)/(N);
    C = zeros(2^J,2^J,J+1);
    D = zeros(2^J,2^J,J+1,3);
    Renconstruction = zeros(2^J,2^J);
    for j = 0:J
        for k = 0:(2^(j-1)-1)
            C_new(J-j+1,2*k+1) = (C_new(J-j+2,k+1) + D_new(J-j+1,k+1))/sqrt(2);
            C_new(J-j+1,2*k+1+1) = (C_new(J-j+2,k+1) - D_new(J-j+1,k+1))/sqrt(2);
        end
    end
    C_renconstruction = C_new(1,:);
end