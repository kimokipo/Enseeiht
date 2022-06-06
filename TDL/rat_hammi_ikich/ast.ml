open Type

(* Interface des arbres abstraits *)
module type Ast =
sig
   type expression
   type affectable
   type instruction
   type fonction
   type programme
end


(* *************************************** *)
(* AST après la phase d'analyse syntaxique *)
(* *************************************** *)
module AstSyntax =
struct

(* Opérateurs unaires de Rat *)
type unaire = Numerateur | Denominateur

(* Opérateurs binaires de Rat *)
type binaire = Fraction | Plus | Mult | Equ | Inf

(* Affectable de Rat *)
type affectable = 
  (* Identifiant *)
  | Ident of string
  (* Déréferencement d'un Pointeur *)
  | Deref of affectable
  (* Champ d'un Enregistrement *)
  | Champ of affectable * string

(* Expressions de Rat *)
type expression =
  (* Affectable *)
  | Affectable of affectable
  (* Appel de fonction représenté par le nom de la fonction et la liste des paramètres réels *)
  | AppelFonction of string * expression list
  (* Enregistrement *)
  | Enregistrement of expression list
  (* Booléen *)
  | Booleen of bool
  (* Entier *)
  | Entier of int
  (* Opération unaire représentée par l'opérateur et l'opérande *)
  | Unaire of unaire * expression
  (* Opération binaire représentée par l'opérateur, l'opérande gauche et l'opérande droite *)
  | Binaire of binaire * expression * expression
  (* Initialisation de Pointeur *)
  | NEW of typ
  (* Adresse d'une variable *)
  | Adresse of string
  (* Pointeur null *)
  | NULL


(* Instructions de Rat *)
type bloc = instruction list
and instruction =
  (* Déclaration de variable représentée par son type, son nom et l'expression d'initialisation *)
  | Declaration of typ * string * expression
  (* Définition d'un type nommé *)
  | DefinitionType of string * typ
  (* Affectation d'une variable représentée par son nom et la nouvelle valeur affectée *)
  | Affectation of affectable * expression
  (* Assignation d'addition *)
  | AssignationAddition of affectable * expression
  (* Déclaration d'une constante représentée par son nom et sa valeur (entier) *)
  | Constante of string * int
  (* Affichage d'une expression *)
  | Affichage of expression
  (* Conditionnelle représentée par la condition, le bloc then et le bloc else *)
  | Conditionnelle of expression * bloc * bloc
  (*Boucle TantQue représentée par la conditin d'arrêt de la boucle et le bloc d'instructions *)
  | TantQue of expression * bloc
  (* return d'une fonction *)
  | Retour of expression

(* Structure des fonctions de Rat *)
(* type de retour - nom - liste des paramètres (association type et nom) - corps de la fonction *)
type fonction = Fonction of typ * string * (typ * string) list * bloc

(* Structure d'un programme Rat *)
(* Soit un bloc soit une liste de défintions des types - fonction - sous programme *)
type programme = 
  |Bloc of bloc
  |Programme of (string * typ) list * fonction * programme

end


(* ********************************************* *)
(* AST après la phase d'analyse des identifiants *)
(* ********************************************* *)
module AstTds =
struct

  type affectable = 
    | Ident of Tds.info_ast  (* le nom de l'identifiant est remplacé par ses informations *)     
    | Deref of affectable
    | Champ of affectable * Tds.info_ast (* le nom de l'enregistrement est remplacé par ses informations *)

  (* Expressions existantes dans notre langage *)
  (* ~ expression de l'AST syntaxique où les noms des identifiants ont été
  remplacés par les informations associées aux identificateurs *)
  type expression =
    | AppelFonction of Tds.info_ast * expression list
    | Enregistrement of expression list
    | Affectable of affectable
    | Booleen of bool
    | Entier of int
    | Unaire of AstSyntax.unaire * expression
    | Binaire of AstSyntax.binaire * expression * expression
    | NEW of typ 
    | NULL
    | Adresse of Tds.info_ast

  (* instructions existantes dans notre langage *)
  (* ~ instruction de l'AST syntaxique où les noms des identifiants ont été
  remplacés par les informations associées aux identificateurs
  + suppression de nœuds (const) *)
  type bloc = instruction list
  and instruction =
    | Declaration of typ * Tds.info_ast * expression (* le nom de l'identifiant est remplacé par ses informations *)
    | AssignationAddition of affectable * expression
    | DefinitionType of Tds.info_ast * typ  (* le nom du type est remplacé par ses informations *)
    | Affectation of affectable * expression 
    | Affichage of expression
    | Conditionnelle of expression * bloc * bloc
    | TantQue of expression * bloc
    | Retour of expression
    | Empty (* les nœuds ayant disparus: Const *)


  (* Structure des fonctions dans notre langage *)
  (* type de retour - informations associées à l'identificateur (dont son nom) - liste des paramètres (association type et information sur les paramètres) - corps de la fonction *)
  type fonction = Fonction of typ * Tds.info_ast * (typ * Tds.info_ast ) list * bloc

  (* Structure d'un programme dans notre langage *)
  type programme = 
    |Bloc of bloc
    |Programme of (Tds.info_ast * typ) list * fonction * programme (* le nom du type est remplacé par ses informations *)

end


(* ******************************* *)
(* AST après la phase de typage *)
(* ******************************* *)
module AstType =
struct

(* Opérateurs unaires de Rat - résolution de la surcharge *)
type unaire = Numerateur | Denominateur

(* Opérateurs binaires existants dans Rat - résolution de la surcharge *)
type binaire = Fraction | PlusInt | PlusRat | MultInt | MultRat | EquInt | EquBool | EquRef | Inf


(* Expressions existantes dans Rat *)
(* = expression de AstTds *)
type expression =
  | AppelFonction of Tds.info_ast * expression list
  | Affectable of AstTds.affectable
  | Enregistrement of expression list
  | Booleen of bool
  | Entier of int
  | Unaire of unaire * expression
  | Binaire of binaire * expression * expression
  | NEW of typ 
  | NULL
  | Adresse of Tds.info_ast

(* instructions existantes Rat *)
(* = instruction de AstTds + informations associées aux identificateurs, mises à jour *)
(* + résolution de la surcharge de l'affichage *)
type bloc = instruction list
 and instruction =
  | Declaration of Tds.info_ast * expression
  | DefinitionType of Tds.info_ast
  | Affectation of AstTds.affectable * expression
  | AssignationAddition of AstTds.affectable * expression * typ
  | AffichageInt of expression
  | AffichageRat of expression
  | AffichageBool of expression
  | Conditionnelle of expression * bloc * bloc
  | TantQue of expression * bloc
  | Retour of expression
  | Empty (* les nœuds ayant disparus: Const *)

(* informations associées à l'identificateur (dont son nom), liste des paramètres, corps *)
type fonction = Fonction of Tds.info_ast * Tds.info_ast list * bloc

(* Structure d'un programme dans notre langage *)
type programme = 
  |Bloc of bloc
  |Programme of Tds.info_ast list * fonction * programme

let taille_variables_declarees i =
  match i with
  | Declaration (info,_) ->
    begin
    match Tds.info_ast_to_info info with
    | InfoVar (_,t,_,_,_) -> getTaille t
    | _ -> failwith "internal error"
    end
  | _ -> 0 ;;

end

(* ******************************* *)
(* AST après la phase de placement *)
(* ******************************* *)
module AstPlacement =
struct

(* Expressions existantes dans notre langage *)
(* = expression de AstType  *)
type expression = AstType.expression

(* instructions existantes dans notre langage *)
(* = instructions de AstType  *)
type bloc = instruction list
 and instruction = AstType.instruction

(* informations associées à l'identificateur (dont son nom), liste de paramètres, corps, expression de retour *)
(* Plus besoin de la liste des paramètres mais on la garde pour les tests du placements mémoire *)
type fonction = Fonction of Tds.info_ast * Tds.info_ast list * bloc

(* Structure d'un programme dans notre langage *)
type programme = 
  |Bloc of bloc
  |Programme of Tds.info_ast list * fonction * programme

end
