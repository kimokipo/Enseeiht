with Ada.Text_IO;       use Ada.Text_IO;
with Ada.Float_Text_IO; use Ada.Float_Text_IO;
with Vecteurs_Creux;    use Vecteurs_Creux;

-- Exemple d'utilisation des vecteurs creux.
procedure Exemple_Vecteurs_Creux is
   n:float;
   V : T_Vecteur_Creux;
   Epsilon: constant Float := 1.0e-5;
begin
   Put_Line ("Début du scénario");
   Initialiser(V);
   Afficher(V);
   New_Line;
   pragma Assert (Est_Nul(V));
   Detruire(V);
   pragma Assert(Nombre_Composantes_Non_Nulles(V)=0);
   pragma Assert(Norme2(V)=0.0);
   pragma Assert(Composante_Iteratif(V,18)=0.0);
   pragma Assert(Composante_Recursif(V,18)=0.0);
   Modifier(V,16,7.0);
   pragma Assert(Composante_Iteratif(V,16)=7.0);
   Modifier(V,15,8.0);
   pragma Assert(Composante_Iteratif(V,15)=8.0);
   pragma Assert(Norme2(V)=Produit_Scalaire(V,V));
   n:= Norme2(V);
   Additionner(V,V);
   pragma Assert(Norme2(V)=4.0*n);
   pragma Assert(Sont_Egaux_Iteratif(V,V));
   pragma Assert(Sont_Egaux_Recursif(V,V));
   Detruire(V);
   Put_Line ("Fin du scénario");

end Exemple_Vecteurs_Creux;