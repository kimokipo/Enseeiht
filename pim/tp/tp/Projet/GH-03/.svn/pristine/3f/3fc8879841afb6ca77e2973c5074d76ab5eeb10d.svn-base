
with Ada.Strings.Unbounded; use Ada.Strings.Unbounded;
with Google_Naive;
procedure test_google_naive is

    Capacite : constant Integer := 5;
    type Test is digits 5;
    package Google is new Google_Naive(Capacite => Capacite, T_Element => Test, Alpha => 0.0, Iterations => 150, Nom_Fichier => To_Unbounded_String(""));
    use Google;

    Matrice : T_Google;
    Colonne_Poids : T_Colonne;
    Colonne_Indice : T_Colonne_Indice;
    Indice : constant Integer := 1;



begin
    Initialiser(Matrice);
    pragma Assert(Lire(Matrice,4,4) =0.0);
    pragma Assert(Est_Nulle(Matrice));
    Affecter(Matrice,Indice,Indice,25.3);
    pragma Assert(Lire(Matrice,1,1) =25.3);

    for i in 1..Capacite loop
        Colonne_Indice(i) := i;
    end loop;
    Initialiser(Colonne_Poids);

    Affecter(Colonne_Poids,5, 3.0);
    Affecter(Colonne_Poids,3, 8.5);


    Tri(Colonne_Poids,Colonne_Indice);

    pragma Assert(Colonne_Indice(1) = 3);
    pragma Assert(Colonne_Indice(2) = 5);

end test_google_naive;
