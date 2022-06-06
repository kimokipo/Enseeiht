Transactions et mémoire transactionnelle
========================

Reponses

    3) Exemples et scénarios d’exécution:
       1) 
        Pour TMPP
       a) T2 tue T1 en 5) et T3 tue T2 en 7)
       b) T3 séexecute seul.
       c) x = 3 et ft3 = 1
        Pour TMPC
       a) T1 validé, T2 valide mais T3 abondonne.
       b) T1 T2.
       c) ft1 = 1, z = 2, ft2 = 1 et y = 1
        Pour TMP2PL
       a) T2 blocke T1 en 4) -> 5) et T3 blocke T2 en 6) -> 7)
       b) T3 T2 T1.
       c) x = 3, ft3 = 1, y = 1, z = 2, ft2 = 1, ft1 = 1
       
      2) 
        Pour TMPP
       a) T3 tue T2 en 7) et T1 tue T3 en 10)
       b) T1 séexecute seul.
       c) ft1 = 1
        Pour TMPC
       a) T1 validé, T2 valide mais T3 abondonne.
       b) T1 T2.
       c) ft1 = 1, z = 2, ft2 = 1 et y = 1
        Pour TMP2PL
       a) T3 blocke T2 en 6) -> 7), T2 blocke T1 en 4) -> 8) et T1 blocke T3 en 5) -> 10)
       b) S'executer jusqu'à 4) 
       c) y = 1
      3) 
        Pour TMNoCC
       a) T1 T2 et T3 validés
       b) T1 T2 T3.
       c) ft1 = 1, y = 1, z = 2, ft2 = 1, x = 3 et ft3 = 1
    4) Evaluation de protocoles
       1)        
                T1              T2              T3
                        
         1)                     write y
                                
         2)     read y
                
         3)                                     read z
                                                
         4)                     write z
                                
         5)     read x
                
         6)                     read x
                                                
         7)                                     write x
                                                
         8)     commit 
                                
         9)                     commit 
                                    
         10)                                    commit
                                            
       Pour TMPP
           a) T2 tue T1 en 2) et T3 tue T2 en 4)
           b) T3 séexecute seul.
       Pour TMPC
           a) T1 validé, T2 valide mais T3 abondonne.
           b) T1 T2.
       Pour TMP2PL
           a) T2 blocke T1 en 1) -> 2), T3 blocke T2 en 3) -> 4)
           b) T3 T2 T1 
       Pour TMNoCC
           a) T1 T2 et T3 validés
           b) T1 T2 T3.
           
      2) Le fichier scenarion4 contient le scénario permettant de caractériser la situation favorable pour la politique TMPP.
      -- Le fichier scenarion5 contient le scénario permettant de caractériser la situation favorable pour la politique TMNoCC
      
    5) Mise en œuvre des protocoles de controle de concurrence
       1) Protocole A :
          - Optimiste
          - N'assure pas la sérialisabilité
          - Propagation des valeurs immédiate
          - Ne présente pas un risque d’interblocage
          - Présente un risque de rejet en cascade
       -- Protocole B :
          - Pessimiste
          - Assure pas la sérialisabilité
          - Propagation des valeurs différée
          - Présente un risque d’interblocage
          - Ne présente pas un risque de rejet en cascade
       2) 
       -- Le scénario 0 met en evidence à la fois que le protocole TMPP est Optimiste alors que TMPC est Pessimiste. Cela réside dans l'étape 4) où T2 tue T1 quand il s'agit de TMPP pour éviter l'incohérence. Il montre que TMPC est serialisable puisque, l'exécution en série de T1 puis T2, mène au mème resultat. Tandis que pour TMPP, il n'y a aucun combinaison des Threads qui mène au mème resultat. La propagation différé de TMPC est observable dans la fin de l'éxecution du mème scenario 0, quand le Thread T3 a fait tous ses écritures, mais lorsque il a abandonné, tout reste inchangeable. Au contraire de TMPP où les écritures sont irréversibles. L'interblocage est abscent dans le protocole TMPP, puisque le Thread T2 a tué T3 qui a voulu le blocker. Mais ceci clarifie aussi que le rejet en cascade est présent pour ce protocole.
      
      -- Le fichier TM2PL.java contient l'implementation du protocole TM2PL.
