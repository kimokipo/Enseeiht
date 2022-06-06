Require Import Naturelle.
Section Session1_2019_Logique_Exercice_1.

Variable A B C : Prop.

Theorem Exercice_1_Naturelle :  (A -> B -> C) -> ((A /\ B) -> C).
Proof.
I_imp'.
I_imp'.
E_imp (B).
E_imp (A).
Hyp H.
E_et_g B.
Hyp H0.
E_et_d A.
Hyp H0.
Qed.

Theorem Exercice_1_Coq :  (A -> B -> C) -> ((A /\ B) -> C).
Proof.
intros.
apply H.
destruct H0.
exact H0.
destruct H0.
exact H1.
Qed.

End Session1_2019_Logique_Exercice_1.

