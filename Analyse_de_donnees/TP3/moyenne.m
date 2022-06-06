function [x] = moyenne(im);
im_single = single(im);
im_normalise = 1./max(1,im_single(:,:,1)+ im_single(:,:,2) + im_single(:,:,3)).*im_single;
R = im_normalise(:,:,1);
V = im_normalise(:,:,2);
r_bar = mean(mean(R));
v_bar = mean(mean(V));
x = [r_bar,v_bar];
end