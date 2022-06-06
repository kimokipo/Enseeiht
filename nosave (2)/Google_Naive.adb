


package body Google_Naive is
    procedure Initialiser_M(S : out T_Matrice) is
    begin
        for i in 1..capacite loop
            for j in 1..capacite loop
                S(i,j) := T_Element(0.0);
            end loop;
        end loop;
    end Initialiser_M;

    Procedure Modifier_M(M : in out T_Matrice; I,J : in Integer; Val : T_Element) is
    begin
        M(I,J) := Val;
    end Modifier_M;

    function Somme_M_Ligne(M : in  T_Matrice; I : in integer) return T_Element is
        s : T_Element := T_Element(0.0);
    begin
        for j in 1..capacite loop
            s := s + M(I,j);
        end loop;
        return s;
    end Somme_M_Ligne;

    procedure Modifier_M_Ligne(S : in out T_Matrice; I : in Integer; Val : In T_Element) is
    begin
        for j in 1..capacite loop
            S(I,j) := Val;
        end loop;
    end Modifier_M_Ligne;

    procedure Produit_M_Ligne(M : in out T_Matrice; I : in Integer; Val : in T_Element) is
    begin
        for j in 1..capacite loop
            M(I,j) := Val*M(I,j);
        end loop;
    end Produit_M_Ligne;

    procedure Matrice_Google_M(M : in out T_Matrice; alpha : in T_Element) is
    begin
        for i in 1..capacite loop
            for j in 1..capacite loop
                Modifier_M(M,i,j,alpha*M(i,j) + (1 - alpha)/T_Element(capacite));
            end loop;
        end loop;
    end Matrice_Google_M;

    function Constant_V(L : T_Element) return T_vecteur is
        W : T_Vecteur;
    begin
        for i in 1..capacite loop
            W(i) := L;
        end loop;
    end Constant_V;

    function Transposer(M : in T_Matrice) return T_Matrice is
        N : T_Matrice;
    begin
        for i in 1..capacite loop
            for j in 1..capacite loop
                N(i,j) := M(j,i);
            end loop;
        end loop;
    end Transposer;

    procedure Produit_Matrice_Vecteur_M(V : in out T_Vecteur; M : in T_Matrice) is
        function somme(W : in out T_vecteur; I : in Integer) return T_Element is
            s : T_Element := T_Element(0.0);
        begin
            for j in 1..capacite loop
                s := s + V(j)*M(I,j);
            end loop;
            return s;
        end somme;

    begin
        for i in 1..capacite loop
            V(i) := somme(V,i);
        end loop;
    end Produit_Matrice_Vecteur_M;

    procedure Trier_Vecteur(V: in out T_Vecteur; W : out T_Vecteur) is
        a,b : T_Element;
        procedure Creer_W is
        begin
            for i in 1..capacite loop
                W(i) := T_Element(i-1);
            end loop;
        end Creer_W;
    begin
        Creer_W;
        for i in 1..capacite loop
            j := i - 1;
            while (j >= 1) and (V(j) < V(j+1)) loop
                a := V(j);
                b := W(j);
                V(j) := V(j+1);
                W(j) := W(j+1);
                V(j+1) := a;
                W(j+1) := b;
                j := j - 1;

            end loop;
        end loop;
    end Trier_Vecteur;


    function Composante(V : in T_Vecteur; I : in Integer) return T_Element is
    begin
        return V(I);
    end Composante;
end Google_Naive;









