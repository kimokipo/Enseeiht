with Ada.Strings.Unbounded; use Ada.Strings.Unbounded;

generic
    Capacite: Integer;
    -- type reel de precision quelconque
    type T_Element is digits <>;
    Alpha: T_Element;
    Iterations : integer; --Le nombre d'itérations de l'algorithme de calcul du poids des pages.
    Nom_Fichier : Unbounded_String; -- Le nom du fichier .net entré

Package Google_Creuse is
    type T_Colonne_Indice is array (1..Capacite) of Integer;
    type T_Colonne_Poids is array (1..Capacite) of T_Element;
    type T_Google is limited private;
    type T_Cellule is private;
    type T_Colonne is access T_Cellule;

    -- Executer l'algorithme PageRank
    procedure Pagerank_Creuse;

private



    type T_Cellule is
        record
            Indice : Integer;
            Valeur : T_Element;
            Suivant : T_Colonne;
            -- Invariant :
            --   Indice >= 1;
            --   Suivant = Null or else Suivant.all.Indice > Indice;
            --   les cellules sont stockés dans l'ordre croissant des indices.
        end record;

    type T_Google is array (1..Capacite)  of T_Colonne;
end Google_Creuse;
