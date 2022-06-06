(* Module de la passe de gestion des identifiants *)
module PasseTdsRat : Passe.Passe with type t1 = Ast.AstSyntax.programme and type t2 = Ast.AstTds.programme =
struct

  open Tds
  open Type
  open Exceptions
  open Ast
  open AstTds

  type t1 = Ast.AstSyntax.programme
  type t2 = Ast.AstTds.programme

(* list des longueurs des Enregistrements *)
let list_length_struct = ref []

(* Retourne true si la longueur d'un Enregistrement est dans la liste *)
let rec chercherLength l n =
  match l with
    | [] -> false
    | (t::q) -> if (t = n) then true else chercherLength q n

(* Retourne true si un type nommé est un des champs d'un Enregistrement *)
let rec chercherNom l n =
    (match l with 
      | [] -> false
      | ((t,_)::q) -> (match t with 
            | Pointeur (TypeNomme n2) -> if (String.compare n2 n == 0) then true else chercherNom q n
            | _ -> chercherNom q n))

(* Vérifie la bonne utilisation des identifiants dans l'affectable et renvoie le nouveau *)
let rec analyse_tds_affectable tds affect a = 
  (match a with  
    |Ast.AstSyntax.Ident x -> begin
    (match chercherGlobalement tds x with
          | None -> raise (IdentifiantNonDeclare x )
          | Some info_ast -> (match info_ast_to_info info_ast with
              | InfoVar (n,_,_,_,_) -> Ast.AstTds.Ident info_ast,n
              | InfoStruct (n,_,_,_) -> Ast.AstTds.Ident info_ast,n
              | InfoConst (n,_) -> if affect then raise (MauvaiseUtilisationIdentifiant x) else Ast.AstTds.Ident info_ast,n
              | _ -> raise (MauvaiseUtilisationIdentifiant x)))
    end
    |Ast.AstSyntax.Deref na -> let nna,n = analyse_tds_affectable tds false na in Deref(nna),"*"^n
    |Ast.AstSyntax.Champ (na,x) -> let nna,n = analyse_tds_affectable tds false na in
      (match chercherGlobalement tds (n^"."^x) with
            | None -> raise (IdentifiantNonDeclare (n^"."^x))
            | Some info_ast -> (match info_ast_to_info info_ast with
                | InfoVar (n1,_,_,_,_) -> Champ(nna,info_ast),(n^"."^n1)
                | InfoStruct (n1,_,_,_) -> Champ(nna,info_ast),(n^"."^n1)
                | _ -> raise (MauvaiseUtilisationIdentifiant x))))

(* Renvoie l'info correcte à creer pour un type *)
let rec getInfoType tds (n,t) nom estTypeStruct = 
    (match t with
      |TypeStruct (lp) -> if (lp == []) then raise (StructEstVide lp) else let nlp = List.map (fun (te,xe) -> 
      match chercherGlobalement tds xe with
            | None -> if (String.compare nom "" > 0) then let ninfo,_ = getInfoType tds (xe,te) (nom^"."^n) false in 
            (* Création du pointeur sur l'information *)
              let ia_xe = info_to_info_ast ninfo in
              (* Ajout de l'information (pointeur) dans la tds *)
              ajouter tds (nom^"."^n^"."^xe) ia_xe;
              (te,ia_xe) else let ninfo,_ = getInfoType tds (xe,te) n false in 
              (* Création du pointeur sur l'information *)
                let ia_xe = info_to_info_ast ninfo in
                (* Ajout de l'information (pointeur) dans la tds *)
                ajouter tds (n^"."^xe) ia_xe;
                (te,ia_xe)
            | Some _ -> if (estTypeStruct) then raise (DoubleDeclaration xe) else if (String.compare nom "" > 0) then let ninfo,_ = getInfoType tds (xe,te) (nom^"."^n) false in 
            (* Création du pointeur sur l'information *)
              let ia_xe = info_to_info_ast ninfo in
              (* Ajout de l'information (pointeur) dans la tds *)
              ajouter tds (nom^"."^n^"."^xe) ia_xe;
              (te,ia_xe) else let ninfo,_ = getInfoType tds (xe,te) n false in 
              (* Création du pointeur sur l'information *)
                let ia_xe = info_to_info_ast ninfo in
                (* Ajout de l'information (pointeur) dans la tds *)
                ajouter tds (n^"."^xe) ia_xe;
                (te,ia_xe)) lp in 
              let info_struct = InfoStruct(n,nlp,0,"") in 
              (info_struct,t)
      |TypeNomme n1 ->  
      (match chercherGlobalement tds n1 with
        | None -> raise (TypeNonDeclare n1)
        | Some info -> (match info_ast_to_info info with
            |InfoType (_,t1) -> let ninfo,nt = getInfoType tds (n,t1) nom false in
                ninfo,nt
            |_ -> assert false))
      |Pointeur t1 -> 
        (match t1 with
          |TypeNomme n2 ->  
          (match chercherGlobalement tds n2 with
            | None -> raise (TypeNonDeclare n2)
            | Some info -> (match info_ast_to_info info with
              |InfoType (_,t2) -> (match t2 with 
                                    |TypeStruct(lp) -> let condition = (chercherNom lp n2) in if condition then  let info_xe = InfoVar (n,Pointeur t1,nom ,0, "") in Type.list_types_recursifs := ((t1,t2)::!(Type.list_types_recursifs));
                                    (info_xe,Pointeur t1) else let ninfo,nt = getInfoType tds (n,Pointeur t2) nom false in 
                                        ninfo,nt
                                    | _ -> let ninfo,nt = getInfoType tds (n,Pointeur t2) nom false in 
                                    ninfo,nt)
              | _ -> assert false))
          |TypeStruct (lp) -> if (lp == []) then raise (StructEstVide lp) else let _ = List.map (fun (te,xe) -> 
          match chercherGlobalement tds xe with
                | None -> let ninfo,_ = getInfoType tds (xe,te) ("*"^nom^"."^n) false in 
                (* Création du pointeur sur l'information *)
                  let ia_xe = info_to_info_ast ninfo in
                  (* Ajout de l'information (pointeur) dans la tds *)
                  ajouter tds ("*"^nom^"."^n^"."^xe) ia_xe;
                  (te,ia_xe)
                | Some _ -> raise (DoubleDeclaration xe)) lp in 
                  let info_xe = InfoVar (n,Undefined,nom ,0, "") in 
                  (info_xe,Pointeur t1)
          | _-> let info_xe = InfoVar (n,Undefined,nom ,0, "") in 
                (info_xe,Pointeur t1))
      |_ -> let info_xe = InfoVar (n,Undefined,nom ,0, "") in 
      (info_xe,t))


(* Définie le type nommé puis renvoie son info *)
let rec analyse_tds_deftype tds (n,t) =  
    (match chercherGlobalement tds n with
    | None ->
      (match t with
        |TypeNomme n1 ->  
        (match chercherGlobalement tds n1 with
          | None -> raise (TypeNonDeclare n1)
          | Some info -> (match info_ast_to_info info with
              |InfoType (_,t1) -> 
                  let info = InfoType (n,t1) in
                  (* Création du pointeur sur l'information *)
                  let ia = info_to_info_ast info in
                  (* Ajout de l'information (pointeur) dans la tds *)
                  ajouter tds n ia;
                  ia,t1
              |_ -> assert false))
        | TypeStruct lp -> let info = InfoType (n,t) in
                  (* Création du pointeur sur l'information *)
                  let ia = info_to_info_ast info in
                  (* Ajout de l'information (pointeur) dans la tds *)
                  ajouter tds n ia;
        if (lp == []) then raise (StructEstVide lp) else let nlp = List.map (fun (te,xe) -> 
          (match chercherGlobalement tds xe with
                | None -> let (info_new,t_new) = getInfoType tds (xe,te) "" false in 
              (* Création du pointeur sur l'information *)
                let ia_xe = info_to_info_ast info_new in
                (* Ajout de l'information (pointeur) dans la tds *)
                ajouter tds xe ia_xe;
                (t_new,xe)
              | Some _ -> raise (DoubleDeclaration xe))) lp in 
                  let t_info_new = TypeStruct nlp in 
                (* Création du pointeur sur l'information *)
                  modifier_type_info t_info_new ia;
                  (ia,t_info_new)
        | Pointeur t1 -> 
          (match t1 with
          |TypeNomme n2 ->  
          (match chercherGlobalement tds n2 with
          | None -> raise (TypeNonDeclare n2)
          | Some info -> (match info_ast_to_info info with
                |InfoType (_,t2) -> 
                  let info = InfoType (n,Pointeur t2) in
                  (* Création du pointeur sur l'information *)
                  let ia = info_to_info_ast info in
                  (* Ajout de l'information (pointeur) dans la tds *)
                  ajouter tds n ia;
                  ia,Pointeur t2
                | _ -> assert false))
          | _-> 
          let info = InfoType (n,t) in
          (* Création du pointeur sur l'information *)
          let ia = info_to_info_ast info in
          (* Ajout de l'information (pointeur) dans la tds *)
          ajouter tds n ia;
          ia,t)
        |_ -> let info = InfoType (n,t) in
              (* Création du pointeur sur l'information *)
              let ia = info_to_info_ast info in
              (* Ajout de l'information (pointeur) dans la tds *)
              ajouter tds n ia;
              ia,t)
    |Some _ -> raise (DoubleDeclaration n))

(* analyse_tds_expression : AstSyntax.expression -> AstTds.expression *)
(* Paramètre tds : la table des symboles courante *)
(* Paramètre e : l'expression à analyser *)
(* Vérifie la bonne utilisation des identifiants et tranforme l'expression
en une expression de type AstTds.expression *)
(* Erreur si mauvaise utilisation des identifiants *)
let rec analyse_tds_expression tds e = (match e with 
  |Ast.AstSyntax.Affectable a -> let na,_ = analyse_tds_affectable tds false a in Affectable (na)
  |Ast.AstSyntax.Enregistrement lp -> let nlp = List.map (analyse_tds_expression tds) lp in Enregistrement(nlp)
  |Ast.AstSyntax.NEW t -> 
  (match t with
    |TypeNomme n1 ->  
    (match chercherGlobalement tds n1 with
    | None -> raise (TypeNonDeclare n1)
    | Some info -> (match info_ast_to_info info with
          |InfoType (_,t1) -> NEW t1
          |_ -> assert false))
    |_ -> NEW t)
  |Ast.AstSyntax.NULL -> NULL
  |Ast.AstSyntax.Adresse x ->  begin
    (match chercherGlobalement tds x with
          | None -> raise (IdentifiantNonDeclare x )
          | Some info_ast -> (match info_ast_to_info info_ast with
              | InfoVar _ -> Ast.AstTds.Adresse info_ast
              | InfoStruct _ -> Ast.AstTds.Adresse info_ast
              | _ -> raise (MauvaiseUtilisationIdentifiant x)))
    end
  |Ast.AstSyntax.Booleen b -> Ast.AstTds.Booleen b
  |Ast.AstSyntax.Entier n -> Ast.AstTds.Entier n
  |Ast.AstSyntax.Binaire (op,e1,e2) -> 
    let ne1 = analyse_tds_expression tds e1 in
    let ne2 = analyse_tds_expression tds e2 in
    Ast.AstTds.Binaire (op,ne1,ne2)

  |Ast.AstSyntax.Unaire (op,e1) -> 
    let ne1 = analyse_tds_expression tds e1 in
    Ast.AstTds.Unaire (op,ne1)

 |Ast.AstSyntax.AppelFonction (id,es) ->
 begin
  (match chercherGlobalement tds id with
        | None -> raise (IdentifiantNonDeclare id)
        | Some info_ast -> (match info_ast_to_info info_ast with
            | InfoFun (_,_,_) -> Ast.AstTds.AppelFonction(info_ast,(List.map (fun e -> analyse_tds_expression tds e) es))
            | _ -> raise (MauvaiseUtilisationIdentifiant id)))
end)
  



  




(* analyse_tds_instruction : AstSyntax.instruction -> tds -> AstTds.instruction *)
(* Paramètre tds : la table des symboles courante *)
(* Paramètre i : l'instruction à analyser *)
(* Vérifie la bonne utilisation des identifiants et tranforme l'instruction
en une instruction de type AstTds.instruction *)
(* Erreur si mauvaise utilisation des identifiants *)
let rec analyse_tds_instruction tds i =
  match i with
  | AstSyntax.Declaration (t, n, e) ->
  begin
    (match chercherLocalement tds n with
    | None ->
      let ne = analyse_tds_expression tds e in
      (match t with
      |TypeNomme n1 ->  
        (match chercherGlobalement tds n1 with
        | None -> raise (TypeNonDeclare n1)
        | Some info -> (match info_ast_to_info info with
              |InfoType (_,t1) -> (match t1 with 
                | TypeStruct lp -> let nlp = List.map (fun (te,xe) -> 
                        (match chercherGlobalement tds xe with
                              | None -> raise (IdentifiantNonDeclare xe)
                            | Some _ -> let (info_new,t_new) = getInfoType tds (xe,te) n false in
                          (* Création du pointeur sur l'information *)
                            let ia_xe = info_to_info_ast info_new in
                            (* Ajout de l'information (pointeur) dans la tds *)
                            ajouter tds (n^"."^xe) ia_xe;
                            (t_new,ia_xe))) lp in  
                              let info_struct = InfoStruct(n,nlp,0,"") in 
                              let ia_struct = info_to_info_ast info_struct in
                              (* Ajout de l'information (pointeur) dans la tds *)
                              ajouter tds n ia_struct;
                              Declaration (t1, ia_struct, ne)
                |_ -> let (info_new,t_new) = getInfoType tds (n,t1) "" false in
              (* Création du pointeur sur l'information *)
              let ia = info_to_info_ast info_new in
              (* Ajout de l'information (pointeur) dans la tds *)
              ajouter tds n ia;
              Declaration (t_new, ia, ne))
              | _ -> assert false))
      | TypeStruct lp -> let longueur = (List.length lp) in let condition = chercherLength !list_length_struct longueur in list_length_struct := (longueur::(!list_length_struct));if (lp == []) then raise (StructEstVide lp) else let nlp = List.map (fun (te,xe) -> 
                    match chercherGlobalement tds xe with
                          | None -> let (info_new,t_new) = getInfoType tds (xe,te) n false in
                          (* Création du pointeur sur l'information *)
                            let ia_xe = info_to_info_ast info_new in
                            (* Ajout de l'information (pointeur) dans la tds *)
                            ajouter tds (n^"."^xe) ia_xe;
                            ajouter tds xe ia_xe;
                            (t_new,ia_xe)
                          | Some _ -> if (not condition) then raise (DoubleDeclaration xe) else let (info_new,t_new) = getInfoType tds (xe,te) n false in
                          (* Création du pointeur sur l'information *)
                            let ia_xe = info_to_info_ast info_new in
                            (* Ajout de l'information (pointeur) dans la tds *)
                            ajouter tds (n^"."^xe) ia_xe;
                            ajouter tds xe ia_xe;
                            (t_new,ia_xe)) lp in 
                            let info_struct = InfoStruct(n,nlp,0,"") in 
                            let ia_struct = info_to_info_ast info_struct in
                            (* Ajout de l'information (pointeur) dans la tds *)
                            ajouter tds n ia_struct;
                            Declaration(t,ia_struct,ne)
      | _-> let (info_new,t_new) = getInfoType tds (n,t) "" false in
      (* Création du pointeur sur l'information *)
      let ia = info_to_info_ast info_new in
      (* Ajout de l'information (pointeur) dans la tds *)
      ajouter tds n ia;
      Declaration (t_new, ia, ne))
    | Some _ ->
            (* L'identifiant est trouvé dans la tds locale, 
            il a donc déjà été déclaré dans le bloc courant *) 
            raise (DoubleDeclaration n))
      end
  |Ast.AstSyntax.DefinitionType (n,t) -> let i,t1 = analyse_tds_deftype tds (n,t) in
      DefinitionType(i,t1)
  | AstSyntax.Affectation (a,e) ->
          let na,_ = analyse_tds_affectable tds true a in
              (* Vérification de la bonne utilisation des identifiants dans l'expression *)
              (* et obtention de l'expression transformée *) 
              let ne = analyse_tds_expression tds e in
              (* Renvoie de la nouvelle affectation où le nom a été remplacé par l'information 
              et l'expression remplacée par l'expression issue de l'analyse *)
               Affectation (na, ne)
  | AstSyntax.AssignationAddition (a,e) ->
        let _ = analyse_tds_affectable tds false a in
            let ne = analyse_tds_expression tds e in
            (* Vérification de la bonne utilisation des identifiants dans l'expression *)
            (* et obtention de l'expression transformée *) 
            let na2,_ = analyse_tds_affectable tds true a in
                        AstTds.AssignationAddition (na2,ne)
  | AstSyntax.Constante (n,v) -> 
      begin
        match chercherLocalement tds n with
        | None -> 
        (* L'identifiant n'est pas trouvé dans la tds locale, 
        il n'a donc pas été déclaré dans le bloc courant *)
        (* Ajout dans la tds de la constante *)
        ajouter tds n (info_to_info_ast (InfoConst (n,v))); 
        (* Suppression du noeud de déclaration des constantes devenu inutile *)
        Empty
        | Some _ ->
          (* L'identifiant est trouvé dans la tds locale, 
          il a donc déjà été déclaré dans le bloca courant *) 
          raise (DoubleDeclaration n)
      end
  | AstSyntax.Affichage e -> 
      (* Vérification de la bonne utilisation des identifiants dans l'expression *)
      (* et obtention de l'expression transformée *)
      let ne = analyse_tds_expression tds e in
      (* Renvoie du nouvel affichage où l'expression remplacée par l'expression issue de l'analyse *)
      Affichage (ne)
  | AstSyntax.Conditionnelle (c,t,e) -> 
      (* Analyse de la condition *)
      let nc = analyse_tds_expression tds c in
      (* Analyse du bloc then *)
      let tast = analyse_tds_bloc tds t in
      (* Analyse du bloc else *)
      let east = analyse_tds_bloc tds e in
      (* Renvoie la nouvelle structure de la conditionnelle *)
      Conditionnelle (nc, tast, east)
  | AstSyntax.TantQue (c,b) -> 
      (* Analyse de la condition *)
      let nc = analyse_tds_expression tds c in
      (* Analyse du bloc *)
      let bast = analyse_tds_bloc tds b in
      (* Renvoie la nouvelle structure de la boucle *)
      TantQue (nc, bast)
  | AstSyntax.Retour (e) -> 
      (* Analyse de l'expression *)
      let ne = analyse_tds_expression tds e in
      Retour (ne)

      
(* analyse_tds_bloc : AstSyntax.bloc -> AstTds.bloc *)
(* Paramètre tds : la table des symboles courante *)
(* Paramètre li : liste d'instructions à analyser *)
(* Vérifie la bonne utilisation des identifiants et tranforme le bloc
en un bloc de type AstTds.bloc *)
(* Erreur si mauvaise utilisation des identifiants *)
and analyse_tds_bloc tds li =
  (* Entrée dans un nouveau bloc, donc création d'une nouvelle tds locale 
  pointant sur la table du bloc parent *)
  let tdsbloc = creerTDSFille tds in
  (* Analyse des instructions du bloc avec la tds du nouveau bloc 
  Cette tds est modifiée par effet de bord *)
   let nli = List.map (analyse_tds_instruction tdsbloc) li in
   (* afficher_locale tdsbloc ; *) (* décommenter pour afficher la table locale *)
   nli


(* analyse_tds_fonction : AstSyntax.fonction -> AstTds.fonction *)
(* Paramètre tds : la table des symboles courante *)
(* Paramètre : la fonction à analyser *)
(* Vérifie la bonne utilisation des identifiants et tranforme la fonction
en une fonction de type AstTds.fonction *)
(* Erreur si mauvaise utilisation des identifiants *)
let analyse_tds_fonction maintds (AstSyntax.Fonction(t,n,lp,li)) = 
  match chercherGlobalement maintds n with
        | None -> let info = InfoFun(n,Undefined,[]) in
        let info_fun = (info_to_info_ast info) in
        ajouter maintds n info_fun;
        let tdsfille = creerTDSFille maintds in
        let m = List.map (fun (x,y) -> begin
          match chercherLocalement tdsfille y with
          | None -> 
          (match x with
            |TypeNomme n2 ->  
              (match chercherGlobalement maintds n2 with
              | None -> raise (TypeNonDeclare n2)
              | Some info_type -> (match info_ast_to_info info_type with
                    |InfoType (_,t2) -> 
                    (match t2 with 
                      | TypeStruct lp1 -> let nlp = List.map (fun (te,xe) -> 
                              (match chercherGlobalement maintds xe with
                                    | None -> raise (IdentifiantNonDeclare xe)
                                  | Some _ -> let (info_new,t_new) = getInfoType maintds (xe,te) y false in
                                (* Création du pointeur sur l'information *)
                                  let ia_xe = info_to_info_ast info_new in
                                  (* Ajout de l'information (pointeur) dans la tds *)
                                  ajouter tdsfille (y^"."^xe) ia_xe; (t_new,ia_xe))) lp1 in  
                                    let info_struct = InfoStruct(y,nlp,0,"") in 
                                    let ia_struct = info_to_info_ast info_struct in
                                    (* Ajout de l'information (pointeur) dans la tds *)
                                    ajouter tdsfille y ia_struct;
                                    (t2,ia_struct)
                      |_ -> let (info_new,t_new) = getInfoType maintds (y,t2) "" false in 
                      let info = info_to_info_ast info_new in
                      ajouter tdsfille y info;
                      (t_new,info))
                    | _ -> assert false))
            | _ ->  let (info_new,t_new) = getInfoType maintds (y,x) "" false in 
            let info = info_to_info_ast info_new in
            ajouter tdsfille y info;
            (t_new,info))
          |Some _ -> raise (DoubleDeclaration y)
          end) lp in
      (match t with
      |TypeNomme n1 ->  
        (match chercherGlobalement maintds n1 with
        | None -> raise (TypeNonDeclare n1)
        | Some info -> (match info_ast_to_info info with
              |InfoType (_,t1) -> Ast.AstTds.Fonction (t1,info_fun,m,(analyse_tds_bloc tdsfille li))
              | _ -> assert false))
      |_ ->  Ast.AstTds.Fonction (t,info_fun,m,(analyse_tds_bloc tdsfille li)))
        | Some _-> raise (DoubleDeclaration n) 
  

(* analyser : AstSyntax.ast -> AstTds.ast *)
(* Paramètre : le programme à analyser *)
(* Vérifie la bonne utilisation des identifiants et tranforme le programme
en un programme de type AstTds.ast *)
(* Erreur si mauvaise utilisation des identifiants *)
let rec analyse_tds_programme tds p = match p with 
          |AstSyntax.Programme (defTypes,fonction,p1) -> let tdsfille = creerTDSFille tds in 
          let ndt = List.map (analyse_tds_deftype tds) defTypes in 
  let nf = analyse_tds_fonction tds fonction in 
  let np = analyse_tds_programme tdsfille p1 in
  Programme (ndt,nf,np)
          | Ast.AstSyntax.Bloc b -> Bloc (analyse_tds_bloc tds b)


let analyser p = 
  let tds = creerTDSMere () in
  analyse_tds_programme tds p

end
