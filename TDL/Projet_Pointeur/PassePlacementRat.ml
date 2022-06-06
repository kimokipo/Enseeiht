(* Module de la passe de gestion des types *)
module PassePlacementRat : Passe.Passe with type t1 = Ast.AstType.programme and type t2 = Ast.AstPlacement.programme =
struct

  open Tds
  open Exceptions
  open Ast
  open AstPlacement
  open Type

  type t1 = Ast.AstType.programme
  type t2 = Ast.AstPlacement.programme

(* analyse_placement_instruction : AstType.instruction ->  AstPlacement.instruction -> option typ *)
(* Paramètre i : l'instruction à analyser *)
(* Vérifie la bonne utilisation des identifiants et tranforme l'instruction
en une instruction de type AstPlacement.instruction *)
(* Erreur si mauvaise utilisation des identifiants *)
let rec analyse_placement_instruction base reg i =
  (match i with
  | AstType.Declaration (info, _) ->    
            begin (match (info_ast_to_info info) with 
            | InfoVar(_,t,_,_)-> modifier_adresse_info base reg info; (Type.getTaille t)
            |_ -> assert false)
            end
      (* Renvoie du nouvel affichage où l'expression remplacée par l'expression issue de l'analyse *)
  | AstType.Conditionnelle (_,t,e) -> 
            analyse_placement_bloc base reg t;
            analyse_placement_bloc base reg e;
            0
  | AstType.TantQue (_,b) -> 
      analyse_placement_bloc base reg b;
      0
  | _-> 0)
(* analyse_placement_bloc : AstType.bloc -> AstPlacement.bloc*)
(* Paramètre li : liste d'instructions à analyser *)
(* Vérifie la bonne utilisation des identifiants et tranforme le bloc
en un bloc de type AstPlacement.bloc *)
(* Erreur si mauvaise utilisation des identifiants *)
and analyse_placement_bloc base reg li =

    List.fold_left (fun base i -> base + analyse_placement_instruction base reg i) base li |> ignore



(* analyse_placement_fonction : AstType.fonction -> AstPlacement.fonction * typ*)
(* Paramètre tds : la table des symboles courante *)
(* Paramètre : la fonction à analyser *)
(* Vérifie la bonne utilisation des identifiants et tranforme la fonction
en une fonction de type AstPlacement.fonction *)
(* Erreur si mauvaise utilisation des identifiants *)
let analyse_placement_fonction (Ast.AstType.Fonction(info,lp,li)) = 
    let analyse_parameters infos = 
        List.fold_right ( fun info base -> 
            match (info_ast_to_info info) with
            | InfoVar(_,t,_,_) -> let nbase = base - (Type.getTaille t) in
              modifier_adresse_info nbase "LB" info;
              nbase
            | _ -> assert false) infos (0) |> ignore in
    analyse_parameters lp;
    analyse_placement_bloc 3 "LB" li;
    Ast.AstPlacement.Fonction(info,lp,li)

  

(* analyser : AstType.ast -> AstPlacement.ast *)
(* Paramètre : le programme à analyser *)
(* Vérifie la bonne utilisation des identifiants et tranforme le programme
en un programme de type AstPlacement.ast *)
(* Erreur si mauvaise utilisation des identifiants *)
let analyser (AstType.Programme (fonctions,prog)) =
  let nfcts = List.map (analyse_placement_fonction) fonctions in
    analyse_placement_bloc 0 "SB" prog;
    Ast.AstPlacement.Programme(nfcts,prog)
end
