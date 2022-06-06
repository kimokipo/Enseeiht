with Ada.Text_IO;           use Ada.Text_IO;
with Ada.Integer_Text_IO;   use Ada.Integer_Text_IO;
with Ada.Strings.Unbounded; use Ada.Strings.Unbounded;
with LCA;
procedure lca_sujet is
   package LCA_String_Integer is
     new LCA (T_Cle => Unbounded_String, T_Donnee => Integer);
   use LCA_String_Integer;
   -- Retourner une chaÃ®ne avec des guillemets autour de S
   function Avec_Guillemets (S: Unbounded_String) return String is
   begin
      return '"' & To_String (S) & '"';
   end;

   -- Utiliser & entre String Ã  gauche et Unbounded_String Ã  droite.  Des
   -- guillemets sont ajoutÃ©es autour de la Unbounded_String
   -- Il s'agit d'un masquage de l'opÃ©rteur & dÃ©fini dans Strings.Unbounded
   function "&" (Left: String; Right: Unbounded_String) return String is
   begin
      return Left & Avec_Guillemets (Right);
   end;


   -- Surcharge l'opÃ©rateur unaire "+" pour convertir une String
   -- en Unbounded_String.
   -- Cette astuce permet de simplifier l'initialisation
   -- de cles un peu plus loin.
   function "+" (Item : in String) return Unbounded_String
               renames To_Unbounded_String;


   -- Afficher une Unbounded_String et un entier.
   procedure Afficher (S : in Unbounded_String; N: in Integer) is
   begin
      Put (Avec_Guillemets (S));
      Put (" : ");
      Put (N, 1);
      New_Line;
   end Afficher;
   -- Afficher la Sda.
   procedure Afficher is
     new Pour_Chaque (Afficher);
   LCA: T_LCA; -- Définir notre LCA.
begin
   --Initialiser LCA.
   Initialiser(LCA);
   --Vérifier que LCA est vide.
   pragma Assert (Est_Vide(LCA));
   --Enregistrer la donnée 1 sous la clée "un" dans LCA.
   Enregistrer (LCA,To_Unbounded_String("un"),1);
   --Vérifier que la clée "un" est présente dans LCA.
   pragma Assert (Cle_Presente(LCA,+("un")));
   --Vérifier que la donnée 1 est sous la clée "un" dans LCA.
   pragma Assert (La_Donnee(LCA,+("un"))=1);
   --Enregistrer la donnée 2 sous la clée "deux" dans LCA.
   Enregistrer (LCA,To_Unbounded_String("deux"),2);
   --Vérifier que la clée "deux" est présente dans LCA.
   pragma Assert (Cle_Presente(LCA,+("deux")));
   --Vérifier que la donnée 2 est sous la clée "deux" dans LCA.
   pragma Assert (La_Donnee(LCA,+("deux"))=2);
   --Afficher LCA.
   Afficher(LCA);
   --Vider LCA.
   Vider(LCA);
end lca_sujet;
