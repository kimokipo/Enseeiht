#include "aux.h"
#include "omp.h"

int main(int argc, char **argv){
  long    t_start;
  double  time;
  int     i, j, n;
  Stack   stacks[ntypes];
  Request req;
  int     head;
    
  init(stacks);

  t_start=usecs();
  #pragma omp parallel 
  #pragma omp single
  for(i=0;i<1000000;i++){
    
    req = receive();
    
    /* printf("Received request %d\n",req.id); */
    if(req.type != -1) {
      
      /* process request and push result on stack */
      /* printf("Processing request %d\n",req.id); */
      #pragma omp task depend(out:stacks[req.type]) firstprivate(req)
      {
        stacks[req.type].results[++stacks[req.type].head] = process(&req);
      }

    } else {
      i = 1000000;
    }
    
  }

  time=(double)(usecs()-t_start)/1000000.0;
  printf("Finished. Execution time:%.2f \n",time);

  check(stacks);
  
  return 0;
}



// Sequential : 1.06 s
// Parallel : 0.30 s
// the time decrease 3 times, wich means that the parallelisation is correct.
