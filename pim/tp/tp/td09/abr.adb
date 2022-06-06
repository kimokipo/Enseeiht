with SDA_Exceptions;         use SDA_Exceptions;
with Ada.Unchecked_Deallocation;

package body ABR is

   procedure Free is
     new Ada.Unchecked_Deallocation (Object => T_Noeud, Name => T_ABR);


   procedure Initialiser(Sda: out T_ABR) is
   begin
      Sda:=Null;
   end Initialiser;


   function Est_Vide (Sda : T_ABR) return Boolean is
   begin
      return Sda=Null;	-- TODO : à changer
   end Est_Vide;


   function Taille (Sda : in T_ABR) return Integer is
   begin
      if Est_Vide(Sda) then
         return 0;
      else
         return 1+Taille(Sda.all.Sous_Arbre_Gauche)+Taille(Sda.all.Sous_Arbre_Droit);
      end if;
   end Taille;


   procedure Enregistrer (Sda : in out T_ABR ; Cle : in T_Cle ; Donnee : in T_Donnee) is
   begin
      if Est_Vide(Sda) then
         Sda:=new T_Noeud'(Cle,Donnee,Null,Null);
      else
         if Sda.all.Cle=Cle then
            Sda.all.Donnee:=Donnee;
         elsif Cle < Sda.all.Cle then
            Enregistrer(Sda.all.Sous_Arbre_Gauche,Cle,Donnee);
         else
            Enregistrer(Sda.all.Sous_Arbre_Droit,Cle,Donnee);
         end if;
      end if;
   end Enregistrer;


   function La_Donnee (Sda : in T_ABR ; Cle : in T_Cle) return T_Donnee is
   begin
      if Est_Vide(Sda) then
         raise Cle_Absente_Exception;
      else
         if Sda.all.Cle=Cle then
            return Sda.all.Donnee;
         elsif Cle < Sda.all.Cle then
            return La_Donnee(Sda.all.Sous_Arbre_Gauche,Cle);
         else
            return La_Donnee(Sda.all.Sous_Arbre_Droit,Cle);
         end if;
      end if;
   end La_Donnee;
   
   procedure Decrocher_Min (Sda : in out T_ABR; Min : out T_ABR) is
   begin
      if Sda.all.Sous_Arbre_Gauche = null then
         Min := Sda;
         Sda := Sda.all.Sous_Arbre_Droit;
      else
         Decrocher_Min (Sda.all.Sous_Arbre_Gauche, Min);
      end if;
   end Decrocher_Min;
                                                                        

   Procedure Supprimer (Sda : in out T_ABR ; Cle : in T_Cle) is
      A_Detruire:T_ABR;
      Min:T_ABR;
   begin
      if Sda = null then
         raise Cle_Absente_Exception;
      elsif Sda.all.Cle < Cle then
         Supprimer (Sda.all.Sous_Arbre_Droit, Cle);
      elsif Cle < Sda.all.Cle then
         Supprimer (Sda.all.Sous_Arbre_Gauche, Cle);
      else
         A_Detruire := Sda;
         if Sda.all.Sous_Arbre_Gauche = null then
            Sda := Sda.all.Sous_Arbre_Droit;
         elsif Sda.all.Sous_Arbre_Droit = null then
            Sda := Sda.all.Sous_Arbre_Gauche;
         else
            Decrocher_Min (Sda.all.Sous_Arbre_Droit, Min);
            Min.all.Sous_Arbre_Gauche := 
              Sda.all.Sous_Arbre_Gauche;
            Min.all.Sous_Arbre_Droit := 
              Sda.all.Sous_Arbre_Droit;
            Sda := Min;
         end if;
         Free (A_Detruire);
      
      end if;
   end Supprimer;

               


   procedure Vider (Sda : in out T_ABR) is
   begin
      if Est_Vide(Sda) then
         null;
      else
         Vider(Sda.all.Sous_Arbre_Gauche);
         Vider(Sda.all.Sous_Arbre_Droit);
         Free(Sda);
      end if;
   end Vider;


   procedure Pour_Chaque (Sda : in T_ABR) is
   begin
      if Est_Vide(Sda) then
         null;
      else
         begin
            Pour_Chaque(Sda.all.Sous_Arbre_Gauche);
            Traiter(Sda.all.Cle,Sda.all.Donnee);
            Pour_Chaque(Sda.all.Sous_Arbre_Droit);
         exception
            when others => Pour_Chaque(Sda.all.Sous_Arbre_Droit);
         end;
      end if;

   end Pour_Chaque;
end ABR;
