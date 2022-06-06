
% Q = [2,0,0,0;0,4,0,0;0,0,7,0;0,0,0,5];
% R = chol(Q);
% I_bar = [.1;1.2;2.3;-0.6];

% chi = phi(round(I_bar),I_bar,Q);
% minimum = chi;
% sol = round(I_bar);
% g_3 = ceil(-sqrt(chi)/R(3,3) + I_bar(3));
% d_3 = floor(sqrt(chi)/R(3,3) + I_bar(3));
% for i_3=g_3:d_3
%     if (chi > (R(3,3)*(i_3-I_bar(3)))^2)
%         g_2 = ceil(-sqrt(chi-(R(3,3)*(i_3-I_bar(3)))^2)/R(2,2) + I_bar(2)-R(2,3)*(i_3-I_bar(3))/R(2,2));
%         d_2 = floor(sqrt(chi-(R(3,3)*(i_3-I_bar(3)))^2)/R(2,2) + I_bar(2)-R(2,3)*(i_3-I_bar(3))/R(2,2));
%         for i_2 = g_2:d_2
%             if (chi > (R(3,3)*(i_3-I_bar(3)))^2 + (R(2,2)*(i_2-I_bar(2))+R(2,3)*(i_3-I_bar(3)))^2)
%                 g_1 = ceil(-sqrt(chi-(R(3,3)*(i_3-I_bar(3)))^2-(R(2,2)*(i_2-I_bar(2))+R(2,3)*(i_3-I_bar(3)))^2)/R(1,1) + I_bar(1)-R(1,2)*(i_2-I_bar(2))/R(1,1)-R(1,3)*(i_3-I_bar(3))/R(1,1));
%                 d_1 = floor(sqrt(chi-(R(3,3)*(i_3-I_bar(3)))^2-(R(2,2)*(i_2-I_bar(2))+R(2,3)*(i_3-I_bar(3)))^2)/R(1,1) + I_bar(1)-R(1,2)*(i_2-I_bar(2))/R(1,1)-R(1,3)*(i_3-I_bar(3))/R(1,1));
%                 for i_1=g_1:d_1
%                     p = phi([i_1;i_2;i_3],I_bar,Q);
%                     sol = [i_1;i_2;i_3];
%                     if (minimum > p)
%                         minimum = p
%                     end
%                 end
%             end
%         end
%     end
% end
%
% 
% phi([0;1;0],I_bar,Q);
% phi([1;-1;1],I_bar,Q);

A = [100;200;300;400];
G = [1,1,1;2,2,4;3,4,5;1,0,1];
b = [-151.66;96.534;-253.27;-1202.7];
Z = [A,G];
Y = Z\b;
x_bar = Y(1);
I_bar = Y(2:end);
Q = G'*G-G'*A*inv(A'*A)*A'*G;
R = chol(Q);

% 
% Q = [2,2,2;2,4,5;2,5,7];
% R = chol(Q);
% I_bar = [.1;.2;.3];


chi = phi(round(I_bar),I_bar,Q);
[m,~] = size(R);
[minimum,sol] = MCLM(m,chi,R,round(I_bar),I_bar,Q,round(I_bar),chi);
I_bar;
sol;
x_sol = (A'*A)\(A'*b-A'*G*sol)


        