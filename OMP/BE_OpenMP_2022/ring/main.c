#include "aux.h"
#include "omp.h"


int main(int argc, char **argv){
  long t_start, t_end;
  int  l, t, L, T,iam,j,tour;
  Token token;
  
  if ( argc == 3 ) {
    L = atoi(argv[1]);    /* number of loops */
    T = atoi(argv[2]);    /* number of threads */
  } else {
    printf("Usage:\n\n ./main L T\n\nsuch that L is the number of loops and T the number of threads to use.\n");
    return 1;
  }

  tour = 0;

  init(&token, L, T);

  #pragma omp parallel num_threads(T) private(l,iam,j)
  for(l=0; l<L; l++){
    iam = omp_get_thread_num();
    printf("Loop %2d\n",l);
    #pragma omp critical
    {
      if(iam == tour){
        process(&token);
        #pragma omp atomic update
        tour++;
      }
    }
    #pragma omp barrier
    #pragma omp single
    tour = 0;

  }
  
  check(&token, L, T);

  
  return 0;
}
