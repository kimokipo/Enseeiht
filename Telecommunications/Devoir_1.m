%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%Parametres du modulateur1
close all;
Fe = 24000; %Fréquence d'échantillonage
Te = 1/Fe; %Période d'échantillonage
Rb = 6000; %Débit du signal
M = 2;     %Nombre de symbole
Tb = 1 / Rb;
Rs = Rb / log2(M);
Ns = Fe/Rs; %Nombre de points pour représenter un bit
Ts = Ns*Te; %Période du signal
Fs = 1/Ts; %Fréquence des bits du signal
Bits = randi(2,10000,1)-2;
Bits(Bits == 0) = 1;
dirac = zeros(Ns*10000,1);
dirac(1)=Bits(1);
for k=2:10000
    dirac(k+Ns-1) = Bits(k);
end
h=ones(1,Ns);
x=filter(h,1,dirac);
Duree = length(Bits)/Rs; %Duree en secondes du signal
Ne = Ns*length(Bits); %Nombre de points échantillonés
Temps = 0:Duree/(Ne):Duree-1/Ne; %Echelle temporelle en secondes

figure;
plot(Temps,x);
xlabel('Temps en secondes');
ylabel('signal x généré par le modulateur 1');

%Génération de la densité spectrale de puissance de x
periodogramme_modulation_frequence_1 = (1/length(x))*abs(fft(x,length(x))).^2;
figure;
semilogy(linspace(-Fe/2,Fe/2,length(periodogramme_modulation_frequence_1)),fftshift(periodogramme_modulation_frequence_1));
xlabel("Fréquence en Hz");

hold on;
%Calcul théorique de la densité spectrale de puissance de x
f= linspace(-Fe/2,Fe/2,length(periodogramme_modulation_frequence_1));
Sx_theorique_1 = Ts*(sinc(Ts*f)).^2;
semilogy(f,Sx_theorique_1,'r');
legend('densité spectrale de puissance du signal x généré par le modulateur 1 ','densité spectrale de puissance théorique du signal x généré par le modulateur 1');
title('Comparaison entre densité spectrale de puissance du signal x généré par le modulateur 1 et sa valeur théorique');


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%Parametres du modulateur2
Fe = 24000; %Fréquence d'échantillonage
Te = 1/Fe; %Période d'échantillonage
Rb = 6000; %Débit du signal
Tb = 1 / Rb;
M = 4;     %Nombre de symbole
Tb = 1 / Rb;
Rs = Rb / log2(M);
Ns = Fe/Rs; %Nombre de points pour représenter un bit
Ts = Ns*Te; %Période du signal
Fs = 1/Ts; %Fréquence des bits du signal
Bits = randi(2,10000,1)-2;
Bits = reshape(Bits,[5000,2]);
dirac1 = zeros(5000,1);
dirac1(Bits==[0 1])=-1;
dirac1(Bits==[1 0])=3;
dirac1(Bits==[1 1])=1;
dirac1(Bits==[0 0])=-3;

dirac = zeros(Ns*5000,1);
dirac(1)=dirac1(1);
for k=2:5000
    dirac(k+Ns-1) = dirac1(k);
end
h=ones(1,Ns);
x=filter(h,1,dirac);
Duree = length(Bits)/Rs; %Duree en secondes du signal
Ne = Ns*length(Bits); %Nombre de points échantillonés
Temps = 0:Duree/(Ne):Duree-Duree/Ne; %Echelle temporelle en secondes

figure;
plot(Temps,x);
xlabel('Temps en secondes');
ylabel('signal x généré par le modulateur 2');

%Génération de la densité spectrale de puissance de x
periodogramme_modulation_frequence_2 = (1/length(x))*abs(fft(x,length(x))).^2;
figure;
semilogy(linspace(-Fe/2,Fe/2,length(periodogramme_modulation_frequence_2)),fftshift(periodogramme_modulation_frequence_2));
xlabel("Fréquence en Hz");

hold on;

%Calcul théorique de la densité spectrale de puissance de x
f= linspace(-Fe/2,Fe/2,length(periodogramme_modulation_frequence_2));
Sx_theorique_2 = 5*Ts*(sinc(Ts*f)).^2;
semilogy(f,Sx_theorique_2,'r');
legend('densité spectrale de puissance du signal x généré par le modulateur 2','densité spectrale de puissance théorique du signal x généré par le modulateur 2');
title('Comparaison entre densité spectrale de puissance du signal x généré par le modulateur 2 et sa valeur théorique');

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%Parametres des modulateur3
Fe = 24000; %Fréquence d'échantillonage
Te = 1/Fe; %Période d'échantillonage
Rb = 6000; %Débit du signal
Tb = 1 / Rb;
M = 2;     %Nombre de symbole
Tb = 1 / Rb;
Rs = Rb / log2(M);
Ns = Fe/Rs; %Nombre de points pour représenter un bit
Ts = Ns*Te; %Période du signal
Fs = 1/Ts; %Fréquence des bits du signal
Bits = randi(2,10000,1)-2;
Bits(Bits == 0) = 1;
Maping = Bits;
dirac = zeros(Ns*10000,1);
dirac(1)=Bits(1);
for k=2:10000
dirac(k+Ns-1) = Bits(k);
end
h=ones(1,Ns);
h(Ns/2+1:end)=-1;
x=filter(h,1,dirac);
Duree = length(Bits)/Rs; %Duree en secondes du signal
Ne = Ns*length(Bits); %Nombre de points échantillonés
Temps = 0:Duree/(Ne):Duree-1/Ne; %Echelle temporelle en secondes

figure;
plot(Temps,x);
xlabel('Temps en secondes');
ylabel('signal x généré par le modulateur 3');

%Génération de la densité spectrale de puissance de x
periodogramme_modulation_frequence_3 = (1/length(x))*abs(fft(x,length(x))).^2;
figure;
semilogy(linspace(-Fe/2,Fe/2,length(periodogramme_modulation_frequence_3)),fftshift(periodogramme_modulation_frequence_3));
xlabel("Fréquence en Hz");
hold on;

%Calcul théorique de la densité spectrale de puissance de x
f= linspace(-Fe/2,Fe/2,length(periodogramme_modulation_frequence_3));
Sx_theorique_3 = Ts*(sinc(Ts/2*f).*sin(pi*Ts/2*f)).^2;
semilogy(f,Sx_theorique_3,'r');
legend('densité spectrale de puissance du signal x généré par le modulateur 3','densité spectrale de puissance théorique du signal x généré par le modulateur 3');
title('Comparaison entre densité spectrale de puissance du signal x généré par le modulateur 3 et sa valeur théorique');

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%Parametres des modulateur4
Fe = 24000; %Fréquence d'échantillonage
Te = 1/Fe; %Période d'échantillonage
Rb = 6000; %Débit du signal
Tb = 1 / Rb;
M = 2;     %Nombre de symbole
Tb = 1 / Rb;
Rs = Rb / log2(M);
Ns = Fe/Rs; %Nombre de points pour représenter un bit
Ts = Ns*Te; %Période du signal
Fs = 1/Ts; %Fréquence des bits du signal
Bits = randi(2,10000,1)-2;
Bits(Bits == 0) = 1;
Maping = Bits;
dirac = zeros(Ns*10000,1);
dirac(1)=Bits(1);
for k=2:10000
dirac(k+Ns-1) = Bits(k);
end
h=rcosdesign(0.5,8,Ns); 

x=filter(h,1,dirac);
Duree = length(Bits)/Rs; %Duree en secondes du signal
Ne = Ns*length(Bits); %Nombre de points échantillonés
Temps = 0:Duree/(Ne):Duree-1/Ne; %Echelle temporelle en secondes

figure;
plot(Temps,x);
xlabel('Temps en secondes');
ylabel('signal x généré par le modulateur 4');

%Génération de la densité spectrale de puissance de x
periodogramme_modulation_frequence_4 = (1/length(x))*abs(fft(x,length(x))).^2;
figure;
semilogy(linspace(-Fe/2,Fe/2,length(periodogramme_modulation_frequence_4)),fftshift(periodogramme_modulation_frequence_4));
xlabel("Fréquence en Hz");
hold on;

% Calcul théorique de la densité spectrale de puissance de x
f= linspace(-Fe/2,Fe/2,length(periodogramme_modulation_frequence_4));
Sx_theorique = 0.5*(1 + cos(pi*Ts/0.5*(abs(f)-(1-0.5)/2/Ts)));
Sx_theorique(length(Sx_theorique)/2-length(Sx_theorique)/4/Ns:length(Sx_theorique)/2+length(Sx_theorique)/4/Ns)=1;
Sx_theorique(length(Sx_theorique)/2+length(Sx_theorique)*3/4/Ns:end)=0;
Sx_theorique(1:length(Sx_theorique)/2-length(Sx_theorique)*3/4/Ns)=0;
semilogy(f,Sx_theorique,'r');
legend('densité spectrale de puissance du signal x généré par le modulateur 4','densité spectrale de puissance théorique du signal x généré par le modulateur 4');
title('Comparaison entre densité spectrale de puissance du signal x généré par le modulateur 4 et sa valeur théorique');

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% Tracage dans la meme figure les DSPs des signaux générés par les différents modulateurs
figure;
semilogy(linspace(-Fe/2,Fe/2,length(periodogramme_modulation_frequence_1)),fftshift(periodogramme_modulation_frequence_1));
xlabel("Fréquence en Hz");
hold on;
semilogy(linspace(-Fe/2,Fe/2,length(periodogramme_modulation_frequence_2)),fftshift(periodogramme_modulation_frequence_2));
semilogy(linspace(-Fe/2,Fe/2,length(periodogramme_modulation_frequence_3)),fftshift(periodogramme_modulation_frequence_3));
semilogy(linspace(-Fe/2,Fe/2,length(periodogramme_modulation_frequence_4)),fftshift(periodogramme_modulation_frequence_4));
legend('DSP de x généré par le modulateur_1','DSP de x généré par le modulateur_2','DSP de x généré par le modulateur_3','DSP de x généré par le modulateur_4');
title('Comparaison entre DSPs de x généré par les différents modulateurs' );

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%