#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>
#include <string.h>
#include <math.h>
#include "aux.h"
#include "omp.h"

unsigned long sequential_sweep(struct node *head);
unsigned long parallel_for_sweep(struct node *head);
unsigned long parallel_task_sweep(struct node *head);


int main(int argc, char **argv){
  int n, i, s;
  long    t_start, t_end, save;
  int *x;
  unsigned long acc, result;
  struct node *head, *curr;
  
  init_list(&head);
  
  t_start = usecs();
  result = sequential_sweep(head);
  t_end = usecs();
  printf("Sequential      time    : %8.2f msec.",((double)t_end-t_start)/1000.0);
  printf("       -- result: %5ld\n",result);

  t_start = usecs();
  result = parallel_for_sweep(head);
  t_end = usecs();
  printf("Parallel for time       : %8.2f msec.",((double)t_end-t_start)/1000.0);
  printf("       -- result: %5ld\n",result);



  t_start = usecs();
  result = parallel_task_sweep(head);
  t_end = usecs();
  
  printf("Parallel task   time    : %8.2f msec.",((double)t_end-t_start)/1000.0);
  printf("       -- result: %5ld\n",result);
  
  
  return 0;
}


  

unsigned long sequential_sweep(struct node *head){

  unsigned long acc;
  struct node *curr;

  curr = head;
  acc = 0;
  while(curr){
    /* Loop until the last element in the list and accumulate the
       result of nodes processing */
    acc += process_node(curr);
    curr = curr->next;
  }

  return acc;
}
  



unsigned long parallel_for_sweep(struct node *head){
  unsigned long acc;
  struct node *curr;

  curr = head;
  acc = 0;
  int i;
  struct node *c;
#pragma omp parallel for private(c)
  for (i = 0; i < 1000000; i++) {
    /* Loop until the last element in the list and accumulate the
       result of nodes processing */
#pragma omp critical
      {
          if (curr) {
      c = curr;
      curr = curr->next;
          } else {
            c = -1;
            i=1000000;
          }
      }

      if (c != -1)
          {
#pragma omp atomic update
              acc += process_node(c); 
          }
  }

  return acc;
}






  
unsigned long parallel_task_sweep(struct node *head) {
  unsigned long acc;
  struct node *curr;

  curr = head;
  acc = 0;
#pragma omp parallel
{
#pragma omp single
    {
  while(curr){
#pragma omp task firstprivate(curr)
      {
    /* Loop until the last element in the list and accumulate the
       result of nodes processing */
#pragma omp atomic update
    acc += process_node(curr);
      }
    curr = curr->next;
  }
}
}

  return acc;
  
}
