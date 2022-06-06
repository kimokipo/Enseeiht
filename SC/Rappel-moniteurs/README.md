Moniteurs en Java (rappel) :
--------------------

 - Créer une instance de la classe java.util.concurrent.locks.ReentrantLock (laquelle implémente l'interface java.util.concurrent.locks.Lock)
      `    ReentrantLock mon_moniteur = new java.util.concurrent.locks.ReentrantLock();`       
   Cet objet (verrou) fournit
     * l'exclusion mutuelle sur les opérations du moniteur (qui devra être définie explictement, pour chaque opération)
     * les opérations permettant de créer des variables-conditions pour le moniteur.
          
       *Remarque* :  Il est possible de créer un ReentrantLock équitable (mais pas nécessairement FIFO) :  
    `       ReentrantLock mon_moniteur = new java.util.concurrent.locks.ReentrantLock(true);`
      

 - Créer une ou des variables-conditions (java.util.concurrent.locks.Condition)
   à partir du "ReentrantLock" précédemment créé :
   
       `    Condition ma_var_condition = mon_moniteur.newCondition();`

 - Les opérations doivent explicitement demander le verrou pour obtenir
   l'exclusion mutuelle, le code de chaque opération (méthode) doit donc être encadré 
   par la prise et la libération du verrou  :
   
    `mon_opération() {`   
    `    mon_moniteur.lock();`     
       
    `         ...           `
    
    `        (code  de l'opération)          `
    
    `         ...           `
    
    `    mon_moniteur.unlock(); `         
    `  }`

 - Les variables-conditions s'utilisent avec
 
       `    ma_var_condition.await();`     
   et  
       `    ma_var_condition.signal();`      
       `    ma_var_condition.signalAll();`
   
 - La sémantique est priorité au signaleur, sans file des signalés : 
	* le signaleur conserve l'accès exclusif
	* le signalé est réveillé, mais doit réacquérir l'accès exclusif, et il n'est pas
 	   prioritaire par rapport aux entrants en attente (que le verrou soit équitable ou non) ;
 	   il doit donc nécessairement retester la condition attendue, car elle a pu être utilisée invalidée par un entrant avant qu'il réobtienne l'accès exclusif. 
   Il faut donc penser à utiliser des boucles "while" pour déterminer si les conditions 
   attendues sont effectivement vérifiées au moment du réveil.
 	 * 	en conséquence, l'attente sur les conditions n'est **pas FIFO** : l'ordre d'accès
 	 effectif au moniteur ne correspond pas forcément à l'ordre des appels à await()
 	 
 - Les méthodes permettant de tester l'état des processus en attente sur les conditions ne
   sont **pas fiables**. En conséquence, il est nécessaire d'utiliser explicitement des 
   compteurs pour dénombrer les processus en attente sur une condition :
   
      `    cpt_attente_C++ ; C.await() ; cpt_attente_C++  `