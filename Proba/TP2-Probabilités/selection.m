function [selection_frequences,selection_alphabet] = selection(frequences,alphabet);
m=length(alphabet);
selection_frequences=zeros(m);
selection_alphabet=zeros(m);
k=0;
for i =1:m 
    if frequences(i)>0 
        
        selection_frequences(i-k)=frequences(i);
        selection_alphabet(i-k)=alphabet(i);
    else
        k=k+1;
    end
end 
selection_frequences=selection_frequences(1:(m-k));
selection_alphabet=selection_alphabet(1:(m-k));
end