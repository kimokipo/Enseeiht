%Parametres de la chaine_QPSK.
close all;
Fe = 12000; %Fréquence d'échantillonage
Te = 1/Fe; %Période d'échantillonage
Rb = 6000; %Débit du signal
M = 4;     %Nombre de symbole
Tb = 1 / Rb;
Rs = Rb / log2(M);
Ns = Fe/Rs; %Nombre de points pour représenter un bit
Ts = Ns*Te; %Période du signal
Fs = 1/Ts; %Fréquence des bits du signal
Fp = 2000; %Fréquence porteuse
N_bits = 1000;
Bits = randi([0,1],N_bits,1);
Bits_reshape = reshape(Bits,[500,2]);

ak = 2*Bits_reshape(:,1)-1;
bk = 2*Bits_reshape(:,2)-1;
dk_qpsk = ak +1i * bk;

dirac=zeros(Ns*N_bits/2,1);
dirac(1:Ns:end,1) = dk_qpsk;


figure;
plot(real(dk_qpsk),imag(dk_qpsk));
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
ylabel('signal g généré sans canal par la chaine_QPSK. ');

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
    %ylabel('Diagramme de loeil sans canal de la chaine Chaine_4-ASK ');

    n0 = Ns;
    z_hantillonne = z(n0:Ns:end);
    
    ak_renconstruits = sign(real(z_hantillonne));
    bk_renconstruits = sign(imag(z_hantillonne));
    
    difference_ak = ((ak_renconstruits+1)/2 ~= Bits_reshape(:,1));
    difference_bk = ((bk_renconstruits+1)/2 ~= Bits_reshape(:,2));
    vecteur_Teb(i) = (sum(difference_ak) + sum(difference_bk))/2/length(difference_ak);
    
end 

figure;
plot(ak_renconstruits,bk_renconstruits);
xlabel("les symboles ak");
ylabel("les symboles bk");
title("Constellations en sortie de l’ ́echantillonneur pour Eb/N0 = 8db");

%Comparaison entre Taux  d’erreur  binaire TEB simulé et théorique pour la Chaine_QPSK
figure
semilogy(vecteur_db_Eb_N0,vecteur_Teb);
xlabel('Rapport  signal à  bruit  Eb/N0 en db');
ylabel('Taux  d’erreur  binaire TEB pour la chaine_QPSK.');
hold on
vecteur_Teb_theorique = 4*(1-1/sqrt(M))*qfunc(sqrt(3*log2(M)*10.^(vecteur_db_Eb_N0/10)/(M-1)))/log2(M);
semilogy(vecteur_db_Eb_N0,vecteur_Teb_theorique);

legend('Taux  d’erreur  binaire TEB simulé pour la chaine_QPSK ','Taux  d’erreur  binaire TEB théorique pour la chaine_QPSK.');
title('Comparaison entre Taux  d’erreur  binaire TEB simulé et théorique pour la chaine_QPSK.');
