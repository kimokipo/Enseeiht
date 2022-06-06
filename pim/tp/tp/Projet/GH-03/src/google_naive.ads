with Ada.Strings.Unbounded; use Ada.Strings.Unbounded;

generic
    Capacite: Integer;
    -- type reel de precision quelconque
    type T_Element is digits <>;
    Alpha: T_Element;
    Iterations : integer; --Le nombre d'itérations de l'algorithme de calcul du poids des pages.
    Nom_Fichier : Unbounded_String; -- Le nom du fichier .net entré

Package Google_Naive is
    type T_Colonne is array (1..Capacite) of T_Element;
    type T_Google is array (1..Capacite,1..Capacite)  of T_Element;
    type T_Colonne_Indice is array (1..Capacite) of Integer;

    -- Calculer les poids de l'itérations suivante
    function Calcul_Poids(H : in T_Google; Poids : in T_Colonne; Alpha : in T_Element) return T_Colonne;

    -- Executer l'algorithme PageRank
    procedure PageRank_Naive;

end Google_Naive;



