{

(* Partie recopiée dans le fichier CaML généré. *)
(* Ouverture de modules exploités dans les actions *)
(* Déclarations de types, de constantes, de fonctions, d'exceptions exploités dans les actions *)

  open Tokens 
  exception Printf

}

(* Déclaration d'expressions régulières exploitées par la suite *)
let chiffre = ['0' - '9']
let minuscule = ['a' - 'z']
let majuscule = ['A' - 'Z']
let alphabet = minuscule | majuscule
let alphanum = alphabet | chiffre | '_'
let commentaire =
  (* Commentaire fin de ligne *)
  "#" [^'\n']*

rule scanner = parse
  | ['\n' '\t' ' ']+					{ (scanner lexbuf) }
  | commentaire						{ (scanner lexbuf) }
  | "{"							{ UL_ACCOUV :: (scanner lexbuf) }
  | "}"							{ UL_ACCFER :: (scanner lexbuf)}
  | "."           {UL_PT :: (scanner lexbuf)}
  | ","							{ UL_VIRG :: (scanner lexbuf)}
  | ";"							{ UL_PTVIRG :: (scanner lexbuf)}
  | "("					       		{ UL_PAROUV :: (scanner lexbuf)}
  | ")"							{ UL_PARFER :: (scanner lexbuf)}
  | "package"						{ UL_PACKAGE :: (scanner lexbuf)}
  | "interface"         {UL_INTERFACE :: (scanner lexbuf)}
  | "void"        {UL_VOID :: (scanner lexbuf)}
  | "extends"       { UL_EXTENDS :: (scanner lexbuf)}
  | "boolean"			{ UL_BOOLEAN :: (scanner lexbuf) }
  | "int"         {UL_INT :: (scanner lexbuf)}
  | minuscule alphabet* as texte		{ (UL_IDENT_PACKAGE texte) :: (scanner lexbuf)}
  | majuscule alphabet* as texte			{ (UL_IDENT_INTERFACE texte) :: (scanner lexbuf)}
  | eof							{ [UL_FIN] }
  | _ as texte				 		{ (print_string "Erreur lexicale : ");(print_char texte);(print_newline ()); (UL_ERREUR::(scanner lexbuf)) }

{

}
