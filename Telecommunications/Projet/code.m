%Parametres du chaine de transmition avec canal
close all;
Fe = 24000; %Fréquence d'échantillonage
Te = 1/Fe; %Période d'échantillonage
Rb = 3000; %Débit du signal
M = 2;     %Nombre de symbole
Tb = 1 / Rb;
Rs = Rb / log2(M);
Ns = Fe/Rs; %Nombre de points pour représenter un bit
Ts = Ns*Te; %Période du signal
Fs = 1/Ts; %Fréquence des bits du signal
Bits = [1;1;1;0;0;1;0];
N_bits = length(Bits);
symbol = 2*Bits-1;

dirac=zeros(Ns*N_bits,1);
dirac(1:Ns:end,1) = symbol;

h=ones(1,Ns);

x=filter(h,1,dirac);


Duree = length(Bits)/Rs; %Duree en secondes du signal
Ne = Ns*length(Bits); %Nombre de points échantillonés
Temps = 0:Duree/(Ne):Duree-1/Ne; %Echelle temporelle en secondes

%Avec canal de propagation 

hc = 0*h;
hc(1) = 1;
hc(Ns) = 0.5;
g = conv(h,h);
g = conv(g,hc);
N = length(g);

z = filter(hc,1,x);
z = filter(h,1,z);
n0 = Ns/2;
z_hantillonne = z(n0:Ns:end);
%plot(0:Ns/2:8*Ns,[0,Ns/2,0,3*Ns/4,0,3*Ns/4,0,-Ns/4,0,-3*Ns/4,0,Ns/4,0,-Ns/4,0,-Ns/4,0]);
N_z = length(z_hantillonne);

figure;
plot(0:Duree/N_z:Duree-Duree/N_z,z_hantillonne);
xlabel('Temps en secondes');
ylabel('Signal en sortie du filtre de réception de la chaine de transmition échantillonnée avec canal et sans égaliseur');


figure;
plot(reshape(z,Ns,length(z)/Ns));
xlabel('Temps en secondes');
ylabel('Diagramme de loeil sans bruit en sortie du filtre de réception ');

% Ajout de bruit 

vecteur_db_Eb_N0 = 0:10/100:10;
vecteur_Teb_avec_canal = zeros(101,1);
P_x = mean(abs(x).^2);
random  = randn(length(x),1);
for i = 1:101
    
    Sigma_carre = P_x * Ns /(2 * log2(M) * 10^(vecteur_db_Eb_N0(i)/10));
    bruit = sqrt(Sigma_carre) * random;
    
    x_bruite = x + bruit;
    
    z = filter(hc,1,x_bruite);
    z = filter(h,1,z);
    

    
    %plot(reshape(z,Ns,length(z)/Ns));
    %xlabel('Temps en secondes');
    %ylabel('Diagramme de loeil de la chaine de transmition avec canal ');

    z_hantillonne = z(n0:Ns:end);
    symboles = sign(z_hantillonne);
    Bits_renconstruits = (symboles+1)/2;
    
    difference = (Bits_renconstruits ~= Bits);
    vecteur_Teb_avec_canal(i) = sum(difference)/length(difference);
end 

%Comparaison entre Taux  d’erreur  binaire TEB simulé et théorique pour la chaine de transmition avec canal
figure
semilogy(vecteur_db_Eb_N0,vecteur_Teb_avec_canal);
xlabel('Rapport  signal à  bruit  Eb/N0 en db');
ylabel('Taux  d’erreur  binaire TEB pour la chaine de transmition avec canal');
hold on
vecteur_Teb_avec_canal_theorique = qfunc(sqrt(2*10.^(vecteur_db_Eb_N0/10)))/log2(M);
semilogy(vecteur_db_Eb_N0,vecteur_Teb_avec_canal_theorique);

legend('Taux  d’erreur  binaire TEB simulé pour la chaine de transmition avec canal','Taux  d’erreur  binaire TEB théorique pour la chaine de transmition avec canal');
title('Comparaison entre Taux  d’erreur  binaire TEB simulé et théorique pour la chaine de transmition avec canal et bruit');


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%La chaine de transmition sans canal

g = conv(h,h);
N = length(g);

z = filter(h,1,z);
N_z = length(z);



% Ajout de bruit 

vecteur_Teb_sans_canal = zeros(101,1);
for i = 1:101
    
    Sigma_carre = P_x * Ns /(2 * log2(M) * 10^(vecteur_db_Eb_N0(i)/10));
    bruit = sqrt(Sigma_carre) * random;
    
    x_bruite = x + bruit;
    
    z = filter(h,1,x_bruite);
    

    
    %plot(reshape(z,Ns,length(z)/Ns));
    %xlabel('Temps en secondes');
    %ylabel('Diagramme de loeil de la chaine de transmition sans canal ');

    
    z_hantillonne = z(n0:Ns:end);
    symboles = sign(z_hantillonne);
    Bits_renconstruits = (symboles+1)/2;
    
    difference = (Bits_renconstruits ~= Bits);
    vecteur_Teb_sans_canal(i) = sum(difference)/length(difference);
end 

%Comparaison entre Taux  d’erreur  binaire TEB simulé de la chaine de transmition sans canal et celui de la chaine de transmition avec canal
figure
semilogy(vecteur_db_Eb_N0,vecteur_Teb_sans_canal);
xlabel('Rapport  signal à  bruit  Eb/N0 en db');
ylabel('Taux  d’erreur  binaire TEB pour la chaine de transmition');
hold on
semilogy(vecteur_db_Eb_N0,vecteur_Teb_avec_canal);

legend('Taux  d’erreur  binaire TEB simulé pour la chaine de transmition sans canal','Taux  d’erreur  binaire TEB simulé pour la chaine de transmition avec canal');
title('Comparaison entre Taux  d’erreur  binaire TEB simulé de la chaine de transmition sans canal et celui de la chaine de transmition avec canal');

%%%%%%%%%%%%%%%%%%%%%%%%%%%
%Parametres du chaine de transmition avec canal et égaliseur




z = filter(hc,1,x);
z_avant = filter(h,1,z);
N_z_avant = length(z_avant);



%Egaliseur
N = N_bits-1;
K = N_bits;
Y0 = zeros(N+1,1);
Y0(1) = 1;
ligne = zeros(1,N+1);
ligne(1) = z_avant(n0);
Z = toeplitz(z_avant(n0:Ns:end),ligne);
C = Z\Y0;

%exemple de C
N_exemple = 6;
K_exemple = 7;
Y0_exemple = zeros(N_exemple+1,1);
Y0_exemple(1) = 1;
ligne_exemple = zeros(1,N_exemple+1);
ligne_exemple(1) = 3*Ns/4;
Z_exemple = toeplitz([3*Ns/4,3*Ns/4,-Ns/4,-3*Ns/4,Ns/4,-Ns/4,-Ns/4],ligne_exemple);
C_exemple = Z_exemple\Y0_exemple;

z_apres = filter(C,1,z_avant);

Sx_Hc = abs(fft(hc,length(hc)).^2);
figure;
semilogy(linspace(-Fe/2,Fe/2,length(Sx_Hc)),Sx_Hc,'g');
xlabel("Fréquence en Hz");
hold on;
Sx_egaliseur = abs(fft(C,length(C)).^2);
f= linspace(-Fe/2,Fe/2,length(Sx_egaliseur));

semilogy(f,Sx_egaliseur,'r');
hold on 
semilogy(f,Sx_egaliseur*Sx_Hc,'b');
legend('|Hc(f)| la réponse en fréquence du canal de propagation','|C(f)|  la réponse en fréquence de l’égaliseur ','|H(f)*C(f)| leur produit');

z_hantillonne = z_apres(n0:Ns:end);
N_z = length(z_hantillonne);

figure;
plot(0:Duree/N_z:Duree-Duree/N_z,z_hantillonne);
xlabel('Temps en secondes');
ylabel('Signal en sortie du filtre de réception de la chaine de transmition échantillonnée avec canal et égaliseur');

N_z_apres = length(z_apres);

figure;
plot(0:Duree/N_z_avant:Duree-Duree/N_z_avant,z_avant);
xlabel('Temps en secondes');
hold on 
plot(0:Duree/N_z_apres:Duree-Duree/N_z_apres,z_apres);
legend('Signal en sortie du filtre de réception de la chaine de transmition sans canal avant égalisation','Signal en sortie du filtre de réception de la chaine de transmition sans canal après égalisation');
title('Comparaison des constellations obtenues avant et après égalisation');



% Ajout de bruit 

vecteur_db_Eb_N0 = 0:10/100:10;
vecteur_Teb_avec_canal_egaliseur = zeros(101,1);
P_x = mean(abs(x).^2);
random  = randn(length(x),1);
for i = 1:101
    
    Sigma_carre = P_x * Ns /(2 * log2(M) * 10^(vecteur_db_Eb_N0(i)/10));
    bruit = sqrt(Sigma_carre) * random;
    
    x_bruite = x + bruit;
    
    z = filter(hc,1,x_bruite);
    z = filter(h,1,z);
    Z = toeplitz(z(n0:Ns:end));
    C = Z\Y0;
    z = filter(C,1,z);

    
    %plot(reshape(z,Ns,length(z)/Ns));
    %xlabel('Temps en secondes');
    %ylabel('Diagramme de loeil de la chaine de transmition avec canal et égaliseur');

    z_hantillonne = z(n0:Ns:end);
    symboles = sign(z_hantillonne);
    Bits_renconstruits = (symboles+1)/2;
    
    difference = (Bits_renconstruits ~= Bits);
    vecteur_Teb_avec_canal_egaliseur(i) = sum(difference)/length(difference);
end 

%Comparaison entre Taux  d’erreur  binaire TEB simulé de la chaine de transmition avec canal et égaliseur et le TEB de la chaine de transmition avec canal et sans égaliseur
figure
semilogy(vecteur_db_Eb_N0,vecteur_Teb_avec_canal);
xlabel('Rapport  signal à  bruit  Eb/N0 en db');
ylabel('Taux  d’erreur  binaire TEB pour la chaine de transmition avec canal et égaliseur');
hold on
semilogy(vecteur_db_Eb_N0,vecteur_Teb_avec_canal_egaliseur);

legend('Taux  d’erreur  binaire TEB simulé pour la chaine de transmition avec canal et sans égaliseur','Taux  d’erreur  binaire TEB simulé pour la chaine de transmition avec canal et  égaliseur');
title('Comparaison entre Taux  d’erreur  binaire TEB simulé de la chaine de transmition avec canal et égaliseur et le TEB de la chaine de transmition avec canal et sans égaliseur');


