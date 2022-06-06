with Ada.Text_IO;          use Ada.Text_IO;
with Ada.Integer_Text_IO;  use Ada.Integer_Text_IO;
with Ada.Command_Line;     use Ada.Command_Line;
with SDA_Exceptions;       use SDA_Exceptions;
with Alea;
with LCA;
-- Ã‰valuer la qualitÃ© du gÃ©nÃ©rateur alÃ©atoire et les SDA.
procedure Evaluer_Alea_LCA is


   -- Afficher l'usage.
   procedure Afficher_Usage is
   begin
      New_Line;
      Put_Line ("Usage : " & Command_Name & " Borne Taille");
      New_Line;
      Put_Line ("   Borne  : les nombres sont tirÃ©s dans l'intervalle 1..Borne");
      Put_Line ("   Taille : la taille de l'Ã©chantillon");
      New_Line;
   end Afficher_Usage;


   -- Afficher le Nom et la Valeur d'une variable.
   -- La Valeur est affichÃ©e sur la Largeur_Valeur prÃ©cisÃ©e.
   procedure Afficher_Variable (Nom: String; Valeur: in Integer; Largeur_Valeur: in Integer := 1) is
   begin
      Put (Nom);
      Put (" : ");
      Put (Valeur, Largeur_Valeur);
      New_Line;
   end Afficher_Variable;

   -- Ã‰valuer la qualitÃ© du gÃ©nÃ©rateur de nombre alÃ©atoire Alea sur un
   -- intervalle donnÃ© en calculant les frÃ©quences absolues minimales et
   -- maximales des entiers obtenus lors de plusieurs tirages alÃ©atoires.
   --
   -- ParamÃ¨tres :
   -- 	  Borne: in Entier	-- le nombre alÃ©atoire est dans 1..Borne
   -- 	  Taille: in Entier -- nombre de tirages (taille de l'Ã©chantillon)
   -- 	  Min, Max: out Entier -- frÃ©quence minimale et maximale
   --
   -- NÃ©cessite :
   --    Borne > 1
   --    Taille > 1
   --
   -- Assure : -- poscondition peu intÃ©ressante !
   --    0 <= Min Et Min <= Taille
   --    0 <= Max Et Max <= Taille
   --    Min + Max <= Taille
   --    Min <= Moyenne Et Moyenne <= Max
   --
   -- Remarque : On ne peut ni formaliser les 'vraies' postconditions,
   -- ni Ã©crire de programme de test car on ne maÃ®trise par le gÃ©nÃ©rateur
   -- alÃ©atoire.  Pour Ã©crire un programme de test, on pourrait remplacer
   -- le gÃ©nÃ©rateur par un gÃ©nÃ©rateur qui fournit une sÃ©quence connue
   -- d'entiers et pour laquelle on pourrait dÃ©terminer les donnÃ©es
   -- statistiques demandÃ©es.
   -- Ici, pour tester on peut afficher les nombres alÃ©atoires et refaire
   -- les calculs par ailleurs pour vÃ©rifier que le rÃ©sultat produit est
   -- le bon.
   procedure Calculer_Statistiques (
                                    Borne    : in Integer;  -- Borne supÃ©rieur de l'intervalle de recherche
                                    Taille   : in Integer;  -- Taille de l'Ã©chantillon
                                    Min, Max : out Integer  -- min et max des frÃ©quences de l'Ã©chantillon
                                   ) with
     Pre => Borne > 1 and Taille > 1,
     Post => 0 <= Min and Min <= Taille
     and 0 <= Max and Max <= Taille
     and Min + Max <= Taille
   is
      package Mon_Alea is
        new Alea (1, Borne);
      use Mon_Alea;

      package LCA_integer_integer is
        new LCA(integer,integer);
      use LCA_integer_integer;
      Number :integer; --Nombre généré entre 1 et Borne à chaque éteration.
      Sda:T_LCA;  --La Sda des nombres générés (Cle) et leurs frequences associées (Donnee).

      --Calculer le Max et le Min à partir de la frequence Donnee.
      procedure Comparer(Cle:in integer;Donnee:in integer) is

      begin
         if Donnee>Max then
               Max:=Donnee;    --Modifier la valeure de Max puisque Donnee est supérieure à lui.
         end if;
         if Donnee<Min then
            Min:=Donnee;    --Modifier la valeure de Min puisque Donnee est inférieure à lui.
         end if;
      end Comparer;

      --Calculer le Max et le Min à partir d'une Sda.
      procedure Comparer is
        new Pour_Chaque(Comparer);


   begin
      Initialiser(Sda);  --Initialiser Sda.
      --Générer et Enregistrer Taille nombres aléatoires (Cle) avec leurs fréquences associées (Donnee) dans Sda.
      for i in 1..Taille loop
         Get_Random_Number(Number);  --Générer le nombre Number entre 1 et Borne.
         if Cle_Presente(Sda,Number) then
            Enregistrer (Sda,Number,La_Donnee(Sda,Number)+1); --Enregistrer la clée Number avec la Donnée sa donnée +1
         else                                                    --puisque la clée Number est deja générée et présente dans Sda.
            Enregistrer(Sda,Number,1);     --Enregistrer la clée Number avec la Donnée 1
         end if;                           --puisque la clée Number générée est non présente dans Sda.
      end loop;

      Min:=Taille; --Initialiser Min par Taille.
      Max:=1; -- Initialiser Max par 1.
      Comparer(Sda);  --Calculer le Max et le Min à partir de Sda.

   end Calculer_Statistiques;


   Min, Max: Integer; -- frÃ©quence minimale et maximale d'un Ã©chantillon
   Borne: Integer;    -- les nombres alÃ©atoire sont tirÃ©s dans 1..Borne
   Taille: integer;   -- nombre de tirages alÃ©atoires
begin
   if Argument_Count /= 2 then
      Afficher_Usage;
   else
      -- RÃ©cupÃ©rer les arguments de la ligne de commande
      Borne := Integer'Value (Argument (1));
      Taille := Integer'Value (Argument (2));

      -- Afficher les valeur de Borne et Taille
      Afficher_Variable ("Borne ", Borne);
      Afficher_Variable ("Taille", Taille);

      Calculer_Statistiques (Borne, Taille, Min, Max);

      -- Afficher les frÃ©quence Min et Max
      Afficher_Variable ("Min", Min);
      Afficher_Variable ("Max", Max);
   end if;
exception
   when Constraint_Error => Afficher_Usage; --Afficher l'usage puisque l'exception Constraint_Error est levée.

end Evaluer_Alea_LCA;
