package Jeu.Modeles;


import Jeu.Interfaces.Statistique;

import java.io.Serializable;

public class StatistiqueSimple implements Statistique, Serializable {
    private final String nom;
    private String valeur;

    public StatistiqueSimple(String nom) {
        this(nom,"");
    }

    public StatistiqueSimple(String nom, String valeur) {
        this.nom = nom;
        this.valeur = valeur;
    }

    public String getNom() {
        return this.nom;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public String getValeur() {
        return this.valeur;
    }
}
