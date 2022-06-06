import java.util.*;
% then use following commands to deal with stack
A = Stack();
A.push(1); % inserts 1 on top of stack A
%A.pop(); %
A.get(0);
B = Stack();
B.push(A);

[status,result] = dos('node test_getTable.js Analyse_posts_groupe Post');
X = str2num(result);
close all;
figure;
plot3(X(1:end,1),X(1:end,2),X(1:end,3),'*');
xlabel('Likes');
ylabel('Comments');
zlabel('Shares');

n = size(X,1);
m = size(X,2);
%Trier

[Y, indices] = sort(X,'descend');

pre_rangs = zeros(n,1);

for j=1:n
    for i=1:m
        [ligne,col] = find(indices(1:end,i) == j);
        pre_rangs(j,1) = pre_rangs(j,1) + ligne;
    end
end
pre_rangs = pre_rangs/m;

[~, rangs] = sort(pre_rangs,'ascend');

%% ACP Algoritm
X_moyen = ones(n,1)*(ones(1,n)*X/n);

% Centrage de la matrice Reactions :
X_centre = X - X_moyen;

% Calcul de la matrice de covariance :
Sigma = transpose(X_centre)*X_centre/n;
 
[V,D] =eig(Sigma);

[lambda, ind] = sort(diag(D),'descend');

W = V(:, ind);

C = X*W(1);
distances = zeros(n,n);

for i= 1:n
    for j=1:n
         distances(i,j) = abs(C(i)-C(j));
    end
end

moyenne = zeros(n*(n-1)/2,1);
for i= 1:n
    for j=i+1:n
         moyenne(j-i+n*(i-1)-(i-1)*i/2) = distances(i,j);
    end
end

epsilon = mean(moyenne);
pre_segmentation = Stack();
liste = 1:n;
for i= 1:n
    classe  = Stack();
    for j=i:n
         if liste(j)~= 0 
             if distances(i,liste(j)) < epsilon
                  classe.push(liste(j));
                  liste(j) = 0;
             end
         end
    end
    if classe.size ~= 0
        pre_segmentation.push(classe);
    end
end

 scores = Stack();
 for i=0:pre_segmentation.size-1
          classe = pre_segmentation.get(i);
          moyennes = zeros (m,1);
         for j=0:classe.size-1
                 for k=1:m
                     moyennes(k) = moyennes(k) + X(classe.get(j),k);
                 end
         end
          for k=1:m
                     moyennes(k) = moyennes(k) / classe.size;
          end
          moyenne = Stack();
          for k=1:m
                     moyenne.push(moyennes(k));
          end
          scores.push(moyenne);
 end
 
figure;
for i=0:pre_segmentation.size-1
    longueur_segment = pre_segmentation.get(i).size;
    segment = zeros(longueur_segment,1);
    for j=0:longueur_segment-1
        segment(j+1) = pre_segmentation.get(i).get(j);
    end
    plot3(X(segment,1),X(segment,2),X(segment,3),'*');
    hold on;
end
xlabel('Likes');
ylabel('Comments');
zlabel('Shares');
 
%% K-means Algoritm
k = pre_segmentation.size;
epsilon_k_means = 10^(-4);
centres_gravites = zeros(k,3);
for i=0:k-1
    centres_gravites(i+1,1:end) = X(pre_segmentation.get(i).get(0),1:end);
end
while(true)
    segmentations = Stack();
    segments = Stack();
    for i=1:k
        classe = Stack();
        segment = Stack();
        point = Stack();
        for j=1:3
            point.push(centres_gravites(i,j));
        end
        segment.push(point);
        segments.push(segment);
        segmentations.push(classe);
    end
    
    for i=1:n
        distances = zeros(k,1);
        for j=1:k
            point = X(i,1:end);
            centre = centres_gravites(j,1:end);
            distances(j) = sqrt((point(1)-centre(1))^2+(point(2)-centre(2))^2+(point(3)-centre(3))^2);
        end
        [~,indice] = min(distances);
        point = Stack();
        for j=1:3
            point.push(X(i,j));
        end
        segments.get(indice-1).push(point);
        segmentations.get(indice-1).push(i);
    end
    moyennes = zeros(k,m);
    for i=0:k-1
        points = zeros(segments.get(i).size-1,3);
        for j=1:segments.get(i).size-1
            for l=1:3
                points(j,l) = segments.get(i).get(j).get(l-1);
            end
        end
        for j=1:segments.get(i).size-1
            moyennes(i+1,1:end) = mean(points);
        end
    end
    distances_entre_centres = zeros(k,1);
    for i=1:k
         centre_avant = centres_gravites(i,1:end);
         centre_apres = moyennes(i,1:end);
         distances_entre_centres(i) = sqrt((centre_avant(1)-centre_apres(1))^2+(centre_avant(2)-centre_apres(2))^2+(centre_avant(3)-centre_apres(3))^2);
    end
    if (mean(distances_entre_centres) < epsilon_k_means )
        break;
    else
        centres_gravites(1:end,1:end) = moyennes(1:end,1:end);
    end
end
    
figure;
for i=0:segments.size-1
    longueur_segment = segments.get(i).size;
    points = zeros(longueur_segment,3);
    for j=0:longueur_segment-1
        for l=1:3
            points(j+1,l) = segments.get(i).get(j).get(l-1);
        end
    end
    plot3(points(1:end,1),points(1:end,2),points(1:end,3));
    hold on;
end
xlabel('Likes');
ylabel('Comments');
zlabel('Shares');
