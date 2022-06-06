(* Module de la passe de gestion des types *)
module PasseTypeRat : Passe.Passe with type t1 = Ast.AstTds.programme and type t2 = Ast.AstType.programme =
struct

  open Tds
  open Exceptions
  open Ast
  open AstType
  open Type

  type t1 = Ast.AstTds.programme
  type t2 = Ast.AstType.programme

let rec chercher l = match l with
  |[] -> None
  | (a::q) -> match a with
      | None -> chercher q
      | Some t -> Some t 

let rec analyse_type_affectable a = 
  (match a with 
    |Ast.AstTds.Ident info_ast -> 
  begin(match info_ast_to_info info_ast with
              | InfoVar (n,t,_,_) -> AstTds.Ident info_ast,t
              | InfoConst (_,_) ->   AstTds.Ident info_ast,Int
              | _ -> assert false)
  end
   |Ast.AstTds.Deref na -> let naa,t = analyse_type_affectable na in 
      (match t with
        |Pointeur nt ->  AstTds.Deref(naa),nt
        |_ -> raise (TypeInattendu (t,Pointeur Undefined))))


(* analyse_type_expression : AstTds.expression -> AstType.expression * typ *)
(* Paramètre e : l'expression à analyser *)
(* Vérifie la bonne utilisation des identifiants et tranforme l'expression
en une expression de type AstType.expression *)
(* Erreur si mauvaise utilisation des identifiants *)
let rec analyse_type_expression e = (match e with 
  |Ast.AstTds.Affectable a -> let na,t = analyse_type_affectable a in Ast.AstType.Affectable(na),t
  |Ast.AstTds.Booleen b -> Ast.AstType.Booleen b,Bool
  |Ast.AstTds.Entier n -> Ast.AstType.Entier n,Int
  |Ast.AstTds.NEW t -> Ast.AstType.NEW t,Pointeur t
  |Ast.AstTds.Adresse info_ast -> 
  begin(match info_ast_to_info info_ast with
              | InfoVar (_,t,_,_) -> Ast.AstType.Adresse info_ast,Pointeur t
              | _ -> assert false)
  end 
  |Ast.AstTds.NULL -> Ast.AstType.NULL,Pointeur Undefined
  |Ast.AstTds.Binaire (op,e1,e2) -> 
    let ne1,t1 = analyse_type_expression  e1 in
    let ne2,t2 = analyse_type_expression  e2 in
    begin (match op with 
      | Ast.AstSyntax.Fraction -> if ((est_compatible t1 Int) && (est_compatible t2 Int)) then
                       Ast.AstType.Binaire (Ast.AstType.Fraction,ne1,ne2),Rat else 
                              raise (TypeBinaireInattendu (Fraction,t1,t2))
      | Ast.AstSyntax.Plus -> if ((est_compatible t1 Int) && (est_compatible t2 Int)) then
                  Ast.AstType.Binaire (PlusInt,ne1,ne2),Int else 
                    if ((est_compatible t1 Rat) && (est_compatible t2 Rat)) then
                         Ast.AstType.Binaire (PlusRat,ne1,ne2),Rat else 
                      raise (TypeBinaireInattendu (Plus,t1,t2))
     | Ast.AstSyntax.Mult -> if ((est_compatible t1 Int) && (est_compatible t2 Int)) then
                 Ast.AstType.Binaire (MultInt,ne1,ne2),Int else 
                     if ((est_compatible t1 Rat) && (est_compatible t2 Rat)) then
                           Ast.AstType.Binaire (MultRat,ne1,ne2),Rat else 
                              raise (TypeBinaireInattendu (Mult,t1,t2))
     | Ast.AstSyntax.Equ -> if ((est_compatible t1 Int) && (est_compatible t2 Int)) then
                Ast.AstType.Binaire (EquInt,ne1,ne2),Bool else 
                               if ((est_compatible t1 Bool) && (est_compatible t2 Bool)) then
                                   Ast.AstType.Binaire (EquBool,ne1,ne2),Bool else 
                                     if ((est_compatible t1 (Pointeur Undefined)) && (est_compatible t1 t2)) then 
                                        Ast.AstType.Binaire (EquRef,ne1,ne2),Bool else 
                                raise (TypeBinaireInattendu (Equ,t1,t2))
     | Ast.AstSyntax.Inf -> if ((est_compatible t1 Int) && (est_compatible t2 Int)) then
            Ast.AstType.Binaire (Ast.AstType.Inf,ne1,ne2),Bool else
                                   raise (TypeBinaireInattendu (Inf,t1,t2)))

    end
  |Ast.AstTds.Unaire (op,e1) -> 
    let ne1,t1 = analyse_type_expression e1 in
    if (est_compatible t1 Rat) then match op with
     |Numerateur ->  
    Ast.AstType.Unaire (Numerateur,ne1),Int
   | Denominateur -> 
   Ast.AstType.Unaire (Denominateur,ne1),Int  else raise (TypeInattendu (t1,Rat))

 |Ast.AstTds.AppelFonction (info,es) ->
 begin (match info_ast_to_info info with
            | InfoFun (_,t,ts) -> let tes = [] in
            (try 
              let nes,tes = List.split(List.map2 (fun e t -> 
                let ne,te = analyse_type_expression e in let condition = (est_compatible te t) in if condition then (ne,te) else 
                      raise (TypeInattendu (te,t))) es ts) in Ast.AstType.AppelFonction(info,nes),t
            with _ -> raise (TypesParametresInattendus (ts,tes)))
            | _ -> assert false)
end)
  



  




(* analyse_type_instruction : AstTds.instruction ->  AstType.instruction -> option typ *)
(* Paramètre i : l'instruction à analyser *)
(* Vérifie la bonne utilisation des identifiants et tranforme l'instruction
en une instruction de type AstType.instruction *)
(* Erreur si mauvaise utilisation des identifiants *)
let rec analyse_type_instruction i =
  match i with
  | AstTds.Declaration (t, info, e) ->  
        
        Tds.modifier_type_info t info;
            let ne,te = analyse_type_expression e in
                let condition = (est_compatible te t) in if condition then 
                (* Renvoie de la nouvelle déclaration où le nom a été remplacé par l'information 
                et l'expression remplacée par l'expression issue de l'analyse *)
                Ast.AstType.Declaration (info, ne),None else raise (TypeInattendu (te,t))

  | AstTds.Affectation (a,e) -> 
    let ne,te = analyse_type_expression e in
        (match a with 
          |Ast.AstTds.Ident info_ast -> 
        begin(match info_ast_to_info info_ast with
                    | InfoVar (_,t,_,_) -> if (est_compatible te t) then Ast.AstType.Affectation (Ident info_ast, ne),None else raise (TypeInattendu (te,t))
                    | _ -> assert false)
        end
        |Ast.AstTds.Deref na -> let naa,t = analyse_type_affectable na in
            (match t with
              |Pointeur nt -> if (est_compatible te nt) then Ast.AstType.Affectation (Deref(naa), ne),None else raise (TypeInattendu (te,nt))
              |_ -> raise (TypeInattendu (t,Pointeur Undefined))))
  
| AstTds.AssignationAddition (a,e) ->
let na1,t1 = analyse_type_affectable a in
    (* Vérification de la bonne utilisation des identifiants dans l'expression *)
    (* et obtention de l'expression transformée *) 
    let ne,te = analyse_type_expression e in
    (* Renvoie de la nouvelle affectation où le nom a été remplacé par l'information 
    et l'expression remplacée par l'expression issue de l'analyse *)
        if (est_compatible t1 te) then 
          match t1 with
            |Int -> AstType.AssignationAddition (na1,ne,Int),None
            |Rat -> AstType.AssignationAddition (na1,ne,Rat),None
            |_ -> raise (TypeInattendu (t1,Undefined))
        else
          raise (TypeBinaireInattendu (Plus,t1,te))

  | AstTds.Empty -> 
        Ast.AstType.Empty,None
  | AstTds.Affichage e -> 
      (* Vérification de la bonne utilisation des identifiants dans l'expression *)
      (* et obtention de l'expression transformée *)
      let ne,te = analyse_type_expression e in if (est_compatible te Int) then 
                Ast.AstType.AffichageInt(ne),None else 
                  if (est_compatible te Rat) then 
                      Ast.AstType.AffichageRat(ne),None else 
                        if (est_compatible te Bool) then 
                          Ast.AstType.AffichageBool(ne),None else 
                          assert false
      (* Renvoie du nouvel affichage où l'expression remplacée par l'expression issue de l'analyse *)
  | AstTds.Conditionnelle (c,t,e) -> 
      (* Analyse de la condition *)
      let nc,tc = analyse_type_expression c in if (est_compatible tc Bool) then 
            let tast,tt = analyse_type_bloc t in
            (* Analyse du bloc else *)
            let east,te = analyse_type_bloc e in match (tt,te) with 
                  | (None,None) -> Ast.AstType.Conditionnelle (nc, tast, east),None 
                  | (None, Some te) -> raise (TypeInattendu (Undefined,te)) 
                  | (Some tt,None) -> raise (TypeInattendu (tt,Undefined)) 
                  | (Some tt, Some te) -> if(est_compatible tt te) then
            (* Renvoie la nouvelle structure de la conditionnelle *)
                Ast.AstType.Conditionnelle (nc, tast, east),Some te else raise (TypeInattendu (tt,te))
      else raise (TypeInattendu (tc,Bool))
  | AstTds.TantQue (c,b) -> 
      (* Analyse de la condition *)
      let nc,tc = analyse_type_expression c in if (est_compatible tc Bool) then 
      (* Analyse du bloc *)
      let bast,tb = analyse_type_bloc b in match tb with
          | None -> Ast.AstType.TantQue (nc, bast),None
          | Some tb -> 
      (* Renvoie la nouvelle structure de la boucle *)
      Ast.AstType.TantQue (nc, bast),Some tb else raise (TypeInattendu (tc,Bool))
  | AstTds.Retour (e) -> 
      (* Analyse de l'expression *)
      let ne,te = analyse_type_expression e in
      Ast.AstType.Retour (ne),Some te

      
(* analyse_type_bloc : AstTds.bloc -> AstType.bloc*)
(* Paramètre li : liste d'instructions à analyser *)
(* Vérifie la bonne utilisation des identifiants et tranforme le bloc
en un bloc de type AstType.bloc *)
(* Erreur si mauvaise utilisation des identifiants *)
and analyse_type_bloc li =
  (* Entrée dans un nouveau bloc, donc création d'une nouvelle tds locale 
  pointant sur la table du bloc parent *)
  (* Analyse des instructions du bloc avec la tds du nouveau bloc 
  Cette tds est modifiée par effet de bord *)
   let nli,ts = List.split(List.map (fun i -> analyse_type_instruction i) li) in

   let t = chercher ts in
   
   (* afficher_locale tdsbloc ; *) (* décommenter pour afficher la table locale *)
   nli,t


(* analyse_type_fonction : AstTds.fonction -> AstType.fonction * typ*)
(* Paramètre tds : la table des symboles courante *)
(* Paramètre : la fonction à analyser *)
(* Vérifie la bonne utilisation des identifiants et tranforme la fonction
en une fonction de type AstType.fonction *)
(* Erreur si mauvaise utilisation des identifiants *)
let analyse_type_fonction (Ast.AstTds.Fonction(t,info,lp,li)) = 
        List.iter (fun (ti,info) -> modifier_type_info ti info) lp;
        let list_type,list_info = List.split lp in  
         modifier_type_fonction_info t list_type info;
        let lie,tb = analyse_type_bloc li in
        match tb with
          | None -> raise (RetourAbscentDansFunction)
          | Some te -> 
          let condition = (est_compatible te t) in if condition then 
        Ast.AstType.Fonction (info,list_info,lie),t else raise (TypeInattendu (te,t))
  

(* analyser : AstTds.ast -> AstType.ast *)
(* Paramètre : le programme à analyser *)
(* Vérifie la bonne utilisation des identifiants et tranforme le programme
en un programme de type AstType.ast *)
(* Erreur si mauvaise utilisation des identifiants *)

let analyser (AstTds.Programme (fonctions,prog)) =
  let nf,_ = List.split(List.map (analyse_type_fonction) fonctions) in 
  let nb,t = analyse_type_bloc prog in
  match t with 
    |None ->  Programme (nf,nb)
    | Some _ -> raise (RetourDansMain)
end
