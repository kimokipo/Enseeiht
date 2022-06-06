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

let acceptIdent stream =
  match (peekAtFirstToken stream) with
    | (UL_IDENT _) -> (Success (advanceInStream stream))
    | _ -> Failure
;;

let acceptIdentPort stream =
  match (peekAtFirstToken stream) with
    | (UL_IDENT_PORT _) -> (Success (advanceInStream stream))
    | _ -> Failure
;;

let acceptNumber stream =
  match (peekAtFirstToken stream) with
    | (UL_ENTIER _) -> (Success (advanceInStream stream))
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

let rec parseR stream =
(print_string "R -> model Ident { SE }");
(match (peekAtFirstToken stream) with
  (* regle #1 *)
  | UL_MODEL ->
    inject stream >>=
    accept UL_MODEL >>=
    acceptIdent >>=
    accept UL_ACCOUV >>=
    parseSE >>=
    accept UL_ACCFER
  | _ -> Failure)

and parseSE stream =
  (print_endline "SE -> ");
  (match (peekAtFirstToken stream) with
    (* regle #3 *)
    | UL_BLOCK | UL_SYSTEM | UL_FLOW -> 
        (print_endline "E SE");
        inject stream  >>=
        parseE >>=
        parseSE
    (* regle #2 *)
    | UL_ACCFER ->
      inject stream 
    | UL_FIN -> inject stream
    | _ -> Failure)
and parseE stream =
    (print_endline "E -> ");
    (match (peekAtFirstToken stream) with
      (* regle #4 *)
      | UL_BLOCK ->
      (print_endline "block Ident P");
       inject stream  >>=
          accept UL_BLOCK >>=
          acceptIdent >>=
          parseP >>=
          accept UL_PTVIRG
      (* regle #5 *)
      | UL_SYSTEM -> 
      (print_endline "system Ident P { SE }");
      inject stream >>=
        accept UL_SYSTEM >>=
        acceptIdent >>=
        parseP >>=
        accept UL_ACCOUV >>=
        parseSE >>=
        accept UL_ACCFER
      (*regle #6 *)
      | UL_FLOW -> 
      (print_endline "flow ident from NQ to LN ;");
        inject stream >>=
        accept UL_FLOW >>=
        acceptIdentPort >>=
        accept UL_FROM >>=
        parseNQ >>=
        accept UL_TO >>=
        parseLN >>=
        accept UL_PTVIRG
  
      | _ -> Failure)
and parseP stream =
      (print_endline "P -> ");
      (match (peekAtFirstToken stream) with
        (* regle #13 *)
        | UL_PAROUV -> 
        (print_endline "( LP )");
            inject stream  >>=
            accept UL_PAROUV >>=
            parseLP >>=
            accept UL_PARFER
        | _ -> Failure)  

and parseLP stream =
        (print_endline "LP -> ");
        (match (peekAtFirstToken stream) with
          (* regle #14 *)
          | (UL_IDENT_PORT _) -> 
          (print_endline "DP SP");
              inject stream  >>=
              parseDP >>=
              parseSP
          | _ -> Failure)

and parseDP stream =
          (print_endline "DP -> ");
          (match (peekAtFirstToken stream) with
            (* regle #17 *)
            | (UL_IDENT_PORT _) -> 
            (print_endline "ident : M T QT");
                inject stream  >>=
                acceptIdentPort >>=
                accept UL_DEUXPOINT >>=
                parseM >>=
                parseT >>=
                parseQT
            | _ -> Failure)
and parseSP stream =
          (print_endline "SP -> ");
          (match (peekAtFirstToken stream) with
            (* regle #16 *)
            | UL_VIRG -> 
            (print_endline ", DP SP");
                inject stream  >>=
                accept UL_VIRG >>=
                parseDP >>=
                parseSP
            (* regle #15 *)
            | UL_PARFER -> inject stream 
            | UL_FIN -> inject stream
            | _ -> Failure)

and parseNQ stream =
              (print_endline "NQ -> ");
              (match (peekAtFirstToken stream) with
                (* regle #7 *)
                | (UL_IDENT_PORT _) ->
                (print_endline "ident"); 
                    inject stream  >>=
                    acceptIdentPort
                (* regle #8 *)
                | (UL_IDENT _) ->
                (print_endline "Ident . ident");
                   inject stream >>=
                  acceptIdent >>=
                  accept UL_POINT >>=
                  acceptIdentPort

                | _ -> Failure)

and parseSN stream =
                      (print_endline "SN -> ");
                      (match (peekAtFirstToken stream) with
                        (* regle #12 *)
                        | UL_VIRG -> 
                        (print_endline ", NQ SN"); 
                            inject stream  >>=
                            accept UL_VIRG >>=
                            parseNQ >>=
                            parseSN
                        (* regle #11 *)
                        | UL_PTVIRG-> inject stream
                        | UL_FIN -> inject stream
                        | _ -> Failure)
and parseLN stream =
  (print_endline "LN -> ");
  (match (peekAtFirstToken stream) with
    (* regle #10 *)
    | (UL_IDENT_PORT _) | (UL_IDENT _) ->
    (print_endline "NQ SN");
       inject stream  >>=
        parseNQ >>=
        parseSN
    (* regle #9 *)
    | UL_PTVIRG-> inject stream
    | UL_FIN -> inject stream
    | _ -> Failure)
and parseM stream =
  (print_endline "M -> ");
  (match (peekAtFirstToken stream) with
    (* regle #18 *)
    | UL_IN -> 
    (print_endline "in");
        inject stream  >>=
        accept UL_IN 
    (*regle #19*)
    | UL_OUT -> 
    (print_endline "out");
      inject stream >>=
      accept UL_OUT
    | _ -> Failure)

and parseT stream =
      (print_endline "T -> ");
      (match (peekAtFirstToken stream) with
        (* regle #20 *)
        | UL_INT -> 
        (print_endline "int");
            inject stream  >>=
            accept UL_INT
        (*regle #21*)
        | UL_FLOAT -> 
        (print_endline "float");
          inject stream >>=
          accept UL_FLOAT
          (*regle #22*)
          | UL_BOOLEAN -> 
          (print_endline "boolean");
            inject stream >>=
            accept UL_BOOLEAN
        | _ -> Failure)
and parseSV stream =
              (print_endline "SV -> ");
              (match (peekAtFirstToken stream) with
                (* regle #25 *)
                | UL_CROFER -> 
                    inject stream
                |UL_FIN -> inject stream  
                (*regle #26*)
                | UL_VIRG -> 
                (print_endline ", entier SV]");
                  inject stream >>=
                  accept UL_VIRG >>=
                  acceptNumber >>=
                  parseSV 
                | _ -> Failure)                                                    
       
and parseQT stream =
              (print_endline "QT -> ");
              (match (peekAtFirstToken stream) with
                (* regle #23 *)
                | UL_VIRG | UL_PARFER -> 
                    inject stream
                |UL_FIN -> inject stream  
                (*regle #24*)
                | UL_CROOUV -> 
                (print_endline "[ entier SV]");
                  inject stream >>=
                  accept UL_CROOUV >>=
                  acceptNumber >>=
                  parseSV >>=
                  accept UL_CROFER
                | _ -> Failure)
;;

                           

