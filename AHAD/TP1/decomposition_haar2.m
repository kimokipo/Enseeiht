function [Decomposition] = decomposition_haar2(E)
    [n,m] = size(E);
    J = log(n)/log(2);
    C = zeros(2^J,2^J,J+1);
    D = zeros(2^J,2^J,J+1,3);
    Decomposition = zeros(2^J,2^J);
    C(:,:,1) = E;
    for j = 0:(J-1)
        Tp = zeros(2^(J-j),2^(J-j-1));
        Td = zeros(2^(J-j),2^(J-j-1));
        for k = 1:2^(J-j)
            [c0,C_old,D_old] = decomposition_haar(reshape(C(k,1:2^(J-j),j+1),1,2^(J-j)));
            Tp(k,:) = C_old(2,1:2^(J-j-1));
            Td(k,:) = D_old(1);
        end         
        for k = 1:2^(J-j-1)
            [c0,C_old,D_old] = decomposition_haar(Tp(:,k));
            C(k,1:2^(J-j-1),j+2) = C_old(2,1:2^(J-j-1));
            D(k,1:2^(J-j-1),J-j,1) = D_old(1);
        end
        for k = 1:2^(J-j-1)
            [c0,C_old,D_old] = decomposition_haar(Td(:,k));
            D(k,1:2^(J-j-1),J-j,2) = C_old(2,1:2^(J-j-1));
            D(k,1:2^(J-j-1),J-j,3) = D_old(1);
        end
        Decomposition(1:2^(J-j-1),1:2^(J-j-1)) = C(1:2^(J-j-1),1:2^(J-j-1),J-j);
        Decomposition(1:2^(J-j-1),2^(J-j-1)+1:2^(J-j)) = D(1:2^(J-j-1),1:2^(J-j-1),J-j,1);
        Decomposition(2^(J-j-1)+1:2^(J-j),1:2^(J-j-1)) = D(1:2^(J-j-1),1:2^(J-j-1),J-j,2);
        Decomposition(2^(J-j-1)+1:2^(J-j),2^(J-j-1)+1:2^(J-j)) = D(1:2^(J-j-1),1:2^(J-j-1),J-j,3);
    end
end