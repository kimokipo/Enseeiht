#include <sys/types.h>
#include <sys/stat.h>
#include <sys/mman.h> /* définit mmap  */
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

int main (int argc, char *argv[])
{
 int fin, fout, taille;
 char *src, *dst;
 //char qq [1];
 struct stat statbuf;

 if (argc != 3) {
   printf("usage: %s <fichier source> <fichier destination>\n", argv[0]);
   exit(1);
 }
 /* ouvrir source */
 fin = open(argv[1],O_RDONLY);

 /* recuperer la taille de la source */
 fstat(fin,&statbuf);
 taille = statbuf.st_size;

 /* coupler source */
 src = mmap(0, taille, PROT_READ, MAP_SHARED, fin, 0);


 /* ouvrir destination */
 fout = open(argv[2] ,O_RDWR | O_CREAT | O_TRUNC,0600);
 
 /*	Note : le mode O_RDWR (plutôt que O_WRONLY) est nécessaire car mmap impose 
 	qu'un fichier couplé soit toujours (au moins) ouvert en lecture
 */

 /* ajuster la taille du fichier destination à la taille du fichier source */
 ftruncate(fout,taille);

 /*	Note : 
 	Pourquoi ajuster ? 
 	------------------
 	mmap ne spécifie pas quel est le resultat d'une ecriture *apres* la fin d'un fichier
	couplé (SIGBUS est une possibilite, frequente). Il faut donc fixer la taille du 
	fichier destination à la taille du fichier source *avant* le couplage.
	Comment ajuster ?
	-----------------
	 Le plus simple est d'utiliser truncate, 
	 mais vous pouvez utiliser lseek(a la taille du fichier source) + write d'un octet, 
	 que vous connaissez déjà 
 */
 	
 /* coupler destination */
 dst = mmap(0, taille, PROT_WRITE, MAP_SHARED, fout, 0);
 
 /* Note : MAP_SHARED est necessaire pour que les ecritures soient visibles 
 	dans le fichier */

 /* la copie est le plus facile :) */
 memcpy(dst,src,taille);

 exit(0);
}
