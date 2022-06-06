#include "aux.h"
#include "omp.h"


int main(int argc, char **argv){
  long t_start, t_end;
  int  l, t, L, T,iam;
  Token token;
  
  if ( argc == 3 ) {
    L = atoi(argv[1]);    /* number of loops */
    T = atoi(argv[2]);    /* number of threads */
  } else {
    printf("Usage:\n\n ./main L T\n\nsuch that L is the number of loops and T the number of threads to use.\n");
    return 1;
  }

  int* processed_threads = (int *) malloc(T*sizeof(int));

  init(&token, L, T);

  #pragma omp parallel num_threads(T) private(l,iam)
  iam = omp_get_thread_num();
  for(l=0; l<L; l++){
    processed_threads[iam] = 0;
    printf("Loop %2d\n",l);
    if(iam == 0){
        process(&token);
        #pragma omp atomic update
        processed_threads[0]++;
    } else {
      while(processed_threads[iam-1] == 0){
      }
        process(&token);
        processed_threads[iam]++;
    }
    #pragma omp barrier

  }
  
  check(&token, L, T);

  
  return 0;
}
