Require Import Extraction.
(* Ouverture d’une section *)
Section Induction.
(* Déclaration d’un domaine pour les éléments des listes *)
Variable A : Set.

Inductive liste : Set :=
  Nil : liste
| Cons : A -> liste -> liste.

(* Déclaration du nom de la fonction *)
Variable append_spec : liste -> liste -> liste.

(* Spécification du comportement pour Nil *)
Axiom append_Nil : forall (l : liste), append_spec Nil l = l.

(* Spécification du comportement pour Cons *)
Axiom append_Cons : forall (t : A), forall (q l : liste),
   append_spec (Cons t q) l = Cons t (append_spec q l).

Theorem append_Nil_right : forall (l : liste), (append_spec l Nil) = l.
(* TO DO *)
intros.
induction l.
apply append_Nil.
rewrite append_Cons.
rewrite IHl.
reflexivity.
Qed.

Theorem append_associative : forall (l1 l2 l3 : liste),
   (append_spec l1 (append_spec l2 l3)) = (append_spec (append_spec l1 l2) l3).
(* TO DO *)
intros.
induction l1.
rewrite append_Nil.
rewrite append_Nil.
reflexivity.
rewrite append_Cons.
rewrite append_Cons.
rewrite IHl1.
rewrite append_Cons.
reflexivity.
Qed.

(* Implantation de la fonction append *)
Fixpoint append_impl (l1 l2 : liste) {struct l1} : liste :=
   match l1 with
      Nil => l2
      | (Cons t1 q1) => (Cons t1 (append_impl q1 l2))
end.

Theorem append_correctness : forall (l1 l2 : liste),
   (append_spec l1 l2) = (append_impl l1 l2).
(* TO DO *)
intros.
induction l1.
unfold append_impl.
apply append_Nil.
rewrite append_Cons.
rewrite IHl1.
symmetry.
unfold append_impl.
reflexivity.
Qed.

(* Implantation de la fonction rev (reverse d'une liste) *)
Fixpoint rev_impl (l : liste) : liste :=
(* TO DO *)
  match l with 
    Nil=> Nil
      |(Cons x y) => append_spec (rev_impl y) (Cons x Nil)

 

end.

Lemma rev_append : forall (l1 l2 : liste),
   (rev_impl (append_impl l1 l2)) = (append_impl (rev_impl l2) (rev_impl l1)).
(* TO DO *)
intros.
induction l1.
rewrite <- append_correctness.
rewrite <- append_correctness.
rewrite append_Nil.
symmetry.
unfold rev_impl.
rewrite append_Nil_right.
reflexivity.
rewrite <- append_correctness.
rewrite <- append_correctness.
rewrite append_Cons.
rewrite append_correctness.
rewrite append_correctness.
simpl.
rewrite IHl1.
rewrite <- append_correctness.
rewrite <- append_correctness.
rewrite append_associative.
reflexivity.
Qed.

Theorem rev_rev : forall (l : liste), (rev_impl (rev_impl l)) = l.
(* TO DO *)
intros.
induction l.
simpl.
reflexivity.
simpl.
rewrite append_correctness.
rewrite rev_append.
simpl.
rewrite IHl.
simpl.
rewrite append_correctness.
simpl.
reflexivity.
Qed.

End Induction.
Extraction Language Ocaml.
Extraction "/tmp/induction" append_impl rev_impl.
Extraction Language Haskell.
Extraction "/tmp/induction" append_impl rev_impl.
Extraction Language Scheme.
Extraction "/tmp/induction" append_impl rev_impl.
