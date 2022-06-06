with Ada.Unchecked_Deallocation;
with Ada.Text_IO; Use Ada.Text_IO;
with Ada.Float_Text_IO; use Ada.Float_Text_IO;
with Ada.Integer_Text_IO; use Ada.Integer_Text_IO;
Package body Google_Creuse is

    procedure Free is
            new Ada.Unchecked_Deallocation (T_Cellule, T_Colonne);


    --Initilaiser un Vecteur des Flottants.
    Procedure Initialiser(Vecteur :out T_Colonne) is
    begin
        Vecteur := Null;
    end Initialiser;

    --Initilaiser une Matrice des Flottants.
    Procedure Initialiser(Matrice:out T_Google)
    is
    begin
        for i in 1..Capacite loop
            Initialiser(Matrice(i));
        end loop;
    end Initialiser;



    --Affecter une valeur au Vecteur
    Procedure Affecter(Vecteur : in out T_Colonne; i : in Integer; Valeur : in T_Element) is
        Curseur : T_Colonne;
    begin
        if Vecteur=Null then
            Vecteur := new T_Cellule'(i,Valeur,Null);
        elsif  Vecteur.all.Indice = i then
                Vecteur.all.Valeur := Valeur;
        elsif Vecteur.all.Indice > i then
            Curseur := Vecteur;
            Vecteur := new T_Cellule'(i,Valeur,Curseur);
        else
            Affecter(Vecteur.all.Suivant,i,Valeur);
        end if;
    End Affecter;

    --Affecter une valeur à la matrice
    Procedure Affecter(Matrice : in out T_Google; i : in Integer; j : in Integer; Valeur : in T_Element) is
    begin

        Affecter(Matrice(i),j,Valeur);
    end;

 --Affecter une valeur au Vecteur et compter le nombre de lignes non vides
    Procedure Affecter_Comptage(Vecteur : in out T_Colonne; j : in Integer; Taille_Lignes : in out T_Colonne_Indice) is
        Curseur : T_Colonne;
    begin
        if Vecteur=Null then
            Vecteur := new T_Cellule'(j,T_Element(1.0),Null);
            Taille_Lignes(j) := Taille_Lignes(j) +1;
        elsif  Vecteur.all.Indice = j then
            if Vecteur.all.Valeur = 0.0 then
                Taille_Lignes(j) := Taille_Lignes(j) +1;
            else
                null;
            end if;
                Vecteur.all.Valeur := T_Element(1.0);
        elsif Vecteur.all.Indice > j then
            Curseur := Vecteur;
            Vecteur := new T_Cellule'(j,T_Element(1.0),Curseur);
            Taille_Lignes(j) := Taille_Lignes(j) +1;
        else
            Affecter_Comptage(Vecteur.all.Suivant,j,Taille_Lignes);
        end if;
    End Affecter_Comptage;

    --Affecter une valeur à la matrice et compter le nombre de lignes non vides
    Procedure Affecter_Comptage(Matrice : in out T_Google; i : in Integer; j : in Integer;Taille_Lignes : in out T_Colonne_Indice) is
    begin

        Affecter_Comptage(Matrice(i),j,Taille_Lignes);
    end;

    procedure Vider(Vecteur : in out T_Colonne) is
    begin
        if Vecteur = null then
            null;
        elsif Vecteur.all.Suivant = null then
            Free(Vecteur);
        else
            Vider(Vecteur.all.Suivant);
            Free(Vecteur);
        end if;
    end Vider;

    procedure Vider (Matrice : in out T_Google) is
    begin
        for i in 1..Capacite loop
            Vider(Matrice(i));
        end loop;
    end Vider;

    --Trier les matrices des poids et des indices des paages selon le poid des pages
    Procedure Tri(Poids : in out T_Colonne_Poids; Indices : in out T_Colonne_Indice) is

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
                    Indice_Courant := Indice_Courant + 1;
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

    function Calcul_Poids(H : in T_Google; Poids : in T_Colonne_Poids; Alpha : in T_Element) return T_Colonne_Poids is
        Resultat : T_Colonne_Poids;
        Somme : T_Element;
        Curseur : T_Colonne; --Un pointeur qui permet de parcourir un colonne sans à avoir à recommencer à chaque itération.
    begin
        for i in 1..Capacite loop
            Somme := 0.0;
            Curseur := H(i);
            for j in 1..Capacite loop
                if Curseur = null then -- Si on arrive à la fin de la colonne et toutes les valeurs finales sont nulles.
                    Somme := Somme + Poids(j)*(T_Element(1.0)-Alpha)/T_Element(Float(Capacite));
                elsif Curseur.all.Indice = j then
                        Somme := Somme + Poids(j) * (Alpha*Curseur.all.Valeur+(T_Element(1.0)-Alpha)/T_Element(Float(Capacite)));
                        Curseur := Curseur.all.Suivant;
                elsif Curseur.all.Indice > j then
                    Somme := Somme + Poids(j)*(T_Element(1.0)-Alpha)/T_Element(Float(Capacite));
                else
                    null; -- Ne devrait pas se produire, l'indice du curseur sera plus grand que l'indice lu.
                    end if;
            end loop;
            Resultat(i) := Somme;
        end loop;
        return Resultat;
    end Calcul_Poids;


    procedure Pagerank_Creuse is
        H : T_Google;
        Poids : T_Colonne_Poids;
        Indices : T_Colonne_Indice;
        Taille_Lignes : T_Colonne_Indice; --Pour remplir au fur et à mesure quelles sont les tailles des différentes lignes.
        Nombre_buffer : Integer; -- Sert à lire le nombre d'elements pour acceder à la suite du fichier.
        Fichier : Ada.Text_IO.File_Type; --Le Fichier en cours de lecture écriture.
        Element1 : integer; -- Premier élément de chaque ligne du fichier .net
        Element2 : integer; -- Deuxième élément du fichier .net
        Nom_Ficher_p : Unbounded_String; -- Le nom du fichier.p
        Nom_Ficher_ord : Unbounded_String;-- Le nom du fichier.ord
        Curseur : T_Colonne; --Pour se deplacer dans la matrice quand in calcule S.
    begin
        --Calculer la matrice S
        Initialiser(H);

        open(Fichier, In_File,To_String(Nom_Fichier));
        Get(Fichier,Nombre_buffer);

        for i in 1..Capacite loop
            Taille_Lignes(i) := 0;
        end loop;


        while not end_of_File (Fichier) loop

            Get(Fichier,Element1 );

            Element1 := Element1 + 1; -- en Ada les indices commencent à 1

            Get(Fichier,Element2);

            Element2 := Element2 + 1; -- en Ada les indices commencent à 1

            Affecter_Comptage(H,Element2, Element1,Taille_Lignes);  -- La colonne à remplir est celle du deuxième élément, à la ligne du premier élément
        end loop;
        close(Fichier);





        -- Calculer la matrice H
        for  i in 1..Capacite loop
            Curseur := H(i);
            for  j in 1..Capacite loop -- Fonctionne grace à l'invariant "les indices d'une colonne sont dans l'ordre croissant"
                if Curseur = null and Taille_Lignes(j) = 0 then
                    Affecter(H,i,j,1.0/T_Element(Float(Capacite)));
                elsif Curseur = null then
                    null;
                elsif Curseur.Indice = j and Taille_Lignes(j) = 0 then
                    Curseur.Valeur := 1.0/T_Element(Float(Capacite));
                elsif Curseur.Indice = j then
                    Curseur.Valeur := Curseur.Valeur/T_Element(Float(Taille_Lignes(j)));
                    Curseur := Curseur.Suivant;
                elsif Curseur.Indice > j and Taille_Lignes(j) = 0 then
                    Affecter(H,i,j,1.0/T_Element(Float(Capacite)));
                else
                    null;
                end if;

            end loop;
        end loop;

        -- Initialiser les poids
        for i in 1..Capacite loop
            Poids(i) := T_Element(1.0)/T_Element(Float(Capacite));
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
        Vider(H);
        Vider(Curseur);

    end Pagerank_Creuse;




end google_creuse;
