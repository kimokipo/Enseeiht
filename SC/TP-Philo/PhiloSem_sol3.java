// Time-stamp: <08 déc 2009 08:30 queinnec@enseeiht.fr>

import java.util.concurrent.Semaphore;

public class PhiloSem_sol3 implements StrategiePhilo {

    /****************************************************************/
    private Semaphore [] Philos;
    private EtatPhilosophe [] EtatPhilos;
    private Semaphore mutex;
    public PhiloSem_sol3 (int nbPhilosophes) {
        mutex = new Semaphore(1,true);

        this.Philos = new Semaphore [nbPhilosophes];
        for (int i = 0; i < nbPhilosophes; i++){
                this.Philos[i] = new Semaphore(1,true);
        }

        EtatPhilos = new EtatPhilosophe [nbPhilosophes];
        for (int i = 0; i < nbPhilosophes; i++){
            this.EtatPhilos[i] = EtatPhilosophe.Pense;
        }
    }

     /** Le philosophe no peut-il manger ?
     */
    private boolean peutManger (int no)
    {
        return EtatPhilos[Main.PhiloDroite(no)] != EtatPhilosophe.Mange && EtatPhilos[Main.PhiloGauche(no)] != EtatPhilosophe.Mange;

    }

    /** Le philosophe no demande les fourchettes.
     *  Précondition : il n'en possède aucune.
     *  Postcondition : quand cette méthode retourne, il possède les deux fourchettes adjacentes à son assiette. */
    public void demanderFourchettes (int no) throws InterruptedException
    {
        mutex.acquire();
            if (peutManger(no)){
                EtatPhilos[no] = EtatPhilosophe.Mange;
                mutex.release();
            }else{
                EtatPhilos[no] = EtatPhilosophe.Demande;
                mutex.release();
                Philos[no].acquire();
            }

    }

    /** Le philosophe no rend les fourchettes.
     *  Précondition : il possède les deux fourchettes adjacentes à son assiette.
     *  Postcondition : il n'en possède aucune. Les fourchettes peuvent être libres ou réattribuées à un autre philosophe. */
    public void libererFourchettes (int no) throws InterruptedException
    {
        mutex.acquire();
        EtatPhilos[no] = EtatPhilosophe.Pense;
        if (EtatPhilos[Main.PhiloGauche(no)] == EtatPhilosophe.Demande && peutManger(Main.PhiloGauche(no))){
            EtatPhilos[Main.PhiloGauche(no)] = EtatPhilosophe.Mange;
            Philos[Main.PhiloGauche(no)].release();
        }
        if (EtatPhilos[Main.PhiloDroite(no)] == EtatPhilosophe.Demande && peutManger(Main.PhiloDroite(no))){
            EtatPhilos[Main.PhiloDroite(no)] = EtatPhilosophe.Mange;
            Philos[Main.PhiloDroite(no)].release();
        }
        mutex.release();

    }

    /** Nom de cette stratégie (pour la fenêtre d'affichage). */
    public String nom() {
        return "Implantation Sémaphores, stratégie d'un philosophe ne peut manger que si ses voisins gauche et droit ne mangent pas";
    }

}

