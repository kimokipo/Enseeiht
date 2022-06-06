with Ada.Text_IO; use Ada.Text_IO;
with Ada.Exceptions;

-- Version simple : exclusion mutuelle pour toutes les opérations
--  fournit une ossature pour l'approche "service"

package body LR.Synchro.Exclusion_Fifo is
   
   function Nom_Strategie return String is
   begin
      return "Exclusion mutuelle simple, Stratégie FIFO";
   end Nom_Strategie;

   task LectRedTask is
      entry Demander_Lecture;
      entry Demander_Ecriture;
      entry Terminer_Lecture;
      entry Terminer_Ecriture;
   end LectRedTask;

   task body LectRedTask is
      nblect : Natural := 0;
      ecriture : Boolean := false;
   begin
      loop
      	select
            when ((Demander_Ecriture'count = 0) and (not ecriture)) => accept Demander_Lecture; nblect := nblect + 1;
    	   or
            when ((Demander_Ecriture'count > 0) and (nblect > 0)) => accept Terminer_Lecture; for j in 2..nblect loop accept Terminer_Lecture; end loop; nblect := 0;accept Demander_Ecriture; ecriture := true;
    	   or
			   accept Terminer_Lecture; nblect := nblect - 1;
         or 
            when ((nblect = 0) and (not ecriture)) => accept Demander_Ecriture; ecriture := true;
    	   or
			   accept Terminer_Ecriture; ecriture := false;
        end select;
      end loop;
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

end LR.Synchro.Exclusion_Fifo;