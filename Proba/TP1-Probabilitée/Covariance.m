function covxy = Covariance (x,y)
    n= length(x);
    m=length(y);
    xbar=Moyenne(x);
    ybar=Moyenne (y);
    X=x-xbar;
    Y=y-ybar;
    covxy = Moyenne(X.*Y);
end