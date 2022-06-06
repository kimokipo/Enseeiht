#include <stdio.h>    /* printf */
#include  <stdlib.h> 
#include <string.h>
#include  <unistd.h>/* fork */
#include  <sys/types.h>
#include <stdlib.h>   /* EXIT_SUCCESS */
#include  <sys/wait.h>/* wait */
int spawn (int ret , char buf[]){
		pid_t  pidFils;
		
	  	/* Duplique ce processus. */
	  	pidFils = fork ();
		if (pidFils != 0){
	     		/* Nous sommes dans le processus parent. */
			if (ret == EOF || strcmp(buf,"exit") == 0){
				printf("Salut\n");
				exit(1);
			}
	     		return pidFils;
	  	}else {
			char path[10] = "/bin/";
			printf(">>> Saisissez une commande !\n"); 
			ret = scanf ("%s", buf) ;   /* lit et  range  dans  buf la  chaine  entrée au  clavier */
			strcat(path, buf);
			execl(path,"",NULL);
	     		/* On ne sort de la fonction execvp uniquement si une erreur survient. */
     			perror("ECHEC");
			exit(1);
	  	}
}
int main(int argc,char *argv[]) {
  	while(1) {
		int codeTerm;
		int  ret = 0 ;
		char  buf [30] ;/*  contient  la  commande  saisie  au  clavier  */
		spawn(ret,buf);
 		/* Attend la fin du processus fils. */
  		wait (&codeTerm);
		if (codeTerm == 0){
			printf("SUCCES\n");
		}
	}
	return 0;
}

