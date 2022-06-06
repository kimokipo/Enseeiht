
-- Auteur: 
-- GÃ©rer un stock de matÃ©riel informatique.

package Stocks_Materiel is


    CAPACITE : constant Integer := 10;      -- nombre maximum de matÃ©riels dans un stock

    type T_Nature is (UNITE_CENTRALE, DISQUE, ECRAN, CLAVIER, IMPRIMANTE);


    type T_Stock is limited private;


    -- CrÃ©er un stock vide.
    --
    -- paramÃ¨tres
    --     Stock : le stock Ã  crÃ©er
    --
    -- Assure
    --     Nb_Materiels (Stock) = 0
    --
    procedure Creer (Stock : out T_Stock) with
        Post => Nb_Materiels (Stock) = 0;


    -- Obtenir le nombre de matÃ©riels dans le stock Stock.
    --
    -- ParamÃ¨tres
    --    Stock : le stock dont ont veut obtenir la taille
    --
    -- NÃ©cessite
    --     Vrai
    --
    -- Assure
    --     RÃ©sultat >= 0 Et RÃ©sultat <= CAPACITE
    --
    function Nb_Materiels (Stock: in T_Stock) return Integer with
        Post => Nb_Materiels'Result >= 0 and Nb_Materiels'Result <= CAPACITE;


    -- Enregistrer un nouveau mÃ©tÃ©riel dans le stock.  Il est en
    -- fonctionnement.  Le stock ne doit pas Ãªtre plein.
    -- 
    -- ParamÃ¨tres
    --    Stock : le stock Ã  complÃ©ter
    --    Numero_Serie : le numÃ©ro de sÃ©rie du nouveau matÃ©riel
    --    Nature       : la nature du nouveau matÃ©riel
    --    Annee_Achat  : l'annÃ©e d'achat du nouveau matÃ©riel
    -- 
    -- NÃ©cessite
    --    Nb_Materiels (Stock) < CAPACITE
    -- 
    -- Assure
    --    Nouveau matÃ©riel ajoutÃ©
    --    Nb_Materiels (Stock) = Nb_Materiels (Stock)'Avant + 1
    procedure Enregistrer (
            Stock        : in out T_Stock;
            Numero_Serie : in     Integer;
            Nature       : in     T_Nature;
            Annee_Achat  : in     Integer
        ) with
            Pre => Nb_Materiels (Stock) < CAPACITE,
            Post => Nb_Materiels (Stock) = Nb_Materiels (Stock)'Old + 1;
private
        type T_Stock is array (1..Capacite) of T_Mate
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
end Stocks_Materiel;
