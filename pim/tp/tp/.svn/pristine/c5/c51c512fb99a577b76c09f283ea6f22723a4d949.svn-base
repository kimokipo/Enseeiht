with Ada.Text_IO;            use Ada.Text_IO;
with Ada.Unchecked_Deallocation;
with SDA_Exceptions; 		use SDA_Exceptions;
with LCA;
package body TH is


   procedure Initialiser(Sda: out T_TH) is

   begin
      for i in 1..Capacite loop
          Initialiser(Sda(i));  --Initialiser la LCA Sda(i).
      end loop;
   end Initialiser;


   function Est_Vide (Sda : T_TH) return Boolean is

   begin
      for i in 1..Capacite loop
         if not (Est_Vide(Sda(i))) then
            return False;    --Retourner False car on a une LCA qui n'est pas vide.
         end if;
      end loop;
      return True;  --Retourner True puique tous les LCA du tableau Sda sont vides.
   end Est_Vide;


   function Taille (Sda : in T_TH) return Integer is

      Taille:integer;  --Définir notre counteur.
   begin
      Taille:=0; --Initialiser Taille par 0.
      for i in 1..Capacite loop

            Taille:=Taille + LCA1.Taille(Sda(i));  --Incrementer Taille par la Taille de la LCA Sda(i).

      end loop;
      return Taille;   --Retourner la Taille.


   end Taille;


   procedure Enregistrer (Sda : in out T_TH ; Cle : in T_Cle ; Donnee : in T_Donnee) is
      reste : integer; --Le reste de la division entière de la valeure de hachage par la capacitée du tableau.
   begin
      reste:= Hacher(Cle) mod Capacite; --Calculer le reste
      if reste =0 then
         reste:=Capacite; --Affecter la capacite à reste puisque il est null et la position 0 n'éxiste pas dans le tableau.
      end if;
      Enregistrer(Sda(reste),Cle,Donnee);  --Enregistrer la clée Cle avec la donnée Donnee dans la LCA
   end Enregistrer;                                       --d'indice reste dans le tableau Sda.


   function Cle_Presente (Sda : in T_TH ; Cle : in T_Cle) return Boolean is

   begin
      for i in 1..Capacite loop
         if Cle_Presente(Sda(i),Cle) then
            return True;   --Retourner True puisque il y a une LCA qui contient la clée Cle.
         end if;
      end loop;
      return False;   --Retourner False car tous les LCA du tableau Sda ne contiennent pas la clée Cle.
   end Cle_Presente;


   function La_Donnee (Sda : in T_TH ; Cle : in T_Cle) return T_Donnee is

   begin
      for i in 1..Capacite loop
         begin
            return La_Donnee(Sda(i),Cle);  --Retourner la donnée sous la clée Cle s'il éxiste dans la LCA Sda(i)
         exception                         --sionon l'exception Cle_Absente_Exception est levée.
            when Cle_Absente_Exception => Null;  --Continuer à vouloir obtenir la donnée sous la clée Cle dans les LCA suivantes de Sda.
         end;
      end loop;
      raise Cle_Absente_Exception; --Lever l'exception Cle_Absente_Exception puisque tous les LCA de Sda ne contiennent pas la clée Cle.
   end La_Donnee;

   procedure Supprimer (Sda : in out T_TH ; Cle : in T_Cle) is

   begin
      if not(Cle_Presente(Sda,Cle)) then
         raise Cle_Absente_Exception; --Lever l'exception Cle_Absente_Exception puisque la clée Cle n'est pas présente dans Sda.
      end if;
      for i in 1..Capacite loop
         begin
            Supprimer(Sda(i),Cle);  --Supprimer la clée Cle dans la LCA Sda(i) s'il éxiste
         exception                  --sinon l'exception Cle_Absente_Exception est levée.
            when Cle_Absente_Exception => Null;  --Continuer à vouloir supprimer la clée Cle dans les LCA suivantes de Sda.
         end;
      end loop;

   end Supprimer;


   procedure Vider (Sda : in out T_TH) is
   begin

         for i in 1..Capacite loop
            Vider(Sda(i));  --Vider la LCA Sda(i).
         end loop;

   end Vider;


   procedure Pour_Chaque (Sda : in T_TH) is
      --Instantier la procédure de module LCA1 par la procédure Traiter.
      procedure Pour_Chaque is
        new LCA1.Pour_Chaque (Traiter);
   begin
      if Est_Vide(Sda) then
         null;  --Faire rien puisque le tableau Sda est vide.
      else
         for i in 1..Capacite loop
            begin
               if not Est_Vide(Sda(i)) then
                  Pour_Chaque(Sda(i));  --Appliquer le traitement sur les couples de la LCA Sda(i) non vide, s'il échoue une exception est levée.
               end if;
            exception
               when others => Null;  --Continuer à appliquer le traitement sur les couples des LCA suivantes.
            end;
         end loop;

      end if;
   end Pour_Chaque;


end TH;
