function bornes = partitionnement(selection_frequences);
[m,n]=size(selection_frequences);
bornes = zeros(2,n);
for i= 1:(n-1)
    bornes(1,i+1)=bornes(1,i)+selection_frequences(1,i);
    bornes(2,i)=bornes(1,i)+selection_frequences(1,i);
end
bornes(2,n)=1;
end
    