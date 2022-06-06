Require Import Naturelle.
Section Session1_2020_Logique_Exercice_1.

Variable A B C : Prop.

Theorem Exercice_1_Naturelle :  ((A -> C) /\ (B -> C)) -> ((A \/ B) -> C).
Proof.
I_imp'.
I_imp'.
E_ou (A) (B).
Hyp H0.
E_et_g (B -> C).
Hyp H.
E_et_d (A-> C).
Hyp H.
Qed.

Theorem Exercice_1_Coq : ((A -> C) /\ (B -> C)) -> ((A \/ B) -> C).
Proof.
intros.
firstorder.
Qed.

End Session1_2020_Logique_Exercice_1.

