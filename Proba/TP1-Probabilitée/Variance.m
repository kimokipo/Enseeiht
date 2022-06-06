function varx= Variance (x)
    xbar=Moyenne(x);
    n=size(x);
    X=x-xbar;
    varx=Moyenne(X.*X);
end