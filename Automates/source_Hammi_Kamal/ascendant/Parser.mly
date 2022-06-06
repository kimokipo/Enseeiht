%{

(* Partie recopiee dans le fichier CaML genere. *)
(* Ouverture de modules exploites dans les actions *)
(* Declarations de types, de constantes, de fonctions, d'exceptions exploites dans les actions *)

%}

/* Declaration des unites lexicales et de leur type si une valeur particuliere leur est associee */

%token UL_PACKAGE
%token UL_ACCOUV UL_ACCFER
%token UL_PT 
%token UL_VOID
%token UL_EXTENDS 
%token UL_INTERFACE
%token UL_VIRG
%token UL_PTVIRG 
%token UL_PAROUV 
%token UL_PARFER 
%token UL_INT
%token UL_BOOLEAN


/* Defini le type des donnees associees a l'unite lexicale */

%token <string> UL_IDENT_PACKAGE
%token <string> UL_IDENT_INTERFACE

/* Unite lexicale particuliere qui represente la fin du fichier */

%token UL_FIN

/* Type renvoye pour le nom terminal document */
%type <unit> package

/* Le non terminal document est l'axiome */
%start package

%% /* Regles de productions */

package : UL_PACKAGE UL_IDENT_PACKAGE UL_ACCOUV elements UL_ACCFER UL_FIN { (print_endline "package : PACKAGE IDENT_PACKAGE { ... } FIN ") }

packetage : UL_PACKAGE UL_IDENT_PACKAGE UL_ACCOUV elements UL_ACCFER { (print_endline "package : PACKAGE IDENT_PACKAGE { ... } ") } 

elements : P_ou_I {(print_endline "elements : /* Lambda, mot vide */ ")}
          | P_ou_I elements {(print_endline "elements : P_ou_I elements ")}
P_ou_I : packetage {(print_endline "P_ou_I : package ")}
          | Interface {(print_endline "P_ou_I : Interface ")}

Interface : UL_INTERFACE UL_IDENT_INTERFACE avant_noms UL_ACCOUV methodes UL_ACCFER {}

avant_noms :  /* Lambda, mot vide */ {}
        |  UL_EXTENDS noms {}

noms : nomQualifie {}
      | nomQualifie UL_VIRG noms {}
      
nomQualifie : packages UL_IDENT_INTERFACE {}
  
packages :  /* Lambda, mot vide */ {}
        | UL_IDENT_PACKAGE UL_PT packages {}

methodes :   /* Lambda, mot vide */ {}
        | Methode methodes {}

Methode : Type UL_IDENT_PACKAGE UL_PAROUV avant_type UL_PARFER UL_PTVIRG {}

avant_type : /* Lambda, mot vide */ {}
        | types {}

types :  Type  {}
      | Type UL_VIRG types {}

Type : UL_BOOLEAN {}
      | UL_INT {}
      | UL_VOID {}
      | nomQualifie {}
%%

