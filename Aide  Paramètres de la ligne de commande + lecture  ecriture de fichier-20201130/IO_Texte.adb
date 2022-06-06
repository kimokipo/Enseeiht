with Ada.IO_Exceptions;
with Ada.Text_IO; use Ada.Text_IO;
with Ada.Float_Text_IO; use Ada.Float_Text_IO;
with Ada.Integer_Text_IO; use Ada.Integer_Text_IO;
with Ada.Command_line; use Ada.Command_line;
with Ada.Strings.Unbounded;


procedure IO_Texte is
	package SU renames Ada.Strings.Unbounded;
	use SU;

	No_Argument_Error : Exception;

	-- descripteur de fichier texte (Ada.Text_IO)
	File : Ada.Text_IO.File_Type;
	Entier : Integer;
	Flottant : Float;
	Nom_Fichier : SU.Unbounded_String;
begin
	-- Affichage de tous les paramètres (ou arguments) de la ligne de commande.
	new_line;
	Put("---- Arguments de la ligne de commande : ");
	Put(Argument_Count, 1);
	Put_line(" argument(s).");
	for i in 1 .. Argument_Count loop
		Put("Argument");
		Put(i,1);
		Put(" : ");
		Put_line(Argument(i));
	end loop;
	new_line(2);
	-- On se rendra compte que le 1er argument est le nom du fichier à lire

	if Argument_Count >=1 then
		-- Affichage du texte contenu dans le fichier en argument 1.
		Put("---- Lecture des entiers du fichier ");
		Put_line(Argument(1));
		begin
		-- Ouverture du fichier
		-- Nom du fichier donne dans le premier argument.
		-- Mode d'ouverture : In_File car on lit le contenu
		open(File, In_File, Argument(1));

		-- On lit le 1er entier, puis le réel  et on les l'affiche.
		Get (File, Entier);
		Get (File, Flottant);
		Put ("L'entier lu est : ");
		Put (Entier, 1);
		Put (" et le réel lu est : ");
		-- Affichage du réel sur 2 position avant la virgule et 3 positions après la virgule
		Put (Flottant, 2, 3);
		New_Line;
		-- tant qu'on n'a pas atteint la fin du fichier
		-- on lit et on affiche tous le entiers.
		Put_Line ("---- Lecture jusqu'à la fin du fichier des entiers suivants ");
		while not end_of_File(File) loop
			Get (File, Entier);
			Put (Entier, 1);
			Put (" ");
		end loop;
		new_line;

		-- Fermetude du fichier à lire
		close(File);

		exception
			when ADA.IO_EXCEPTIONS.NAME_ERROR =>
				Put_line("Fichier non present - donner le nom d'un fichier en argument");
		end;
	end if;

	-- Ecriture d'une chaine de caractere dans un nouveau fichier
	-- On cree le nom du fichier en concaténant le 1er argument avec ".new"
	if Argument_Count < 1 then
		raise No_Argument_Error;
	end if;

	Nom_Fichier := To_Unbounded_String(Argument(1));
	Append(Nom_Fichier, ".new");
	Put_Line("---- Ecriture dans un nouveau fichier appelé "& To_String(Nom_Fichier));
	-- Creation du fichier
	Create(File, Out_File, To_String (Nom_Fichier));
	Put(File,"New");
	New_line(File);
	close(File);

	-- Re-ouverture du fichier pour y écrire la fin d'un texte caractere
	-- a caractere, puis écriture d'une réel.
	Open(File, Append_File, To_String (Nom_Fichier));
	Put(File,'V');
	Put(File,'a');
	Put(File,'l');
	Put(File,'u');
	Put(File,'e');
	Put(File,' ');
	Put(File, 12.3);
	close(File);
Exception
	when No_Argument_Error => Put_Line ("Il manque le nom du fichier en paramètre.");
end IO_Texte;
