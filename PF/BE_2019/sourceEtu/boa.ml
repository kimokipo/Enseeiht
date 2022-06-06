module type Regle =
sig
  type tid = int
  type td
  val id : tid
  (******************************************************************************)
  (*   fonction qui applique la regle tid à un terme                            *)
  (*   signature  : appliquer : td -> td list                                   *)
  (*   paramètres : - un terme : td                                             *)
  (*   résultat   : la liste des termes générés : td list                       *)
  (******************************************************************************)
  val appliquer : td -> td list
end

module Regle1 : Regle with type td = char list  =
struct
  type tid = int
  type td = char list
  let id = 1
  let rec dernier l = match l with  
   | [] -> None
   | [a] -> Some a  
   | (_::q) -> match dernier q with  
      | None -> None
      | Some a -> Some a
  (******************************************************************************)
  (*   fonction qui applique la regle 1 à un terme                              *)
  (*   signature  : appliquer : char -> char list list                          *)
  (*   paramètres : - un terme : une liste de caractères : char list            *)                                 
  (*   Préconditions : terme ne contient que les caractères 'B', 'O', ou 'A'    *)
  (*   résultat   : la liste des termes générés :                               *)
  (*            liste de listes de caractères : char list list                  *)
  (******************************************************************************)
  let appliquer l = if ((dernier l) = Some 'O') then [l @ ['A']] else []
end

module Regle2 : Regle with type td = char list  =
struct
  type tid = int
  type td = char list
  let id = 2
  (******************************************************************************)
  (*   fonction qui applique la regle 2 à un terme                              *)
  (*   signature  : appliquer : char -> char list list                          *)
  (*   paramètres : - un terme : une liste de caractères : char list            *)
  (* Préconditions : terme ne contient que les caractères 'B', 'O', ou 'A'      *)
  (*   résultat   : la liste des termes générés :                               *)
  (*            liste de listes de caractères : char list list                  *)
  (******************************************************************************)
  let appliquer l = match l with
        | [] ->  []
        | ('B'::q) -> [l @ q]
        | _ ->  []
end

module Regle3 : Regle with type td = char list =
struct
  type tid = int
  type td = char list
  let id = 3
  (******************************************************************************)
  (*   fonction qui applique la regle 3 à un terme                              *)
  (*   signature  : appliquer : char -> char list list                          *)
  (*   paramètres : - un terme : une liste de caractères : char list            *)
  (*   Préconditions : terme ne contient que les caractères 'B', 'O', ou 'A'    *)
  (*   résultat   : la liste des termes générés :                               *)
  (*            liste de listes de caractères : char list list                  *)
  (******************************************************************************)
  let rec appliquer l = match l with
     | [] -> [] 
     | (a::q) -> if a = 'O' ||  a = 'A' then 
        match q with 
         | [] -> []
         | (b::r) -> if b = 'O' then 
            match r with 
               | [] -> []
               | (c::s) -> if c = 'O' then ['A'::s] @ (List.map (fun x -> a::x) (appliquer q)) 
                    
                          else 
                              if a  = 'A' then ['A'::s] @ (List.map (fun x -> a::'O'::x) (appliquer r))
                                
                              else (List.map (fun x -> a::'O'::c::x) (appliquer s)) 
                                 
                    else List.map (fun x -> a::b::x) (appliquer r) 
                    
                else (List.map (fun x -> a::x) (appliquer q))
                  
end

module Regle4 : Regle with type td = char list =
struct
  type tid = int
  type td = char list
  let id = 4
  (******************************************************************************)
  (*   fonction qui applique la regle 4 à un terme                              *)
  (*   signature  : appliquer : char -> char list list                          *)
  (*   paramètres : - un terme : une liste de caractères : char list            *)
  (*   Préconditions : terme ne contient que les caractères 'B', 'O', ou 'A'    *)
  (*   résultat   : la liste des termes générés :                               *)
  (*            liste de listes de caractères : char list list                  *)
  (******************************************************************************)
  let rec appliquer l = match l with
     | [] -> [] 
     | (a::q) -> if a = 'A' then 
        match q with 
         | [] -> []
         | (b::r) -> if b = 'A' then match r with
              | [] -> [[]]
              | _ -> (appliquer r) 
                    else let result = (appliquer r) in match result with
                      | [] -> [] 
                      | _ -> [a::b::List.flatten result]
                else let result = (appliquer q) in match result with
                  | [] -> [] 
                  | _ -> [a::List.flatten result]
end

module type ArbreReecriture =
sig
  type tid = int
  type td
  type arbre_reecriture = Noeud of td * ( (tid branche) list)
  and 'tid branche = tid * arbre_reecriture

  val creer_noeud : td -> (tid branche) list -> arbre_reecriture

  val racine : arbre_reecriture -> td
  val fils : arbre_reecriture -> (tid branche) list
  (******************************************************************************)
  (*   fonction d'appartenance d'un terme à une arbre_reecriture                *)
  (*   signature  : appartient : td -> arbre_reecriture -> bool                 *)
  (*   paramètres : - un terme : une liste de caractères : td                   *)
  (*                - arbre : arbre_reecriture                                  *) 
  (*   résultat   : le résultat booléen du test                                 *)
  (******************************************************************************)
  val appartient : td -> arbre_reecriture -> bool
  val a1 : arbre_reecriture
  val a2 : arbre_reecriture
end


module ArbreReecritureBOA : ArbreReecriture with type td = char list =
struct
  type tid = int
  type td = char list
  type arbre_reecriture = Noeud of td * ( (tid branche) list)
  and 'tid branche = tid * arbre_reecriture

  let creer_noeud terme list_branches = Noeud (terme,list_branches)

  let racine (Noeud (racine,_)) = racine
  let fils (Noeud (_,fils)) = fils
  (******************************************************************************)
  (*   fonction d'appartenance d'un terme à une arbre_reecriture                *)
  (*   signature  : appartient : td -> arbre_reecriture -> bool                 *)
  (*   paramètres : - un terme : une liste de caractères : td                   *)
  (*                - arbre : arbre_reecritur                                   *) 
  (*   résultat   : le résultat booléen du test                                 *)
  (******************************************************************************)
  let rec appartient terme (Noeud (r,lb)) = if r = terme then true else match lb with 
       | [] -> false
       | ((id,a)::q) -> (appartient terme a) ||  (appartient terme (Noeud (r,q))) 

  let a1 = Noeud(['B';'O';'O'],[(1,Noeud(['B';'O';'O';'A'],[(2,Noeud(['B';'O';'O';'A';'O';'O';'A'],[]));
  (2,Noeud(['B';'O';'O';'O';'O'],[(1,Noeud(['B';'O';'O';'O';'O';'A'],[]));(2,Noeud(['B';'O';'O';'O';'O';'O';'O';'O';'O'],[]));(3,Noeud(['B';'A';'O'],[]))]));(3,Noeud( ['B';'O';'A'] ,[]))]))])
  let a2 = Noeud (['B'; 'O'],
        [(1,
          Noeud (['B'; 'O'; 'A'],
          [(2, Noeud (['B'; 'O'; 'A'; 'O'; 'A'], []))]));
        (2,
          Noeud (['B'; 'O'; 'O'],
          [(1, Noeud (['B'; 'O'; 'O'; 'A'], []));
            (2, Noeud (['B'; 'O'; 'O'; 'O'; 'O'], []))]))])
end 


let%test _ = (ArbreReecritureBOA.appartient ['B';'O';'A'] ArbreReecritureBOA.a1 = true)
let%test _ = (ArbreReecritureBOA.appartient ['B';'O'] ArbreReecritureBOA.a1 = false)
let%test _ = (ArbreReecritureBOA.appartient ['B';'O';'A'] ArbreReecritureBOA.a2 = true)
let%test _ = (ArbreReecritureBOA.appartient ['B';'O';'O';'O'] ArbreReecritureBOA.a1 = false)

let%test _ = (ArbreReecritureBOA.creer_noeud ['B';'O'] [] = Noeud(['B';'O'],[]))
let%test _ = (ArbreReecritureBOA.racine ArbreReecritureBOA.a1 = ['B'; 'O';'O'])
let%test _ = (ArbreReecritureBOA.fils ArbreReecritureBOA.a1 = [(1,Noeud(['B';'O';'O';'A'],[(2,Noeud(['B';'O';'O';'A';'O';'O';'A'],[]));
(2,Noeud(['B';'O';'O';'O';'O'],[(1,Noeud(['B';'O';'O';'O';'O';'A'],[]));(2,Noeud(['B';'O';'O';'O';'O';'O';'O';'O';'O'],[]));(3,Noeud(['B';'A';'O'],[]))]));(3,Noeud( ['B';'O';'A'] ,[]))]))])

let%test _ = (ArbreReecritureBOA.racine ArbreReecritureBOA.a2 = ['B'; 'O'])
let%test _ = (ArbreReecritureBOA.fils ArbreReecritureBOA.a2 = [(1,
          Noeud (['B'; 'O'; 'A'],
          [(2, Noeud (['B'; 'O'; 'A'; 'O'; 'A'], []))]));
          (2,
          Noeud (['B'; 'O'; 'O'],
          [(1, Noeud (['B'; 'O'; 'O'; 'A'], []));
            (2, Noeud (['B'; 'O'; 'O'; 'O'; 'O'], []))]))])

  module SystemeBOA =
  struct 
    include Regle1
    include Regle2
    include Regle3
    include Regle4
    include (ArbreReecritureBOA : ArbreReecriture with type td = ArbreReecritureBOA.td)

    let rec dernier l = match l with  
    | [] -> None
    | [a] -> Some a  
    | (_::q) -> match dernier q with  
      | None -> None
      | Some a -> Some a

    let rec construit_arbre terme n = if n = 0 then (Noeud (terme,[])) else
      let ajouter l id = 
        l @ List.map (fun x -> (id,(construit_arbre x (n-1)))) ((List.assoc id [(1,Regle1.appliquer);(2,Regle2.appliquer);(3,Regle3.appliquer);(4,Regle4.appliquer)]) terme)
    in Noeud(terme,(List.fold_left (fun x y -> ajouter x y) [] [1;2;3;4]))

    let rec chemin terme_depart terme_cible n = 
      let Noeud(terme,lb) = construit_arbre terme_depart n in
          if not (appartient terme_cible (Noeud(terme,lb))) then None else
            let rec parcours (Noeud(r,lb)) = 
              match lb with 
               | [] -> [([r],[])]
               | ((t,a)::q) -> (List.map (fun (x,y) -> (r::x,t::y)) (parcours a)) @ (parcours (Noeud(r,q)))
            in let rec dernier_liste l = 
                match l with 
                  | [] -> None
                  | ((l1,l2)::q) -> if (dernier l1 = Some terme_cible) then Some (l1,l2) else dernier_liste q
           in (dernier_liste (parcours (Noeud(terme,lb))))

    let verification = (chemin ['B';'O'] ['B';'A'] 5) = Some ([['B'; 'O']; ['B'; 'O'; 'O']; ['B'; 'O'; 'O'; 'O'; 'O'];
    ['B'; 'O'; 'O'; 'O'; 'O'; 'A']; ['B'; 'A'; 'O'; 'A']; ['B'; 'A']],
   [2; 2; 1; 3; 3])
  end

module type ReglesReecriture =
sig
  type tid = int
  type td
  val regles : (tid *(td -> td list )) list
end

module SystemeReecriture (A:ArbreReecriture) (R:ReglesReecriture with type td = A.td) =
struct 
  let rec dernier l = match l with  
     | [] -> None
     | [a] -> Some a  
     | (_::q) -> match dernier q with  
        | None -> None
        | Some a -> Some a
  let rec construit_arbre terme n = if n = 0 then (A.Noeud (terme,[])) else
    let ajouter l id =
            l @ List.map (fun x -> (id,(construit_arbre x (n-1)))) ((List.assoc id R.regles) terme)
    in A.Noeud(terme,(List.fold_left (fun x y -> ajouter x (fst y)) [] R.regles))

 let rec chemin terme_depart terme_cible n = 
      let A.Noeud(terme,lb) = construit_arbre terme_depart n in
          if not (A.appartient terme_cible (A.Noeud(terme,lb))) then None else
            let rec parcours (A.Noeud(r,lb)) = 
              match lb with 
               | [] -> [([r],[])]
               | ((t,a)::q) -> (List.map (fun (x,y) -> (r::x,t::y)) (parcours a)) @ (parcours (Noeud(r,q)))
            in let rec dernier_liste l = 
                match l with 
                  | [] -> None
                  | ((l1,l2)::q) -> if (dernier l1 = Some terme_cible) then Some (l1,l2) else dernier_liste q
           in (dernier_liste (parcours (Noeud(terme,lb))))
end

module ReglesReecritureBOA : ReglesReecriture with type td = ArbreReecritureBOA.td =
struct 
  include Regle1
  include Regle2
  include Regle3
  include Regle4

  let regles = [(1,Regle1.appliquer);(2,Regle2.appliquer);(3,Regle3.appliquer);(4,Regle4.appliquer)]
end

module SystemeReecritureBOA = SystemeReecriture (ArbreReecritureBOA) (ReglesReecritureBOA)


let%test _ = (SystemeReecritureBOA.construit_arbre ['B';'O';'O'] 2 = Be.Boa.ArbreReecritureBOA.Noeud (['B'; 'O'; 'O'],
          [(1,
          Be.Boa.ArbreReecritureBOA.Noeud (['B'; 'O'; 'O'; 'A'],
          [(2,
            Be.Boa.ArbreReecritureBOA.Noeud (['B'; 'O'; 'O'; 'A'; 'O'; 'O'; 'A'], []))]));
          (2,
          Be.Boa.ArbreReecritureBOA.Noeud (['B'; 'O'; 'O'; 'O'; 'O'],
          [(1, Be.Boa.ArbreReecritureBOA.Noeud (['B'; 'O'; 'O'; 'O'; 'O'; 'A'], []));
            (2,
            Be.Boa.ArbreReecritureBOA.Noeud
              (['B'; 'O'; 'O'; 'O'; 'O'; 'O'; 'O'; 'O'; 'O'], []));
            (3, Be.Boa.ArbreReecritureBOA.Noeud (['B'; 'A'; 'O'], []));
            (3, Be.Boa.ArbreReecritureBOA.Noeud (['B'; 'O'; 'A'], []))]))]))
let%test _ = (SystemeReecritureBOA.chemin ['B';'O'] ['B';'A'] 5 = Some
          ([['B'; 'O']; ['B'; 'O'; 'O']; ['B'; 'O'; 'O'; 'O'; 'O'];
            ['B'; 'O'; 'O'; 'O'; 'O'; 'A']; ['B'; 'A'; 'O'; 'A']; ['B'; 'A']],
          [2; 2; 1; 3; 3]))