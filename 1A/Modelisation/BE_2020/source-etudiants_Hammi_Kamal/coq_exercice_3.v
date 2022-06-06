Section Session1_2020_Induction_Exercice_3.

(* Déclaration d’un domaine pour les éléments des listes *)
Variable A : Set.

Inductive liste : Set :=
Nil
: liste
| Cons : A -> liste -> liste.

(* Déclaration du nom de la fonction append *)
Variable append_spec : liste -> liste -> liste.

(* Spécification du comportement de append pour Nil en premier paramètre *)
Axiom append_Nil : forall (l : liste), append_spec Nil l = l.

(* Spécification du comportement de append pour Cons en premier paramètre *)
Axiom append_Cons : forall (t : A), forall (q l : liste),
   append_spec (Cons t q) l = Cons t (append_spec q l).

(* append est associative à gauche et à droite *)
Axiom append_associative : forall (l1 l2 l3 : liste),
   (append_spec l1 (append_spec l2 l3)) = (append_spec (append_spec l1 l2) l3).


Variable map_spec : (A -> A) -> (liste -> liste).

Axiom map_Nil : forall (f : A -> A), (map_spec f Nil)=Nil.

Axiom map_Cons : forall (f : A -> A), forall (t : A), forall (q : liste), (map_spec f (Cons t q))=(Cons (f t) (map_spec f q)).

(* taille commute avec append *)
Theorem map_append : forall (f : A -> A), forall (l1 l2 : liste), 
(map_spec f (append_spec l1 l2)) = (append_spec (map_spec f l1) (map_spec f l2)).
Proof.
intros.
induction l1.
rewrite append_Nil.
rewrite map_Nil.
rewrite append_Nil.
reflexivity.
rewrite append_Cons.
rewrite map_Cons.
rewrite map_Cons.
rewrite append_Cons.
rewrite IHl1.
reflexivity.
Qed.

(* Implantation de la fonction taille *)
Fixpoint map_impl (f : A  -> A) (l : liste) {struct l} : liste :=
match l with 
Nil => Nil
|(Cons t q) => (Cons (f t) (map_impl f q))
end.

Theorem taille_correctness : forall (f  : A  -> A), forall (l : liste),
   (map_spec f l) = (map_impl f l).
Proof.
intros.
induction l.
unfold map_impl.
rewrite map_Nil.
reflexivity.
unfold map_impl.
rewrite map_Cons.
rewrite IHl.
unfold map_impl.
reflexivity.
Qed.

End Session1_2020_Induction_Exercice_3.
