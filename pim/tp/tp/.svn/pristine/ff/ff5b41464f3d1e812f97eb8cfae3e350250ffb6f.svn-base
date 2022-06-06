/**
 *  \author Xavier Crégut <nom@n7.fr>
 *  \file file.h
 * 
 *  Objectifs :
 *	.  Définition et utilisation des modules
 *	.  Allocation dynamique de mémoire
 */

#include <stdbool.h>

struct Cellule {
    char valeur;
    struct Cellule *suivante;
};
typedef struct Cellule Cellule;

struct File {
    Cellule *tete;
    Cellule *queue;
    /** Invariant :
      *	 file vide :	tete == NULL && queue == NULL
      */
};
typedef struct File File;


/**
 * Initialiser la file \a f.
 * La file est vide.
 * \param[out] f le pointeur sur la file initialisÈe
 * Postcondition : est_vide(*f);
 */
void initialiser(File *f);

/**
 * Détruire la file \a f.
 * \param[in] f le pointeur sur la file ‡ dÈtruire 
 * Elle ne pourra plus être utilisée (sauf à être de nouveau initialisée)
 */
void detruire(File *f);

/**
 * L'élément en tête de la file.
 * \param[in] f la file
 * Precondition : ! est_vide(f);
 */ 
char tete(File f);

/**
 * Ajouter dans la file \a f l'élément \a v.
 * \param[in] f le pointeur sur la file
 * \param[in] v le charactËre ‡ inserer
 * Precondition : f != NULL;
 * Postcondition : tete(*f)==v;
 */
void inserer(File *f, char v);

/**
 * Extraire l'élément \a v en tête de la file \a f.
 * \param[in] f le pointeur sur la file
 * \param[out] v le pointeur sur le charactËre ‡ extraire
 * Precondition : f != NULL && ! est_vide(*f);
 * Postcondition : longueur(*f'result)==longueur(*f)-1; 
 */
void extraire(File *f, char *v);

/**
 * Est-ce que la file \a f  est vide ?
 * \param[in] f la file
 */
bool est_vide(File f);

/**
 * Obtenir la longueur de la file.
 * \param[in] f la file
 */
int longueur(File f);
