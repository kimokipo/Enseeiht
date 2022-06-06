%Parametres de la chaine sur fréquence porteuse
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
dk = ak +1i * bk;

dirac=zeros(Ns*N_bits/2,1);
dirac(1:Ns:end,1) = dk;

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
ylabel('signal I en phase généré par la chaine sur fréquence porteuse');

figure;
plot(Temps,Q);
xlabel('Temps en secondes');
ylabel('signal Q en quadrature généré par la chaine sur fréquence porteuse');

figure;
plot(Temps,x);
xlabel('Temps en secondes');
ylabel('signal x transmis généré par la chaine sur fréquence porteuse');


%Génération de la densité spectrale de puissance de x
periodogramme_modulation_frequence_porteuse = (1/length(x))*abs(fft(x,length(x))).^2;
figure;
semilogy(linspace(-Fe/2,Fe/2,length(periodogramme_modulation_frequence_porteuse)),fftshift(periodogramme_modulation_frequence_porteuse));
xlabel("Fréquence en Hz");
ylabel("Densite spectrale du signal x transmis généré par la chaine sur fréquence porteuse");



%Sans canal de propagation 

hc = 0*h;
hc(1) = 1;
hr = h;

g = conv(h,hr);
N = length(g);
figure;
plot(0:Duree/N:Duree-Duree/N,g);
xlabel('Temps en secondes');
ylabel('signal g généré sans canal sur fréquence porteuse');

% Ajout de bruit 

vecteur_db_Eb_N0 = 0:8/100:8;
vecteur_Teb_porteuse = zeros(1,101);
P_x = mean(abs(x).^2);
random  = randn(length(x),1);

for i = 1:101
    
    Sigma_carre = P_x * Ns /(2 * log2(M) * 10^(vecteur_db_Eb_N0(i)/10));
    bruit = sqrt(Sigma_carre) * random;
    
    x_bruite = x + bruit;
    cos_multiplie = cos(2*pi*Fp*Te*(0:length(Xe)-1));
    cos_multiplie = reshape(cos_multiplie,[length(cos_multiplie),1]);
    sin_multiplie = sin(2*pi*Fp*Te*(0:length(Xe)-1));
    sin_multiplie = reshape(sin_multiplie,[length(sin_multiplie),1]);
    
    x_cos_multiplie = x_bruite .* cos_multiplie;
    x_sin_multiplie = x_bruite .* -sin_multiplie;
    
    z_ak = filter(h,1,x_cos_multiplie);
   
    z_bk = filter(h,1,x_sin_multiplie);
    
    %plot(reshape(z,Ns,length(z)/Ns));
    %xlabel('Temps en secondes');
    %ylabel('Diagramme de loeil sans canal de la chaine sur fréquence porteuse ');

    n0 = Ns;
    z_ak_echantillonne = z_ak(n0:Ns:end);
    z_bk_echantillonne = z_bk(n0:Ns:end);
    
    symboles_ak = sign(z_ak_echantillonne);
    symboles_bk = sign(z_bk_echantillonne);
    dk_renconstruits = symboles_ak +1i*symboles_bk;
    difference_ak = ((symboles_ak+1)/2 ~= Bits_reshape(:,1));
    difference_bk = ((symboles_bk+1)/2 ~= Bits_reshape(:,2));
    vecteur_Teb_porteuse(i) = (sum(difference_ak) + sum(difference_bk))/2/length(difference_ak);
end 

%Comparaison entre Taux  d’erreur  binaire TEB simulé et théorique pour la chaine sur fréquence porteuse
figure
semilogy(vecteur_db_Eb_N0,vecteur_Teb_porteuse);
xlabel('Rapport  signal à  bruit  Eb/N0 en db');
ylabel('Taux  d’erreur  binaire TEB pour la chaine sur fréquence porteuse');
hold on
vecteur_Teb_theorique = 4*(1-1/sqrt(M))*qfunc(sqrt(3*log2(M)*10.^(vecteur_db_Eb_N0/10)/(M-1)))/log2(M);
semilogy(vecteur_db_Eb_N0,vecteur_Teb_theorique);

legend('Taux  d’erreur  binaire TEB simulé pour la chaine sur fréquence porteuse','Taux  d’erreur  binaire TEB théorique pour la chaine sur fréquence porteuse');
title('Comparaison entre Taux  d’erreur  binaire TEB simulé et théorique pour la chaine sur fréquence porteuse');
