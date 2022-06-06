%Parametres du modem
Fe = 48000; %Fréquence d'échantillonage
Te = 1/Fe; %Période d'échantillonage
Debit = 300; %Débit du signal
Ns = Fe/Debit; %Nombre de points pour représenter un bit
Ts = Ns*Te; %Période du signal
Fs = 1/Ts; %Fréquence des bits du signal
Duree = 5; %Duree en secondes du signal
bits = randi([0 1], 1,Duree*Debit); %Signal à moduler
Ne = Fe*Duree; %Nombre de points échantillonés
Temps = 0:Duree/(Ne):Duree-1/Ne; %Echelle temporelle en secondes

F0 = 1180;
F1 = 980;%Fréquence des cosinus de codage de 0 et 1

%Génération du signal NRZ
figure;
title("Signal NRZ de l'information à envoyer");
NRZ = kron(bits, ones(1,Ns));
plot(Temps,NRZ);
xlabel('Temps en secondes');
ylabel('signal NRZ');

%Génération de la densité spectrale de puissance de NRZ avec le périodogramme
periodogramme_NRZ = (1/length(NRZ))*abs(fft(NRZ,2^nextpow2(length(NRZ)))).^2;
figure;
semilogy(linspace(-Fe/2,Fe/2,length(periodogramme_NRZ)),fftshift(periodogramme_NRZ),'b');
xlabel('Fréquence en Hz');
ylabel('densité spectrale de puissance du signal NRZ');


%Génération des cosinus
cos0 = cos(2*pi*F0*Temps + rand*2*pi);
cos1 = cos(2*pi*F1*Temps + rand*2*pi);

%Génération de x
x = (1-NRZ).*cos0 + NRZ.*cos1;
figure;
plot(Temps,x);

xlabel('Temps en secondes');
ylabel('signal modulé en fréquences');

%Génération de la densité spectrale de puissance de x
periodogramme_modulation_frequence = (1/length(x))*abs(fft(x,2^nextpow2(length(x)))).^2;
figure;
semilogy(linspace(-Fe/2,Fe/2,length(periodogramme_modulation_frequence)),fftshift(periodogramme_modulation_frequence));
xlabel("Fréquence en Hz");
ylabel("Densité spectrale de puissance du signal modulé en fréquences");

%Ajout du Bruit
SNR=50;
Px=mean(abs(x).^2);
Segma=sqrt(10^(-(SNR/10))*Px);
bruit=Segma*randn(1,length(x));
xbruit=x+bruit;
figure;
plot(Temps,xbruit);
xlabel('Temps en secondes');
ylabel('signal modulé en fréquences avec le bruit');

%Démodulation par filtrage
ordre_filtre = 255;
fenetre_filtrage = -(ordre_filtre-1)/2:(ordre_filtre-1)/2;
Frequence_coupure = (F0+F1)/(2*Fe);
hIPB = 2*Frequence_coupure*sinc(2*Frequence_coupure*fenetre_filtrage);
hIPH= -2*Frequence_coupure*sinc(2*Frequence_coupure*fenetre_filtrage);
hIPH(1)=1;
hI= hIPB + hIPH;
figure;
plot(fenetre_filtrage,hIPB);
xlabel('Temps en secondes');
ylabel('Réponse impulsionnelle du filtre');

%Calcul des densite spectrales du signal bruité et du filtre
periodogramme_filtre = abs(fft(hI,2^nextpow2(length(hI))));
periodogramme_xbruit = (1/length(xbruit))*abs(fft(xbruit,2^nextpow2(length(xbruit)))).^2;
figure;
semilogy(linspace(-Fe/2,Fe/2,length(periodogramme_xbruit)),fftshift(periodogramme_xbruit),'g');
hold on;
semilogy(linspace(-Fe/2,Fe/2,length(periodogramme_filtre)),fftshift(periodogramme_filtre),'r');
xlabel("Fréquence en Hz");
ylabel("Densité spectrale de puissance");
legend("signal modulé en fréquence","réponse en frequence du filtre")

%Signal en sortie de filtre
xbruit = [xbruit, zeros(1,(ordre_filtre -1)/2)]; %Retard de fin
y=filter(hIPB,1,xbruit);
y = y((ordre_filtre -1)/2 +1 : end);
figure;
plot(Temps,y);
xlabel('Temps en secondes');
ylabel('Réponse impulsionnelle du signal filtré');

%densité de puissance du signalen sortie du filtre
periodogramme_y = (1/length(y))*abs(fft(y,2^nextpow2(length(y)))).^2;
figure;
semilogy(linspace(-Fe/2,Fe/2,length(periodogramme_y)),fftshift(periodogramme_y),'g');
xlabel("Fréquence en Hz");
ylabel("Densité spectrale de puissance du signal filtré");

%Détection d'énergie
Energies=zeros(Ne/Ns,1);
Bits_Renconstruits=zeros(Ne/Ns);

for i=1:(Ne/Ns) 
    X=y(1+(i-1)*Ns:i*Ns);
    s=0;
    for j=1:Ns 
        s=s+X(j)^2;
    end 
    Energies(i)=s;
end
K = (max(Energies)-min(Energies))/2
Bits_Renconstruits = Energies>K;

%Tracer l'énergie calculée sur les différentes périodes Ts de signal
figure;
plot([1:Ne/Ns],Energies);
xlabel("Periodes de signal");
ylabel("Energie du signal");

%Calcul de l'erreure binaire
erreur=0;
for i =1:(Ne/Ns)
    if bits(i)~=Bits_Renconstruits(i) 
        erreur=erreur+1;
    end
end
erreur=erreur/(Ne/Ns)