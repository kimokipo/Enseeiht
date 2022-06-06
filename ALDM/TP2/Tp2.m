close all;
% load('ToyExample.mat');
% indicesToy = classification_spectrale(Data',2,0.6);
% 
% figure();
% plot(Data(:,1),Data(:,2),'*')
% indices1 = indicesToy == 1;
% indices2 = indicesToy == 2;
% 
% figure();
% plot(Data(indices1,1),Data(indices1,2),'*', col = "red")
% hold on
% plot(Data(indices2,1),Data(indices2,2),'*', col = "blue")

load('DataSagittale.mat');
% load('DataTransverse.mat');

DataTempsT=reshape(Image_DataT,64*54,20);
% DataTempsS=reshape(Image_DataS,64*54,20);

indicesTempsT = classification_spectrale(DataTempsT',5,0.42);
%indicesTempsS = classification_spectrale(DataTempsS',6,0.4275);

image_resultT = zeros(64,54);
for k=1:5
    indiceT = indicesTempsT == k;
    for i =1:64*54
        l = indiceT(i);
        if (l==1) 
            q = floor(i/64);
            r = i-q*64;
            if (q == 0) 
               image_resultT(i,1) = k;
            elseif(r ~=0)
               image_resultT(r,q+1) = k;
            elseif(r == 0)
               image_resultT(1,q) = k;
            end
        end
    end
end

% image_resultS = zeros(64,54);
% for k=1:5
%     indiceS = indicesTempsS == k
%     for i =1:64*54
%         l = indiceS(i);
%         if (l==1) 
%             q = floor(i/64);
%             r = i-q*64;
%             if (q == 0) 
%                image_resultS(i,1) = k;
%             elseif(r ~=0)
%                image_resultS(r,q+1) = k;
%             elseif(r == 0)
%                image_resultS(1,q) = k;
%             end
%         end
%     end
% end

figure()
image(image_resultT,'CDataMapping','scaled')
% figure()
% image(image_resultS,'CDataMapping','scaled')

figure()
image(Image_ROI_T,'CDataMapping','scaled')
% figure()
% image(Image_ROI_S,'CDataMapping','scaled')