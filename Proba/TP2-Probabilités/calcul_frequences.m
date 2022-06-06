function frequences = calcul_frequences(texte,alphabet);
n=length (texte);
m=length (alphabet);
s=zeros(m);
for i = 1:m
    indices=find (texte==alphabet(i));
    s(i)=length(indices)/n;
end
frequences =s;
end 