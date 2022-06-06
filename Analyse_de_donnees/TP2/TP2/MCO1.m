function Beta_chapeau = MCO1(x, y);
n= length(x);
A = zeros(n+1,5);
A= [x.*y y.*y+x.*x x y ones(n,1)];
A = [A;[0,1,0,0,0]];
beta = MCO(x, y);
b= [zeros(n,1);1-beta(1)];
Beta_chapeau = pinv(A) * b;
end