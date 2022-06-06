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


let rec analyse_tds_affectable tds affect a = 
  (match a with  
    |Ast.AstSyntax.Ident x -> begin
    (match chercherGlobalement tds x with
          | None -> raise (IdentifiantNonDeclare x )
          | Some info_ast -> (match info_ast_to_info info_ast with
              | InfoVar (n,_,_,_) -> Ast.AstTds.Ident info_ast
              | InfoConst (n,_) -> if affect then raise (MauvaiseUtilisationIdentifiant x) else Ast.AstTds.Ident info_ast
              | _ -> raise (MauvaiseUtilisationIdentifiant x)))
    end
    |Ast.AstSyntax.Deref na -> let nna = analyse_tds_affectable tds false na in Deref(nna))




(* analyse_tds_expression : AstSyntax.expression -> AstTds.expression *)
(* Paramètre tds : la table des symboles courante *)
(* Paramètre e : l'expression à analyser *)
(* Vérifie la bonne utilisation des identifiants et tranforme l'expression
en une expression de type AstTds.expression *)
(* Erreur si mauvaise utilisation des identifiants *)
let rec analyse_tds_expression tds e = (match e with 
  |Ast.AstSyntax.Affectable a -> let na = analyse_tds_affectable tds false a in Affectable (na)
  |Ast.AstSyntax.NEW t -> NEW t
  |Ast.AstSyntax.NULL -> NULL
  |Ast.AstSyntax.Adresse x ->  begin
    (match chercherGlobalement tds x with
          | None -> raise (IdentifiantNonDeclare x )
          | Some info_ast -> (match info_ast_to_info info_ast with
              | InfoVar _ -> Ast.AstTds.Adresse info_ast
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
  



  



let rec getInfoType tds (n,t) = 
  (match t with
    |Pointeur t1 -> let info_xe = InfoVar (n,Undefined ,0, "") in 
              (info_xe,Pointeur t1)
    |_ -> let info_xe = InfoVar (n,Undefined ,0, "") in 
    (info_xe,t))

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
      let (info_new,t_new) = getInfoType tds (n,t) in
        (* Création du pointeur sur l'information *)
        let ia = info_to_info_ast info_new in
        (* Ajout de l'information (pointeur) dans la tds *)
        ajouter tds n ia;
        Declaration (t_new, ia, ne)
    | Some _ ->
            (* L'identifiant est trouvé dans la tds locale, 
            il a donc déjà été déclaré dans le bloc courant *) 
            raise (DoubleDeclaration n))
      end
  | AstSyntax.Affectation (a,e) ->
          let na = analyse_tds_affectable tds true a in
              (* Vérification de la bonne utilisation des identifiants dans l'expression *)
              (* et obtention de l'expression transformée *) 
              let ne = analyse_tds_expression tds e in
              (* Renvoie de la nouvelle affectation où le nom a été remplacé par l'information 
              et l'expression remplacée par l'expression issue de l'analyse *)
               Affectation (na, ne)
  | AstSyntax.AssignationAddition (a,e) ->
        let na1 = analyse_tds_affectable tds false a in
            (* Vérification de la bonne utilisation des identifiants dans l'expression *)
            (* et obtention de l'expression transformée *) 
            let ne = analyse_tds_expression tds e in
            (* Renvoie de la nouvelle affectation où le nom a été remplacé par l'information 
            et l'expression remplacée par l'expression issue de l'analyse *)
            let na2 = analyse_tds_affectable tds true a in
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
          | None ->  let (info_new,t_new) = getInfoType maintds (y,x) in 
            let info = info_to_info_ast info_new in
            ajouter tdsfille y info;
            (t_new,info)
          |Some _ -> raise (DoubleDeclaration y)
          end) lp in
          Ast.AstTds.Fonction (t,info_fun,m,(analyse_tds_bloc tdsfille li))
        | Some _-> raise (DoubleDeclaration n) 
  

(* analyser : AstSyntax.ast -> AstTds.ast *)
(* Paramètre : le programme à analyser *)
(* Vérifie la bonne utilisation des identifiants et tranforme le programme
en un programme de type AstTds.ast *)
(* Erreur si mauvaise utilisation des identifiants *)
let analyser (AstSyntax.Programme (fonctions,prog)) =
  let tds = creerTDSMere () in
  let nf = List.map (analyse_tds_fonction tds) fonctions in 
  let nb = analyse_tds_bloc tds prog in
  Programme (nf,nb)

end