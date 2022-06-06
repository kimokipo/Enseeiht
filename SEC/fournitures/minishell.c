#include <stdio.h>    /* printf */
#include <string.h>
#include <unistd.h>/* fork */
#include <stdlib.h>   /* EXIT_SUCCESS */
#include <sys/wait.h>/* wait */
#include "readcmd.h"
#include <fcntl.h>
#define Nb_procs 10

struct cmdline * commande;

struct liste_pids
{
    pid_t pid;
    int etat; //etat = 0 -> terminé, etat = 1 -> suspendu, etat = 2 -> actif 
    char commande_lancee[Nb_procs];
};

typedef struct liste_pids liste_pids ;
liste_pids tableau_pids[Nb_procs];
int Tableau_Tubes[Nb_procs-1][2];
pid_t pidFils1, proc_avant_plan , id_command_finale;
int idFils1 = 0;
int longueur,i,id, retour;
int p[2];
int p_precedent[2];

sigset_t *ens = NULL;
	    
void ajouter_pid (int id, pid_t pid, int etat, char * commande_lancee){
	tableau_pids[id-1].pid =pid;
	tableau_pids[id-1].etat = etat;
	strcpy(tableau_pids[id-1].commande_lancee, commande_lancee);
}


void changer_etat (int id, int nouveletat){
	tableau_pids[id-1].etat = nouveletat;
}

int get_id (pid_t pid){
	int id = -1;
	for (int i=0 ;i<Nb_procs;i++){
		if(tableau_pids[i].pid == pid){
			id = i+1;
		}
	}
	return id;
}

void handler_chld(int signal_num) {
    int fils_termine, wstatus ;
     if (signal_num == SIGCHLD) {
        while ((fils_termine = (int) waitpid(-1, &wstatus, WNOHANG | WUNTRACED | WCONTINUED)) > 0) {
	    int id = get_id(fils_termine);
           if (WIFCONTINUED(wstatus)) {
		changer_etat (id,2);
		
	   }else if (WIFEXITED(wstatus) | WIFSIGNALED(wstatus)){
               	changer_etat (id,0);
		if (fils_termine == proc_avant_plan){
			proc_avant_plan = 0;
		}
           }else if (WIFSTOPPED(wstatus)) {
		changer_etat (id,1);	
		
           }
        }
     }
     
}

void Terminer_Tous_Programmes(){
	for(int i = 0;i<Nb_procs;i++){
		if (tableau_pids[i].etat != 0){
			kill(tableau_pids[i].pid,SIGINT);						
		}


	}
}

void Afficher_Jobs(){
	for(int i = 0;i<Nb_procs;i++){
					
		if (tableau_pids[i].etat != 0){
						char etat[10] = "";
						if(tableau_pids[i].etat == 2){
						 	strcpy(etat,"actif");
						}else{
							strcpy(etat,"suspendu");
						}
						printf("le processus d'idantifiant %d de pid %d est %s de commande lancée %s\n"
							,i+1,tableau_pids[i].pid,etat,tableau_pids[i].commande_lancee);
		}


	}
}

void handler_int(int num){
	if (proc_avant_plan !=0){
		kill(proc_avant_plan,SIGINT);
		changer_etat (get_id(proc_avant_plan),0);
	}
}
	
void handler_Stop(int num){
	if (proc_avant_plan != 0){
		kill(proc_avant_plan,SIGSTOP);
		changer_etat (get_id(proc_avant_plan),1);
		proc_avant_plan =0;
	}
}

int getLongueur(char ***seq){
	int resultat = 0;
	while (seq[resultat] != NULL){
		resultat ++;
	}
	return resultat;
}

void verifier_dup2(int retour_dup2){
	if(retour_dup2 < 0){
		perror("Erreur dup2\n");
	}
}

void verifier_close(int retour_close){
	if(retour_close < 0){
		perror("Erreur close\n");
	}
}

void fermer_autres_tubes(int Tube1, int Tube2){
	if (Tube2 == 0){
		for (int j = 0; j < longueur -1; j++){
			if (j !=  Tube1){
				retour = close (Tableau_Tubes[j][0]);
				verifier_close(retour);	
				retour = close (Tableau_Tubes[j][1]);
				verifier_close(retour);
			}
		}
	}else {
		for (int j = 0; j < longueur -1; j++){
			if ((j !=  Tube1) & (j !=  Tube2)){
				retour = close (Tableau_Tubes[j][0]);
				verifier_close(retour);	
				retour = close (Tableau_Tubes[j][1]);
				verifier_close(retour);
			}
		}
	}
}
				

void Traiter_in_out(){
	if (commande->in != NULL) {
					int fd_in;
					fd_in = open (commande->in ,O_RDONLY);
					if (fd_in < 0){
						perror("Erreur ouverture fichier de l'entrée\n");
						exit(1);
					}
					retour = dup2(fd_in,0);
					verifier_dup2(retour);
					retour = close (fd_in);
					verifier_close(retour);
	}
	 if (commande->out != NULL){
					int fd_out;	
					fd_out = open (commande->out ,O_WRONLY | O_CREAT | O_TRUNC,0600);
					if (fd_out < 0){
						perror("Erreur ouverture fichier de la sortie\n");
						exit(1);
					}
					retour = dup2(fd_out,1);
					verifier_dup2(retour);
					retour = close (fd_out);
					verifier_close(retour);
	}
}

void Traiter_Tubes(){
	if (longueur > 1){
			if(i == longueur - 1 ){
							retour = dup2(Tableau_Tubes[i-1][0],0);
							verifier_dup2(retour);
							retour = close (Tableau_Tubes[i-1][1]);
							verifier_close(retour);
							fermer_autres_tubes(i-1,0);
							
			}else if(i == 0){
							retour = dup2(Tableau_Tubes[i][1],1);
							verifier_dup2(retour);
							retour = close (Tableau_Tubes[i][0]);
							verifier_close(retour);
							fermer_autres_tubes(i,0);
			}else {
							retour = dup2(Tableau_Tubes[i][1],1);
							verifier_dup2(retour);
							retour = close (Tableau_Tubes[i][0]);
							verifier_close(retour);
							retour = dup2(Tableau_Tubes[i-1][0],0);
							verifier_dup2(retour);
							retour = close (Tableau_Tubes[i-1][1]);
							verifier_close(retour);
							fermer_autres_tubes(i-1,i);
							
			}
	}
	
}
void Executer_Commande(){
				if (pidFils1  ==  -1) {
					printf("Erreur fork\n");
					exit (1);
				}

				if (pidFils1  == 0) {/* fils1 */
					

					Traiter_in_out();
					Traiter_Tubes();
					
					
					execvp(commande->seq[i][0],commande->seq[i]);

		     			perror("ECHEC de l'execution de la commande \n");
					exit(1);
				}else{

					if (commande->backgrounded == NULL) {
						if ( (longueur == 1) ){
							proc_avant_plan = pidFils1;
						}
					}else {
						proc_avant_plan = 0;
					}
					
					ajouter_pid (idFils1,pidFils1, 2,*(commande->seq[i]));
					if ((longueur > 1) && (i == longueur -1)){
						id_command_finale = idFils1;
					}
					while (proc_avant_plan != 0){  //proc_avant_plan != 0 -> on a un processus en avant plan 
						pause();
					}
					
				}
				p_precedent[0] = p[0];
				p_precedent[1] = p[1];
				i = i+1;
					
}

void Executer_Cd(){
	if((commande->seq[0][1] == NULL) || (strcmp(commande->seq[0][1],"~")) ){
				chdir("/");
	}else{
				chdir(commande->seq[0][1]);
	}
}

void Traiter_Non_Exit(){
	
					
			i = 0;
			
			while(i != longueur){
				retour = pipe(Tableau_Tubes[i]);
				if (retour == -1){
					perror("Erreur pipe\n");
					exit(1);
				}
				pidFils1 = fork();
				idFils1 = idFils1 + 1;
				Executer_Commande();
			}
			if (longueur > 1){
				printf("id_command_finale %d ",id_command_finale);
				do {  // on attends le processus poursuivi à ce qu'il soit terminé 
						pause();
				}while((tableau_pids[id_command_finale-1].etat != 0) & (tableau_pids[id_command_finale-1].etat != 1));
			}
}

void Lire_Commande(){
	printf(">>>");
	commande = readcmd();   /* lit et  range  dans commande la  chaine  entrée au  clavier */
	longueur = getLongueur(commande->seq);
	
}

void Traiter_Commande_Null(){
	printf("%s\n",commande->err);
	
}

void Traiter_Masques(){
		proc_avant_plan =0;
		sigemptyset(ens);
	    	sigaddset(ens,SIGINT);
		signal(SIGINT,handler_int);
		signal(SIGCHLD,handler_chld); 
		sigprocmask (SIG_BLOCK, ens, NULL);
		sigemptyset(ens);
	    	sigaddset(ens,SIGTSTP);
		sigaddset(ens,SIGSTOP);
		signal(SIGTSTP,handler_Stop);
		signal(SIGSTOP,handler_Stop);
		sigprocmask (SIG_BLOCK, ens, NULL);
}

int main(int argc,char *argv[]) {
		Traiter_Masques();
  	while(1) {
		Lire_Commande();
		if (commande->err != NULL){
			Traiter_Commande_Null();
			break;
		}else if (strcmp(commande->seq[0][0],"cd") == 0) {
			Executer_Cd();
		}else if ((strcmp(commande->seq[0][0],"jobs") == 0)){
			Afficher_Jobs();
		}else if (strcmp(commande->seq[0][0],"stop") == 0){
			id = atoi(commande->seq[0][1]);
			if (tableau_pids[id-1].etat == 1){
				printf("Le processus en question est déja stopé\n");
			}else if( tableau_pids[id-1].etat != 2 ){
				printf("L'idantifiant donné est incorrect\n");
			}else {
				kill(tableau_pids[id-1].pid,SIGSTOP);
			}
		}else if (strcmp(commande->seq[0][0],"fg") == 0){
			id = atoi(commande->seq[0][1]);
			proc_avant_plan = tableau_pids[id-1].pid;
			if( (tableau_pids[id-1].etat != 1) & (tableau_pids[id-1].etat != 2)){
				printf("L'idantifiant donné est incorrect\n");
			}else {
				kill(proc_avant_plan,SIGCONT);
				do {  // on attends le processus poursuivi à ce qu'il soit terminé 
					pause();
				}while((tableau_pids[id-1].etat != 0) & (tableau_pids[id-1].etat != 1));
			}
		}else if (strcmp(commande->seq[0][0],"bg") == 0){
			id = atoi(commande->seq[0][1]);
			if (tableau_pids[id-1].etat == 2){
				printf("Le processus en question est déja actif\n");
			}else if( tableau_pids[id-1].etat != 1 ){
				printf("L'idantifiant donné est incorrect\n");
			}else {
				kill(tableau_pids[id-1].pid,SIGCONT);
			}
		}else if (strcmp(commande->seq[0][0],"exit") != 0 ){
			Traiter_Non_Exit();
		}else{	
			//Terminer_Tous_Programmes();
			break;
		}
	}
}
