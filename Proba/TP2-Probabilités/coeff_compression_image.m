function coeff_compression = coeff_compression_image(histogramme,dico);
s=0;
z=0;
[m,n]=size(histogramme);
[k,l]=size(dico);
for i = 1:n 
        s=s+histogramme(1,i);
end
for i = 1:k 
    for j =1:l 
        z=z+length(dico(i,j));
    end
end
coeff_compression= s/z;
end