with Ada.Text_IO;          use Ada.Text_IO;
with Ada.Integer_Text_IO;  use Ada.Integer_Text_IO;

-- Auteur: 
-- Gérer un stock de matériel informatique.
--
package body Stocks_Materiel is

    procedure Creer (Stock : out T_Stock) is
    begin
        Stock.Taille:=0;
    end Creer;


    function Nb_Materiels (Stock: in T_Stock) return Integer is
    begin
        return Stock.Taille;
    end;


    procedure Enregistrer (
            Stock        : in out T_Stock;
            Numero_Serie : in     Integer;
            Nature       : in     T_Nature;
            Annee_Achat  : in     Integer
        ) is
    begin
        Stock.Tab(Stock.Taille+1):= (Numero_Serie,Nature,Annee_Achat,Fonctionne);
        Stock.Taille := Stock.Taille+1;
   end;
   function Nb_Mat_Panne(Stock: in T_Stock) return integer is
      S: integer :=0;
   begin
      for i in 1..Stock.Taille loop
         if Stock.Tab(i).Etat=Panne then
            S:=S+1;
         end if;
      end loop;
      return S;
   end ;
   Procedure mise_a_jour(Stock: in out T_Stock;Numero_Serie : in     Integer; Etat : in T_Etat) is
   begin
      for i in 1..Stock.Taille loop
         if Stock.Tab(i).Numero_Serie=Numero_Serie then
            Stock.Tab(i).Etat := Etat;
            exit;
         end if;
      end loop;
   end ;
   procedure supprimer(Stock: in out T_Stock;Numero_Serie : in Integer) is
      S:T_Stock;
   begin
      S.Taille :=0;
      for i in 1..Stock.Taille loop
         if Stock.Tab(i).Numero_Serie/=Numero_Serie then
            S.Tab(S.Taille+1):=Stock.Tab(i);
            S.Taille:=S.Taille+1;
         end if;
      end loop;
      Stock := S;
   end ;
   procedure afficher (Stock: in T_Stock)is 
   begin
      for i in 1..Stock.Taille loop
         put("(");
         put(Stock.Tab(i).Numero_Serie);
         put(",");
         put(Stock.Tab(i).Nature'Image);
         put(",");
         put(Stock.Tab(i).Annee_Achat);
         put(",");
         put(Stock.Tab(i).Etat'Image);
         put(",");
         put(")");
         new_line;
      end loop;
   end;
   procedure supprimer_panne(Stock: in out T_Stock)is
      S:T_Stock;
   begin
      S.Taille :=0;
      for i in 1..Stock.Taille loop
         if Stock.Tab(i).Etat/=Panne then
            S.Tab(S.Taille+1):=Stock.Tab(i);
            S.Taille:=S.Taille+1;
         end if;
      end loop;
      Stock := S;
   end ;
      
      
         
         


end Stocks_Materiel;
