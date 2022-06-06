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
Periode_Integration = Te:Te:Ts;


F0 = 1180;
F1 = 980;%Fréquence des cosinus de codage de 0 et 1

%Génération du signal NRZ
NRZ = kron(bits, ones(1,Ns));


%Génération des cosinus
cos0 = cos(2*pi*F0*Temps);
cos1 = cos(2*pi*F1*Temps);

%Génération de x
x = (1-NRZ).*cos0 + NRZ.*cos1;


%Ajout du Bruit
SNR=50;
Px=mean(abs(x).^2);
Segma=sqrt(10^(-(SNR/10))*Px);
bruit=Segma*randn(1,length(x));
xbruit=x+bruit;
xbruit = x;



%Demodulation
x_compare = zeros(1,Ne/Ns);
x_cosF0 = xbruit .* cos(2*pi*F0*Temps);
x_cosF1 = xbruit .* cos(2*pi*F1*Temps);
for i = Ns:Ns:Ne
%Création du produit scalaire à la fréquence F0

x_scal_cosF0 = trapz(Periode_Integration, x_cosF0(i-Ns+1:i)); %Integration d'une matrice

%Création du produit scalaire à la fréquence F1

x_scal_cosF1 = trapz(Periode_Integration, x_cosF1(i-Ns+1:i)); %Integration d'une matrice

%Comparaison
x_compare(i/Ns) = x_scal_cosF1 - x_scal_cosF0;
end

%Retour en bits
x_demodule = x_compare > 0;

%Calcul de l'erreure binaire
erreur=0;
for i =1:(Ne/Ns)
    if bits(i)~=x_demodule(i) 
        erreur=erreur+1;
    end
end
erreur=erreur/(Ne/Ns)