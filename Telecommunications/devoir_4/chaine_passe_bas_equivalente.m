%Parametres de la chaine passe bas équivalente
close all;
Fe = 10000; %Fréquence d'échantillonage
Te = 1/Fe; %Période d'échantillonage
Rb = 2000; %Débit du signal
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

dk_equivalent = ak +1i*bk;

figure;
plot(bk,ak);
xlabel("les symboles ak");
ylabel("les symboles bk");
title("Constellations en sortie du mapping");

dirac=zeros(Ns*N_bits/2,1);
dirac(1:Ns:end,1) = dk_equivalent;

h=rcosdesign(0.35,1,Ns);

Xe=filter(h,1,dirac);


Duree = length(Bits)/Rs; %Duree en secondes du signal
Ne = Ns*length(Bits); %Nombre de points échantillonés
N = length(Xe);
Temps = 0:Duree/(N):Duree-Duree/N; %Echelle temporelle en secondes

I = real(Xe);
Q = imag(Xe);

complexe_multiplie = exp(2*1i*pi*Fp*Te*(0:length(Xe)-1));
complexe_multiplie = reshape(complexe_multiplie,[length(complexe_multiplie),1]);

x = real(Xe .* complexe_multiplie);

figure;
plot(Temps,I);
xlabel('Temps en secondes');
ylabel('signal I en phase généré par la chaine passe bas équivalente');

figure;
plot(Temps,Q);
xlabel('Temps en secondes');
ylabel('signal Q en quadrature généré par la chaine passe bas équivalente');



%Génération de la densité spectrale de puissance de x
periodogramme_modulation_frequence_porteuse = (1/length(Xe))*abs(fft(Xe,length(Xe))).^2;
figure;
semilogy(linspace(-Fe/2,Fe/2,length(periodogramme_modulation_frequence_porteuse)),fftshift(periodogramme_modulation_frequence_porteuse));
xlabel("Fréquence en Hz");
ylabel("Densite spectrale du signal Xe transmis généré par la chaine passe bas équivalente");



%Sans canal de propagation 

hc = 0*h;
hc(1) = 1;
hr = h;

g = conv(h,hr);
N = length(g);
figure;
plot(0:Duree/N:Duree-Duree/N,g);
xlabel('Temps en secondes');
ylabel('signal g généré sans canal par la chaine passe bas équivalente');

% Ajout de bruit 

vecteur_db_Eb_N0 = 0:8/100:8;
vecteur_Teb = zeros(1,101);
P_Xe = mean(abs(x).^2) *2;
random  = randn(length(Xe),1);
for i = 1:101
    
    Sigma_carre = P_Xe * Ns /(2 * log2(M) * 10^(vecteur_db_Eb_N0(i)/10));
    bruit = sqrt(Sigma_carre) * random*(1+1i);
    
    Xe_bruite = Xe + bruit;
    
    
    z = filter(h,1,Xe_bruite);
    
    
    
    %plot(reshape(z,Ns,length(z)/Ns));
    %xlabel('Temps en secondes');
    %ylabel('Diagramme de loeil sans canal de la chaine passe bas équivalente ');

    n0 = Ns;
    z_hantillonne = z(n0:Ns:end);
    
    ak_renconstruits = sign(real(z_hantillonne));
    bk_renconstruits = sign(imag(z_hantillonne));
    
    difference_ak = ((ak_renconstruits+1)/2 ~= Bits_reshape(:,1));
    difference_bk = ((bk_renconstruits+1)/2 ~= Bits_reshape(:,2));
    vecteur_Teb(i) = (sum(difference_ak) + sum(difference_bk))/2/length(difference_ak);
    
end 

figure;
plot(bk_renconstruits,ak_renconstruits);
xlabel("les symboles ak");
ylabel("les symboles bk");
title("Constellations en sortie de l’ ́echantillonneur pour Eb/N0 = 8db");

%Comparaison entre le Taux  d’erreur  binaire TEB simulé pour la chaine sur
%fréquence porteuse et le Taux  d’erreur  binaire TEB simulé pour la chaine
%passe bas équivalente
figure
semilogy(vecteur_db_Eb_N0,vecteur_Teb);
xlabel('Rapport  signal à  bruit  Eb/N0 en db');
ylabel('Taux  d’erreur  binaire TEB pour la chaine passe bas équivalente');
hold on

semilogy(vecteur_db_Eb_N0,vecteur_Teb_porteuse);

legend('Taux  d’erreur  binaire TEB simulé pour la chaine passe bas équivalente ','Taux  d’erreur  binaire TEB simulé pour la chaine sur fréquence porteuse');
title('Comparaison entre Taux  d’erreur  binaire TEB simulé pour la chaine sur fréquence porteuse et le Taux  d’erreur  binaire TEB simulé pour la chaine passe bas équivalente');
