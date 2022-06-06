(* Définition du type d'environnement d’évaluation *)
  type env = (string*int) list

(* Evaluation des expressions simples *)


(* Module abstrayant les expressions *)
module type ExprSimple =
sig
  type t
  val const : int -> t
  val plus : t -> t -> t
  val mult : t-> t -> t
end

(* Module abstrayant la présence de variable dans les expressions *)
module type ExprVar =
sig
  type t
  val def : string -> t -> t -> t
  val var : string -> t
end

(* Module abstrayant les expressions dans leur intégralité*)
module type Expr =
sig
  include ExprSimple
  include (ExprVar with type t := t)
end

(* Module réalisant l'évaluation d'une expression *)
module EvalSimple : ExprSimple with type t = int =
struct
  type t = int
  let const c = c
  let plus e1 e2 = e1 + e2
  let mult e1 e2 = e1 * e2
end

(* Module permet de compter les opérations
        d’une expression. *)
module CompteSimple : ExprSimple with type t = int =
struct
  type t = int
  let const c = 0
  let plus e1 e2 =  e1 + e2 + 1
  let mult e1 e2 =  e1 + e2 + 1
end

(* Module permet de convertir les expressions en
        chaîne de caractères. *)
module PrintSimple : ExprSimple with type t = string =
struct
  type t = string
  let const c = string_of_int c
  let plus e1 e2 =  "( "^e1^" + "^e2^" )"
  let mult e1 e2 =  "( "^e1^" * "^e2^" )"
end

(* Module permet d’évaluer les expressions simples, en propageant l’environnement. *)
module EvalSimpleEnv : ExprSimple with type t = env -> int =
struct
  type t = env -> int
  let const c = fun _env -> c
  let plus e1 e2 =  fun env -> (e1 env) + (e2 env)
  let mult e1 e2 =  fun env -> (e1 env) * (e2 env)
end

(* Module permet de convertir les expressions avec
  variables en chaînes de caractères. *)
module PrintVar : ExprVar with type t = string =
struct
  type t = string
  let def id e1 e2 = "let "^id^" = " ^e1^" in "^e2
  let var id =  id
end

(* Module permet d'évaluer les expressions avec variables. *)
module EvalVar : ExprVar with type t = env -> int =
struct
  type t = env -> int
  let def id e1 e2 = fun env -> e2 ((id,e1 env)::env)
  let var id = try List.assoc id with Not_found -> failwith "forme_expression_invalide" 
end

(* Module permet de onvertir les expressions avec
  variables en chaînes de caractères. *)
module Print : Expr with type t = string =
struct
  include PrintSimple
  include (PrintVar : ExprVar with type t := t)
end

(* Module permet d’évaluer les expressions dans leur
intégralité. *)
module Eval : Expr with type t = env -> int =
struct
  include EvalSimpleEnv
  include (EvalVar : ExprVar with type t := t)
end

(* Solution 1 pour tester *)
(* A l'aide de foncteur *)

(* Définition des expressions *)
module ExemplesSimples (E:ExprSimple) =
struct
  (* 1+(2*3) *)
  let exemple1  = E.(plus (const 1) (mult (const 2) (const 3)) )
  (* (5+2)*(2*3) *)
  let exemple2 =  E.(mult (plus (const 5) (const 2)) (mult (const 2) (const 3)) )
end

(* Définition des expressions *)
module ExemplesSimples2 (E:Expr) =
struct
  include ExemplesSimples(E)
  (* let x = 1+2 in x*3 *)
  let exemple3  = E.(def "x" (plus (const 1) (const 2)) (mult (var "x") (const 3)) )
end

(*) Module d'affichage des exemples *)
module PrintExemples2 =  ExemplesSimples2 (Print)


let%test _ = (PrintExemples2.exemple1 = "( 1 + ( 2 * 3 ) )")
let%test _ = (PrintExemples2.exemple2 = "( ( 5 + 2 ) * ( 2 * 3 ) )")
let%test _ = (PrintExemples2.exemple3 = "let x = ( 1 + 2 ) in ( x * 3 )")

(* Module d'évaluation des exemples *)
module EvalExemples2 =  ExemplesSimples2 (Eval)

let%test _ = (EvalExemples2.exemple1 [] = 7)
let%test _ = (EvalExemples2.exemple2 [] = 42)
let%test _ = (EvalExemples2.exemple3 [] = 9)

(* Module d'évaluation des exemples *)
module EvalExemples =  ExemplesSimples (EvalSimple)

let%test _ = (EvalExemples.exemple1 = 7)
let%test _ = (EvalExemples.exemple2 = 42)

(*) Module d'affichage des exemples *)
module PrintExemples =  ExemplesSimples (PrintSimple)

let%test _ = (PrintExemples.exemple1 = "( 1 + ( 2 * 3 ) )")
let%test _ = (PrintExemples.exemple2 = "( ( 5 + 2 ) * ( 2 * 3 ) )")


(* Module de calcul des opérations des exemples *)
module CompteExemples =  ExemplesSimples (CompteSimple)

let%test _ = (EvalExemples.exemple1 = 2)
let%test _ = (EvalExemples.exemple2 = 3)