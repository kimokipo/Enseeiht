function [X,Y]= vectorisation(I)
    [m,n]= size(I);
    Ig=I(:,1:n-1);
    Id=I(:,2:n);
    X= Ig(:);
    Y=Id(:);  
end 
