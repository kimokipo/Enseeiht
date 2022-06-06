
-- Auteur: 
-- Gérer un stock de matériel informatique.

package Stocks_Materiel is


    CAPACITE : constant Integer := 10;      -- nombre maximum de matériels dans un stock

    type T_Nature is (UNITE_CENTRALE, DISQUE, ECRAN, CLAVIER, IMPRIMANTE);
   type T_Etat is (Fonctionne,Panne); 
   type T_Mate is 
             record
                Numero_Serie : integer;
                Nature : T_Nature;
                Annee_Achat : integer;
                Etat : T_Etat;
                -- Invariant
                --    Annee_Achat > 0
             end record;
    
    type T_Stock is limited private;


    -- Créer un stock vide.
    --
    -- paramètres
    --     Stock : le stock à créer
    --
    -- Assure
    --     Nb_Materiels (Stock) = 0
    --
    procedure Creer (Stock : out T_Stock) with
        Post => Nb_Materiels (Stock) = 0;


    -- Obtenir le nombre de matériels dans le stock Stock.
    --
    -- Paramètres
    --    Stock : le stock dont ont veut obtenir la taille
    --
    -- Nécessite
    --     Vrai
    --
    -- Assure
    --     Résultat >= 0 Et Résultat <= CAPACITE
    --
    function Nb_Materiels (Stock: in T_Stock) return Integer with
        Post => Nb_Materiels'Result >= 0 and Nb_Materiels'Result <= CAPACITE;


    -- Enregistrer un nouveau métériel dans le stock.  Il est en
    -- fonctionnement.  Le stock ne doit pas être plein.
    -- 
    -- Paramètres
    --    Stock : le stock à compléter
    --    Numero_Serie : le numéro de série du nouveau matériel
    --    Nature       : la nature du nouveau matériel
    --    Annee_Achat  : l'année d'achat du nouveau matériel
    -- 
    -- Nécessite
    --    Nb_Materiels (Stock) < CAPACITE
    -- 
    -- Assure
    --    Nouveau matériel ajouté
    --    Nb_Materiels (Stock) = Nb_Materiels (Stock)'Avant + 1
    procedure Enregistrer (
            Stock        : in out T_Stock;
            Numero_Serie : in     Integer;
            Nature       : in     T_Nature;
            Annee_Achat  : in     Integer
        ) with
            Pre => Nb_Materiels (Stock) < CAPACITE,

           Post => Nb_Materiels (Stock) = Nb_Materiels (Stock)'Old + 1;
   function Nb_Mat_Panne(Stock: in T_Stock) return integer with 
     Post => Nb_Mat_Panne'Result <= CAPACITE;
   Procedure mise_a_jour(Stock: in out T_Stock;Numero_Serie : in     Integer; Etat : in T_Etat) ;
   procedure supprimer(Stock: in out T_Stock;Numero_Serie : in Integer);
   
   procedure afficher (Stock: in T_Stock);
   
   procedure supprimer_panne(Stock: in out T_Stock);
              
private   
        type T_Tableau is array (1..Capacite) of T_Mate;
        
        
        type T_Stock is 
        record
         Tab : T_Tableau;
         Taille:integer;
        end record;
end Stocks_Materiel;
