open Util
open Mem


  (*   fonction qui retourne la valeur                                          
    associée à la clef e dans la liste l, ou la valeur fournie def
        si la clef n’existe pas              
     signature  : get_assoc : 'a -> ('a * 'b ) list -> 'b -> 'b                
     paramètres : - e : l'addresse dont on veut la valeur : 'a                  
                  - l : liste des couples adresses valeurs : ('a * 'b) list
                  - def : la valeur à retourner par défaut si la clé n'existe pas dans la liste  : 'b                              
     résultat   : le clé correspondante à e : 'b                              *)
let rec get_assoc e l def = match l with 
        | [] -> def
        | t::q -> let (cle,v) = t in if cle = e then v else (get_assoc e q def)

(* Tests unitaires : *)

let%test _ = (get_assoc 1 [(1,'r');(2,'a')] 'b' = 'r')
let%test _ = (get_assoc 2 [(1,'r');(2,'a')] 'b' = 'a')
let%test _ = (get_assoc 3 [(1,'r');(2,'a')] 'b' = 'b')

(*fonction qui ramplace la valeur                                          
    associée à la clef e dans la liste l par une valeur x ou ajoute le couple (e, x) si la clef n’existe pas déjà
     signature  : set_assoc : 'a -> ('a * 'b ) list -> 'b -> ('a * 'b ) list            
     paramètres : - e : l'addresse dont on veut remplacer la valeur : 'a                  
                  - l : liste des couples adresses valeurs : ('a * 'b ) list
                  - x : la valeur à associer à la clé dans la liste : 'b 
    résultat   : la nouvelle liste apres remplissage par x  ('a * 'b ) list *)
let rec set_assoc e l x = match l with 
    | [] -> [(e,x)]
    | t::q -> let (cle,_) = t in if cle = e then (e,x)::q else t::(set_assoc e q x)

(* Tests unitaires :  *)

let%test _ = (set_assoc 1 [(1,'r');(2,'a')] 'b' =  [(1,'b');(2,'a')])
let%test _ = (set_assoc 2 [(1,'r');(2,'a')] 'b' = [(1,'r');(2,'b')])
let%test _ = (set_assoc 3 [(1,'r');(2,'a')] 'b' = [(1,'r');(2,'a');(3,'b')])

module AssocMemory : Memory =
struct
    (* Type = liste qui associe des adresses (entiers) à des valeurs (caractères) *)
    type mem_type = (int*char) list

    (* Un type qui contient la mémoire + la taille de son bus d'adressage *)
    type mem = int * mem_type

    (* Nom de l'implémentation *)
    let name = "assoc"

    (* Taille du bus d'adressage *)
    let bussize (bs, _) = bs

    (* Taille maximale de la mémoire *)
    let size (bs, _) = pow2 bs

    (* Taille de la mémoire en mémoire *)
    let allocsize (_, m) = (List.length m)

    (* Nombre de cases utilisées *)
    let rec busyness (bs, m) = match m with  
        | [] -> 0
        | ((_,v)::q) -> if v = _0 then busyness (bs, q) else 1+busyness (bs, q)

    (* Construire une mémoire vide *)
    let rec clear bs = if bs = 1 then (bs, [(0,_0);(1,_0)]) else
        let (_,m) = (clear (bs-1)) in 
        (bs, m @ (List.map (fun x -> (bs+(fst x),(snd x))) m))

    (* Lire une valeur *)
    let read (bs, m) addr = if addr < (size (bs, m)) then (get_assoc addr m _0) else raise OutOfBound

    (* Écrire une valeur *)
    let write (bs, m) addr x = if addr < (size (bs, m)) then (bs,(set_assoc addr m x)) else raise OutOfBound
end
