/**
 *  \author Xavier Cr�gut <nom@n7.fr>
 *  \file file.h
 * 
 *  Objectifs :
 *	.  D�finition et utilisation des modules
 *	.  Allocation dynamique de m�moire
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
 * \param[out] f le pointeur sur la file initialis�e
 * Postcondition : est_vide(*f);
 */
void initialiser(File *f);

/**
 * D�truire la file \a f.
 * \param[in] f le pointeur sur la file � d�truire 
 * Elle ne pourra plus �tre utilis�e (sauf � �tre de nouveau initialis�e)
 */
void detruire(File *f);

/**
 * L'�l�ment en t�te de la file.
 * \param[in] f la file
 * Precondition : ! est_vide(f);
 */ 
char tete(File f);

/**
 * Ajouter dans la file \a f l'�l�ment \a v.
 * \param[in] f le pointeur sur la file
 * \param[in] v le charact�re � inserer
 * Precondition : f != NULL;
 * Postcondition : tete(*f)==v;
 */
void inserer(File *f, char v);

/**
 * Extraire l'�l�ment \a v en t�te de la file \a f.
 * \param[in] f le pointeur sur la file
 * \param[out] v le pointeur sur le charact�re � extraire
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
