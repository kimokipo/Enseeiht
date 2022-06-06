Require Import Naturelle.
Section Session1_2020_Logique_Exercice_2.

Variable A B : Prop.

Theorem Exercice_2_Naturelle : ((~A) -> B) /\ (A -> B) -> B.
Proof.
I_imp'.
E_ou (A) (~ A).
TE.
E_et_d (~ A  -> B).
Hyp H.
E_et_g (A-> B).
Hyp H.
Qed.

Theorem Exercice_2_Coq : ((~A) -> B) /\ (A -> B) -> B.
Proof.
intros.
destruct H.
cut(A).
exact H0.
Qed.

End Session1_2020_Logique_Exercice_2.

