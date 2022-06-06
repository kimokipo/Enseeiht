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

  (* Retourne le code de tous les champs d'un Enregistrement *)
  let rec getCodeCahmps l affect =
    List.fold_left (fun acc (t1,info) -> 
  (match info_ast_to_info info with
              | InfoVar (_,_,_,d1,r1) -> if affect then assert false  else acc ^"\nLOAD (" ^ (string_of_int (getTaille t1)) ^ ") "  ^ string_of_int d1 ^ "[" ^ r1 ^ "]"
              | InfoStruct (_,lp,_,_) -> acc ^ "\n" ^ getCodeCahmps lp affect
              | _ -> assert false)) "" l
  
  (* Retourne le code d'un affectable *)
  let rec analyse_code_affectable affect a = 
    (match a with 
      |Ast.AstTds.Ident info_ast ->
        begin(match info_ast_to_info info_ast with
                    | InfoVar (_,t,_,d,r) -> if affect then "\nSTORE (" ^ string_of_int (Type.getTaille t) ^ ") "  ^ string_of_int d ^ "[" ^ r ^ "]",t else "LOAD (" ^ (string_of_int (getTaille t)) ^ ") "  ^ string_of_int d ^ "[" ^ r ^ "]",t
                    | InfoStruct (_,lp,_,_) -> let list_types_noms = List.map (fun (t,info) -> (match info_ast_to_info info with 
                        | InfoVar (n,_,_,_,_) -> (t,n) 
                        | InfoStruct (n,_,_,_) -> (t,n) 
                        | _ -> assert false )) lp in let resultat = getCodeCahmps lp affect in resultat,(TypeStruct list_types_noms)
                     | InfoConst (_,n) -> "LOADL " ^ (string_of_int n),Int
                    | _ -> assert false)
        end
      |Ast.AstTds.Deref na -> let nna,t = analyse_code_affectable false na in (match t with
                |Pointeur nt -> (match nt with 
                          | TypeNomme _ -> let type_struct = List.assoc nt !(list_types_recursifs) in if affect then nna ^ "\nSTOREI ("^(string_of_int (getTaille type_struct))^")",t else nna ^ "\nLOADI ("^(string_of_int (getTaille type_struct))^")",t
                          | _ -> if affect then nna ^ "\nSTOREI ("^(string_of_int (getTaille nt))^")",t else nna ^ "\nLOADI ("^(string_of_int (getTaille nt))^")",t)
                |_ -> assert false)
      |Ast.AstTds.Champ (_,info_ast) -> 
                         (match info_ast_to_info info_ast with
                                   | InfoVar (_,t1,_,d,r) -> if affect then "\nSTORE (" ^ string_of_int (Type.getTaille t1) ^ ") "  ^ string_of_int d ^ "[" ^ r ^ "]",t1 else "LOAD (" ^ (string_of_int (getTaille t1)) ^ ") "  ^ string_of_int d ^ "[" ^ r ^ "]",t1
                                   | InfoStruct (_,lp,_,_) -> let list_types_noms = List.map (fun (t,info) -> (match info_ast_to_info info with 
                                          | InfoVar (n,_,_,_,_) -> (t,n) 
                                          | InfoStruct (n,_,_,_) -> (t,n) 
                                          | _ -> assert false )) lp in  getCodeCahmps lp affect, TypeStruct (list_types_noms)
                                   | _ -> assert false))

  (* Retourne le code d'une expression *)                                 
  let rec analyse_code_expression e = (match e with 
  |Ast.AstType.Affectable a -> let na,_ = analyse_code_affectable false a in na
  |Ast.AstType.NEW t -> "LOADL "^string_of_int (getTaille t)^"\nSUBR MAlloc" 
  |Ast.AstType.NULL -> "LOADL -1" (* -1 adresse négative*)
  |Ast.AstType.Enregistrement lp -> let resultat = List.fold_left (fun acc e -> let ne = analyse_code_expression e in acc ^"\n"^ne) "" lp in resultat
  |Ast.AstType.Adresse info_ast -> 
  begin(match info_ast_to_info info_ast with
              | InfoVar (_,_,_,d,r) -> "LOADA "  ^ string_of_int d ^ "[" ^ r ^ "]"
              | InfoStruct (_,_,d,r) -> "LOADA "  ^ string_of_int d ^ "[" ^ r ^ "]"
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
          | Denominateur-> na ^"\nSTORE (1) -2[ST]")
     |_ -> assert false)

 |Ast.AstType.AppelFonction (info,es) ->
 begin (match info_ast_to_info info with
            | InfoFun (n,_,_) -> 
              let nes = List.fold_left (fun acc e -> let ne = (analyse_code_expression e) in acc  ^ "\n" ^ ne ) "" es in
                nes ^ "\n" ^ "CALL (LB) " ^ n
            | _ -> assert false)
end)  

(* Retourne le code d'une instruction*)
let rec analyse_code_instruction i tailleType nbparam =
  (match i with
  | Ast.AstType.Declaration (info, e) -> let ne = (analyse_code_expression e) in 
            (match info_ast_to_info info with 
            | InfoVar(_,t,_,d,r)-> ("\nPUSH " ^ string_of_int (Type.getTaille t)) ^ "\n" ^ ne ^ "\n" ^ "STORE (" ^ 
                          string_of_int (Type.getTaille t) ^ ") "  ^ string_of_int d ^ "[" ^ r ^ "]",(getTaille t)
            | InfoStruct(_,lp,d,r)-> let list_types_noms = List.map (fun (t,info) -> (match info_ast_to_info info with 
                          | InfoVar (n,_,_,_,_) -> (t,n) 
                          | InfoStruct (n,_,_,_) -> (t,n) 
                          | _ -> assert false )) lp in let t = TypeStruct (list_types_noms) in ("\nPUSH " ^ string_of_int (Type.getTaille t)) ^ "\n" ^ ne ^ "\n" ^ "STORE (" ^ 
            string_of_int (Type.getTaille t) ^ ") "  ^ string_of_int d ^ "[" ^ r ^ "]",(getTaille t)
            |_->assert false) 
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
  | Ast.AstType.Retour(e) -> let ne = (analyse_code_expression e) in if ((tailleType = 0) && (nbparam = 0)) then ne,0 else ne ^ "\nRETURN ("^(string_of_int tailleType)^") "^ (string_of_int nbparam),0
  | _ -> "",0)


      
(* Retourne le code d'un bloc *)
and analyse_code_bloc li tailleType nbparam =
    let e,s = List.fold_left(fun acc i -> let ni,n = (analyse_code_instruction i tailleType nbparam) in ((fst acc) ^ "\n" ^ ni,(snd acc)+n)) ("",0) li in if (s > 0) then e^"\nPOP (0) "^ (string_of_int s) else e



(* Retourne le code d'une fonction *)
let analyse_code_fonction (Ast.AstPlacement.Fonction(info,_,li)) = 
          (match info_ast_to_info info with 
            | InfoFun (n,t,ts) -> let nbparam = List.fold_left(fun acc te -> acc+getTaille te) 0 ts in let tailleType = getTaille t in n ^ "\n" ^ analyse_code_bloc li tailleType nbparam
            | _ -> assert false)
        
  

(* Retourne le code d'un programme *)
let rec analyser_code_progremme p = match p with 
|AstPlacement.Programme (_,fonction,p1) ->  
let nf = analyse_code_fonction fonction in 
let np = analyser_code_progremme p1 in nf ^"\n"^np
| Ast.AstPlacement.Bloc b -> "\nmain\n" ^ analyse_code_bloc b  0 0 ^ "\nHALT" 

let analyser p =
  let np = analyser_code_progremme p in getEntete () ^ "\n" ^ np 
   
end
