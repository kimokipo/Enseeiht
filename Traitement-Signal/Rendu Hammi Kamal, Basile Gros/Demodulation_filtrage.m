close all
%Parametres du modem
Fe = 48000; %Fréquence d'échantillonage
Te = 1/Fe; %Période d'échantillonage
Debit = 300; %Débit du signal
Ns = Fe/Debit; %Nombre de points pour représenter un bit
Ts = Ns*Te; %Période du signal
Fs = 1/Ts; %Fréquence des bits du signal
load DonneesBinome1.mat
Duree = length(bits)/Debit; %Duree en secondes du signal
Ne = Ns*length(bits); %Nombre de points échantillonés
Temps = 0:Duree/(Ne):Duree-1/Ne; %Echelle temporelle en secondes

F0 = 1180;
F1 = 980;%Fréquence des cosinus de codage de 0 et 1

SNR=50; % Signal to noise ratio en dB

%Génération du signal NRZ
figure;

NRZ = kron(bits, ones(1,Ns));
plot(Temps,NRZ);
xlabel('Temps en secondes');
ylabel('signal NRZ');
title("Signal NRZ de l'information à envoyer");
%Génération de la densité spectrale de puissance de NRZ avec le périodogramme
periodogramme_NRZ = (1/length(NRZ))*abs(fft(NRZ,2^nextpow2(length(NRZ)))).^2;
figure;

semilogy(linspace(-Fe/2,Fe/2,length(periodogramme_NRZ)),fftshift(periodogramme_NRZ),'b');
xlabel('Fréquence en Hz');

hold on;

%Calcul théorique de la densité spectrale de puissance de NRZ 
SNRZ_theorique=1/4*Ts*(sinc(Ts*linspace(-Fe/2,Fe/2,length(periodogramme_NRZ))).^2);
SNRZ_theorique(length(SNRZ_theorique)/2) = SNRZ_theorique(length(SNRZ_theorique)/2) +1/4;
semilogy(linspace(-Fe/2,Fe/2,length(periodogramme_NRZ)),SNRZ_theorique,'r');
title('Comparaison entre densité spectrale de puissance du signal NRZ et sa valeur théorique');
legend('densité spectrale de puissance du signal NRZ','densité spectrale de puissance théorique du signal NRZ');

%Génération des cosinus
cos0 = cos(2*pi*F0*Temps + rand*2*pi);
cos1 = cos(2*pi*F1*Temps + rand*2*pi);

%Génération de x
x = (1-NRZ).*cos0 + NRZ.*cos1;
figure;

plot(Temps,x);

xlabel('Temps en secondes');
ylabel('signal modulé en fréquences');
title('Signal modulé en fréquences gràce au signal NRZ');
%Génération de la densité spectrale de puissance de x
periodogramme_modulation_frequence = (1/length(x))*abs(fft(x,length(x))).^2;
figure;
semilogy(linspace(-Fe/2,Fe/2,length(periodogramme_modulation_frequence)),fftshift(periodogramme_modulation_frequence));
xlabel("Fréquence en Hz");
hold on;

%Calcul théorique de la densité spectrale de puissance de x
f= linspace(-Fe/2,Fe/2,length(periodogramme_modulation_frequence));

SNRZ_F0plus= 1/4*Ts*(sinc(Ts*(f+F0)).^2);
%SNRZ_F0plus(length(f)/2)= SNRZ_F0plus(length(f)/2)+1/4;

SNRZ_F0moins= 1/4*Ts*(sinc(Ts*(f-F0)).^2);
%SNRZ_F0moins(length(f)/2)= SNRZ_F0moins(length(f)/2)+1/4;

SNRZ_F1plus= 1/4*Ts*(sinc(Ts*(f+F1)).^2);
%SNRZ_F1plus(length(f)/2)= SNRZ_F1plus(length(f)/2)+1/4;

SNRZ_F1moins= 1/4*Ts*(sinc(Ts*(f-F1)).^2);


Sx_theorique = 1/4*(SNRZ_F1plus+SNRZ_F1moins+SNRZ_F0plus+SNRZ_F0moins);
Sx_theorique(length(Sx_theorique)/2-length(Sx_theorique)*F0/Fe)= Sx_theorique(length(Sx_theorique)/2-length(Sx_theorique)*F0/Fe)+1/4;
Sx_theorique(length(Sx_theorique)/2+length(Sx_theorique)*F0/Fe)= Sx_theorique(length(Sx_theorique)/2+length(Sx_theorique)*F0/Fe)+1/4;
Sx_theorique(length(Sx_theorique)/2-length(Sx_theorique)*F1/Fe)= Sx_theorique(length(Sx_theorique)/2-length(Sx_theorique)*F1/Fe)+1/4;
Sx_theorique(length(Sx_theorique)/2+length(Sx_theorique)*F1/Fe)= Sx_theorique(length(Sx_theorique)/2+length(Sx_theorique)*F1/Fe)+1/4;
semilogy(f,Sx_theorique,'r');
legend('densité spectrale de puissance du signal x','densité spectrale de puissance théorique du signal x');
title('Comparaison entre densité spectrale de puissance du signal x et sa valeur théorique');

%Ajout du Bruit

Px=mean(abs(x).^2);
Sigma=sqrt(10^(-(SNR/10))*Px);
bruit=Sigma*randn(1,length(x));
xbruit=x+bruit;
figure;
plot(Temps,xbruit);
title("Signal Modulé en fréquence bruité avec un bruit blanc gaussien")
xlabel('Temps en secondes');
ylabel('signal modulé en fréquences avec le bruit');

%Démodulation par filtrage
ordre_filtre = 255;
fenetre_filtrage = -(ordre_filtre-1)/2:(ordre_filtre-1)/2;
Frequence_coupure = (F0+F1)/(2*Fe);

hIPB = 2*Frequence_coupure*sinc(2*Frequence_coupure*fenetre_filtrage);
hIPB_freq = ifft(hIPB);

hIPH= -2*Frequence_coupure*sinc(2*Frequence_coupure*fenetre_filtrage);
hIPH((ordre_filtre-1)/2+1)=hIPH((ordre_filtre-1)/2+1)+1;
hIPH_freq = ifft(hIPH);



%Calcul des densite spectrales du signal bruité et du filtre
periodogramme_filtre_bas = abs(fft(hIPB,2^nextpow2(length(hIPB))));
periodogramme_filtre_haut = abs(fft(hIPH,2^nextpow2(length(hIPH))));
periodogramme_xbruit = (1/length(xbruit))*abs(fft(xbruit,2^nextpow2(length(xbruit)))).^2;
figure;
semilogy(linspace(-Fe/2,Fe/2,length(periodogramme_xbruit)),fftshift(periodogramme_xbruit),'g');
hold on;
semilogy(linspace(-Fe/2,Fe/2,length(periodogramme_filtre_bas)),fftshift(periodogramme_filtre_bas),'r');
hold on 
semilogy(linspace(-Fe/2,Fe/2,length(periodogramme_filtre_haut)),fftshift(periodogramme_filtre_haut),'b');
xlabel("Fréquence en Hz");
ylabel("Densité spectrale de puissance");
legend("signal modulé en fréquence","réponse en frequence du filtre passe bas","réponse en frequence du filtre passe haut");
title("Superposition des réponses en fréquence des filtres et de la DSP du signl bruité")

figure;
subplot(2,1,1);
plot(fenetre_filtrage,hIPB);
xlabel('Temps en secondes');
ylabel('Réponse impulsionnelle');
subplot(2,1,2);
semilogy(linspace(-Fe/2,Fe/2,length(periodogramme_filtre_bas)),fftshift(periodogramme_filtre_bas),'r');
xlabel('frequence en Hz');
ylabel('Réponse frequencielle');
title("Réponses impulsionnelles et fréquencielles du filtre passe bas");

figure;
subplot(2,1,1);
plot(fenetre_filtrage,hIPH);
xlabel('Temps en secondes');
ylabel('Réponse impulsionnelle');
subplot(2,1,2);
semilogy(linspace(-Fe/2,Fe/2,length(periodogramme_filtre_haut)),fftshift(periodogramme_filtre_haut),'r');
xlabel('frequence en Hz');
ylabel('Réponse frequencielle');
title("Réponses impulsionnelles et fréquencielles du filtre passe haut");


%Signal en sortie de filtre
xbruit = [xbruit, zeros(1,(ordre_filtre -1)/2)]; %Retard de fin

y_bas=filter(hIPB,1,xbruit);
y_bas= y_bas((ordre_filtre -1)/2 +1 : end);

y_haut=filter(hIPH,1,xbruit);
y_haut= y_haut((ordre_filtre -1)/2 +1 : end);

figure;
plot(Temps,y_bas);
xlabel('Temps en secondes');
title('Réponse impulsionnelle du signal filtré par passe bas');

figure;
plot(Temps,y_haut);
xlabel('Temps en secondes');
title('Réponse impulsionnelle du signal filtré par passe haut');

%densité de puissance du signal en sortie du filtre
periodogramme_y_bas = (1/length(y_bas))*abs(fft(y_bas,2^nextpow2(length(y_bas)))).^2;
periodogramme_y_haut = (1/length(y_haut))*abs(fft(y_haut,2^nextpow2(length(y_haut)))).^2;

figure;
subplot(2,1,1);
semilogy(linspace(-Fe/2,Fe/2,length(periodogramme_y_bas)),fftshift(periodogramme_y_bas),'g');
xlabel("Fréquence en Hz");
ylabel("DSP du signal filtré par passe bas");
subplot(2,1,2);
semilogy(linspace(-Fe/2,Fe/2,length(periodogramme_y_haut)),fftshift(periodogramme_y_haut),'g');
xlabel("Fréquence en Hz");
ylabel("DSP du signal filtré par passe haut");
title("Densité spectrale de puissance des signaux filtrés");
%Reconstitution du signal final :
y = y_bas;

%Détection d'énergie
Energies=bits*0;


for i=1:(Ne/Ns) 
    X=y(1+(i-1)*Ns:i*Ns);
    s=0;
    for j=1:Ns 
        s=s+X(j)^2;
    end 
    Energies(i)=s;
end
K = (max(Energies)-min(Energies))/2;
Bits_Renconstruits = Energies>K;

%Tracer l'énergie calculée sur les différentes périodes Ts de signal
figure;
plot([1:Ne/Ns],Energies);
xlabel("Periodes de signal");
ylabel("Energie du signal");
title("Energie des différentes periodes du signal");

%Calcul de l'erreure binaire
erreur=0;
for i =1:(Ne/Ns)
    if bits(i)~=Bits_Renconstruits(i) 
        erreur=erreur+1;
    end
end
erreur = erreur/(Ne/Ns)
%pcode reconstitution_image;
%reconstitution_image(Bits_Renconstruits);
%which reconstitution_image;

