function [indices] = classification_spectrale(S,k,sigma)
%UNTITLED Summary of this function goes here
%   Detailed explanation goes here
[p,n] = size(S);
A = zeros(n,n);
for i=1:n
    for j=1:n
        if (i ~= j)
            A(i,j) = exp(-norm(S(1:end,i)-S(1:end,j),2)^2/2/sigma^2);
        end
    end
end
D_demi_inv = zeros(n,n);
for i=1:n
    D_demi_inv(i,i) = 1/sqrt(sum(A(i,1:end)));
end
L = D_demi_inv*A*D_demi_inv;
[V,D] = eig(L);
[D2,I] = sort(diag(D),"descend");
V2 = V(1:end,I);
X = V2(1:end,1:k);
Y = zeros(n,k);
for i=1:n
    for j=1:k
        Y(i,j) = X(i,j)/(sum(X(i,1:end).^2))^0.5;
    end
end
indices = kmeans(Y,k);
end
