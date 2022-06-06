%{

(* Partie recopiee dans le fichier CaML genere. *)
(* Ouverture de modules exploites dans les actions *)
(* Declarations de types, de constantes, de fonctions, d'exceptions exploites dans les actions *)

%}

/* Declaration des unites lexicales et de leur type si une valeur particuliere leur est associee */

%token UL_MODEL
%token UL_ACCOUV UL_ACCFER
%token UL_FLOW
%token UL_FROM
%token UL_POINT
%token UL_VIRG
%token UL_PTVIRG 
%token UL_BLOCK
%token UL_PAROUV 
%token UL_PARFER 
%token UL_DEUXPOINT
%token UL_IN
%token UL_OUT
%token UL_FLOAT
%token UL_CROOUV
%token UL_CROFER
%token UL_SYSTEM
%token UL_TO
%token UL_INT
%token UL_BOOLEAN
/* Defini le type des donnees associees a l'unite lexicale */

%token <string> UL_IDENT
%token <string> UL_IDENT_PORT
%token <int> UL_ENTIER

/* Unite lexicale particuliere qui represente la fin du fichier */

%token UL_FIN

/* Type renvoye pour le nom terminal modele */
%type <unit> modele

/* Le non terminal modele est l'axiome */
%start modele

%% /* Regles de productions */

modele : UL_MODEL UL_IDENT UL_ACCOUV elements UL_ACCFER UL_FIN { (print_endline "modele : UL_MODEL IDENT { elements } UL_FIN ") }

elements : /* Lambda, mot vide */{(print_endline "elements : /* Lambda, mot vide */");}
          | element elements {(print_endline "elements : element elements");}

element : bloc {(print_endline "element : bloc");}    
        | Systeme {(print_endline "element : Systeme");}
        | flot {(print_endline "element : flot");}

bloc : UL_BLOCK UL_IDENT parameters UL_PTVIRG {(print_endline "bloc : block Ident parameters ;");}

Systeme : UL_SYSTEM UL_IDENT parameters UL_ACCOUV elements UL_ACCFER {(print_endline "Systeme : system Ident parameters { elements }");}

parameters : UL_PAROUV ports UL_PARFER {(print_endline "parameters : ( ports )");}

ports : port {(print_endline "ports : port");}
      | port UL_VIRG ports {(print_endline "ports : port , ports");}

port : UL_IDENT_PORT UL_DEUXPOINT UL_IN Type {(print_endline "port : ident in Type");}
        | UL_IDENT_PORT UL_DEUXPOINT UL_OUT Type {(print_endline "port : ident out Type");}

Type  : UL_INT {(print_endline "Type : int");}
        | UL_FLOAT {(print_endline "Type : float");}
        | UL_BOOLEAN {(print_endline "Type : boolean");}
        | UL_INT UL_CROOUV entiers UL_CROFER {(print_endline "Type : int [ entiers ]");}
        | UL_FLOAT UL_CROOUV entiers UL_CROFER {(print_endline "Type : float [ entiers ]");}
        | UL_BOOLEAN UL_CROOUV entiers UL_CROFER {(print_endline "Type : boolean [ entiers ]");}

entiers : UL_ENTIER {(print_endline "entiers : entier");}
        | UL_ENTIER UL_VIRG entiers {(print_endline "entiers : entier , entiers");}

flot : UL_FLOW UL_IDENT_PORT UL_FROM UL_IDENT_PORT UL_TO UL_PTVIRG {(print_endline "flot : flow ident from ident to ;");}
      | UL_FLOW UL_IDENT_PORT UL_FROM UL_IDENT UL_POINT UL_IDENT_PORT UL_TO UL_PTVIRG {(print_endline "flot : flow ident from Ident . ident to ;");}
      | UL_FLOW UL_IDENT_PORT UL_FROM UL_IDENT_PORT UL_TO identifiants UL_PTVIRG {(print_endline "flot : flow ident from ident to identifiants ;");}
      | UL_FLOW UL_IDENT_PORT UL_FROM UL_IDENT UL_POINT UL_IDENT_PORT UL_TO identifiants UL_PTVIRG {(print_endline "flot : flow ident from Ident . ident to identifiants;");}

identifiants : UL_IDENT_PORT {(print_endline "identifiants : ident");}
          | UL_IDENT_PORT UL_VIRG identifiants {(print_endline "identifiants : ident , identifiants");}
          | UL_IDENT UL_POINT UL_IDENT_PORT {(print_endline "identifiants : Ident . ident");}
          | UL_IDENT UL_POINT UL_IDENT_PORT UL_VIRG identifiants {(print_endline "identifiants : Ident . ident , identifiants");}
%%
