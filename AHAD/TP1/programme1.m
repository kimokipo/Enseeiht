close all;
N = 1024;
n_e = 16;
J = log(N)/log(2);
x = linspace(0,1,N);
f = sqrt(abs(cos(2*pi*x)));
[c0,C,D] = decomposition_haar(f);
R = zeros(n_e);
E = zeros(n_e);
for e = -n_e:-1
    [C,r] = renconstruction(c0,D,10^(e));
    R(n_e+e+1) = r;
    E(n_e+e+1) = 10^(e);
end
[C,r] = renconstruction(c0,D,10^(-1));
disp(r);
figure;
plot(x,f);
xlabel("x");
ylabel("f = sqrt(abs(cos(2*pi*x)))");
hold on ;
plot(x,C);
figure;
plot(E,R);
xlabel("epsilon");
ylabel("R = N_epsilon / N");