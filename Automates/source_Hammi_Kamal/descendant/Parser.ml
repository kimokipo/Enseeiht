open Tokens

(* Type du résultat d'une analyse syntaxique *)
type parseResult =
  | Success of inputStream
  | Failure
;;

(* accept : token -> inputStream -> parseResult *)
(* Vérifie que le premier token du flux d'entrée est bien le token attendu *)
(* et avance dans l'analyse si c'est le cas *)
let accept expected stream =
  match (peekAtFirstToken stream) with
    | token when (token = expected) ->
      (Success (advanceInStream stream))
    | _ -> Failure
;;

let acceptIdentPackage stream =
  match (peekAtFirstToken stream) with
    | (UL_IDENT_PACKAGE _) -> (Success (advanceInStream stream))
    | _ -> Failure
;;

let acceptIdentInterface stream =
  match (peekAtFirstToken stream) with
    | (UL_IDENT_INTERFACE _) -> (Success (advanceInStream stream))
    | _ -> Failure
;;

(* Définition de la monade  qui est composée de : *)
(* - le type de donnée monadique : parseResult  *)
(* - la fonction : inject qui construit ce type à partir d'une liste de terminaux *)
(* - la fonction : bind (opérateur >>=) qui combine les fonctions d'analyse. *)

(* inject inputStream -> parseResult *)
(* Construit le type de la monade à partir d'une liste de terminaux *)
let inject s = Success s;;

(* bind : 'a m -> ('a -> 'b m) -> 'b m *)
(* bind (opérateur >>=) qui combine les fonctions d'analyse. *)
(* ici on utilise une version spécialisée de bind :
   'b  ->  inputStream
   'a  ->  inputStream
    m  ->  parseResult
*)
(* >>= : parseResult -> (inputStream -> parseResult) -> parseResult *)
let (>>=) result f =
  match result with
    | Success next -> f next
    | Failure -> Failure
;;


(* parseMachine : inputStream -> parseResult *)
(* Analyse du non terminal Programme *)
let rec parsePackage stream =
  (print_string "Package -> ...");
  (match (peekAtFirstToken stream) with
    | UL_PACKAGE -> 
    (print_string "package ident { E SE }");
          inject stream >>=
          accept UL_PACKAGE >>=
          acceptIdentPackage >>=
          accept UL_ACCOUV >>=
          parseE >>=
          parseSE >>=
          accept UL_ACCFER
    | _ -> Failure)

and parseSE stream =
(print_string "SE -> ...");
(match (peekAtFirstToken stream) with
  | UL_PACKAGE | UL_INTERFACE -> 
  (print_string "E SE");
      inject stream >>=
        parseE >>=
        parseSE 
  | UL_ACCFER -> 
  inject stream
  | UL_FIN -> inject stream
  | _ -> Failure)

  and parseE stream =
  (print_string "E -> ...");
  (match (peekAtFirstToken stream) with
    | UL_PACKAGE -> 
    (print_string "P");
    inject stream >>=
        parsePackage 
    | UL_INTERFACE ->
    (print_string "I");
     inject stream >>=
          parseI
    | _ -> Failure)

and parseI stream =
      (print_string "I -> ...");
      (match (peekAtFirstToken stream) with
        | UL_INTERFACE -> 
        (print_string "interface Ident X { SM }");
        inject stream >>=
              accept UL_INTERFACE >>=
              acceptIdentInterface >>=
              parseX >>=
              accept UL_ACCOUV >>=
              parseSM >>=
              accept UL_ACCFER
        | _ -> Failure)

and parseX stream =
        (print_string "X -> ...");
        (match (peekAtFirstToken stream) with
          | UL_EXTENDS -> inject stream >>=
                accept UL_EXTENDS >>=
                parseQ >>=
                acceptIdentInterface >>=
                parseSQ 
          | UL_ACCOUV -> inject stream 
          | UL_FIN -> inject stream
          | _ -> Failure)
  
and parseQ stream =
          (print_string "X -> ...");
          (match (peekAtFirstToken stream) with
            | (UL_IDENT_PACKAGE _) -> inject stream >>=
                  acceptIdentPackage >>=
                  accept UL_PT >>=
                  parseQ 
            | (UL_IDENT_INTERFACE _) -> inject stream 
            | UL_FIN -> inject stream
            | _ -> Failure)

and parseSQ stream =
            (print_string "SQ -> ...");
            (match (peekAtFirstToken stream) with
              | UL_VIRG -> inject stream >>=
                    accept UL_VIRG >>=
                    parseQ >>=
                    acceptIdentInterface >>=
                    parseSQ
              | UL_ACCOUV  -> inject stream 
              | UL_FIN -> inject stream
              | _ -> Failure)

and parseSM stream =
              (print_string "SM -> ...");
              (match (peekAtFirstToken stream) with
                | UL_BOOLEAN | UL_INT | UL_VOID | (UL_IDENT_PACKAGE _) | (UL_IDENT_INTERFACE _) -> inject stream >>=
                      parseM >>=
                      parseSM
                | UL_ACCFER  -> inject stream 
                | UL_FIN -> inject stream
                | _ -> Failure)

and parseM stream =
                (print_string "M -> ...");
                (match (peekAtFirstToken stream) with
                  | UL_BOOLEAN | UL_INT | UL_VOID | (UL_IDENT_PACKAGE _) | (UL_IDENT_INTERFACE _) -> inject stream >>=
                        parseT >>=
                        acceptIdentPackage >>=
                        accept UL_PAROUV >>=
                        parseO >>=
                        accept UL_PARFER >>=
                        accept UL_PTVIRG
                  | _ -> Failure)
          
and parseO stream =
                  (print_string "O -> ...");
                  (match (peekAtFirstToken stream) with
                    | UL_BOOLEAN | UL_INT | UL_VOID | (UL_IDENT_PACKAGE _) | (UL_IDENT_INTERFACE _) -> inject stream >>=
                          parseT >>=
                          parseST
                    | UL_PARFER -> inject stream
                    | UL_FIN -> inject stream
                    | _ -> Failure)

and parseST stream =
                    (print_string "ST -> ...");
                    (match (peekAtFirstToken stream) with
                      | UL_VIRG -> inject stream >>=
                            accept UL_VIRG >>=
                            parseT >>=
                            parseST
                      | UL_PARFER -> inject stream
                      | UL_FIN -> inject stream
                      | _ -> Failure)

and parseT stream =
                      (print_string "T -> ...");
                      (match (peekAtFirstToken stream) with
                        | UL_BOOLEAN -> inject stream >>=
                              accept UL_BOOLEAN
                        | UL_INT -> inject stream >>=
                              accept UL_INT
                        | UL_VOID -> inject stream >>=
                                    accept UL_VOID
                        |(UL_IDENT_PACKAGE _) | (UL_IDENT_INTERFACE _) -> inject stream >>=
                          parseQ >>=
                          acceptIdentInterface
                        | _ -> Failure)


;;
