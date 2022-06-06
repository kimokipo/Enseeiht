package Jeu.Modeles;

import Jeu.Interfaces.Capacite;
import Jeu.Interfaces.Inventaire;
import Jeu.Interfaces.Statistique;
import Jeu.Utils;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
  * ModeleFichePersonnage est une réalisation de l'interface fiche de personnage 
  *	
  * @version	$version: 1.0 $
  */

public class ModeleFichePersonnage implements Serializable {

	private String nomPersonnage;
	private String rolePersonnage;
	private int viePersonnage;
	private List<Capacite> capacites;
	private Map<String,List<Statistique>> statistiques;
	private Inventaire inventaire;
	private transient ImageIcon imagePersonnage;
	
	public ModeleFichePersonnage(String nom, String role) {
		nomPersonnage = nom;
		rolePersonnage = role;
		viePersonnage = 10;
		imagePersonnage = Utils.DEFAULT_ICON;
		inventaire = new InventaireSimple();
		capacites = new ArrayList<>();
		statistiques = new HashMap<>();
	}

	public ImageIcon getImage() {
		return imagePersonnage;
	}

	public void setImage(ImageIcon icon) {
		imagePersonnage = icon;
	}

	public Inventaire getInventaire() {
		return inventaire;
	}

	public String getNom() {
		return nomPersonnage;
	}

	public void setNom(String nom) {
		this.nomPersonnage = nom;
	}

	public String getRole() {
		return rolePersonnage;
	}

	public void setRole(String role) {
		this.rolePersonnage = role;
	}
	
	public int getVie() {
		return viePersonnage;
	}

	public void setVie(int vie) {
		this.viePersonnage = vie;
	}

	public void ajouterNomStatistique(String nom){
		if(!statistiques.containsKey(nom)){
			statistiques.put(nom,new ArrayList<>());
		}
	}

	public void supprimerNomStatistique(String nom){
		if(statistiques.containsKey(nom)){
			statistiques.remove(nom);
		}
	}

	public List<Capacite> getCapacites() {
		return capacites;
	}

	public Map<String,List<Statistique>> getNewstatistiques() {
		return statistiques;
	}

	public Capacite ajouterCapacite(String capacite) {
		if (capacites.stream().anyMatch(x -> x.getNom().equals(capacite)) || capacite == null)
			return null;

		Capacite c = new CapaciteSimple(capacite);
		capacites.add(c);
		return c;
	}

	public Statistique ajouterStatistique(String nom, String statistique) {
		if (statistiques.get(nom).stream().anyMatch(x -> x.getNom().equals(statistique)) || statistique == null)
			return null;

		Statistique s = new StatistiqueSimple(statistique);
		statistiques.get(nom).add(s);
		return s;
	}
	
	public void reinitialiser() {
		nomPersonnage = "";
		rolePersonnage = "";
		imagePersonnage = Utils.DEFAULT_ICON;
		viePersonnage = 10;
		inventaire.clear();
		capacites.clear();
		for(String nom : statistiques.keySet()){
			statistiques.get(nom).clear();
		}
	}
}
