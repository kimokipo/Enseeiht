Reponses
---------
### Efficacité de la parallélisation

- Le résultat « idéal » qu'peut a priori espérer c'est que le temps d'exécution en paralléle soit N fois plus petit que celui de l'exécution séquentielle.

- Les temps d'exécution réels pour une mesure avec une attente de 1 ms est :
    N = 1, Durée exécution séquentielle (ms): 1803, Durée exécution non synchronisée (ms): 1798 (attendue: 1803/1 = 1803)
    N = 10, Durée exécution séquentielle (ms): 17744, Durée exécution non synchronisée (ms): 3726 (attendue: 17744/10 = 1774)
    N = 20, Durée exécution séquentielle (ms): 35501, Durée exécution non synchronisée (ms): 7509 (attendue: 35501/20 = 1775)
    N = 30, Durée exécution séquentielle (ms): 53280, Durée exécution non synchronisée (ms): 11251 (attendue: 53280/30 = 1776)
    N = 40, Durée exécution séquentielle (ms): 71070, Durée exécution non synchronisée (ms): 14893 (attendue: 71070/40 = 1776)
    N = 50, Durée exécution séquentielle (ms): 88629, Durée exécution non synchronisée (ms): 18658 (attendue: 88629/50 = 1772)

    * Les différences observées entre le temps mesuré et le temps attendu sont due au fait que chaque Tread a des instructions qui doivent étre exécutées sequentiellement, c'est en ce qui concerne l'incrémentation élémentaire du variable globale cpt.
    * Le surcoût induit par la gestion des threads est pratiquement null
  
### Coût de la cohérence

- Les valeurs affichées à priori dans le cas où il n'y a pas préemption 
 du processeur entre threads sont :
 pour le thread kème : k * NB_IT_INTERNES, avec NB_IT_INTERNES = 1000000000
  
- Quelles seront *a priori* les valeurs affichées dans le cas où la gestion des activités
 partage le temps processeur par quantum de temps entre threads ? : 
 Je n'ai pas compris la question.

- La politique suivie par la JVM utilisée pour le test est : l'Accés Concurrent

- La valeur finale du compteur n'est pas égale au nombre total d'itérations. En exécutant avec N = 2, attente = 1 ms, on obtient : 
    Thread t0 part de : 0
    Thread t1 part de : 0
    Thread t0 finit à : 1891139797
    Thread t1 finit à : 1891139797
 Ce resultat est due aux itérferences entre les threads.

- En rendant la méthode incr() synchronisé, les resultats sont corrects, pour une mesure avec N = 2 et attente = 1 ms :
    Thread t1 part de : 0
    Thread t0 part de : 0
    Thread t1 finit à : 1000000000
    Thread t0 finit à : 2000000000

    * en plaçant uniquement l'incrémentation de la boucle interne dans le bloc `synchronized` : le processus s'est planté sans rien afficher
    
    * en plaçant la boucle interne dans le bloc `synchronized` : on obtient : 
    Thread t0 part de : 0
    Thread t1 part de : 0
    Thread t1 finit à : 2000000000
    Thread t0 finit à : 2000000000

- La correction du résultat est-elle garantie a priori si l'on utilise un objet de la classe
 `java.util.concurrent.atomic.AtomicLong` pour le compteur ? Argumenter, puis vérifier 
 cet a priori. Evaluer le coût de l'utilisation de ce mécanisme : 
 Lorsque je déclare le variable cpt comme `static java.util.concurrent.atomic.AtomicLong`, j'obtient des erreurs de compilation me disant que le type ` long` ne peut pas ètre converti vers `atomicLong`.
 
 - La correction du résultat est garantie a priori si l'on déclare le compteur
 comme  `volatile`, car l'accés se fait dans la mémoire et pas dans la cache, du coup ça va prendre beaucoup du temps que les exécutions précedentes, donc on a un coùt temporelle important. Une mesure avec N = 2, et attente  = 1 ms nous donne, avec l'ajout du mot clé `Volatile` :
    Thread t1 part de : 0
    Thread t0 part de : 0
    Thread t1 finit à : 1999202508
    Thread t0 finit à : 2000000000
    Durée exécution non synchronisée (ms): 14048

 - Conclure globalement sur les conditions d'utilisation (ou pas) de ces différents mécanismes.
 
### Supplément
Le test de l'application PCA nous donne l'affichage des valeurs nulles des deux variables `depot` et `retrait`, ce que veut dire que l'accés à ces variables se fait dans la cache, et pour remedier à ça, on ajoute le mot clé `volatile` devant les deux variables, dans ce cas, ça marche.
-------------
