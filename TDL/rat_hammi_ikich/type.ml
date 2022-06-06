
type typ = Bool | Int | Rat | Pointeur of typ | TypeNomme of string | TypeStruct of (typ*string) list | Undefined 

let list_types_recursifs = ref []

let rec string_of_type t = 
  match t with
  | Bool ->  "Bool"
  | Int  ->  "Int"
  | Rat  ->  "Rat"
  | Pointeur t  -> (string_of_type t) ^ " *"
  | TypeNomme n -> n
  | TypeStruct lp -> "{" ^ List.fold_left (fun acc (t,x) -> acc ^" "^(string_of_type t)^" "^x)"" lp ^"}"
  | Undefined -> "Undefined"


(* Renvoie true si le couple des deux types (t1,t2) est dans la liste *)
let rec chercherTypes listref (t1,t2) =
  match listref with
    | [] -> false
    | ((te1,te2)::q) -> if ((est_compatible t1 te1) && (est_compatible t2 te2)) then true else chercherTypes q (t1,t2)

and est_compatible t1 t2 =
  match t1, t2 with
  | Bool, Bool -> true
  | Int, Int -> true
  | Rat, Rat -> true 
  | Pointeur Undefined, Pointeur _ -> true 
  | Pointeur _, Pointeur Undefined -> true 
  | TypeStruct lp1, TypeStruct lp2 -> let ts1 = fst (List.split lp1) in let ts2 = fst (List.split lp2) in let condition = List.fold_left2 (fun acc x y -> acc && (est_compatible x y)) true ts1 ts2 in condition
  | Pointeur t1, Pointeur t2 -> est_compatible t1 t2
  | TypeNomme n1, TypeNomme n2 -> String.compare n1 n2 == 0
  | TypeNomme _, TypeStruct _ -> if (chercherTypes !(list_types_recursifs) (t1,t2)) then true else false
  | _ -> false

let%test _ = est_compatible Bool Bool
let%test _ = est_compatible Int Int
let%test _ = est_compatible Rat Rat
let%test _ = not (est_compatible Int Bool)
let%test _ = not (est_compatible Bool Int)
let%test _ = not (est_compatible Int Rat)
let%test _ = not (est_compatible Rat Int)
let%test _ = not (est_compatible Bool Rat)
let%test _ = not (est_compatible Rat Bool)
let%test _ = not (est_compatible Undefined Int)
let%test _ = not (est_compatible Int Undefined)
let%test _ = not (est_compatible Rat Undefined)
let%test _ = not (est_compatible Bool Undefined)
let%test _ = not (est_compatible Undefined Int)
let%test _ = not (est_compatible Undefined Rat)
let%test _ = not (est_compatible Undefined Bool)

let est_compatible_list lt1 lt2 =
  try
    List.for_all2 est_compatible lt1 lt2
  with Invalid_argument _ -> false

let%test _ = est_compatible_list [] []
let%test _ = est_compatible_list [Int ; Rat] [Int ; Rat]
let%test _ = est_compatible_list [Bool ; Rat ; Bool] [Bool ; Rat ; Bool]
let%test _ = not (est_compatible_list [Int] [Int ; Rat])
let%test _ = not (est_compatible_list [Int] [Rat ; Int])
let%test _ = not (est_compatible_list [Int ; Rat] [Rat ; Int])
let%test _ = not (est_compatible_list [Bool ; Rat ; Bool] [Bool ; Rat ; Bool ; Int])

let rec getTaille t =
  match t with
  | Int -> 1
  | Bool -> 1
  | Rat -> 2
  | Undefined -> 0
  | TypeStruct lp -> List.fold_left (fun acc (t,_) -> acc+(getTaille t)) 0 lp
  | TypeNomme _ -> 0
  | Pointeur _ -> 1
  
let%test _ = getTaille Int = 1
let%test _ = getTaille Bool = 1
let%test _ = getTaille Rat = 2
