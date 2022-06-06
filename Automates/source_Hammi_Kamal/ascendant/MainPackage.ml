open Parser

(* Fonction d'affichage des unités lexicales et des données qu'elles contiennent *)
let printToken t =
  (print_endline
     (match t with
       | UL_ACCOUV -> "{"
       | UL_ACCFER -> "}"
       | UL_BOOLEAN -> "boolean"
       | UL_INT -> "int"
       | UL_PAROUV -> "("
       | UL_PARFER -> ")"
       | UL_PT -> "."
       | UL_VOID -> "void"
       | UL_EXTENDS -> "extends"
       | UL_PACKAGE -> "package"
       | UL_INTERFACE -> "interface"
       | UL_VIRG -> ","
       | UL_PTVIRG -> ";"
       | UL_IDENT_PACKAGE n -> n
       | UL_IDENT_INTERFACE n -> n
       | UL_FIN -> "EOF"
));;

(* Analyse lexicale du fichier passé en paramètre de la ligne de commande *)
if (Array.length Sys.argv > 1)
then
  let lexbuf = (Lexing.from_channel (open_in Sys.argv.(1))) in
  let token = ref (Lexer.lexer lexbuf) in
  while ((!token) != UL_FIN) do
    (printToken (!token));
    (token := (Lexer.lexer lexbuf))
  done
else
  (print_endline "MainPackage fichier");;

(* Analyse lexicale, syntaxique et sémantique du fichier passé en paramètre de la ligne de commande *)
if (Array.length Sys.argv > 1)
then
  let lexbuf = (Lexing.from_channel (open_in Sys.argv.(1))) in
  (Parser.package Lexer.lexer lexbuf)
else
  (print_endline "MainPackage fichier");;
