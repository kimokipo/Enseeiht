#include <stdio.h>    /* printf */
#include  <stdlib.h>
#include <string.h>
#include  <unistd.h>/* fork */
#include <stdlib.h>   /* EXIT_SUCCESS */
#include  <sys/wait.h>/* wait */

int main(int argc,char *argv[]) {
  	while(1) {
		pid_t  pidFils , idFils;
		int  ret;
		int codeTerm;
		char  buf [30] ; /*  contient  la  commande  saisie  au  clavier  */
		char path[35] = "/bin/";
		printf(">>> Saisissez une commande !\n"); 
		ret = scanf ("%s", buf) ;   /* lit et  range  dans  buf la  chaine  entrée au  clavier */
		if (ret != EOF && strcmp(buf,"exit") != 0){
			pidFils = fork ();
			if (pidFils  ==  -1) {
				printf("Erreur fork\n");
				exit (1);
			}
			if (pidFils  == 0) {/* fils */
				strcat(path, buf);
				execl(path,"",NULL);
		     		/* On ne sort de la fonction execvp uniquement si une erreur survient. */
	     			perror("ECHEC");
				exit(1);
			}else {/* p`ere */
				idFils = wait(& codeTerm );
				if (idFils  ==  -1) {
					perror("wait ");
					exit (2);
				}
				if (codeTerm == 0) {
					printf("SUCCESS\n");
				}
			}
		} else{
			break;
		}
	}
	printf("Salut\n");
  	return EXIT_SUCCESS;
}

