function [C_renconstruction,r_e] = renconstruction(c0,D,epsilon)
    [J,m] = size(D);
    D_new = zeros(J,2^(J-1));
    N_e = 0;
    N = 2^J;
    for j=1:J
        for k=1:(2^(J-j))
            if (abs(D(j,k))>epsilon)
                D_new(j,k) = D(j,k);
                N_e = N_e + 1;
            end
        end
    end
    r_e = (N-N_e)/(N);
    C_new = zeros(J+1,2^J);
    C_new(J+1,1)=c0;
    for j = 1:J
        for k = 0:(2^(j-1)-1)
            C_new(J-j+1,2*k+1) = (C_new(J-j+2,k+1) + D_new(J-j+1,k+1))/sqrt(2);
            C_new(J-j+1,2*k+1+1) = (C_new(J-j+2,k+1) - D_new(J-j+1,k+1))/sqrt(2);
        end
    end
    C_renconstruction = C_new(1,:);
end