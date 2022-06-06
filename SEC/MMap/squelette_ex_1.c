#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <fcntl.h>
#include <errno.h>
#include <sys/wait.h>/* wait */
#include <sys/mman.h>
#include <sys/types.h>

void garnir(char zone[], int lg, char motif) {
	int ind;
	for (ind=0; ind<lg; ind++) {
		zone[ind] = motif ;
	}
}

void lister(char zone[], int lg) {
	int ind;
	for (ind=0; ind<lg; ind++) {
		printf("%c",zone[ind]);
	}
	printf("\n");
}

int main(int argc,char *argv[]) {
	int status;
	int taillepage = sysconf(_SC_PAGESIZE);
	int desc = open (argv[1],O_RDONLY |O_RDWR | O_CREAT | O_TRUNC,0600);
	ftruncate(desc,2*taillepage);
	char * base = mmap(0, 2*taillepage, PROT_READ|PROT_WRITE, MAP_SHARED, desc, 0);
	garnir(base,20,'a');
	garnir(base +taillepage,20,'a');
	int pidfils = fork();
	if (pidfils == 0){
		sleep(2);
		lister(base,10);
		lister(base +taillepage,10);
		garnir(base,20,'c');
	}else{
		garnir(base+taillepage,20,'b');
		wait(&status);
		lister(base,10);
	}
		

}
