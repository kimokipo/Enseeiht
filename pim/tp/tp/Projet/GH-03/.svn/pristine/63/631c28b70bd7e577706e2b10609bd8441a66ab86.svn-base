with Ada.Text_IO; use Ada.Text_IO;
with Ada.Float_Text_IO; use Ada.Float_Text_IO;
with Ada.Integer_Text_IO; use Ada.Integer_Text_IO;

Package body Google_Naive is

    --Initialiser une Matrice des Flottants.
    Procedure Initialiser(Matrice:out T_Google) is
    begin
        for i in 1..Capacite loop
            for j in 1..Capacite loop
                Matrice(i,j) := 0.0;
            end loop;
        end loop;
    end Initialiser;



    --Trier les matrices des poids et des indices des paages selon le poid des pages
    Procedure Tri(Poids : in out T_Colonne; Indices : in out T_Colonne_Indice) is

        Procedure Echanger(Gauche, Droite : Integer) is
            Temp_Poids : constant T_Element := Poids(Gauche);
            Temp_Indices : constant Integer := Indices(Gauche);
        begin
            Poids(Gauche) := Poids(Droite);
            Indices(Gauche) := Indices(Droite);
            Poids(Droite) := Temp_Poids;
            Indices(Droite) := Temp_Indices;
        end Echanger;

        Procedure Partition (Gauche : in Integer; Droite : in Integer; Milieu : out Integer) is
            Pivot : T_Element;
            Indice_Courant : Integer;
        begin
            Pivot := Poids(Droite);
            Indice_Courant := Gauche;
            for i in Gauche..Droite loop
                if Poids(i) > Pivot then
                    Echanger(Indice_Courant, i);
                    Indice_Courant := Indice_Courant +1;
                else
                    null;
                end if;
            end loop;
            Echanger (Indice_Courant, Droite);
            Milieu := Indice_Courant;
        end Partition;

        procedure Tri_Rapide (Gauche : in Integer; Droite : in Integer) is
            Pivot : Integer;
        begin

            if Gauche < Droite then
                Partition(Gauche, Droite, Pivot);
                Tri_Rapide(Gauche, Pivot-1);
                Tri_Rapide(Pivot+1, Droite);
            else
                null;
            end if;
        end Tri_Rapide;

    begin
        Tri_Rapide(1, Capacite);
    end Tri;

    function Calcul_Poids(H : in T_Google; Poids : in T_Colonne; Alpha : in T_Element) return T_Colonne is
        Resultat : T_Colonne;
        Somme : T_Element;
    begin
        for i in 1..Capacite loop
            Somme := 0.0;
            for j in 1..Capacite loop
                Somme := Somme + Poids(j) * (Alpha*H(j,i)+(1.0-Alpha)/T_Element(Float(Capacite)));
            end loop;
            Resultat(i) := Somme;
        end loop;

        return Resultat;
    end Calcul_Poids;




    procedure Pagerank_Naive is -- Si l'argume -P a été entré

        H : T_Google;
        Poids : T_Colonne;
        Indices : T_Colonne_Indice;
        Nombre_buffer : Integer; -- Sert à lire le nombre d'elements pour acceder ) la suite du fichier
        Fichier : Ada.Text_IO.File_Type; --Le Fichier en cosurs de lecture écriture.
        Element1 : integer; -- Premier élément de chaque ligne du fichier .net
        Element2 : integer; -- Deuxième élément du fichier .net
        Taille_Ligne : integer; -- Le nombre de pages ie la taille des lignes de la matrice G
        Nom_Ficher_p : Unbounded_String; -- Le nom du fichier.p
        Nom_Ficher_ord : Unbounded_String;-- Le nom du fichier.ord

    begin
        --Calculer la matrice S à partir des éléments du fichier.net
        Initialiser(H);

        open(Fichier, In_File,To_String(Nom_Fichier));
        Get(Fichier,Nombre_buffer);

        --Lire les éléments du fichier
        while not end_of_File (Fichier) loop
            Get(Fichier,Element1);
            Element1 := Element1 + 1; -- en Ada les indices commencent à 1
            Get(Fichier,Element2);
            Element2 := Element2 + 1; -- en Ada les indices commencent à 1
            H(Element1, Element2) := 1.0;
        end loop;
        close(Fichier);

        -- Calculer la matrice S
        for  i in 1..Capacite loop
            Taille_Ligne := 0;
            for  j in 1..Capacite loop
                if H(i,j) = 1.0 then
                    Taille_Ligne  := Taille_Ligne  + 1;
                else
                    null;
                end if;
            end loop;
            if Taille_Ligne /= 0 then
                for  j in 1..Capacite loop
                    H(i,j) := H(i,j)/T_Element(Float((Taille_Ligne)));
                end loop;
            else
                for  j in 1..Capacite loop
                    H(i,j) := 1.0/T_Element(Float(Capacite));
                end loop;
            end if;
        end loop;

        for i in 1..Capacite loop
            Poids(i) := 1.0/T_Element(Float(Capacite));
        end loop;

        for indice in 1..Iterations loop --indice de boucle inutile dans le calcul.
            --Calculer le poids des pages
            Poids := Calcul_Poids(H,Poids,Alpha);
        end loop;

        --Créer une matrice d'indices des poids
        for i in 0..(Capacite-1) loop
            Indices(i+1) := i;
        end loop;

        --Trier dans l'ordre décroissant les poids des pages et leur indice
        Tri(Poids,Indices);

        --Générer les fichiers
        --Enlever le .net du nom du fichier et créer une copie en .ord et une en .p
        Nom_Ficher_p := To_Unbounded_String(To_String(Nom_Fichier)(1..(length(Nom_Fichier)-4)));
        Append(Nom_Ficher_p,".p");
        Nom_Ficher_ord :=To_Unbounded_String(To_String(Nom_Fichier)(1..(length(Nom_Fichier)-4)));
        Append(Nom_Ficher_ord,".ord");


        --Remplir le fichier .ord
        Open(Fichier,Out_File,To_String(Nom_Ficher_ord));
        for i in 1..Capacite loop
            Put(Fichier,Indices(i),1);
            New_Line(Fichier);
        end loop;
        close(Fichier);

        --Remplir le fichier .p
        Open(Fichier,Out_File,To_String(Nom_Ficher_p));
        Put(Fichier,Capacite,1);
        Put(Fichier,' ');
        Put(Fichier,Float(Alpha));
        Put(Fichier,' ');
        Put(Fichier,Iterations,1);
        New_Line(Fichier);
        for i in 1..Capacite loop
            Put(Fichier,Float(Poids(i)));
            New_Line(Fichier);
        end loop;
        close(Fichier);

    end Pagerank_Naive;



end Google_Naive;
