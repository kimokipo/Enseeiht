#include <stdlib.h> 
#include <stdio.h>
#include <assert.h>
#include <stdbool.h>
#define CAPACITE 5

// Definition du type monnaie
struct t_monnaie{
    int valeur;
    char devise;
};
typedef struct t_monnaie t_monnaie;

/**
 * \brief Initialiser une monnaie 
 * \param[out] m la monnaie à initialiser
 * \param[in] valeur la valeur de la monnaie
 * \param[in] devise le devise de la monnaie
 * \pre valeur >0  
 */ 
void initialiser(t_monnaie *m, int valeur, char devise){
    m->valeur=valeur;
    m->devise=devise;
}



/**
 * \brief Ajouter une monnaie m2 à une monnaie m1 
 * \param[in] m1 la monnaie à ajouter et inchangée
 * \param[in out] m2 la monnaie qu'on ajoute et changée par le resultat d'ajout 
 */ 
bool ajouter(t_monnaie m1, t_monnaie m2){
    m2.valeur=m1.valeur+m2.valeur;
    return (m1.devise==m2.devise)&&(m2.valeur==m1.valeur+m2.valeur);
}


/**
 * \brief Tester Initialiser 
 * \param[]
 */ 
void tester_initialiser(){
    t_monnaie *m;
    initialiser(m,5,'e');
    assert(m->valeur==5);
    assert(m->devise=='e');
}

/**
 * \brief Tester Ajouter 
 * \param[]
 */ 
void tester_ajouter(){
    t_monnaie *m1;
    t_monnaie *m2;
    t_monnaie *m3;
    initialiser(m1,5,'e');
    initialiser(m2,7,'e');
    initialiser(m3,8,'$');
    assert(ajouter(*m1,*m2));
    assert(!ajouter(*m1,*m3));
}



int main(void){
    // Un tableau de 5 monnaies
    typedef t_monnaie t_porte_monnaie[CAPACITE];

    //Initialiser les monnaies
    t_porte_monnaie porte_monnaie;
    int valeur;
    char devise;
    char devise_somme;
    for (int i=0;i<CAPACITE;i++){
        printf("Entrer une monnaie!\n");
        scanf("%d %c",&valeur,&devise);
        initialiser(&porte_monnaie[i],valeur,devise);
    }
    // Afficher la somme des toutes les monnaies qui sont dans une devise entrée par l'utilisateur.
    printf("Entrer la devise des monnaies qu'on veut sommer!\n");
    scanf(" %c",&devise_somme);
    int  somme=0;
    for (int i=0;i<CAPACITE;i++){
        if (porte_monnaie[i].devise==devise_somme){
            somme+=porte_monnaie[i].valeur;

        }
    }
    printf("la somme des monnaies est : %d %c.\n",somme,devise_somme);
    return EXIT_SUCCESS;
}