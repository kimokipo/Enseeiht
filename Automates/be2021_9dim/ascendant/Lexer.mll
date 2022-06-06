{

(* Partie recopiée dans le fichier CaML généré. *)
(* Ouverture de modules exploités dans les actions *)
(* Déclarations de types, de constantes, de fonctions, d'exceptions exploités dans les actions *)

  open Parser 
  exception LexicalError

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

rule lexer = parse
  | ['\n' '\t' ' ']+					{ (lexer lexbuf) }
  | commentaire						{ (lexer lexbuf) }
  | "{"							{ UL_ACCOUV }
  | "}"							{ UL_ACCFER }
  | "model"						{ UL_MODEL }
  | "flow"          {UL_FLOW}
  | "from"          {UL_FROM}
  | "."           {UL_POINT}
  | ","							{ UL_VIRG }
  | ";"							{ UL_PTVIRG }
  | "block"          {UL_BLOCK}
  | "("					       		{ UL_PAROUV }
  | ")"							{ UL_PARFER }
  | ":"         {UL_DEUXPOINT}
  | "in"        {UL_IN}
  | "out"       {UL_OUT}
  | "float"       {UL_FLOAT}
  | "["           {UL_CROOUV}
  | "]"           {UL_CROFER}
  | "system"      {UL_SYSTEM}
  | "int"         {UL_INT}
  | "to"          {UL_TO}
  | "boolean"			{ UL_BOOLEAN }
  | chiffre+ as texte					{ (UL_ENTIER (int_of_string texte)) }
  | minuscule alphabet* as texte		{ (UL_IDENT_PORT texte) }
  | majuscule alphabet* as texte			{ (UL_IDENT texte) }
  | eof							{ UL_FIN }
  | _ as texte				 		{ (print_string "Erreur lexicale : ");(print_char texte);(print_newline ()); raise LexicalError }

{

}
