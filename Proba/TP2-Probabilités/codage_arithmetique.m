function [borne_inf,borne_sup] = codage_arithmetique(texte,selection_alphabet,bornes);
borne_inf = 0;
borne_sup = 1;
[m,n]=size(selection_alphabet);
m=length(texte);
for i =1:m 
    for j = 1:n
        if texte(i)==selection_alphabet(j) 
      
            largeur = borne_sup-borne_inf;
            borne_sup = borne_inf+largeur*bornes(2,j);
            borne_inf = borne_inf+largeur*bornes(1,j);
        end
    end
end
end