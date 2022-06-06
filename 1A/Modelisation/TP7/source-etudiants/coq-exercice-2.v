Require Import Naturelle.
Section Session1_2019_Logique_Exercice_2.

Variable A B : Prop.



Theorem Exercice_2_Naturelle : (~A) \/ B -> (~A) \/ (A /\ B).
Proof.
I_imp' .
E_ou (~A) B.
Hyp H.
I_imp' .
I_ou_g.
Hyp H0.
I_imp' .
E_ou A (~A).
TE.
I_imp'.
I_ou_d.
I_et.
Hyp H1.
Hyp H0.
I_imp'.
I_ou_g .
Hyp H1.



Qed.

Theorem Exercice_2_Coq : (~A) \/ B -> (~A) \/ (A /\ B).
Proof.
intros.
firstorder.

cut (A\/ (~ A)).
intros.
elim H0.
intros.
apply or_intror.
split.
exact H1.
exact H.
intros.
apply or_introl.
exact H1.
exact (classic A).

Qed.






End Session1_2019_Logique_Exercice_2.

