// Time-stamp: <08 Apr 2008 11:35 queinnec@enseeiht.fr>

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import Synchro.Assert;

/** Lecteurs/rédacteurs
 * stratégie d'ordonnancement: priorité aux rédacteurs,
 * implantation: avec un moniteur. */
public class LectRed_PrioLecteur implements LectRed
{
    private ReentrantLock mon_moniteur;
    private Condition LP ; 
    private Condition EP ; 
    private Integer lec;
    private boolean red;
    private Integer lecteur_att;

    public LectRed_PrioLecteur()
    {
        mon_moniteur = new java.util.concurrent.locks.ReentrantLock();
        LP = mon_moniteur.newCondition(); 
        EP = mon_moniteur.newCondition();
        lec = 0;
        red = false;
        lecteur_att = 0;
    }

    public void demanderLecture() throws InterruptedException
    {
        mon_moniteur.lock();
        while (red) {
            lecteur_att ++;
            LP.await();
            lecteur_att--;
        }
        lec ++;
        LP.signal();
        mon_moniteur.unlock();
    }

    public void terminerLecture() throws InterruptedException
    {
        mon_moniteur.lock();
        lec--;
        LP.signal();
        if (lec == 0){
            EP.signal();
        }
        mon_moniteur.unlock();
    }

    public void demanderEcriture() throws InterruptedException
    {
        mon_moniteur.lock();
        while (lec != 0 | lecteur_att != 0 | red) {
            EP.await();
        }
        red =true;
        mon_moniteur.unlock();
    }

    public void terminerEcriture() throws InterruptedException
    {
        mon_moniteur.lock();
        red =false;
        if (lecteur_att > 0){
            LP.signal();
        }else {
            EP.signal();
        }
        mon_moniteur.unlock();
    }

    public String nomStrategie()
    {
        return "Stratégie: Priorité Lecteurs.";
    }
}
