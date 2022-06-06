function Beta_chapeau = MCO(x, y);
n= length(x);
A = zeros(n+1,6);
A= [x.*x x.*y y.*y x y ones(n,1)];
A = [A;[1,0,1,0,0,0]];
b= [zeros(n,1);1];
Beta_chapeau = pinv(A) * b;
end