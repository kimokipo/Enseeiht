clear;
close all;

taille_ecran = get(0,'ScreenSize');
L = taille_ecran(3);
H = taille_ecran(4);

% Fenetre d'affichage :
figure('Name','Points situes au voisinage d''un cercle', ...
       'Position',[0.4*L,0.05*H,0.6*L,0.7*H]);
axis equal;
hold on;
set(gca,'FontSize',20);
hx = xlabel('$x$','FontSize',30);
set(hx,'Interpreter','Latex');
hy = ylabel('$y$','FontSize',30);
set(hy,'Interpreter','Latex');

% Bornes d'affichage des donnees centrees en (0,0) :
taille = 20;
bornes = [-taille taille -taille taille];

% Creation du cercle et des donnees bruitees :
n = 50;
sigma = 0.5;
[x_cercle,y_cercle,x_donnees_bruitees,y_donnees_bruitees,theta_donnees_bruitees] ...
		= creation_cercle_et_donnees_bruitees(taille,n,sigma);
teta1=2*pi*randn;
teta2=2*pi*randn;
if teta1<=teta2
    x=theta_donnees_bruitees<=teta2;
    y=teta1<=theta_donnees_bruitees;
    z=zeros(n,1);
    w=zeros(n,1);
else
    x=theta_donnees_bruitees<=teta2;
    y=0<=theta_donnees_bruitees;
    z=theta_donnees_bruitees<2*pi;
    w=teta1<=theta_donnees_bruitees;
end
r=x.*y+w.*z;
x_donnees_bruitees=r.*x_donnees_bruitees;
y_donnees_bruitees=r.*y_donnees_bruitees;
% Affichage du cercle :
plot(x_cercle([1:end 1]),y_cercle([1:end 1]),'r','LineWidth',3);

% Affichage des donnees bruitees :
plot(x_donnees_bruitees,y_donnees_bruitees,'k+','MarkerSize',10,'LineWidth',2);
axis(bornes);
lg = legend(' Cercle', ...
		' Donnees bruitees', ...
		'Location','Best');
grid on;
