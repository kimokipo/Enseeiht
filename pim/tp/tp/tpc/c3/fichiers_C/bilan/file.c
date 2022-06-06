/**
 *  \author Xavier Crégut <nom@n7.fr>
 *  \file file.c
 *
 *  Objectif :
 *	Implantation des opérations de la file
*/

#include <malloc.h>
#include <assert.h>

#include "file.h"


void initialiser(File *f)
{
    f->tete=NULL;
    f->queue=NULL;
    assert(est_vide(*f));
}


void detruire(File *f)
{
    free(f->tete);
    f=NULL;
}


char tete(File f)
{
    assert(!est_vide(f));
    return (f.tete)->valeur;
}


bool est_vide(File f)
{
    return (f.tete==NULL) && (f.queue==NULL);
}

/**
 * Obtenir une nouvelle cellule allouée dynamiquement
 * initialisée avec la valeur et la cellule suivante précisé en paramètre.
 */
Cellule * cellule(char valeur, Cellule *suivante)
{
    Cellule *cellule=malloc(sizeof(Cellule));
    cellule->valeur=valeur;
    cellule->suivante=suivante;
    return cellule;
}


void inserer(File *f, char v)
{
    assert(f != NULL);
    if (est_vide(*f)){
        f->queue=cellule(v,NULL);
        f->tete=f->queue;
    }else{
       (f->queue)->suivante=cellule(v,NULL);
       f->queue=(f->queue)->suivante;
   }
}

void extraire(File *f, char *v)
{
    assert(f != NULL);
    assert(! est_vide(*f));
    *v=(f->tete)->valeur;
    if (f->tete==f->queue){
        f->tete=NULL;
        f->queue=NULL;
    }else{
        f->tete=(f->tete)->suivante;
    }
}


int longueur(File f)
{
    Cellule * curseur=malloc(sizeof(Cellule));
    curseur=f.tete;
    int longueur=0;
    if (est_vide(f)){
        return 0;
    }else{
        while(curseur!=NULL){
            longueur++;
            curseur=curseur->suivante;
        }
    }
    return longueur;
}
