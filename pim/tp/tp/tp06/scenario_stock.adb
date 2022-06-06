with Stocks_Materiel;      use Stocks_Materiel;

-- Auteur: 
-- Gérer un stock de matériel informatique.
--
procedure Scenario_Stock is

    Mon_Stock : T_Stock;
begin
    -- Créer un stock vide
    Creer (Mon_Stock);
    pragma Assert (Nb_Materiels (Mon_Stock) = 0);

    -- Enregistrer quelques matériels
    Enregistrer (Mon_Stock, 1012, UNITE_CENTRALE, 2016);
    pragma Assert (Nb_Materiels (Mon_Stock) = 1);

    Enregistrer (Mon_Stock, 2143, ECRAN, 2016);
    pragma Assert (Nb_Materiels (Mon_Stock) = 2);

    Enregistrer (Mon_Stock, 3001, IMPRIMANTE, 2017);
    pragma Assert (Nb_Materiels (Mon_Stock) = 3);

    Enregistrer (Mon_Stock, 3012, UNITE_CENTRALE, 2017);
   pragma Assert (Nb_Materiels (Mon_Stock) = 4);
   pragma assert (Nb_Mat_Panne(Mon_Stock) = 0);
   mise_a_jour (Mon_Stock,3012,Panne);
   pragma assert (Nb_Mat_Panne(Mon_Stock) = 1);
   supprimer(Mon_Stock,3001);
   pragma Assert (Nb_Materiels (Mon_Stock) = 3);
   afficher(Mon_Stock);
   supprimer_panne(Mon_Stock);
   pragma assert (Nb_Mat_Panne(Mon_Stock) = 0);
   pragma Assert (Nb_Materiels (Mon_Stock) = 2);
   

end Scenario_Stock;
