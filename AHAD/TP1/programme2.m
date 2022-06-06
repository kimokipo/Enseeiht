A = read_image("cameraman.png");
%[c0,C,D]= decomposition_haar2([1,2;2,1]);
[Decomposition]= decomposition_haar2(A);


   figure(2)
   imshow(Decomposition)
   title('Decomposition')