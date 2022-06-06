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
	ftruncate(desc,3*taillepage);
	char * base = mmap(0, 3*taillepage, PROT_READ|PROT_WRITE, MAP_SHARED, desc, 0);
	garnir(base,20,'a');
	garnir(base +taillepage,20,'a');
	garnir(base +2*taillepage,20,'a');
	int pidfils = fork();
	if (pidfils == 0){
		base = mmap(0, 3*taillepage, PROT_READ|PROT_WRITE, MAP_PRIVATE, desc, 0);
		lister(base,10);
		sleep(4);
		lister(base,10);
		lister(base +taillepage,10);
		lister(base +2*taillepage,10);
		garnir(base+taillepage,20,'d');
		sleep(8);
		lister(base,10);
		lister(base +taillepage,10);
		lister(base +2*taillepage,10);
		exit(1);
	}else{
		sleep(1);
		garnir(base,20,'b');
		garnir(base+taillepage,20,'b');
		sleep(6);
		garnir(base+taillepage,20,'c');
		wait(&status);
	}
		

}
