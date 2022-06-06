 load('SG1.mat');
 I = reshape(Data,[size(Data,1)*size(Data,2),1]);
 J = reshape(DataMod,[size(DataMod,1)*size(DataMod,2),1]);
 A = [I ones(size(I))];
 X = pinv(A) * log(J);
 alpha = -X(1);
 betha = X(2);
ImMod = (betha -log(DataMod))/alpha;
 erreur = sum((Data - ImMod).^2)/size(Data,1);
 erreur = sum(erreur)/size(Data,2);
 
 
 [U,S,V] = svd([A log(J)]);
 X1 = -1/V(3,3)*V(:,3);
 alpha1 = -X1(1);
 betha1 = X1(2);
 
 ImMod1 = (betha1 -log(DataMod))/alpha1;
 erreur1 = sum((Data - ImMod1).^2)/size(Data,1);
 erreur1 = sum(erreur1)/size(Data,2);