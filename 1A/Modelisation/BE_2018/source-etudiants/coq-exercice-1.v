Require Import Naturelle.
Section Session1_2018_Logique_Exercice_1.

Variable A B : Prop.


Theorem Exercice_1_Naturelle : ~(A \/ B) -> (~A /\ ~B).
Proof.
I_imp'.
I_et.
E_imp (~(A \/ B)).
E_imp (A->(A\/B)).
apply contra.
I_ou_d.
Hyp H.
E_imp (~(A \/ B)).
E_imp (B->(A\/B)).
apply contra.
I_ou_g.
Hyp H.
Qed.

Theorem Exercice_1_Coq : ~(A \/ B) -> (~A /\ ~B).
Proof.
intros.
firstorder.
Qed.

End Session1_2018_Logique_Exercice_1.
