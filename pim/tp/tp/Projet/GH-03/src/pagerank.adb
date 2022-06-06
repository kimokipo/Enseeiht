with Ada.IO_Exceptions;
with Ada.Text_IO; use Ada.Text_IO;
with Ada.Integer_Text_IO; use Ada.Integer_Text_IO;
with Ada.Command_line; use Ada.Command_line;
with Ada.Strings.Unbounded; use Ada.Strings.Unbounded;
with Google_Naive;
with Google_Creuse;


procedure Pagerank is
    Pas_D_Argument_Erreur : Exception; --Erreur levée quand aucun ou de mauvais arguments sont rentrés dans le terminal
    Iterations_Negatif_Erreur : Exception; --Erreur levée quand le nombre d'itérations entré est négatif
    A_Hors_Borne_Erreur : Exception; -- Erreur levée quand alpha n'est pas dans l'interval [0,1]

    Precision : constant Integer := 6; --Précision des flottant de poids.
    Type T_Double is digits Precision; -- Le type des poids des pages.

    Alpha: T_Double := T_Double(0.85); --Le paramètre Alpha, initialisé par défaut à 0.85.
    Iterations : integer := 150; --Le nombre d'itérations de l'algorithme de calcul du poids des pages.
    Naive : boolean := False; -- Utilise-t-on l'implémentation naive (True) ou l'implémentation creuse (False) ?
    nombre_page : integer; -- Le nombre de pages dans le fichier .net
    Fichier : Ada.Text_IO.File_Type; --Le fichier en cours de lecture ou écriture.
    Nom_Fichier : Unbounded_String; -- Le nom du fichier .net entré





begin -- Utiliser l’algorithme PageRank sur un fichier *.net



    -- Lire et comprendre la commande
    if Argument_Count < 1 then
        raise Pas_D_Argument_Erreur;
    end if;



    --Extraire les arguments
    if Argument(1) = "-P" or Argument(1) = "-p" then
        Naive := True;
        if Argument(2) = "-I" or Argument(2) = "-i" then
            Iterations := Integer'Value(Argument(3));
            if Argument(4) = "-A" or Argument(4) = "-a" then
                Alpha := T_Double(Float'Value(Argument(5)));
                Nom_Fichier := To_Unbounded_String(Argument(6));
            else
                Nom_Fichier := To_Unbounded_String(Argument(4));
            end if;
        elsif Argument(2) = "-A" or Argument(2) = "-a" then
            Alpha := T_Double(Float'Value(Argument(3)));
            Nom_Fichier := To_Unbounded_String(Argument(4));
        else
            Nom_Fichier := To_Unbounded_String(Argument(2));
        end if;
    elsif Argument(1) = "-I" or Argument(1) = "-i" then
        Iterations := Integer'Value(Argument(2));
        if Argument(3) = "-A" or Argument(3) = "-a" then
            Alpha :=  T_Double(Float'Value(Argument(4)));
            Nom_Fichier := To_Unbounded_String(Argument(5));
        else
            Nom_Fichier := To_Unbounded_String(Argument(3));
        end if;
    elsif Argument(1) = "-A" or Argument(1) = "-a" then
        Alpha := T_Double(Float'Value(Argument(2)));
        Nom_Fichier := To_Unbounded_String(Argument(3));
    else
        Nom_Fichier := To_Unbounded_String(Argument(1));
    end if;



    -- Lever les exceptions nécessaires
    if Iterations < 0 then
        raise  Iterations_Negatif_Erreur;
    elsif  Alpha < 0.0 or Alpha > 1.0 then
        raise  A_Hors_Borne_Erreur;
    end if;



    open(Fichier, In_File,To_String(Nom_Fichier));
    Get(Fichier,nombre_page);
    close(Fichier);

    -- Charger le bon module
    declare
        package Google_Naive_Utilisation is new Google_Naive(Capacite => nombre_page, T_Element => T_Double, Alpha => Alpha, Iterations => Iterations, Nom_Fichier => Nom_Fichier);
        use Google_Naive_Utilisation;
        package Google_Creuse_Utilisation is new Google_Creuse(Capacite => nombre_page, T_Element => T_Double, Alpha => Alpha, Iterations => Iterations, Nom_Fichier => Nom_Fichier);
        use Google_Creuse_Utilisation;
    begin

        if Naive then
            Pagerank_Naive;
        else
            Pagerank_Creuse;
        end if;
    end;


    -- Gérer les exceptions
Exception
    when Pas_D_Argument_Erreur => put( "Aucun argument n’a été rentré");
    when Iterations_Negatif_Erreur => put( "Le nombre d’itération doit être positif");
    when A_Hors_Borne_Erreur => put("Alpha doit être dans [0,1]");
    when ADA.IO_EXCEPTIONS.NAME_ERROR => put("Le nom du fichier donné est incorrect ou le fichier n’est pas présent");
    when CONSTRAINT_ERROR => put("I doit être un entier et alpha un nombre flottant");
    when STORAGE_ERROR => put("Il y a trop peu de mémoire alouée au programme");
end Pagerank;



