#include "main.h"
/**
 * \brief Initialiser une main.
 * \param[in] N nombre de cartes composant la main.  Précondition : N <= (NB_CARTES - 1) div 2
 * \param[out] la_main créée
 * \return true si l'initialisation a échouée.
 */
bool init_main(t_main* la_main, int N){
    assert(N <= (NB_CARTES-1)/2);
    la_main->main = malloc(N*sizeof(carte));
    la_main->nb = N;
    return (la_main==NULL); //allocation réussie ?
}

/**
 * \brief Afficher une main.
 * \param[in] la_main la main a afficher
 */
void afficher_main(t_main la_main){
    for (int k=0; k<la_main.nb; k++){
        afficher_carte(la_main.main[k]);
    }
    printf("\n");
}
