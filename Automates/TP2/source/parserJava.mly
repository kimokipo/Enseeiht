%{

(* Partie recopiee dans le fichier CaML genere. *)
(* Ouverture de modules exploites dans les actions *)
(* Declarations de types, de constantes, de fonctions, d'exceptions exploites dans les actions *)

(* let nbrVariables = ref 0;; *)

let nbrFonctions = ref 0;;
let nbrInstructions = ref 0;;
let nbrInstructionsFonction = ref 0;;
let nbrInstructionsbloc = ref 0;;
let nbrBlocsFonction = ref 1;;

%}

/* Declaration des unites lexicales et de leur type si une valeur particuliere leur est associee */

%token IMPORT
%token <string> IDENT TYPEIDENT
%token INT FLOAT BOOL CHAR VOID STRING
%token ACCOUV ACCFER PAROUV PARFER CROOUV CROFER
%token PTVIRG VIRG
%token SI SINON TANTQUE RETOUR
/* Defini le type des donnees associees a l'unite lexicale */
%token <int> ENTIER
%token <float> FLOTTANT
%token <bool> BOOLEEN
%token <char> CARACTERE
%token <string> CHAINE
%token VIDE
%token NOUVEAU
%token ASSIGN
%token OPINF OPSUP OPINFEG OPSUPEG OPEG OPNONEG
%token OPPLUS OPMOINS OPOU
%token OPMULT OPMOD OPDIV OPET
%token OPNON
%token OPPT
%token PUBLIC
%token CLASS
%token STATIC 
%token MAIN
%token EXTENDS
%token PRIVATE
/* Unite lexicale particuliere qui represente la fin du fichier */
%token FIN

/* Declarations des regles d'associative et de priorite pour les operateurs */
/* La priorite est croissante de haut en bas */
/* Associatif a droite */
%right ASSIGN /* Priorite la plus faible */
/* Non associatif */
%nonassoc OPINF OPSUP OPINFEG OPSUPEG OPEG OPNONEG
/* Associatif a gauche */
%left OPPLUS OPMOINS OPOU
%left OPMULT OPMOD OPDIV OPET
%right OPNON
%left OPPT PAROUV CROOUV /* Priorite la plus forte */

/* Type renvoye pour le nom terminal fichier */
%type <unit> fichier
%type <int> variables

/* Le non terminal fichier est l'axiome */
%start fichier

%% /* Regles de productions */

fichier : programme FIN { (print_endline "fichier : programme FIN");(print_string "Nombre de fonctions : ");(print_int !nbrFonctions);(print_newline());(print_string "Nombre d'instructions : ");(print_int !nbrInstructions);(print_newline()) }
				| importations programme FIN { (print_endline "fichier : importations programme FIN");(print_string "Nombre de fonctions : ");(print_int !nbrFonctions);(print_newline());(print_string "Nombre d'instructions : ");(print_int !nbrInstructions);(print_newline())  }

importations : /* Lambda, mot vide */{(print_endline "importations : /* Lambda, mot vide */");}
				| importation importations {(print_endline "importations : importation importations");}

importation : IMPORT ensemble_classes PTVIRG { (print_endline "importation : import ensemble_classes ;");}
		| IMPORT ensemble_classes OPPT OPMULT PTVIRG { (print_endline "importation : import ensemble_classes.*;");}
		
		   	
ensemble_classes : IDENT { (print_endline "ensemble_classes : ident");}
		
	| IDENT OPPT ensemble_classes { (print_endline "importation : ident.ensemble_classes");}
		
programme : classes principale {(print_endline "programme : classes principale");}

classes : /* Lambda, mot vide */{(print_endline "classes : /* Lambda, mot vide */");}
				| classe classes {(print_endline "classes : classe classes");}

classe : CLASS IDENT ACCOUV definitions ACCFER {(print_endline "classe : class ident { definitions }");}
			| CLASS IDENT EXTENDS IDENT ACCOUV definitions ACCFER {(print_endline "classe : class ident extends ident { definitions }");}

definitions : /* Lambda, mot vide */{(print_endline "definitions : /* Lambda, mot vide */");}
				| definition definitions {(print_endline "definitions : definition definitions");}
 
definition : PUBLIC variable {(print_endline "definition : public variable");} 
				| PUBLIC fonction {(print_endline "definition : public fonction");(nbrFonctions := !nbrFonctions + 1); (nbrInstructions := !nbrInstructions + !nbrInstructionsFonction);(print_string "Nombre de blocs : ");(print_int !nbrBlocsFonction);(print_newline())} 
				| PRIVATE variable {(print_endline "definition : private variable");} 
				| PRIVATE fonction {(print_endline "definition : private fonction");(nbrFonctions := !nbrFonctions + 1); (nbrInstructions := !nbrInstructions + !nbrInstructionsFonction);(print_string "Nombre de blocs : ");(print_int !nbrBlocsFonction);(print_newline())}

principale : PUBLIC CLASS IDENT ACCOUV principal ACCFER {(print_endline "principale : public class ident { principal }");}

principal : PUBLIC STATIC VOID MAIN PAROUV STRING CROOUV CROFER IDENT PARFER bloc {(print_endline "principal : public static void main ( String [ ] ident ) bloc");(nbrInstructions := !nbrInstructions + !nbrInstructionsbloc);}


typeStruct : typeBase declTab { (print_endline "typeStruct : typeBase declTab") }

typeBase : INT { (print_endline "typeBase : INT") }
         | FLOAT { (print_endline "typeBase : FLOAT") }
         | BOOL { (print_endline "typeBase : BOOL") }
         | CHAR { (print_endline "typeBase : CHAR") }
         | STRING { (print_endline "typeBase : STRING") }
         | TYPEIDENT { (print_endline "typeBase : TYPEIDENT") }

declTab : /* Lambda, mot vide */ { (print_endline "declTab : /* Lambda, mot vide */") }
        | CROOUV CROFER { (print_endline "declTab : CROOUV CROFER") }

fonction : entete bloc  { (print_endline "fonction : entete bloc") ;(nbrInstructions := !nbrInstructions + !nbrInstructionsbloc);}

entete : typeStruct IDENT PAROUV parsFormels PARFER { (print_endline "entete : typeStruct IDENT PAROUV parsFormels PARFER") }
       | VOID IDENT PAROUV parsFormels PARFER { (print_endline "entete : VOID IDENT PAROUV parsFormels PARFER") }

parsFormels : /* Lambda, mot vide */ { (print_endline "parsFormels : /* Lambda, mot vide */") }
            | typeStruct IDENT suiteParsFormels { (print_endline "parsFormels : typeStruct IDENT suiteParsFormels") }

suiteParsFormels : /* Lambda, mot vide */ { (print_endline "suiteParsFormels : /* Lambda, mot vide */") }
                 | VIRG typeStruct IDENT suiteParsFormels { (print_endline "suiteParsFormels : VIRG typeStruct IDENT suiteParsFormels") }

bloc : ACCOUV /* $1 */ variables /* $2 */ instructions /* $3 */ ACCFER /* $4 */
     {
	(print_endline "bloc : ACCOUV variables instructions ACCFER");
	(print_string "Nombre de variables = ");
	(print_int $2);
	(print_newline ())
	}

variables : /* Lambda, mot vide */
	  {
		(print_endline "variables : /* Lambda, mot vide */");
		0
		}
          | variable /* $1 */ variables /* $2 */
	  {
		(print_endline "variables : variable variables");
		($2 + 1)
		}

variable : typeStruct IDENT PTVIRG { (print_endline "variable : typeStruct IDENT PTVIRG") }

/* A FAIRE : Completer pour decrire une liste d'instructions eventuellement vide */
instructions : /* Lambda, mot vide */
	  {
		(print_endline "instructions : /* Lambda, mot vide */");
		(nbrInstructionsbloc := 0);
		}
          | instruction /* $2 */ instructions /* $3 */
	  {
		(print_endline "instructions : instruction instructions");
		(nbrInstructionsbloc := !nbrInstructionsbloc + 1);
		}

/* A FAIRE : Completer pour ajouter les autres formes d'instructions */
               instruction : expression PTVIRG { (print_endline "instruction : expression PTVIRG") }
                             | RETOUR expression PTVIRG  { (print_endline "instruction : RETURN expression PTVIRG") }
                             | SI PAROUV expression PARFER bloc  { (nbrBlocsFonction := !nbrBlocsFonction +1); (print_endline "instruction : IF ( expression ) bloc") }
                             | SI PAROUV expression PARFER bloc SINON bloc  { (nbrBlocsFonction := !nbrBlocsFonction +1); (print_endline "instruction : IF ( expression ) bloc ELSE bloc") }
                             | TANTQUE PAROUV expression PARFER bloc  { (nbrBlocsFonction := !nbrBlocsFonction +1); (print_endline "instruction : WHILE ( expression ) bloc") }

/* A FAIRE : Completer pour ajouter les autres formes d'expressions */

expression : sous_expression {(print_endline "expression : sous_expression")}
		 				| unaires sous_expression  { (print_endline "sous_expression : unaires sous_expression ") }
						| expression binaire expression  {(print_endline "expression : sous_expression binaire sous_expression ")}

sous_expression : ENTIER  { (print_endline "sous_expression : ENTIER ") }
		 | FLOTTANT  { (print_endline "sous_expression : FLOTTANT ") }	
		 | CARACTERE  { (print_endline "sous_expression : CARACTERE ") }	
		 | BOOLEEN  { (print_endline "sous_expression : BOOLEAN ") }	
		 | VIDE  { (print_endline "sous_expression : NULL ") }	
		 | NOUVEAU IDENT PAROUV PARFER  { (print_endline "sous_expression : NEW IDENT ( ) ") }
		 | NOUVEAU IDENT CROOUV expression CROFER  { (print_endline "sous_expression : NEW IDENT [ expression ] ") }
		 | IDENT suffixes  { (print_endline "sous_expression : IDENT suffixes ") }
		 | PAROUV expression PARFER suffixes  { (print_endline "sous_expression : ( expression ) suffixes ") }

unaires : /* Lambda, mot vide */
	  {
		(print_endline "unaires : /* Lambda, mot vide */");
		}
          | unaire unaires
	  {
		(print_endline "unaires : unaire unaires");
		}

unaire : PAROUV typeStruct PARFER {(print_endline "unaire : ( type )");}
			| OPPLUS {(print_endline "unaire : +");}
			| OPMOINS {(print_endline "unaire : -");}
			| OPNON	 {(print_endline "unaire : !");}

suffixes : /* Lambda, mot vide */
	  {
		(print_endline "suffixes : /* Lambda, mot vide */");
		}
          | suffixe suffixes 
	  {
		(print_endline "suffixes : suffixe suffixes");
		}

suffixe : PAROUV PARFER {(print_endline "suffixe : ( )");}
			| PAROUV expression PARFER {(print_endline "suffixe : ( expression )");}
			| CROOUV expression CROFER {(print_endline "suffixe : [ expression ]");}

binaire : ASSIGN {(print_endline "binaire : =");}
       | OPINF {(print_endline "binaire : <");}
       | OPSUP {(print_endline "binaire : >");}
       | OPINFEG {(print_endline "binaire : <=");}
       | OPSUPEG {(print_endline "binaire : >=");}
       | OPEG {(print_endline "binaire : ==");}
       | OPNONEG {(print_endline "binaire : !=");}
       | OPPLUS {(print_endline "binaire : +");}
       | OPMOINS {(print_endline "binaire : -");}
       | OPOU {(print_endline "binaire : ||");}
       | OPMULT {(print_endline "binaire : *");}
       | OPMOD {(print_endline "binaire : %");}
       | OPDIV {(print_endline "binaire : /");}
       | OPET {(print_endline "binaire : &&");}
       | OPNON {(print_endline "binaire : !");}
       | OPPT {(print_endline "binaire : .");}
%%
