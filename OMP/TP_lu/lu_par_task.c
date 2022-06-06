#include "trace.h"
#include "common.h"
#include <omp.h>


/* This routine performs the LU factorization of a square matrix by
   block-columns */

void lu_par_task(Matrix A, info_type info){

  int i, j;

  /* Initialize the tracing system */
  trace_init();
  
  #pragma omp parallel private(i)
  {

  for(i=0; i<info.NB; i++){
    #pragma omp single 
    {
    /* Do the Panel operation on column i */
    #pragma omp task depend (inout:A[i])
    {  
    panel(A[i], i, info);
    } 
    /* Parallelize this loop     */
    for(j=i+1; j<info.NB; j++){
      /* Update column j with respect to the result of panel(A, i) */
      #pragma omp task depend (in : A[i]) depend(inout:A[j])
      { 
      update(A[i], A[j], i, j, info);
      }  
    }
    } 
  }
  }
  
  /* This routine applies permutations resulting from numerical
     pivoting. It has to be executed sequentially. */
  backperm(A, info);
  
  /* Write the trace in file (ignore) */
  trace_dump("trace_par_task.svg");
  
  return;
  
}
