with Ada.Text_IO;           use Ada.Text_IO;
with Ada.Integer_Text_IO;   use Ada.Integer_Text_IO;
with Ada.Strings.Unbounded; use Ada.Strings.Unbounded;
with TH;
procedure th_sujet is
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
   --Déterminer la longueure de la clée S.
   function Hacher_string(S: Unbounded_String) return integer is
   begin
      return Length(S) ; --Retourner la longueure de la clée S.
   end Hacher_string;
   package TH_String_Integer is
     new TH (Capacite=>11, T_Cle => Unbounded_String, T_Donnee => Integer,Hacher=> Hacher_string);
   use TH_String_Integer;
   --Afficher la Sda.
   procedure Afficher is
     new Pour_Chaque (Afficher);

   TH : T_TH; --Définir notre TH.
begin
   --Initialiser TH.
   Initialiser(TH);
   --Vérifier que TH est vide.
   pragma Assert (Est_Vide(TH));
   --Enregistrer la donnée 1 sous la clée "un" dans TH.
   Enregistrer (TH,To_Unbounded_String("un"),1);
   --Vérifier que la clée "un" est présente dans TH.
   pragma Assert (Cle_Presente(TH,+("un")));
   --Vérifier que la donnée 1 est sous la clée "un" dans TH.
   pragma Assert (La_Donnee(TH,+("un"))=1);
   --Enregistrer la donnée 2 sous la clée "deux" dans TH.
   Enregistrer (TH,To_Unbounded_String("deux"),2);
   --Vérifier que la clée "deux" est présente dans TH.
   pragma Assert (Cle_Presente(TH,+("deux")));
   --Vérifier que la donnée 2 est sous la clée "deux" dans TH.
   pragma Assert (La_Donnee(TH,+("deux"))=2);
   --Enregistrer la donnée 3 sous la clée "trois" dans TH.
   Enregistrer (TH,+("trois"),3);
   --Vérifier que la clée "trois" est présente dans TH.
   pragma Assert (Cle_Presente(TH,+("trois")));
   --Vérifier que la donnée 3 est sous la clée "trois" dans TH.
   pragma Assert (La_Donnee(TH,+("trois"))=3);
   --Enregistrer la donnée 4 sous la clée "quatre" dans TH.
   Enregistrer(TH,+("quatre"),4);
   --Vérifier que la clée "quatre" est présente dans TH.
   pragma Assert (Cle_Presente(TH,+("quatre")));
   --Vérifier que la donnée 4 est sous la clée "quatre" dans TH.
   pragma Assert (La_Donnee(TH,+("quatre"))=4);
   --Enregistrer la donnée 5 sous la clée "cinq" dans TH.
   Enregistrer (TH,+("cinq"),5);
   --Vérifier que la clée "cinq" est présente dans TH.
   pragma Assert (Cle_Presente(TH,+("cinq")));
   --Vérifier que la donnée 5 est sous la clée "cinq" dans TH.
   pragma Assert (La_Donnee(TH,+("cinq"))=5);
   --Enregistrer la donnée 99 sous la clée "quatre-vingt-dix-neuf" dans TH.
   Enregistrer(TH,+("quatre-vingt-dix-neuf"),99);
   --Vérifier que la clée "quatre-vingt-dix-neuf" est présente dans TH.
   pragma Assert (Cle_Presente(TH,+("quatre-vingt-dix-neuf")));
   --Vérifier que la donnée 99 est sous la clée "quatre-vingt-dix-neuf" dans TH.
   pragma Assert (La_Donnee(TH,+("quatre-vingt-dix-neuf"))=99);
   --Enregistrer la donnée 21 sous la clée "vingt-et-un" dans TH.
   Enregistrer (TH,+("vingt-et-un"),21);
   --Vérifier que la clée "vingt-et-un" est présente dans TH.
   pragma Assert (Cle_Presente(TH,+("vingt-et-un")));
   --Vérifier que la donnée 21 est sous la clée "vingt-et-un" dans TH.
   pragma Assert (La_Donnee(TH,+("vingt-et-un"))=21);
   --Afficher TH.
   Afficher(TH);
   --Vider TH.
   Vider(TH);
end th_sujet;
