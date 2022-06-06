#include "aux.h"


void bottom_up(int nleaves, struct node **leaves, int nnodes);

int main(int argc, char **argv){
  long   t_start, t_end;
  int    nnodes, nleaves;
  struct node **leaves;

  // Command line argument: number of nodes in the tree
  if ( argc == 2 ) {
    nnodes = atoi(argv[1]); 
  } else {
    printf("Usage:\n\n ./main n\n\nwhere n is the number of nodes in the tree.\n");
    return 1;
  }

  printf("\nGenerating a tree with %d nodes\n\n",nnodes);
  generate_tree(nnodes, &leaves, &nleaves);
  
  t_start = usecs();
  bottom_up(nleaves, leaves, nnodes);
  t_end = usecs();
  
  printf("Parallel time : %8.2f msec.\n\n",((double)t_end-t_start)/1000.0);

  check_result();
  
}
  

/* You can change the number and type of arguments if needed.     */
/* Just don't forget to update the interface declaration above.   */
void bottom_up(int nleaves, struct node **leaves, int nnodes){

  /* Implement this routine */
  int i,j,v;
  int * visited;
  struct node * curr;
  visited = (int*) malloc(nnodes*sizeof(int));
  for(j=0;j<nnodes;j++)
  	visited[j] = 0;
  #pragma omp parralel for
  for(i=0;i<nleaves;i++){
      curr = leaves[i];
      while (curr){
        #pragma omp atomic capture
        v = visited[curr->id-1]++;
        if (v >0){
        	break;
        }else{
        	 process_node(curr);
        	curr = curr->parent;
        }
      }
  } 
}
    




