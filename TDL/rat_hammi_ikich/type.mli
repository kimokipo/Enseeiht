(* Types manipulés dans Rat *)
type typ = Bool | Int | Rat | Pointeur of typ | TypeNomme of string | TypeStruct of (typ*string) list | Undefined

(* Pointeur sur la liste des couples (type Nomme Récurssif, Type Struct Associé) *)
val list_types_recursifs : (typ*typ) list ref 

(* string_of_type :  typ -> string *)
(* transforme un typ en chaîne de caractère *)
val string_of_type : typ -> string  

(* est_compatible : typ -> typ -> bool *)
(* vérifie que le second type est compatible avec le premier *)
(* c'est à dire qu'un élèment du second type peut être affecté *)
(* à un élément du premier type *)
val est_compatible : typ -> typ -> bool

(* est_compatible_list : typ list -> typ list -> bool *)
(* vérifie si les types sont compatibles deux à deux *)
val est_compatible_list : typ list -> typ list -> bool

(* getTaille : typ -> int *)
(* Renvoie la taille en mémoire qui doit prendre une variable en fonction de son type *)
val getTaille : typ -> int 
