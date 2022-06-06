(* Module de la passe de gestion des types *)
module PasseCodeRatToTam : Passe.Passe with type t1 = Ast.AstPlacement.programme and type t2 = string =
struct

  open Tds
  open Exceptions
  open Ast
  open String
  open Type
  open Code

  type t1 = Ast.AstPlacement.programme
  type t2 = string

  
  let rec analyse_code_affectable affect a = 
    (match a with 
      |Ast.AstTds.Ident info_ast ->
        begin(match info_ast_to_info info_ast with
                    | InfoVar (_,t,d,r) -> if affect then "\nSTORE (" ^ string_of_int (Type.getTaille t) ^ ") "  ^ string_of_int d ^ "[" ^ r ^ "]",t else "LOAD (" ^ (string_of_int (getTaille t)) ^ ") "  ^ string_of_int d ^ "[" ^ r ^ "]",t
                    | InfoConst (_,n) -> "LOADL " ^ (string_of_int n),Int
                    | _ -> assert false)
        end
      |Ast.AstTds.Deref na -> let nna,t = analyse_code_affectable false na in (match t with
                |Pointeur nt -> if affect then nna ^ "\nSTOREI ("^(string_of_int (getTaille nt))^")",t else nna ^ "\nLOADI ("^(string_of_int (getTaille nt))^")",t
                |_ -> assert false))

  let rec analyse_code_expression e = (match e with 
  |Ast.AstType.Affectable a -> let na,t = analyse_code_affectable false a in na
  |Ast.AstType.NEW t -> "LOADL "^string_of_int (getTaille t)^"\nSUBR MAlloc" 
  |Ast.AstType.NULL -> "LOADL -1"
  |Ast.AstType.Adresse info_ast -> 
  begin(match info_ast_to_info info_ast with
              | InfoVar (_,_,d,r) -> "LOADA "  ^ string_of_int d ^ "[" ^ r ^ "]"
              | _ -> assert false)
  end   
  |Ast.AstType.Booleen b -> if b then "LOADL 1" else "LOADL 0"
  |Ast.AstType.Entier n -> "LOADL " ^ (string_of_int n)
  |Ast.AstType.Binaire (op,e1,e2) -> 
      let ne1 = (analyse_code_expression e1) in 
      let ne2 = (analyse_code_expression e2) in
    begin (match op with 
      | Ast.AstType.Fraction -> ne1 ^ "\n" ^ ne2 ^ "\n" ^ "CALL (SB) norm"
       
      | Ast.AstType.PlusInt -> ne1 ^ "\n" ^ ne2 ^ "\n" ^ "SUBR IAdd"
      
      | Ast.AstType.PlusRat -> ne1 ^ "\n" ^ ne2 ^ "\n" ^ "CALL (SB) RAdd"
      
     | Ast.AstType.MultInt -> ne1 ^ "\n" ^ ne2 ^ "\n" ^ "SUBR IMul"

     | Ast.AstType.MultRat -> ne1 ^ "\n" ^ ne2 ^ "\n" ^ "CALL (SB) RMul"
     
     | Ast.AstType.EquInt -> ne1 ^ "\n" ^ ne2 ^ "\n" ^ "SUBR IEq"

     | Ast.AstType.EquBool -> ne1 ^ "\n" ^ ne2 ^ "\n" ^ "SUBR IEq"
     
     | Ast.AstType.Inf -> ne1 ^ "\n" ^ ne2 ^ "\n" ^ "SUBR ILss"
     | Ast.AstType.EquRef -> ne1 ^ "\n" ^ ne2 ^ "\n" ^ "SUBR IEq")
end 
| Ast.AstType.Unaire(op,e1) -> (match e1 with
     |Ast.AstType.Affectable a -> let na,_ = analyse_code_affectable false a in
        (match op with
          | Numerateur -> na^ "\nPOP (0) 1"
          | Denominateur-> na ^"\nSTORE (1) -2[ST]"
                        | _ -> assert false)
     |_ -> assert false)

 |Ast.AstType.AppelFonction (info,es) ->
 begin (match info_ast_to_info info with
            | InfoFun (n,t,ts) -> 
              let nes = List.fold_left (fun acc e -> let ne = (analyse_code_expression e) in acc  ^ "\n" ^ ne ) "" es in
                nes ^ "\n" ^ "CALL (LB) " ^ n
            | _ -> assert false)
end)  
(* analyse_code_instruction : AstPlacement.instruction ->  String.instruction -> option typ *)
(* Paramètre i : l'instruction à analyser *)
(* Vérifie la bonne utilisation des identifiants et tranforme l'instruction
en une instruction de type String.instruction *)
(* Erreur si mauvaise utilisation des identifiants *)
let rec analyse_code_instruction i tailleType nbparam =
  (match i with
  | Ast.AstType.Declaration (info, e) -> let ne = (analyse_code_expression e) in 
            (match info_ast_to_info info with 
            | InfoVar(_,t,d,r)-> ("\nPUSH " ^ string_of_int (Type.getTaille t)) ^ "\n" ^ ne ^ "\n" ^ "STORE (" ^ 
                          string_of_int (Type.getTaille t) ^ ") "  ^ string_of_int d ^ "[" ^ r ^ "]",(getTaille t)
            |_->assert false)    (* Renvoie du nouvel affichage où l'expression remplacée par l'expression issue de l'analyse *)
  | Ast.AstType.Affectation(a,e) -> let na,_ = analyse_code_affectable true a in let ne = (analyse_code_expression e) in ne ^ "\n"^na,0
  
| AstType.AssignationAddition (a,e,t) ->
  (match t with
    | Int -> let ne = AstType.Binaire(PlusInt,AstType.Affectable(a),e) in
        let a,_ = analyse_code_instruction (AstType.Affectation (a,ne)) tailleType nbparam in a,0
    |Rat -> let ne = AstType.Binaire(PlusRat,AstType.Affectable(a),e) in
      let a,_ = analyse_code_instruction (AstType.Affectation (a,ne)) tailleType nbparam in a,0
    | _ -> assert false)
 | Ast.AstType.Conditionnelle (c,t,e) ->let etiquette = getEtiquette() in let ne = (analyse_code_expression c) in ne ^ "\n" ^ "JUMPIF (1) if_true"^etiquette ^ "\n" ^ (analyse_code_bloc e tailleType nbparam) ^ "\nJUMP if_fin"^etiquette^"\nif_true"^etiquette ^ "\n" ^ (analyse_code_bloc t tailleType nbparam) ^ "\nif_fin"^etiquette,0

  | Ast.AstType.TantQue (c,b) ->  let etiquette = getEtiquette() in let ne = (analyse_code_expression c) in "JUMP whileTest"^ etiquette ^ "\n" ^ "whileDebut"^etiquette ^ "\n" ^ (analyse_code_bloc b tailleType nbparam) ^ "\n" ^ "whileTest"^etiquette ^ "\n" ^ ne ^ "\n" ^ "JUMPIF (1) whileDebut"^etiquette,0
  
  | Ast.AstType.AffichageInt (e) ->  let ne = (analyse_code_expression e) in ne ^ "\n" ^ "SUBR IOut",0
       | Ast.AstType.AffichageRat(e) -> let ne = (analyse_code_expression e) in ne ^ "\n" ^ "CALL (SB) ROut",0
       | Ast.AstType.AffichageBool(e) ->  let ne = (analyse_code_expression e) in ne  ^ "\n" ^ "SUBR BOut",0
      (* Renvoie la nouvelle structure de la boucle *)
  | Ast.AstType.Retour(e) -> let ne = (analyse_code_expression e) in if ((tailleType = 0) && (nbparam = 0)) then ne,0 else ne ^ "\nRETURN ("^(string_of_int tailleType)^") "^ (string_of_int nbparam),0
  | _ -> "",0)


      
(* analyse_code_bloc : AstPlacement.bloc -> String.bloc*)
(* Paramètre li : liste d'instructions à analyser *)
(* Vérifie la bonne utilisation des identifiants et tranforme le bloc
en un bloc de type String.bloc *)
(* Erreur si mauvaise utilisation des identifiants *)
and analyse_code_bloc li tailleType nbparam =
  (* Entrée dans un nouveau bloc, donc création d'une nouvelle tds locale 
  pointant sur la table du bloc parent *)
  (* Analyse des instructions du bloc avec la tds du nouveau bloc 
  Cette tds est modifiée par effet de bord *) 
    let e,s = List.fold_left(fun acc i -> let ni,n = (analyse_code_instruction i tailleType nbparam) in ((fst acc) ^ "\n" ^ ni,(snd acc)+n)) ("",0) li in if (s > 0) then e^"\nPOP (0) "^ (string_of_int s) else e



(* analyse_code_fonction : AstPlacement.fonction -> String.fonction * typ*)
(* Paramètre tds : la table des symboles courante *)
(* Paramètre : la fonction à analyser *)
(* Vérifie la bonne utilisation des identifiants et tranforme la fonction
en une fonction de type String.fonction *)
(* Erreur si mauvaise utilisation des identifiants *)
let analyse_code_fonction (Ast.AstPlacement.Fonction(info,lp,li)) = 
          (match info_ast_to_info info with 
            | InfoFun (n,t,ts) -> let nbparam = List.fold_left(fun acc te -> acc+getTaille te) 0 ts in let tailleType = getTaille t in n ^ "\n" ^ analyse_code_bloc li tailleType nbparam
            | _ -> assert false)
        
  


(* analyser : AstPlacement.ast -> String.ast *)
(* Paramètre : le programme à analyser *)
(* Vérifie la bonne utilisation des identifiants et tranforme le programme
en un programme de type String.ast *)
(* Erreur si mauvaise utilisation des identifiants *)
let analyser (AstPlacement.Programme (fonctions,prog)) =
  let nf = List.fold_left (fun acc f -> acc ^ "\n" ^ analyse_code_fonction f) "" fonctions in 
  getEntete () ^ "\n" ^ nf ^ "\nmain\n" ^ analyse_code_bloc prog  0 0 ^ "\nHALT" 
end