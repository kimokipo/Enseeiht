function [c0,C,D]=decomposition_haar(E)
    J = log(length(E))/log(2);
    C = zeros(J+1,2^J);
    D = zeros(J,2^(J-1));
    C(1,:) = E;
    for j = 0:(J-1)
        for k = 0:(2^(J-j-1)-1)
            C(j+1+1,k+1) = (C(j+1,2*k+1) + C(j+1,2*k+1+1))/sqrt(2);
            D(j+1,k+1) = (C(j+1,2*k+1) - C(j+1,2*k+1+1))/sqrt(2);
        end
    end
    c0 = C(J+1,1);
end
