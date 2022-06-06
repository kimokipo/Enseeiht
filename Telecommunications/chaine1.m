%Parametres de la chaine 1
close all
Fe = 24000; %Fréquence d'échantillonage
Te = 1/Fe; %Période d'échantillonage
Rb = 6000; %Débit du signal
M = 2;     %Nombre de symbole
Tb = 1 / Rb;
Rs = Rb / log2(M);
Ns = Fe/Rs; %Nombre de points pour représenter un bit
Ts = Ns*Te; %Période du signal
Fs = 1/Ts; %Fréquence des bits du signal
N_bits = 10000;
Bits = randi([0,1],N_bits,1);
symbol = 2*Bits-1;

dirac=zeros(Ns*N_bits,1);
dirac(1:Ns:end,1) = symbol;

h=ones(1,Ns);

x=filter(h,1,dirac);


Duree = length(Bits)/Rs; %Duree en secondes du signal
Ne = Ns*length(Bits); %Nombre de points échantillonés
Temps = 0:Duree/(Ne):Duree-1/Ne; %Echelle temporelle en secondes

%Sans canal de propagation 

hc = 0*h;
hc(1) = 1;
hr = h;
hr(Ns/2+1:end)=0;

g = conv(h,hr);
N = length(g);
figure;
plot(0:Duree/N:Duree-Duree/N,g);
xlabel('Temps en secondes');
ylabel('signal g généré sans canal par la chaine 1');

% Ajout de bruit 
vecteur_db_Eb_N0 = 0:8/100:8;
vecteur_Teb_r = zeros(1,101);
P_x = mean(abs(x).^2);
random  = randn(length(x),1);
figure;
for i = 1:101
    
    Sigma_carre = P_x * Ns /(2 * log2(M) * 10^(vecteur_db_Eb_N0_ref(i)/10));
    bruit = sqrt(Sigma_carre) * random;
    
    x_bruite = x + bruit;
    
    z = filter(hr,1,x_bruite);
    
    
    %plot(reshape(z,Ns,length(z)/Ns));
    xlabel('Temps en secondes');
    ylabel('Diagramme de loeil sans canal de la chaine 1 ');

    n0 = Ns;
    z_hantillonne = z(n0:Ns:end);
    symboles = sign(z_hantillonne);
    bits_recus = (symboles+1)/2;
    
    difference = (bits_recus ~= Bits);
    vecteur_Teb_r(i) = sum(difference)/length(difference);
end 
% Comparaison entre le Taux  d’erreur  binaire TEB simulé de la chaine 1 et Taux  d’erreur  binaire TEB simulé pour la chaine de référence
figure

semilogy(vecteur_db_Eb_N0,vecteur_Teb_r);
xlabel('Rapport  signal à  bruit  Eb/N0 en db');
ylabel('Taux  d’erreur  binaire TEB');
hold on 
semilogy(vecteur_db_Eb_N0_ref,vecteur_Teb_r_ref);
legend('Taux  d’erreur  binaire TEB simulé pour la chaine 1','Taux  d’erreur  binaire TEB simulé pour la chaine de référence');
title('Comparaison entre le Taux  d’erreur  binaire TEB simulé de la chaine 1 et Taux  d’erreur  binaire TEB simulé pour la chaine de référence');

%Comparaison entre Taux  d’erreur  binaire TEB simulé et théorique pour la chaine 1
figure

semilogy(vecteur_db_Eb_N0,vecteur_Teb_r);
xlabel('Rapport  signal à  bruit  Eb/N0 en db pour la chaine 1');
ylabel('Taux  d’erreur  binaire TEB pour la chaine 1');
hold on
for i = 1:101
    
    Sigma_carre = P_x * Ns /(2 * log2(M) * 10^(vecteur_db_Eb_N0_ref(i)/10));
    
    n0 = Ns;
  
    vecteur_Teb_r(i) = qfunc(g(n0)/sqrt(Sigma_carre))/log2(M);
end 
semilogy(vecteur_db_Eb_N0,vecteur_Teb_r);

legend('Taux  d’erreur  binaire TEB simulé pour la chaine 1','Taux  d’erreur  binaire TEB théorique pour la chaine 1');
title('Comparaison entre Taux  d’erreur  binaire TEB simulé et théorique pour la chaine 1');
