Section Session1_2018_Induction_Exercice_3.

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

(* Spécification du comportement de append pour Nil en second paramètre *)
Axiom append_Nil_right : forall (l : liste), (append_spec l Nil) = l.

(* append est associative à gauche et à droite *)
Axiom append_associative : forall (l1 l2 l3 : liste),
   (append_spec l1 (append_spec l2 l3)) = (append_spec (append_spec l1 l2) l3).

(* Déclaration du nom de la fonction snoc *)
Variable snoc_spec : A -> liste -> liste.

(* Spécification du comportement de snoc pour Nil en second paramètre *)
Axiom snoc_Nil : forall (e : A), (snoc_spec e Nil)= (Cons e Nil).

(* Spécification du comportement de snoc pour Cons en second paramètre *)
Axiom snoc_Cons : forall (e : A), forall (t : A), forall (q : liste),
(snoc_spec e (Cons t q))=(Cons t (snoc_spec e q)).

(* snoc pourrais être spécifié avec append *)
Theorem snoc_alternative : forall (e : A), forall (l : liste),
(snoc_spec e l)=(append_spec  l (Cons e Nil)).
Proof.
intros.
induction l.
rewrite append_Nil.
rewrite snoc_Nil.
reflexivity.
rewrite append_Cons.
rewrite snoc_Cons.
rewrite IHl.
reflexivity.
Qed.

(* snoc commute avec append *)
Theorem snoc_append : forall (e : A), forall (l1 l2 : liste),
(snoc_spec e (append_spec l1 l2))=(append_spec l1 (snoc_spec e l2)).
Proof.
intros.
induction l1.
rewrite append_Nil.
rewrite append_Nil.
reflexivity.
rewrite append_Cons.
rewrite snoc_Cons.
rewrite IHl1.
rewrite append_Cons.
reflexivity.
Qed.

(* Implantation de la fonction snoc *)
Fixpoint snoc_impl (e : A) (l : liste) {struct l} : liste :=
match l with 
  Nil => (Cons e Nil)
  | (Cons t q ) => (Cons t (snoc_impl e q ))
end.

Theorem snoc_correctness : forall (e : A), forall (l : liste),
   (snoc_spec e l) = (snoc_impl e l).
Proof.
intros.
induction l.
unfold snoc_impl.
rewrite snoc_Nil.
reflexivity.
unfold snoc_impl.
rewrite snoc_Cons.
rewrite IHl.
unfold snoc_impl.
reflexivity.
Qed.
		     
End Session1_2018_Induction_Exercice_3.
