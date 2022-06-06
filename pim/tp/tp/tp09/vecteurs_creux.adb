with Ada.Text_IO;                 use Ada.Text_IO;
with Ada.Integer_Text_IO;         use Ada.Integer_Text_IO;
with Ada.Float_Text_IO;           use Ada.Float_Text_IO;
with Ada.Unchecked_Deallocation;

package body Vecteurs_Creux is


   procedure Free is
     new Ada.Unchecked_Deallocation (T_Cellule, T_Vecteur_Creux);


   procedure Initialiser (V : out T_Vecteur_Creux) is
   begin
      V:=Null;	-- TODO : à changer
   end Initialiser;


   procedure Detruire (V: in out T_Vecteur_Creux) is
   begin
      if Est_Nul(V) then
         Null;
      else
         Detruire(V.all.Suivant);
         Free (V);-- TODO : à changer
      end if;
   end Detruire;


   function Est_Nul (V : in T_Vecteur_Creux) return Boolean is
   begin
      return 0=Nombre_Composantes_Non_Nulles(V);	-- TODO : à changer
   end Est_Nul;


   function Composante_Recursif (V : in T_Vecteur_Creux ; Indice : in Integer) return Float is
   begin
      if Est_Nul(V) then
         return 0.0;
      elsif V.all.Indice=Indice then
         return V.all.Valeur;
      else
         return Composante_Recursif(V.all.Suivant,Indice);
      end if;
   end Composante_Recursif;


   function Composante_Iteratif (V : in T_Vecteur_Creux ; Indice : in Integer) return Float is
      cursor : T_Vecteur_Creux;
   begin
      if V=Null then
         return 0.0;
      else
         cursor := V;
         while cursor /=Null and then cursor.all.Indice /= Indice loop
            cursor := cursor.all.Suivant;
         end loop;
         if cursor/=Null then
            return cursor.all.Valeur;
         else
            return 0.0;
         end if;
      end if;
   end Composante_Iteratif;


   procedure Modifier (V : in out T_Vecteur_Creux ;
                       Indice : in Integer ;
                       Valeur : in Float ) is

   begin
      if V=Null then
         V:=new T_Cellule'(Indice,Valeur,Null);
      else
         if V.all.Indice= Indice then
            V.all.Valeur := Valeur;
         else
            Modifier(V.all.Suivant,Indice,Valeur);
         end if;
      end if;
   end Modifier;


   function Sont_Egaux_Recursif (V1, V2 : in T_Vecteur_Creux) return Boolean is
   begin
      if V1=Null then
         if V2=Null then
            return True;
         else
            return False;
         end if;
      elsif V2=Null then
         return False;
      elsif V1.all.Indice=V2.all.Indice and then V1.all.Valeur=V2.all.Valeur then
         return Sont_Egaux_Recursif(V1.all.Suivant,V2.all.Suivant);
      elsif V1.all.Indice=V2.all.Indice then
         return False;
      else
         return Composante_Recursif(V1,V2.all.Indice)=V2.all.Valeur and Composante_Recursif(V2,V1.all.Indice)=V1.all.Valeur and Sont_Egaux_Recursif(V1.all.Suivant,V2.all.Suivant);
      end if;
   end Sont_Egaux_Recursif;


   function Sont_Egaux_Iteratif (V1, V2 : in T_Vecteur_Creux) return Boolean is
      cursor1 : T_Vecteur_Creux;
      cursor2: T_Vecteur_Creux;
   begin
      if V1=Null then
         if V2=Null then
            return True;
         else
            return False;
         end if;
      elsif V2=Null then
         return False;
      else
         cursor1:=V1;
         cursor2:=V2;
         while cursor1.all.Indice = cursor2.all.Indice and cursor1.all.Valeur = cursor2.all.Valeur loop
            cursor1 := cursor1.all.Suivant;
            cursor2 := cursor2.all.Suivant;
            if cursor1=Null then
               if cursor2=Null then
                  return True;
               else
                  return False;
               end if;
            elsif cursor2=Null then
               return False;
            end if;
         end loop;
         return False;
      end if;

   end Sont_Egaux_Iteratif;


   procedure Additionner (V1 : in out T_Vecteur_Creux; V2 : in T_Vecteur_Creux) is

   begin
      if V1=Null then
         if V2=Null then
            Null;
         else
            V1:= V2;
         end if;
      elsif V2=Null then
         Null;
      else

         if V1.all.Indice = V2.all.Indice then
            V1.all.Valeur := V1.all.Valeur + V2.all.Valeur;
         else
            Modifier(V1,V2.all.Indice,Composante_Recursif(V1,V2.all.Indice)+V2.all.Valeur);
         end if;
         Additionner(V1.all.Suivant,V2.All.Suivant);
      end if;

   end Additionner;


   function Norme2 (V : in T_Vecteur_Creux) return Float is
   begin
      if V = Null then
         return 0.0;
      else
         return (V.all.Valeur)**2 + Norme2 (V.all.Suivant);
      end if;
   end Norme2;


   Function Produit_Scalaire (V1, V2: in T_Vecteur_Creux) return Float is
   begin
      if V1=Null or V2=Null then
         return 0.0;
      elsif V1.all.Indice=V2.all.Indice then
         return V1.all.Valeur*V2.all.Valeur + Produit_Scalaire(V1.all.Suivant,V2.all.Suivant);
      else
         return Composante_Recursif(V1,V2.all.Indice)*V2.all.Valeur+Composante_Recursif(V2,V1.all.Indice)*V1.all.Valeur+Produit_Scalaire(V1.all.Suivant,V2.all.Suivant);
      end if;
   end Produit_Scalaire;


   procedure Afficher (V : T_Vecteur_Creux) is
   begin
      if V = Null then
         Put ("--E");
      else
         -- Afficher la composante V.all
         Put ("-->[ ");
         Put (V.all.Indice, 0);
         Put (" | ");
         Put (V.all.Valeur, Fore => 0, Aft => 1, Exp => 0);
         Put (" ]");

         -- Afficher les autres composantes
         Afficher (V.all.Suivant);
      end if;
   end Afficher;


   function Nombre_Composantes_Non_Nulles (V: in T_Vecteur_Creux) return Integer is
   begin
      if V = Null then
         return 0;
      elsif V.all.Valeur=0.0 then
         return Nombre_Composantes_Non_Nulles(V.all.Suivant);
      else
         return 1 + Nombre_Composantes_Non_Nulles (V.all.Suivant);
      end if;
   end Nombre_Composantes_Non_Nulles;


end Vecteurs_Creux;
