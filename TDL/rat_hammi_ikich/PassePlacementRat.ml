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

(* Analyse le placement d'un instuction et renvoie la nouvelle instruction *)
let rec analyse_placement_instruction base reg i =
  (match i with
  | AstType.Declaration (info, _) ->    
            begin (match (info_ast_to_info info) with 
            | InfoVar(_,t,_,_,_)-> modifier_adresse_info base reg info; (Type.getTaille t)
            | InfoStruct(_,lp,_,_)-> let list_types_noms = List.map (fun (t,info) -> (match info_ast_to_info info with 
                  | InfoVar (n,_,_,_,_) -> (t,n) 
                  | InfoStruct (n,_,_,_) -> (t,n) 
                  | _ -> assert false )) lp in modifier_adresse_info base reg info; (Type.getTaille (TypeStruct list_types_noms))
            |_ -> assert false)
            end
  | AstType.Conditionnelle (_,t,e) -> 
            analyse_placement_bloc base reg t;
            analyse_placement_bloc base reg e;
            0
  | AstType.TantQue (_,b) -> 
      analyse_placement_bloc base reg b;
      0
  | _-> 0)

(* Analyse le placement d'un bloc et renvoie le nouveau bloc *)
and analyse_placement_bloc base reg li =

    List.fold_left (fun base i -> base + analyse_placement_instruction base reg i) base li |> ignore



(* Analyse le placement d'une fonction et renvoie la nouvelle fonction *)
let analyse_placement_fonction (Ast.AstType.Fonction(info,lp,li)) = 
    let analyse_parameters infos = 
        List.fold_right ( fun info base -> 
            match (info_ast_to_info info) with
            | InfoVar(_,t,_,_,_) -> let nbase = base - (Type.getTaille t) in
              modifier_adresse_info nbase "LB" info;
              nbase
            | InfoStruct(_,lp,_,_) -> let list_types_noms = List.map (fun (t,info) -> (match info_ast_to_info info with 
                    | InfoVar (n,_,_,_,_) -> (t,n) 
                    | InfoStruct (n,_,_,_) -> (t,n) 
                    | _ -> assert false)) lp in let nbase = base - (Type.getTaille (TypeStruct list_types_noms)) in
                        modifier_adresse_info nbase "LB" info;
                        nbase
            | _ -> assert false) infos (0) |> ignore in
    analyse_parameters lp;
    analyse_placement_bloc 3 "LB" li;
    Ast.AstPlacement.Fonction(info,lp,li)


(* Analyse le placement d'un programme et renvoie le nouveau programme *)

let rec analyser p = 
  (match p with 
  |AstType.Programme (defTypes,fonction,p1) ->  let nf = analyse_placement_fonction fonction in 
  let np = analyser p1 in
  Programme (defTypes,nf,np)
  | Ast.AstType.Bloc b -> 
      analyse_placement_bloc 0 "SB" b;
      Ast.AstPlacement.Bloc(b))
end
