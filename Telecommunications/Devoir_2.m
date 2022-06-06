%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%Parametres du chaine de transmition 1
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
N_bits = 1000;
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
g = conv(h,h);
N = length(g);
figure;
plot(0:Duree/N:Duree-Duree/N,g);
xlabel('Temps en secondes');
ylabel('signal g généré sans canal par la chaine de transmition 1');


z = filter(h,1,x);


figure;
plot(reshape(z,Ns,length(z)/Ns));
xlabel('Temps en secondes');
ylabel('Diagramme de loeil sans canal de la chaine de transmition 1 ');

n0 = 3;
z_hantillonne = z(n0:Ns:end);
symboles = sign(z_hantillonne);
symboles = (symboles+1)/2;
Teb = 0;
for k = 1:N_bits
    if symboles(k) == Bits(k)
        Teb =Teb +1;
    end
end
Teb = Teb/N_bits;
Teb1_s = 1-Teb;

%Avec canal de propagation 

% BW1 = 4000
fc = 4000;
hc = (2*fc/Fe)*sinc(2*fc*[-(Ns-1)*Te/2 :Te: (Ns-1)*Te/2]);
g = conv(h,h);
periodogramme_modulation_frequence_1 = abs(fft(h,length(h)).^2);
figure;
semilogy(linspace(-Fe/2,Fe/2,length(periodogramme_modulation_frequence_1)),periodogramme_modulation_frequence_1);
xlabel("Fréquence en Hz");

hold on;

f= linspace(-Fe/2,Fe/2,length(periodogramme_modulation_frequence_1));
Sx_theorique_1 = abs(fft(hc));
semilogy(f,Sx_theorique_1,'r');
legend('|H(f)*Hr(f)| généré avec canal pour BW1 par la chaine de transmition 1 ','|Hc(f)| généré avec canal pour BW1 par la chaine de transmition 1 ');
title('|H(f)*Hr(f)| et |Hc(f)| généré avec canal pour BW1 par la chaine de transmition 1 ');

N = length(g);
figure;
plot(0:Duree/(N):Duree-Duree/N,g);
xlabel('Temps en secondes');
ylabel('signal g généré avec canal pour BW1 par la chaine de transmition 1');
x = filter(hc,1,x);
z = filter(h,1,x);
figure;
plot(reshape(z,Ns,length(z)/Ns));
xlabel('Temps en secondes');
ylabel('Diagramme de loeil avec canal pour BW1 de la chaine de transmition 1 ');

n0 = 3;
z_hantillonne = z(n0:Ns:end);
symboles = sign(z_hantillonne);
symboles = (symboles+1)/2;
Teb = 0;
for k = 1:N_bits
    if symboles(k) == Bits(k)
        Teb =Teb +1;
    end
end
Teb = Teb/N_bits;
Teb1_a1 = 1-Teb;

%BW2 = 1000

fc = 1000;
hc = (2*fc/Fe)*sinc(2*fc*[-(Ns-1)*Te/2 :Te: (Ns-1)*Te/2]);
g = conv(h,h);
periodogramme_modulation_frequence_1 = abs(fft(h,length(h)).^2);
figure;
semilogy(linspace(-Fe/2,Fe/2,length(periodogramme_modulation_frequence_1)),periodogramme_modulation_frequence_1);
xlabel("Fréquence en Hz");

hold on;

f= linspace(-Fe/2,Fe/2,length(periodogramme_modulation_frequence_1));
Sx_theorique_1 = abs(fft(hc));
semilogy(f,Sx_theorique_1,'r');
legend('|H(f)*Hr(f)| généré avec canal pour BW2 par la chaine de transmition 1 ','|Hc(f)| généré avec canal pour BW2 par la chaine de transmition 1 ');
title('|H(f)*Hr(f)| et |Hc(f)| généré avec canal pour BW2 par la chaine de transmition 1 ');

N = length(g);
figure;
plot(0:Duree/(N):Duree-Duree/N,g);
xlabel('Temps en secondes');
ylabel('signal g généré avec canal pour BW2 par la chaine de transmition 1');

x = [x;zeros(Ns/2,1)];
x = filter(hc,1,x);
x = x(Ns/2+1:end);

z = filter(h,1,x);
figure;
plot(reshape(z,Ns,length(z)/Ns));
xlabel('Temps en secondes');
ylabel('Diagramme de loeil avec canal pour BW2 de la chaine de transmition 1 ');

n0 = 3;
z_hantillonne = z(n0:Ns:end);
symboles = sign(z_hantillonne);
symboles = (symboles+1)/2;
Teb = 0;
for k = 1:N_bits
    if symboles(k) == Bits(k)
        Teb =Teb +1;
    end
end
Teb = Teb/N_bits;
Teb1_a2 = 1-Teb;

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%Parametres de la chaine de transmition 2
Fe = 24000; %Fréquence d'échantillonage
Te = 1/Fe; %Période d'échantillonage
Rb = 3000; %Débit du signal
Tb = 1 / Rb;
M = 2;     %Nombre de symbole
Tb = 1 / Rb;
Rs = Rb / log2(M);
Ns = Fe/Rs; %Nombre de points pour représenter un bit
Ts = Ns*Te; %Période du signal
Fs = 1/Ts; %Fréquence des bits du signal
N_bits = 1000;
Bits = randi([0,1],N_bits,1);
symbol = 2*Bits-1;

dirac=zeros(Ns*N_bits,1);
dirac(1:Ns:end,1) = symbol;
h=rcosdesign(0.5,1,Ns); 

x=filter(h,1,dirac);
Duree = length(Bits)/Rs; %Duree en secondes du signal
Ne = Ns*length(Bits); %Nombre de points échantillonés
Temps = 0:Duree/(Ne):Duree-1/Ne; %Echelle temporelle en secondes

%Sans canal de propagation 

hc = 0*h;
hc(1) = 1;
g = conv(h,h);
N = length(g);
figure;
plot(0:Duree/(N):Duree-Duree/N,g);
xlabel('Temps en secondes');
ylabel('signal g généré sans canal par la chaine de transmition 2');
z = filter(h,1,x);
figure;
plot(reshape(z,Ns,length(z)/Ns));
xlabel('Temps en secondes');
ylabel('Diagramme de loeil sans canal de la chaine de transmition 2 ');

n0 = 6;
z_hantillonne = z(n0:Ns:end);
symboles = sign(z_hantillonne);
symboles = (symboles+1)/2;
Teb = 0;
for k = 1:N_bits
    if symboles(k) == Bits(k)
        Teb =Teb +1;
    end
end
Teb = Teb/N_bits;
Teb2_s = 1-Teb;
%Avec canal de propagation 

% BW1 = 4000
fc = 4000;
hc = (2*fc/Fe)*sinc(2*fc*[-(Ns-1)*Te/2 :Te: (Ns-1)*Te/2]);
g = conv(h,h);
periodogramme_modulation_frequence_1 = abs(fft(h,length(h)).^2);
figure;
semilogy(linspace(-Fe/2,Fe/2,length(periodogramme_modulation_frequence_1)),periodogramme_modulation_frequence_1);
xlabel("Fréquence en Hz");

hold on;

f= linspace(-Fe/2,Fe/2,length(periodogramme_modulation_frequence_1)-1);
Sx_theorique_1 = abs(fft(hc));
semilogy(f,Sx_theorique_1,'r');
legend('|H(f)*Hr(f)| généré avec canal pour BW1 par la chaine de transmition 2 ','|Hc(f)| généré avec canal pour BW1 par la chaine de transmition 2 ');
title('|H(f)*Hr(f)| et |Hc(f)| généré avec canal pour BW1 par la chaine de transmition 2 ');

N = length(g);
figure;
plot(0:Duree/(N):Duree-Duree/N,g);
xlabel('Temps en secondes');
ylabel('signal g généré avec canal pour BW1 par la chaine de transmition 2');

x = [x;zeros(Ns/2,1)];
x = filter(hc,1,x);
x = x(Ns/2+1:end);

z = filter(h,1,x);

figure;
plot(reshape(z,Ns,length(z)/Ns));
xlabel('Temps en secondes');
ylabel('Diagramme de loeil avec canal pour BW1 de la chaine de transmition 2 ');

n0 = 6;
z_hantillonne = z(n0:Ns:end);
symboles = sign(z_hantillonne);
symboles = (symboles+1)/2;
Teb = 0;
for k = 1:N_bits
    if symboles(k) == Bits(k)
        Teb =Teb +1;
    end
end
Teb = Teb/N_bits;
Teb2_a1 = 1- Teb;

%BW2 = 1000

fc = 1000;
hc = (2*fc/Fe)*sinc(2*fc*[-(Ns-1)*Te/2 :Te: (Ns-1)*Te/2]);
g = conv(h,h);
periodogramme_modulation_frequence_1 = abs(fft(h,length(h)).^2);
figure;
semilogy(linspace(-Fe/2,Fe/2,length(periodogramme_modulation_frequence_1)),periodogramme_modulation_frequence_1);
xlabel("Fréquence en Hz");

hold on;

f= linspace(-Fe/2,Fe/2,length(periodogramme_modulation_frequence_1)-1);
Sx_theorique_1 = abs(fft(hc));
semilogy(f,Sx_theorique_1,'r');
legend('|H(f)*Hr(f)| généré avec canal pour BW1 par la chaine de transmition 2 ','|Hc(f)| généré avec canal pour BW2 par la chaine de transmition 2 ');
title('|H(f)*Hr(f)| et |Hc(f)| généré avec canal pour BW2 par la chaine de transmition 2 ');

N = length(g);
figure;
plot(0:Duree/(N):Duree-Duree/N,g);
xlabel('Temps en secondes');
ylabel('signal g généré avec canal pour BW2 par la chaine de transmition 2');

x = [x;zeros(Ns/2,1)];
x = filter(hc,1,x);
x = x(Ns/2+1:end);

z = filter(h,1,x);

figure;
plot(reshape(z,Ns,length(z)/Ns));
xlabel('Temps en secondes');
ylabel('Diagramme de loeil avec canal pour BW2 de la chaine de transmition 2 ');

n0 = 6;
z_hantillonne = z(n0:Ns:end);
symboles = sign(z_hantillonne);
Teb = 0;
for k = 1:N_bits
    if symboles(k) == Bits(k)
        Teb =Teb +1;
    end
end
Teb = Teb/N_bits;
Teb2_a2 = 1-Teb;
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
