// Time-stamp: <08 Apr 2008 11:35 queinnec@enseeiht.fr>

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import Synchro.Assert;

/** Lecteurs/rédacteurs
 * stratégie d'ordonnancement: priorité aux rédacteurs,
 * implantation: avec un moniteur. */
public class LectRed_PrioRedacteur implements LectRed
{
    private ReentrantLock mon_moniteur;
    private Condition LP ; 
    private Condition EP ; 
    private Integer lec;
    private boolean red;
    private Integer redacteur_att;

    public LectRed_PrioRedacteur()
    {
        mon_moniteur = new java.util.concurrent.locks.ReentrantLock();
        LP = mon_moniteur.newCondition(); 
        EP = mon_moniteur.newCondition();
        lec = 0;
        red = false;
        redacteur_att = 0;
    }

    public void demanderLecture() throws InterruptedException
    {
        mon_moniteur.lock();
        while (red | redacteur_att != 0) {
            LP.await();
        }
        lec ++;
        LP.signal();
        mon_moniteur.unlock();
    }

    public void terminerLecture() throws InterruptedException
    {
        mon_moniteur.lock();
        lec--;
        if (redacteur_att != 0) {
            EP.signal();
        }else{
            LP.signal();
        }
        mon_moniteur.unlock();
    }

    public void demanderEcriture() throws InterruptedException
    {
        mon_moniteur.lock();
        while (red | lec != 0) {
            redacteur_att++;
            EP.await();
            redacteur_att--;
        }
        red = true;
        mon_moniteur.unlock();
    }

    public void terminerEcriture() throws InterruptedException
    {
        mon_moniteur.lock();
        red = false;
        EP.signal();
        if (redacteur_att == 0){
            LP.signal();
        }
        mon_moniteur.unlock();
    }

    public String nomStrategie()
    {
        return "Stratégie: Priorité Rédacteurs.";
    }
}
