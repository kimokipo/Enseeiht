Reponses
---------

- Calcul du maximum d'un tableau:
       Pour cet exercice on peut mettre en pratique les deux schémas (pool fixe et map/reduce).
	   Le schéma de parallélisation le plus naturel est celui de map/reduce, puisque il me rappelle de la recherche dicotomique. Et donc je mise sur lui pour qu'il soit le plus efficace.
	   J'ai creé un fichier `jeuxDeDonnes` qui contient un tableau de `10000000` d'entrées de valeur maximal `5000`, et j'ai testé avec `2` essais, `100` taches et `10` ouvriers, et `10000` comme taille de troncons pour (poul Fork/Join), et j'ai obtenu les resultats suivants:
Essai [0] : maximum = 4999, durée (mono) 21151µs
Essai [1] : maximum = 4999, durée (mono) 18750µs
--------------------
Essai [0] : maximum = 4999, durée (pool) 62924µs
Essai [1] : maximum = 4999, durée (pool) 11798µs
--------------------
Essai [0] : maximum = 4999, durée (FJ) 53773µs
Essai [1] : maximum = 4999, durée (FJ) 20195µs
	
	   * On remarque que les deuxs versions (pool fixe et Fork/join) sont lentes par rapport à la version séquentielle pendant le premier essai, mais la version (pool fixe) devient plus rapide pendant le deuxième.
	   On constate que la version (pool fixe) était rapide que la version (poul Fork/Join) ce qui n'était pas attendue.
	
- Tri d'un tableau selon le schéma tri-fusion:
       Pour cet exercice on peut mettre en pratique les deux schémas (pool fixe et map/reduce).
	   Comme pour la recherche de Max d'un Tab, le schéma de parallélisation le plus naturel est celui de map/reduce, puisque c'est d'ailleurs le principe de Tri Fusion. Et je mise alors sur lui pour qu'il soit le plus efficace.
	
	   J'ai creé un fichier `jeuxDeDonnes` qui contient un tableau de `1000000` d'entrées de valeur maximal `500`, et j'ai testé avec `2` essais, `100` taches et `10` ouvriers, et `1000` comme Seuil pour (poul Fork/Join), et j'ai obtenu les resultats suivants:
	
Essai [0] : durée (mono) 229566µs
Essai [1] : durée (mono) 127896µs
--------------------
Essai [0] : durée (PF) 311528µs
Essai [1] : durée (PF) 325583µs
--------------------
Essai [0] : durée (FJ) 140386µs
Essai [1] : durée (FJ) 127427µs
	
	   * On remarque que la version (pool fixe) est lente par rapport à la version séquentielle pendant les deux essais, tandis que la version (poul Fork/join) est plus rapide pendant les deux.
	   Ce qui nous prouve que la version (poul Fork/Join) est plus rapide et efficace que la version (pool fixe), ce qui était bien attendue.
	
- L'application de comptage de mots dans un répertoire:
       Pour cet exercice on peut mettre en pratique le schéma (map/reduce).
	
	   J'ai testé avec le repertoire `max` pour chercher le mot `public` avec `2` essais, et j'ai obtenu les resultats suivants:
	
Essai [0] : 5 occurrences de public, durée (mono) 2217879µs
Essai [1] : 5 occurrences de public, durée (mono) 1531367µs
--------------------
Essai [0] : 5 occurrences de public, durée (FJ) 1434428µs
Essai [1] : 5 occurrences de public, durée (FJ) 1439557µs
	
	   * On remarque que la version (poul Fork/Join) est rapide par rapport à la version séquentielle pendant les deux essais.
