package Jeu.Modeles;

import java.util.*;
import javax.swing.*;/**
  * ModeleMaitreJeu est une réalisation de l'iterface du maitre du jeu
  *
  * @author	Kamal Hammi
  * @version	$version: 1.0 $
  */

@Deprecated
public class ModeleMaitreJeu  {

	private Map<String,JTextField> listCapacites;
	private Map<String,Integer> listInventaire;
	
	public ModeleMaitreJeu() {
		listCapacites = new HashMap<String,JTextField>();
		listInventaire = new HashMap<String,Integer>();
	}
	
	public String getInventaire() {
		String inventaire = "";	
		int i = 0;
		for (Map.Entry<String,Integer> e : listInventaire.entrySet()){
			i++;
			if (e.getValue()>0){
			if ( i==listInventaire.size()){
				inventaire = inventaire + e.getValue() + "x " + e.getKey()+".";
			}
			else {
				inventaire = inventaire + e.getValue() + "x " + e.getKey()+",";
			}
			}
		}
		return inventaire;
	}

	public Map<String,Integer> getInventaireMap() {
		return listInventaire;
	}

	public void ajouterInventaire(String inventaire){
		int ancien = (listInventaire.containsKey(inventaire)) ? listInventaire.get(inventaire) : 0;
		listInventaire.put(inventaire,ancien+1);
	}

	public void supprimerInventaire(String inventaire){
		int ancien = (listInventaire.containsKey(inventaire)) ? listInventaire.get(inventaire) : -1;
		if (ancien == 0){
			listInventaire.remove(inventaire);
		}else if(ancien!=-1){
			listInventaire.put(inventaire,ancien-1);
		}
	}

	public Map<String,JTextField> getCapacites() {
		return listCapacites;
	}

	public void ajouterCapacite(String capacite){
		if(!listCapacites.containsKey(capacite)){
			listCapacites.put(capacite,new JTextField(6));
		}
	}

	public void reinitialiser() {
		listCapacites.clear();
		listInventaire.clear();
	}
}
