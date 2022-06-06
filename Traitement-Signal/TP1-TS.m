Rx=xcorr(y,'unbiased')
N=2^nextpow2(length(Rx))
x2=[0:Fe/N:Fe-Fe/N]
S=abs(fft(Rx,2^nextpow2(length(Rx))))
semilogy(x2,S)
close all;
Fe=10000
Te=1/Fe
x=[0:Te:(100-1)Te];

y=cos(2*pi*1000*x)+cos(2*pi*3000*x);
figure;
plot(x,y);
xlabel('temps')
ylabel('Amplitude')


Fe2=1000
Te2=1/Fe2
x2=[0:Te2:(90-1)Te2];
y2=cos(2pix21100);

figure;
plot(x2,y2);
xlabel('temps')
ylabel('Amplitude')


y3=abs(fft(y2));
x3=[0:Fe2/90:Fe2-Fe2/90];
figure;
semilogy(x3,y3);
xlabel('frequence');
ylabel('norme log');


y4=abs(fft(y));
x4=[0:Fe/100:Fe-Fe/100];
figure;
semilogy(x4,y4);
xlabel('frequence');
ylabel('norme log');

N=512
Y=abs(fft(y,N));
x5=[0:Fe/N:Fe-Fe/N];
figure;
semilogy(x5,Y);
xlabel('frequence');
ylabel('norme log');

Rx=xcorr(y,'unbiased')
S=abs(fft(Rx,2^nextpow2(length(Rx))));

figure;
semilogy(x5,S);



x4=[-5*Fe/11:Fe/11:5*Fe/11];
x=[-49*Fe/100:Fe/100:49*Fe/100];
x5=[-30*Fe/61:Fe/61:30*Fe/61];
t=[0:Te:99*Te]
N1=[-5:5]
N2=[-30:30]
x6=0.4*sinc(pi*0.4*N1)
x7=0.4*sinc(pi*0.4*N2)
y6=abs(fft(x6))
y7=abs(fft(x7))
y=cos(2*pi*1000*t)+cos(2*pi*3000*t);
y4=abs(fft(y));
y8=filter(y7,1,y)
plot(t,y8);


semilogy(x,y4,'g');
hold on
semilogy(N1,y6,'r')

semilogy(N2,y7,'b')