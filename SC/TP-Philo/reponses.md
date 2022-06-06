Problème des philosophes
========================

Reponses

### Première approche : les fourchettes sont des ressources critiques 
=> associer un sémaphore à chacune des fourchettes

- Le fichier PhiloSem.java contient l'implantation de base, où tous les philosophes commencent par prendre leur 
fourchette de droite avant de prendre leur fourchette de gauche. 

- Aprés l'introduction d'une temporisation de 1s entre les prises de 
fourchette. L'interblocage est produit lorsque on augmente le temps d'exécution, il réside dans 
la demande de tous les philosophes à manger en mème temps.

- Le fichier PhiloSem_sol1.java contient l'implantation de la 1er solution : 
    Inverser le sens d'interblocage en obligeant le premier philosophe Numero : 0
     à commencer par prendre la fourchette de gauche avant la fourchette de droite.
     
- Le fichier PhiloSem_sol2.java contient l'implantation de la 2ème solution : 
    (N-1) philosophes ont le droit de demander en mème temps à manger, il est implanté 
     en introduisant un semaphore table initialisé à (N-1) où N est le nombre de philosophes.

### Seconde approche : contrôler la progression d'un philosophe en fonction de l'état de ses voisins.

=> Le fichier PhiloSem_sol3.java contient l'implantation de la seconde Approche, en introduisant : 
    La notion d'état des philosophes : un tableau d'états EtatPhilos.
    Sémaphore « privé » à chaque philosophe : Philos tableau des smaphores.
    Méthode peutManger(no) : où un philosophe ne peut manger que si aucun de ses voisins ne mange, 

Le degré de parallélisme de cette seconde approche est de N/2, Tandis que pour les deux différentes solutions de la première approche est 1.

#### Equité
Dans la seconde approche, il y a le risque de la famine d'un philosophe, l'image famine.jpg fournit montre un scénario qui l'a produit:
    En considérant 4 philosophes : 0, 1, 2, et 3, dans un premier temps, les philosophes 1 et 3 mangent et le philosophe 0 demande à manger mais il ne peut pas car ses voisins mangent, puis le 3ème philosophe termine de manger et pense, mais le 1er est toujours mangeant. Soudain le mème philosophe 3 décide de manger à nouveau et il mange car ses voisins 0 et 2 ne mangent pas, dans ce cas on voit que le philosophe 0 reste toujours sans nouriture. C'est la famine. 

Le fichier PhiloSem_sol4.java contient l'implantation de la solution d'equité, en introduisant une file d'attente fileDemandeurs, dans laquelle on ajoute l'idantifiant de philosophe qui demande, afin de guarantir que le demandeur le plus ancien est plus prioritère pour manger que les autres.


