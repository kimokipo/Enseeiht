with Ada.IO_Exceptions;
with Ada.Text_IO; use Ada.Text_IO;
with Ada.Float_Text_IO; use Ada.Float_Text_IO;
with Ada.Integer_Text_IO; use Ada.Integer_Text_IO;
with Ada.Command_line; use Ada.Command_line;
with Ada.Strings.Unbounded;
with Google_Naive;

procedure PageRank is

   type Mon_Double is digits 7;

   package SU renames Ada.Strings.Unbounded;
   use SU;
   -- descripteur de fichier texte (Ada.Text_IO)
   File : Ada.Text_IO.File_Type;
   Nbr_Totale: Integer;
   Page_Source: Integer;
   Page_referencie: Integer;
   Nom_fichier: SU.Unbounded_String;

   procedure PageRank_Naive is
      Nbr_Totale : Integer;
       
      -- determiner le nombre totale des pages du reseau
      Procedure Nombre_Totale is
      begin
         put("lik1");
         open(File,In_File,Argument(4));
         put("lik2");
         Get(File,Nbr_Totale);
         put(Nbr_Totale);
         close(File);
      end Nombre_Totale;
      Package GGN is new Google_Naive(capacite => Nbr_Totale,T_Element => Mon_Double);
      use GGN;

      --Calculer la matrice S qui sert à calculer la matrice google

      Procedure Matrice_S(S : in out T_Matrice) is
         Source, Ref : Integer;
      begin
         Initialiser_M(S);
         open(File,In_File,Argument(4));
         Get(File,Nbr_Totale);
         put(Nbr_Totale);
         while Not End_Of_File(File) loop
            Get(File,Page_Source);
            Source := Page_Source+1;
            put(Source);
            Get(File,Page_referencie);
            Ref := Page_referencie+1;
            put(Ref);
            put("lik4");
            Modifier_M(S,Source,Ref,Mon_Double(1));
            put("lik5");
         end loop;
         Close(File);
         for i in 1..Nbr_Totale loop
            if Somme_M_Ligne(S,i) = Mon_Double(0.0) then
               Modifier_M_Ligne(S,i,Mon_Double(1)/Mon_Double(Nbr_Totale));
            else
               Produit_M_Ligne(S,i,Mon_Double(1)/Somme_M_Ligne(S,i));
            end if;
         end loop;
      exception
         when ADA.IO_EXCEPTIONS.NAME_ERROR =>
            Put_line("Fichier non present - donner le nom d'un fichier en argument");
      end Matrice_S;

      -- Calculer la matrice google
      Procedure Google(S : in out T_Matrice) is
      begin
         if (Argument(3) = "-a") or  (Argument(3) = "-A") then
            Matrice_Google_M(S,Mon_Double(0.85));
         else
            Matrice_Google_M(S,Mon_Double'Value(Argument(3)));
         end if;
      end Google;


      --calculer le poids des pages
      procedure Poids_Pages(V : in out T_Vecteur;S : in T_Matrice) is
      begin
         -- initialiser le vecteur poids a l'itération 0
         V := Constant_V(Mon_Double(1)/Mon_Double(Nbr_Totale));
         if Argument(2) = "-I" or Argument(2) = "-i" then
            for i in 1..150 loop
               Produit_Matrice_Vecteur_M(V, Transposer(S));
            end loop;
         else
            for i in 1..Integer'Value(Argument(2)) loop
               Produit_Matrice_Vecteur_M(V,Transposer(S));
            end loop;
         end if;
      end Poids_Pages;

      -- trier le vecteur des poids en conservant les indices initialles de ses elements
      -- et stocker les poids trier dans une fichier texte reseau.p et les indices dans une autre reseau.ord
      procedure Creation_Fichiers(V: in out T_Vecteur; W : in out T_Vecteur) is
         Nom_fichier_1,Nom_fichier_2 : Unbounded_String;
      begin
         Trier_Vecteur(V,W);
         -- On cree le nom du fichier en concaténant le 4emr argument avec ".p"
         Nom_fichier_1 := To_Unbounded_String(argument(4));
         append(Nom_fichier_1, ".p");
         Create(File, Out_File, To_String(Nom_fichier));
         Close(File);
         -- Re_ouverture de fichier pour y ecrire les poids
         open(File,Append_File,To_String(Nom_fichier_1));
         for i in 1..Nbr_Totale loop
            put(File,Float(Composante(V,i)));
            New_line(File);
         end loop;
         Close(File);

         Nom_fichier_2 := To_Unbounded_String(argument(4));
         append(Nom_fichier_2, ".ord");
         Create(File, Out_File, To_String(Nom_fichier_2));
         Close(File);
         -- Re_ouverture de fichier pour y ecrire les poids
         open(File,Append_File,To_String(Nom_fichier_2));
         for i in 1..Nbr_Totale loop
            put(File,Float(Composante(W,i)));
            New_line(File);
         end loop;
         Close(File);
      end Creation_Fichiers;
      S : T_Matrice;
      V,W : T_Vecteur; 
   begin
      Nombre_Totale;
      Matrice_S(S);
      Google(S);
      Poids_Pages(V, S);
      Creation_Fichiers(V,W);
   end PageRank_Naive;

begin
   --put("lik0");
   PageRank_Naive;
   
end PageRank;






















