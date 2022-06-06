open Util
open Mem
open Btree

(* Implémentation plus raffinée d'une mémoire associative à base de "bit tree" :
 * le bit tree est un arbre binaire où les branches à gauche correspondent à des
 * 0 dans l'adresse, et les branches à droite correspondent à des 1.
 *
 * Concrètement, une adresse sous forme binaire (b_1, b_2, ..., b_n) correspond
 * à un chemin dans l'arbre. Par ex :
 *     01100101  => G, D, D, G, G, D, G, D
 *
 * Lorsqu'on effectue une lecture, on emprunte le chemin correspondant à
 * l'adresse jusqu'à tomber sur une feuille. Si on atteint cette feuille et que
 * l'adresse est à 0 (plus aucun bit à lire ou potentiellement une suite de 0),
 * alors on a atteint l'emplacement mémoire, et la valeur est dans la feuille.
 *
 * Si on tombe sur une feuille alors que l'adresse n'est pas complètement lue,
 * c'est que l'emplacement n'existe pas, et on retourne donc la valeur par
 * défaut.
 *
 * Pour l'écriture, on procède similairement, mais si la valeur n'existe pas,
 * alors on crée le chemin depuis la racine qui correspond à l'adresse en
 * question.
 *)
module TreeMemory : Memory =
struct
    (* La mémoire est un arbre + une taille du bus d'adressage. *)
    type mem_type = btree

    (* Un type qui contient la mémoire + la taille de son bus d'adressage *)
    type mem = int * mem_type

    let name = "tree"

    (* Taille du bus d'adressage stockée dans le type lui-même *)
    let bussize (bs, _) = bs

    (* Taille maximum de la mémoire = 2^(taille du bus d'adressage) *)
    let size (bs, _) = pow2 bs

    (* Taille (approximative) en mémoire de l'arbre, pour évaluer les
     * performance de cette implémentation.
     *)
    let allocsize (_, tr) = let nombre = (num_nodes tr) in (nombre - nombre/2)

    (* Occupation de l'arbre. On ne compte que les feuilles non égales à 0. *)
    let busyness (_, tr) = num_values tr

    (* La mémoire vide est celle qui ne contient aucun chemin *)
    let rec clear bs = if bs = 1 then (bs, Node (Leaf _0, Leaf _0)) else
        let (_,tr) = (clear (bs-1)) in 
        (bs, Node (tr,tr))

    (* Implémentation de read. *)
    let read (bs, tr) addr = if addr < size(bs,tr) then (search tr (bits bs addr)) else raise OutOfBound 

    (* Implémentation de write. *)
    let write (bs, tr) addr value = if addr < size(bs,tr) then (bs,(update tr value (bits bs addr))) else raise OutOfBound
end
