function image_RVB = ecriture_RVB(image_originale)
    [H,L]=size (image_originale);
    image_RVB = zeros(H/2,L/2,3);
    image_RVB(:,:,1)= image_originale(1:2:end,2:2:end); 
    image_RVB(:,:,2)= (1/2)*(image_originale(1:2:end,1:2:end)+image_originale(2:2:end,2:2:end));
    image_RVB(:,:,3)= image_originale(2:2:end,1:2:end);
end 