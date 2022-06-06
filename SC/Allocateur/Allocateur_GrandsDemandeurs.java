// Time-stamp: <02 Apr 2008 16:19 queinnec@enseeiht.fr>

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

/** Allocateur de ressources,
 * stratégie d'ordonnancement: indéterminée,
 * implantation: à base de moniteur java. */
public class Allocateur_GrandsDemandeurs implements Allocateur {

    // Nombre de ressources actuellement disponibles
    // invariant 0 <= nbLibres <= nbRessources
    private int nbLibres;
    private int nbRessources;

    // Protection des variables partagées
    private Lock moniteur;

    // Une condition de blocage commune à tous
    private Condition Acces[];
    private Integer Attentes[]; 

    /** Initilialise un nouveau gestionnaire de ressources pour nbRessources. */
    public Allocateur_GrandsDemandeurs (int nbRessources)
    {
        this.nbRessources = nbRessources;
        this.nbLibres = nbRessources;
        this.moniteur = new ReentrantLock();
        this.Acces = new Condition [nbRessources +1];
        for (int i = 0; i < nbRessources +1; i++){
            Acces[i] = moniteur.newCondition();
        }

        this.Attentes = new Integer [nbRessources +1];
        for (int i = 0; i < nbRessources +1; i++){
            Attentes[i] = 0;
        }
    }

    /** Demande à obtenir `demande' ressources. */
    public void allouer (int demande) throws InterruptedException
    {
        moniteur.lock();
        while (demande > nbLibres) { // while nécessaire : pas de contrôle de l'utilité du réveil.
            Attentes[demande]++; 
            Acces[demande].await();
            Attentes[demande]--;
        }
        nbLibres -= demande;
        ReveileEnChaine();
        moniteur.unlock();
    }

    /** Libère `rendu' ressources. */
    public void liberer (int rendu)
    {
        moniteur.lock();
        nbLibres += rendu;
        ReveileEnChaine();
        moniteur.unlock();
    }

    /** Chaîne décrivant la stratégie d''allocation. */
    public String nomStrategie ()
    {
        return "GrandsDemandeurs";
    }

    private void ReveileEnChaine(){
        Integer i = nbRessources;
        while (i > -1 && Attentes[i] == 0 ){
            i--;
        } 
        if (i >= 0){
            Acces[i].signalAll();
        } 

    }
}
