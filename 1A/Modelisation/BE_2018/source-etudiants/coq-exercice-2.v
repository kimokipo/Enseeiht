Require Import Naturelle.
Section Session1_2018_Logique_Exercice_2.

Variable A B : Prop.


Theorem Exercice_2_Naturelle : ~(A /\ B) -> (~A \/ ~B).
Proof.
E_imp ((~(~A \/ ~B))-> (A /\ B)).
apply contra.
I_imp'.
I_et.
E_imp (~(~A \/ ~B)).
E_imp (~A->(~A\/~B)).
apply contra.
I_ou_d.
Hyp H.
E_imp (~(~A \/ ~B)).
E_imp (~B->(~A\/~B)).
apply contra.
I_ou_g.
Hyp H.
Qed.

Theorem Exercice_2_Coq : ~(A /\ B) -> (~A \/ ~B).
Proof.
cut ((~(~A \/ ~B))-> (A /\ B)).
I_imp H1.
I_imp H2.
I_non H3.
I_antiT psi.
E_imp phi.
Hyp H1.
Hyp H3.
Hyp H2.
intros.
firstorder.
Qed.


End Session1_2018_Logique_Exercice_2.

