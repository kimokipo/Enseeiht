%Parametres de la chaine_8-PSK.
close all;
Fe = 12000; %Fréquence d'échantillonage
Te = 1/Fe; %Période d'échantillonage
Rb = 6000; %Débit du signal
M = 8;     %Nombre de symbole
Tb = 1 / Rb;
Rs = Rb / log2(M);
Ns = Fe/Rs; %Nombre de points pour représenter un bit
Ts = Ns*Te; %Période du signal
Fs = 1/Ts; %Fréquence des bits du signal
Fp = 2000; %Fréquence porteuse
N_bits = 1000;
Bits = randi([0,1],N_bits,1);
Bits_reshape = reshape(Bits,[500,2]);

dk_psk = pskmod(Bits,8);

dirac=zeros(Ns*N_bits,1);
dirac(1:Ns:end,1) = dk_psk;



h=ones(1,Ns);
x=filter(h,1,dirac);

figure;
plot(real(dk_psk),imag(dk_psk));
xlabel("les symboles ak");
ylabel("les symboles bk");
title("Constellations en sortie du mapping");


h=rcosdesign(0.35,1,Ns);

Xe=filter(h,1,dirac);


Duree = length(Bits)/Rs; %Duree en secondes du signal
Ne = Ns*length(Bits); %Nombre de points échantillonés
N = length(Xe);
Temps = 0:Duree/(N):Duree-Duree/N; %Echelle temporelle en secondes

complexe_multiplie = exp(2*1i*pi*Fp*Te*(0:length(Xe)-1));
complexe_multiplie = reshape(complexe_multiplie,[length(complexe_multiplie),1]);

x = real(Xe .* complexe_multiplie);



%Sans canal de propagation 

hc = 0*h;
hc(1) = 1;
hr = h;

g = conv(h,hr);
N = length(g);
figure;
plot(0:Duree/N:Duree-Duree/N,g);
xlabel('Temps en secondes');
ylabel('signal g généré sans canal par la chaine_8-PSK. ');

% Ajout de bruit 

vecteur_db_Eb_N0 = 0:8/100:8;
vecteur_Teb = zeros(1,101);
P_Xe = mean(abs(x).^2) * 2;
random  = randn(length(Xe),1);
for i = 1:101
    
    Sigma_carre = P_Xe * Ns /(2 * log2(M) * 10^(vecteur_db_Eb_N0(i)/10));
    bruit = sqrt(Sigma_carre) * random*(1+1i);
    
    Xe_bruite = Xe + bruit;
    
    z = filter(h,1,Xe_bruite);
    %plot(reshape(z,Ns,length(z)/Ns));
    %xlabel('Temps en secondes');
    %ylabel('Diagramme de loeil sans canal de la chaine chaine_8-PSK ');

    n0 = Ns;
    z_hantillonne = z(n0:Ns:end);
    
    Bits_renconstruits = pskdemod(z_hantillonne,8);
    difference = (Bits_renconstruits ~= Bits);
    vecteur_Teb(i) = sum(difference)/length(difference);
    
end 

figure;
plot(ak_renconstruits,bk_renconstruits);
xlabel("les symboles ak");
ylabel("les symboles bk");
title("Constellations en sortie de l’ ́echantillonneur pour Eb/N0 = 8db");

%Comparaison entre Taux  d’erreur  binaire TEB simulé et théorique pour la Chaine_4_ASK
figure
semilogy(vecteur_db_Eb_N0,vecteur_Teb);
xlabel('Rapport  signal à  bruit  Eb/N0 en db');
ylabel('Taux  d’erreur  binaire TEB pour la chaine_8-PSK.');
hold on
vecteur_Teb_theorique = 2*qfunc(sqrt(2*10.^(vecteur_db_Eb_N0*log2(M)/10))*sin(pi/M))/log2(M);
semilogy(vecteur_db_Eb_N0,vecteur_Teb_theorique);

legend('Taux  d’erreur  binaire TEB simulé pour la chaine_8-PSK ','Taux  d’erreur  binaire TEB théorique pour la chaine_8-PSK.');
title('Comparaison entre Taux  d’erreur  binaire TEB simulé et théorique pour la chaine_8-PSK.');
