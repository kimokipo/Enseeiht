/** Squelette du programme **/
/*********************************************************************
 *  Auteur  : Kamal HAMMI
 *  Version : 1
 *  Objectif : Conversion pouces/centimètres
 ********************************************************************/

#include <stdio.h>
#include <stdlib.h>
//afficher une longueur saisie au clavier en pouces et en centimètres
int main()
{
    float UN_POUCE =2.54; //valeur en centimètres d'un pouce
    
    float valeur; //valeur de la longueur lue au clavier  
    char unite; //unité de la longueur lue au clavier 
    float lg_cm; //longueur exprimée en centimètres
    float lg_p; //longueur exprimée en pouces
    
        /* Saisir la longueur */
    printf("Entrer une longueur (valeur + unité) : ");
    scanf("%f %c",&valeur,&unite); //saisir la valeur et l'unité
    
        /* Calculer la longueur en pouces et en centimètres */
    switch (unite){
        case 'p'|'P' : //la longueur a été saisie en pouces
            lg_p=valeur;
            lg_cm=lg_p+UN_POUCE;
            break;
        case 'c'|'C': //la longueur a été saisie en centimètres
            lg_cm=valeur;
            lg_p=lg_cm/UN_POUCE;
            break;
        case 'm'|'M': //la longueur a été saisie en mètres
            lg_cm=valeur*100;
            lg_p=lg_cm/UN_POUCE;
            break;
        default : //Unité non reconnue
            lg_p=0;
            lg_cm=0;
            printf("L'unité est incorrect, veulliez recommencer!\n");
            main();
            break;
    }

    /* Afficher la longueur en pouces et en centimètres */
    printf("%1.2f p = %1.2f cm\n",lg_p,lg_cm);
    return EXIT_SUCCESS;
}
