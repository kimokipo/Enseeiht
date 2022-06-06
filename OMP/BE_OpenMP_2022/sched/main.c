#include "aux.h"
#include "omp.h"

void loop1(int n){

  long   t_start, t_end;
  double time_it;
  int i;
  double * load_threads;



  #pragma omp parallel
  {
  #pragma omp single
  {
  load_threads = (double *) malloc(omp_get_num_threads()*sizeof(double));
  }
  load_threads[omp_get_thread_num()] = 0.0;
  #pragma omp for schedule(guided,3)
  for(i=0; i<n; i++){
    t_start=usecs();
    func1(i,n);
    time_it = (double)(usecs()-t_start);
    load_threads[omp_get_thread_num()]+=time_it;
    if(n<=20) printf("Iteration %6d  of loop 3 took %.2f usecs\n",i, time_it);
  }
  #pragma omp barrier 
  printf("load in loop 1 of Thread number : %d is : %.2f usecs\n",omp_get_thread_num(),load_threads[omp_get_thread_num()]);
  }
  


}


void loop2(int n){

  long   t_start, t_end;
  double time_it, load;
  int i;
  double * load_threads;

  #pragma omp parallel
  {
  #pragma omp single
  {
  load_threads = (double *) malloc(omp_get_num_threads()*sizeof(double));
  }
  load_threads[omp_get_thread_num()] = 0.0;
  #pragma omp for schedule(dynamic,(n/omp_get_num_threads()/2)+1)
  for(i=0; i<n; i++){
    t_start=usecs();
    func2(i,n);
    time_it = (double)(usecs()-t_start);
    load_threads[omp_get_thread_num()]+=time_it;
    if(n<=20) printf("Iteration %6d  of loop 3 took %.2f usecs\n",i, time_it);
  }
  #pragma omp barrier 
  printf("load in loop 2 of Thread number : %d is : %.2f usecs\n",omp_get_thread_num(),load_threads[omp_get_thread_num()]);
  }

}

void loop3(int n){

  long   t_start, t_end;
  double time_it, load;
  int i;

  double * load_threads;

  #pragma omp parallel
  {
  #pragma omp single
  {
  load_threads = (double *) malloc(omp_get_num_threads()*sizeof(double));
  }
  load_threads[omp_get_thread_num()] = 0.0;
  #pragma omp for schedule(static,n/omp_get_num_threads())
  for(i=0; i<n; i++){
    t_start=usecs();
    func3(i,n);
    time_it = (double)(usecs()-t_start);
    load_threads[omp_get_thread_num()]+=time_it;
    if(n<=20) printf("Iteration %6d  of loop 3 took %.2f usecs, Thread : %d \n",i, time_it, omp_get_thread_num());
  }
  #pragma omp barrier 
  printf("load in loop 3 of Thread number : %d is : %.2f usecs\n",omp_get_thread_num(),load_threads[omp_get_thread_num()]);
  }

}


int main(int argc, char **argv){
  int    i, j, n;

  // Command line argument
  if ( argc == 2 ) {
    n = atoi(argv[1]);    /* the number of loop iterations */
  } else {
    printf("Usage:\n\n ./main n \n\nwhere n is the number of iterations in the loops\n");
    return 1;
  }

  printf("\n");
  
  loop1(n);
  
  printf("\n");

  loop2(n);
  
  printf("\n");

  loop3(n);
  
  printf("\n");
  
  return 0;
}

// I choosed 
      // the schedule : guided for loop 1 due to results in case 2 Threads, which the schedule used is guided when obtaining this balance most close to 1 
      // the schedule : dynamic for loop 2 due to results in case 2 Threads, which the schedule used is dynamic when obtaining this balance most close to 1 
      // the schedule : static for loop 3 

// 1 Thread : for n = 20
      //loop 1 : total time : 2000007.00 usecs, balance = 1
      //loop 2 : total time : 2100012.00 usecs, balance = 1
      //loop 3 : total time : 2100012.00 usecs, balance = 1

// 2 Thread : for n = 20
      //loop 1 : Thread 0 : total time : 999960.00 usecs
      //         Thread 1 : total time : 900004.00 usecs,
      //         balance = 1.111061
      //loop 2 : Thread 0 : total time : 620577.00 usecs
      //         Thread 1 : total time : 689345.00 usecs,
      //         balance = 1.110813
      //loop 3 : Thread 0 : total time : 1069916.00 usecs
      //         Thread 1 : total time : 490020.00 usecs,
      //         balance = 2.183412

// 4 Thread : for n = 20
      //loop 1 : Thread 0 : total time : 489496.00 usecs
      //         Thread 1 : total time : 101315.00 usecs,
      //         Thread 2 : total time : 399710.00 usecs,
      //         Thread 3 : total time : 205662.00 usecs,
      //         balance = 4.83
      //loop 2 : Thread 0 : total time : 38255.00 usecs
      //         Thread 1 : total time : 343315.00 usecs,
      //         Thread 2 : total time : 330179.00  usecs,
      //         Thread 3 : total time : 151528.00 usecs,
      //         balance = 8.97
      //loop 3 : Thread 0 : total time : 417308.00 usecs
      //         Thread 1 : total time : 251393.00 usecs,
      //         Thread 2 : total time : 182522.00 usecs,
      //         Thread 3 : total time : 143576.00 usecs,
      //         balance = 2.90

