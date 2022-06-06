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

F0 = 6000;
F1 = 2000;%Fréquence des cosinus de codage de 0 et 1

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
xlabel('Temps en secondes')
ylabel('signal modulé en fréquences')

%Génération de la densité spectrale de puissance de x
periodogramme_modulation_frequence = (1/length(x))*abs(fft(x,2^nextpow2(length(x)))).^2;
figure;
semilogy(linspace(-Fe/2,Fe/2,length(periodogramme_modulation_frequence)),fftshift(periodogramme_modulation_frequence));
xlabel("Fréquence en Hz");
ylabel("Densité spectrale de puissance du signal modulé en fréquences");


