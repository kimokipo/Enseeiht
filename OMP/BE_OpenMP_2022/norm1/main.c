#include "aux.h"
#include "omp.h"

double norm1(double **A, int m, int n);
double norm1_colmajor(double **A, int m, int n);
double norm1_rowmajor(double **A, int m, int n);


int main(int argc, char **argv){
  long   t_start, t_end;
  int    m, n, i, j;
  double nrm, nrmrm, nrmcm;
  double **A;

  // Command line argument: matrix size
  if ( argc == 3 ) {
    m = atoi(argv[1]);    /* the number of matrix rows */
    n = atoi(argv[2]);    /* the number of matrix cols */
  } else {
    printf("Usage:\n\n ./main n m\n\nwhere m and n are the number of rows and cols in the matrix\n");
    return 1;
  }

  A = (double**)malloc(m*sizeof(double*));
  for(i=0; i<m; i++) {
    A[i] = (double*)malloc(n*sizeof(double));
    
    for(j=0; j<n; j++) {
      A[i][j] = ((double)rand() / (double)RAND_MAX);
    }
  }

  /* warm up */
  nrm=norm1(A, m, n);
  

  t_start=usecs();
  nrm=norm1(A, m, n);
  t_end=usecs()-t_start;
  printf("Sequential  --  norm:%8.4f   time (usecs):%6ld\n",nrm,t_end);

  t_start=usecs();
  nrmcm=norm1_colmajor(A, m, n);
  t_end=usecs()-t_start;
  printf("Col-major   --  norm:%8.4f   time (usecs):%6ld\n",nrmcm,t_end);

  t_start=usecs();
  nrmrm=norm1_rowmajor(A, m, n);
  t_end=usecs()-t_start;
  printf("Row-major   --  norm:%8.4f   time (usecs):%6ld\n",nrmrm,t_end);

  
  
  
  printf("\n");
  

  return 0;
}


double norm1(double **A, int m, int n){
  int i, j;
  double nrm, tmp;
  nrm = 0.0;
  
  for(j=0; j<n; j++) {
    tmp = 0.0;
    for(i=0; i<m; i++) {
      tmp += fabs(A[i][j]);
    }
    if(tmp>nrm)
      nrm = tmp;
  }

  return nrm;

}




double norm1_colmajor(double **A, int m, int n){
  int i, j;
  double nrm, tmp;
  nrm = 0.0;
  #pragma omp parallel for private(i,tmp)
  for(j=0; j<n; j++) {
    tmp = 0.0;
    for(i=0; i<m; i++) {
      tmp += fabs(A[i][j]);
    }
    if(tmp>nrm)
    #pragma omp atomic write   
      nrm = tmp;
  }

  return nrm;

}






double norm1_rowmajor(double **A, int m, int n){
  int i, j;
  double nrm, *tmp;
  
  nrm = 0.0;
  tmp = (double*)malloc(n*sizeof(double));
  for(j=0; j<n; j++) 
    tmp[j]=0.0;
  
  #pragma omp parallel for private(j)
  for(i=0; i<m; i++) {
    for(j=0; j<n; j++) {
      #pragma omp atomic update 
      tmp[j] += fabs(A[i][j]);
    }
  }
  
  for(j=0; j<n; j++) 
    if(tmp[j]>nrm)
      nrm = tmp[j];
  
  free(tmp);
  
  return nrm;
  
}

        // 1 Thread :   for n = 4000 et m = 5000
         //           Sequential  --  norm:2065.0840   time (usecs):125528
           //         Col-major   --  norm:2065.0840   time (usecs):128608
             //       Row-major   --  norm:2065.0840   time (usecs):112764



        // 2 Thread :  for n = 4000 et m = 50000 (10*n < m)
      //              Sequential  --  norm:2073.5975   time (usecs):1831339
        //            Col-major   --  norm:2073.5975   time (usecs):1022943
          //          Row-major   --  norm:2073.5975   time (usecs):581470      

           //          for n = 40000 et m = 5000 (10*m < n)
         //           Sequential  --  norm:20208.4054   time (usecs):2387682
           //         Col-major   --  norm:20208.4054   time (usecs):1207574
             //       Row-major   --  norm:20208.4054   time (usecs):719675  




        // 4 Thread :  for n = 4000 et m = 50000 (10*n < m)
         //           Sequential  --  norm:2073.5975   time (usecs):2107107
           //         Col-major   --  norm:2073.5975   time (usecs):774860
             //       Row-major   --  norm:2073.5975   time (usecs):337545

           //          for n = 40000 et m = 5000 (10*m < n)
          //          Sequential  --  norm:20208.4054   time (usecs):2193660
            //        Col-major   --  norm:20208.4054   time (usecs):802108
              //      Row-major   --  norm:20208.4054   time (usecs):465671
             

        // based on the last executions with 2 Threads and 4 Threads, we note that the Row-major is more fastest 2 times approximately than Col-major
        //       in the two cases (10*n <m or 10*m < n)



