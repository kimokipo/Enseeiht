#include <math.h>

/* This routine computes the 2-norm of a vector */
double norm2(int n, double *x){
  int i;
  double res;
  
  res = 0.0;
#pragma omp num_threads(2)
#pragma omp parallel for reduction(+:res) 
  for(i=0; i<n; i++)
    res += x[i]*x[i];

  res = sqrt(res);

  return res;

}


/* This routine computes the dot-product of two vectors */
double dot(int n, double *x, double *y){
  int i;
  double res;
  
  res = 0.0;
#pragma omp num_threads(2)
#pragma omp parallel for reduction(+:res) 
  for(i=0; i<n; i++)
    res += x[i]*y[i];

  return res;

}

/* This routine computes the product of a sparse matrix A of size m
   times a vector x and stores the result in a vector y :
   
   y = alpha*A*x + beta*y */
void spmv(int n, int *rowptr, int *colind, double *val, double alpha, double *x, double beta, double *y){

  int i, j;
 #pragma omp parallel for private(j)   num_threads(2) 
  for(i=0; i<n; i++){
    /* for each row... */
    y[i] = beta*y[i];
    for(j=rowptr[i]; j<rowptr[i+1]; j++){
       y[i] += alpha*val[j]*x[colind[j]];
      /* for each coefficient in the row... */
    }
  }

  return;
}

/* This routine computes the sum of two vectors x and y of size m and
   stores the result in y

   y = beta*y + alpha*x */
void axpby(int n, double alpha, double *x, double beta, double *y){

  int i;
  #pragma omp num_threads(2)
  #pragma omp parallel for schedule(dynamic,n/2)
  
  for(i=0; i<n; i++) {
  #pragma omp atomic write 
    y[i] = beta*y[i]+alpha*x[i];

  } 

}

