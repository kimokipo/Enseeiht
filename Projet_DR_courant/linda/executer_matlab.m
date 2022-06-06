close all;
L = 100;
R = 16;
T = 4;
W = 8;
[status,result1] = dos("cd Projet_DR_courant && java executer_test "+L+" "+R+" "+T+" "+W);

X_courant = str2num(result1);

[status,result2] = dos("cd Projet_DR_ancien && java executer_test "+L+" "+R+" "+T+" "+W);

X_ancien = str2num(result2);

figure();
plot(1:L,X_ancien,'r')
xlabel("L : nbr de lectures")
ylabel("temps mis en ms")
hold on
plot(1:L,X_courant,'b')
legend("linda ancienne sans cache","linda courante avec cache")

