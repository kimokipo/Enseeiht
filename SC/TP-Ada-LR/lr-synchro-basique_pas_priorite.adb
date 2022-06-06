with Ada.Text_IO; use Ada.Text_IO;
with Ada.Exceptions;

-- Lecteurs concurrents, approche automate. Pas de politique d'accès.
package body LR.Synchro.Basique_Pas_Priorite is
   
   function Nom_Strategie return String is
   begin
      return "Automate, lecteurs concurrents, sans politique d'accès, Pas de Priorite";
   end Nom_Strategie;
   
   task LectRedTask is
      entry Demander_Lecture;
      entry Demander_Ecriture;
      entry Terminer_Lecture;
      entry Terminer_Ecriture;
   end LectRedTask;

   task body LectRedTask is
      type EtatT is ( Libre , Lecture , Ecriture);
      etat : EtatT := Libre ;
      nblect : Natural := 0;
   begin
      loop
         if etat = Libre then
            select
               accept Demander_Lecture; etat := Lecture; nblect := 1;
            or
               accept Demander_Ecriture; etat := Ecriture;
            end select;
         elsif etat = Lecture then
            select
               accept Demander_Lecture; nblect := nblect + 1;
            or
               accept Terminer_Lecture; nblect := nblect - 1;
               if nblect = 0 then etat := Libre ; else etat := Lecture; end if ;
            end select;
         elsif etat = Ecriture then
            accept Terminer_Ecriture;
            etat := Libre ;
         end if ;
      end loop;
   exception
      when Error: others =>
         Put_Line("**** LectRedTask: exception: " & Ada.Exceptions.Exception_Information(Error));
   end LectRedTask;

   procedure Demander_Lecture is
   begin
      LectRedTask.Demander_Lecture;
   end Demander_Lecture;

   procedure Demander_Ecriture is
   begin
      LectRedTask.Demander_Ecriture;
   end Demander_Ecriture;

   procedure Terminer_Lecture is
   begin
      LectRedTask.Terminer_Lecture;
   end Terminer_Lecture;

   procedure Terminer_Ecriture is
   begin
      LectRedTask.Terminer_Ecriture;
   end Terminer_Ecriture;

end LR.Synchro.Basique_Pas_Priorite;
