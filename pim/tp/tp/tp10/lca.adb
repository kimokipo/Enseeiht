with Ada.Text_IO;            use Ada.Text_IO;
with Ada.Unchecked_Deallocation;
with SDA_Exceptions; 		use SDA_Exceptions;
package body LCA is

   procedure Free is
     new Ada.Unchecked_Deallocation (Object => T_Cellule, Name => T_LCA);


   procedure Initialiser(Sda: out T_LCA) is
   begin
      Sda:=Null; --Initialiser la Sda par l'adresse Null.
   end Initialiser;


   function Est_Vide (Sda : T_LCA) return Boolean is
   begin
      return Sda=Null;  --V�rifier Sda est l'adresse Null.
   end Est_Vide;


   function Taille (Sda : in T_LCA) return Integer is
      cursor:T_LCA; --Variable cursor auxiliaire.
      Taille:integer:=0; --Notre counteur.
   begin
      cursor:=Sda;  --Initialiser cursor par Sda.
      while cursor/=null loop
         Taille:=Taille+1;   --Incrementer Taille puisque cursor est diff�rent de Null.
         cursor:=cursor.all.Suivant;  --Passer au pointeur suivant.
      end loop;
      return Taille; --Retourner la taille car on a parcouri toute notre Sda.
   end Taille;


   procedure Enregistrer (Sda : in out T_LCA ; Cle : in T_Cle ; Donnee : in T_Donnee) is

   begin
      if Sda=Null then
         Sda:=new T_Cellule'(Cle,Donnee,Null); -- Allouer une Cellule � Sda rempli par Cle Donnee et Null.
      else
         if Sda.all.Cle=Cle then
            Sda.all.Donnee:=Donnee;  --Actualiser la donn�e de Sda par Donnee puique sa cl�e est Cle.
         else
            Enregistrer(Sda.all.Suivant,Cle,Donnee); --Enregistrer Cle Donnee dans le pointeur suivant.
         end if;
      end if;
   end Enregistrer;


   function Cle_Presente (Sda : in T_LCA ; Cle : in T_Cle) return Boolean is

   begin

      if Sda=Null then
         return False;  --Retourner False car Sda est Null.
      else
         if Sda.all.Cle=Cle then
            return True; --Retourner True car la cl�e Cle est pr�sente.
         else
            return Cle_Presente(Sda.all.Suivant,Cle);  --Savoir si la cl�e Cle est pr�sente dans le pointeur suivant.
         end if;
      end if;
   end Cle_Presente;


   function La_Donnee (Sda : in T_LCA ; Cle : in T_Cle) return T_Donnee is
      cursor:T_LCA; --Variable cursor auxiliaire.
   begin
      cursor:=Sda; -- Initialiser cursor par Sda.
      while cursor /= Null and then cursor.all.Cle/=Cle loop
         cursor:=cursor.all.Suivant;  --Passer au pointeur suivant puisque la cl�e du cursor est diff�rent de Cle.
      end loop;
      if cursor/=Null then
         return cursor.all.Donnee; -- Rtourner la donn�e du cursor car la cl�e du cursor est bien Cle.
      end if;
      raise Cle_Absente_Exception;  --Lever l'exception Cle_Absente_Exception car la cl�e Cle n'est pas pr�sente dans Sda.
   end La_Donnee;

   procedure Supprimer (Sda : in out T_LCA ; Cle : in T_Cle) is
      cursor:T_LCA; --Variable cursor auxiliaire.

   begin
      if Sda=Null then
         raise Cle_Absente_Exception;     --Lever l'exception Cle_Absente_Exception car la cl�e Cle n'est pas pr�sente dans Sda
      else                                --puisque cette d�rni�re est Null.
         if Sda.all.Cle=Cle then
            cursor:=Sda;    --Affecter � cursor Sda.
            Sda:=Sda.all.Suivant;  --Passer au pointeur suivant de Sda.
            Free(cursor);    --Lib�rer cursor et donc Sda d'avant.
         else
            Supprimer(Sda.all.Suivant,Cle);  --Supprimer la cl�e Cle dans le pointeur suivant car elle est diff�rente de la cl�e de Sda.
         end if;
      end if;
   end Supprimer;


   procedure Vider (Sda : in out T_LCA) is
   begin
      if Est_Vide(Sda) then
         Null;   --Faire rien puisque Sda est vide.
      else
         Vider(Sda.all.Suivant);   --Vider le pointeur suivant.
         Free (Sda); --Lib�rer Sda .
      end if;
   end Vider;


   procedure Pour_Chaque (Sda : in T_LCA) is

   begin
      if Est_Vide(Sda) then
         null;   --Faire rien puisque Sda est vide.
      else
         begin     --Commencer un nouveau bolc puisue on peut avoir une exception.
            Traiter (Sda.all.Cle,Sda.all.Donnee); --Appliquer un traitement au couple (Cle,Donnee).
            Pour_Chaque(Sda.all.Suivant);  --Appliquer le traitement aux couples du pointeur suivant.
         exception
            when others =>
               Pour_Chaque(Sda.all.Suivant);     --Continuer � appliquer le traitement aux couples suivants
         end ;                                   --puisque une exception est lev�e due � l'�choue de traitement du couple actuel.
      end if;
   end Pour_Chaque;


end LCA;