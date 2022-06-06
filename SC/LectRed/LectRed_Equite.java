// Time-stamp: <08 Apr 2008 11:35 queinnec@enseeiht.fr>

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import Synchro.Assert;

/** Lecteurs/rédacteurs
 * stratégie d'ordonnancement: priorité aux rédacteurs,
 * implantation: avec un moniteur. */
public class LectRed_Equite implements LectRed
{
    private ReentrantLock mon_moniteur;
    private Condition Attente ;
    private Condition Sas ; 
    private Integer lec;
    private boolean red;
    private LinkedList<String> FileDemandeurs = new LinkedList<String>();
    private LinkedList<String> FileRedacteurs = new LinkedList<String>();

    public LectRed_Equite()
    {
        mon_moniteur = new java.util.concurrent.locks.ReentrantLock();
        Attente = mon_moniteur.newCondition(); 
        Sas = mon_moniteur.newCondition(); 
        lec = 0;
        red = false;
    }

    public void demanderLecture() throws InterruptedException
    {
        mon_moniteur.lock();
        String nomThreadCourant = Thread.currentThread().toString();
        FileDemandeurs.add(nomThreadCourant);
        while (red | !FileDemandeurs.getFirst().equals(nomThreadCourant)) {
            Attente.await();
        }
        FileDemandeurs.removeFirst();
        lec ++;
        Attente.signalAll();
        mon_moniteur.unlock();
    }

    public void terminerLecture() throws InterruptedException
    {
        mon_moniteur.lock();
        lec--;
        Attente.signalAll();
        if (lec == 0) {
            Sas.signalAll();
        }
        mon_moniteur.unlock();
    }

    public void demanderEcriture() throws InterruptedException
    {
        mon_moniteur.lock();
        String nomThreadCourant = Thread.currentThread().toString();
        FileDemandeurs.add(nomThreadCourant);
        while (red | !FileDemandeurs.getFirst().equals(nomThreadCourant) | lec != 0) {
            Attente.await();
            FileRedacteurs.add(nomThreadCourant);
            while (red | lec !=0 | !FileRedacteurs.getFirst().equals(nomThreadCourant)){
                Sas.await();
            }
            FileRedacteurs.removeFirst();
        }
        FileDemandeurs.removeFirst();
        red = true;
        mon_moniteur.unlock();
    }

    public void terminerEcriture() throws InterruptedException
    {
        mon_moniteur.lock();
        red = false;
        Attente.signalAll();
        Sas.signalAll();
        mon_moniteur.unlock();
    }

    public String nomStrategie()
    {
        return "Stratégie: Equité.";
    }
}
