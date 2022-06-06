function [r,a,b]=calcul_parametres(x,y)
    covxy = Covariance(x,y);
    ecarx = Ecart_type(x);
    ecary = Ecart_type(y);
    varx = Variance(x);
    xbar= Moyenne(x);
    ybar= Moyenne (y);
    r=covxy/(ecarx*ecary);
    a=covxy/varx;
    b=ybar-xbar*a;
end