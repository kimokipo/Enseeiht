Reponses
---------
### Exclusion mutuelle
1. La classe `Peterson` met en place l'algorithme de la planche 20, elle est completée en mettant la boucle `while` de la methode `entrer()` dans le bloc `synchronized`.L'exécution a bien marché.

2. L'ordre des deux premières affectations de la méthode entrer() (lignes 29 et 30 : 
`Peterson.demande[id] = true;` et `Peterson.tour = di ;`) est important car dans la boucle while de l'autre processus, les deux conditions `(Peterson.tour != id) && (Peterson.demande[di])` sont testées dans le mème ordre que les dites affectations.


3.  - Le protocole d'exclusion mutuelle pour N processus utilisant la primitive TestAndSet
	présentée en cours (planche 23) est implanté, et testé avec succés.
	- Le protocole est vivace et toute demande d'entrée 
	en section critique finira par être servie.
	- En utilisant un bloc `synchronized` pour assurer l'exclusion mutuelle, le protocole marche toujours bien.
	- Comparaison entre les 3 protocoles:
	    Peterson : temps_totale = 67.108864 (ms)
	    TestAndSet : temps_totale = 0.0 (ms)
	
### Schéma producteurs consommateurs
4. La classe `TamponBorné` est completée, exécution sans synchronisation a un comportement bizare. Mais avec la synchronisation tout marche bien (en rendant les deux méthodes `déposer()` et `retirer()` `synchronized`).
