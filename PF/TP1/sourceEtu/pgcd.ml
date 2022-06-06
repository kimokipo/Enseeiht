(** pgcd : int -> int
   calcule le pgcd de deux entiers a et b
   Parametre a : int, le premier nombre 
   Parametre b : int, le deuzième nombre 
   Resultat : int, pgcd de a et b
   Précondition : a, b positfs
*)
let rec pgcd a b = if b = 0 then a else
                if a = 0 then b else if a > b then pgcd (a-b) b else pgcd a (b-a)
let%test _ = pgcd 0 5 = 5
let%test _ = pgcd 1 0 = 1
let%test _ = pgcd 21 9 = 3
let%test _ = pgcd 14 35 = 7

