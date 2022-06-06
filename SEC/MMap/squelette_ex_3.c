#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <fcntl.h>
#include <errno.h>
#include <sys/wait.h>/* wait */
#include <sys/mman.h>
#include <sys/types.h>
char * base;
int taillepage;
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

void handler(int signal){
	if (signal == SIGSEGV){
		mprotect(base, taillepage, PROT_WRITE);
	}
}

int main(int argc,char *argv[]) {
	taillepage = sysconf(_SC_PAGESIZE);
	signal(SIGSEGV,handler);
	int desc = open (argv[1],O_RDONLY |O_RDWR | O_CREAT | O_TRUNC,0600);
	ftruncate(desc,taillepage);
	base = mmap(0, taillepage, PROT_NONE, MAP_SHARED, desc, 0);
		garnir(base,20,'d');
		printf("après ecrire 20  d dans la page\n");
		
		

}
