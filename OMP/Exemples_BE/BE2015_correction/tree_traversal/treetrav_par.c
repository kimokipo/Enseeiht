#include "aux.h"

void treetrav_par(int n, int *data, int *left, int *right){
  int i, l, r;

  /* Loop over all the nodes. ATTENTION: nodes are number in
     post-order: all the nodes in a subtree are numbered consecutively
     and thus each node in the tree has a higher index than all of its
     descendants. This ensures that in the sequential loop below a
     node is always visited after its children */
  
#pragma omp parallel
  {  
#pragma omp single
    {
      for(i=0; i<n; i++){
        l = left[i];
        r = right[i];
        
#pragma omp task firstprivate(i,l,r) depend(out:data[i]) depend(in:data[left[i]], data[right[i]])
        {
          data[i] = process(data[l], data[r], i);
        }
      }
    }
  }
  
}
