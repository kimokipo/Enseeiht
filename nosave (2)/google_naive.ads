generic
    type T_Element is digits <>;
    capacite : Integer;
package Google_Naive is
    type T_Vecteur is private;
    type T_Matrice is private;

    --  initialiser une matrice
    procedure Initialiser_M(S : out T_Matrice);
    -- modifier la valeur d'une composante d'une Matrice
    Procedure Modifier_M(M : in out T_Matrice; I,J : in Integer; Val : T_Element);

    -- sommer les composantes d'une ligne d'une matrice
    function Somme_M_Ligne(M : in  T_Matrice; I : in integer) return T_Element;
    -- donner une valeur aux composantes d'une ligne d'une matrice
    procedure Modifier_M_Ligne(S : in out T_Matrice; I : in Integer; Val : In T_Element);
    -- faire le produit d'un reel et une ligne d'une matrice
    procedure Produit_M_Ligne(M : in out T_Matrice; I : in Integer; Val :in T_Element);

    --  Calculer la matrice google procedure
    procedure Matrice_Google_M(M : in out T_Matrice; alpha : in T_Element);

    -- creer un vecteur dont tous les elements egales à une valeur donnée
    function Constant_V(L : T_Element) return T_vecteur;

    --  calculer la transposer d'une matrice
    function Transposer(M : in T_Matrice) return T_Matrice;

    -- calculer le produit d'une matrice et d'un vecteur
    procedure Produit_Matrice_Vecteur_M(V : in out T_Vecteur; M : in T_Matrice);

    -- trier le vecteurs des poids e ainsi construire un vecteurs trier selon les poids qui contient les numeros des pages de reseau
    procedure Trier_Vecteur(V: in out T_Vecteur; W : out T_Vecteur);

    -- recuperer la composante d'indice I d'un vecteur
    function Composante(V : in T_Vecteur; I : in Integer) return T_Element;

private
    type T_Vecteur is array (1..capacite) of T_Element;
    type T_Matrice is array (1..capacite,1..capacite) of T_Element;
end Google_Naive;





