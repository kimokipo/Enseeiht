// Time-stamp: <08 déc 2009 08:30 queinnec@enseeiht.fr>

import java.util.concurrent.Semaphore;

public class PhiloSem_sol2 implements StrategiePhilo {

    /****************************************************************/
    private Semaphore [] Fourchettes;
    private Semaphore table;
    public PhiloSem_sol2 (int nbPhilosophes) {

        this.Fourchettes = new Semaphore [nbPhilosophes];
        for (int i = 0; i < nbPhilosophes; i++){
                this.Fourchettes[i] = new Semaphore(1,true);
        }
        this.table = new Semaphore (nbPhilosophes-1,true);
    }

    /** Le philosophe no demande les fourchettes.
     *  Précondition : il n'en possède aucune.
     *  Postcondition : quand cette méthode retourne, il possède les deux fourchettes adjacentes à son assiette. */
    public void demanderFourchettes (int no) throws InterruptedException
    {
        table.acquire();
            Fourchettes[Main.FourchetteDroite(no)].acquire();
            Thread.sleep(1000);
            Fourchettes[Main.FourchetteGauche(no)].acquire();
        table.release();

    }

    /** Le philosophe no rend les fourchettes.
     *  Précondition : il possède les deux fourchettes adjacentes à son assiette.
     *  Postcondition : il n'en possède aucune. Les fourchettes peuvent être libres ou réattribuées à un autre philosophe. */
    public void libererFourchettes (int no)
    {

        Fourchettes[Main.FourchetteDroite(no)].release();
        Fourchettes[Main.FourchetteGauche(no)].release();
    }

    /** Nom de cette stratégie (pour la fenêtre d'affichage). */
    public String nom() {
        return "Implantation Sémaphores, stratégie de (N-1) philosophes peuvent demander de manger à la fois";
    }

}

