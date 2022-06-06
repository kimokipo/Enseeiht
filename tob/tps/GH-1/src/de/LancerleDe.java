package de;

import java.util.Random;

public class LancerleDe implements LancerDe {
	
	private int N; //taille du dé
	private int valeur;
	
	public LancerleDe() {
		this.N = 6;
		this.valeur = valeur;
	}

	/** Obtenir la valeur du dé */
	public int getValeur() {
		Random rand = new Random();
		this.valeur = 1 + rand.nextInt(N);
		return this.valeur;
	}

	public void changerNbFaces(int N) {
		this.N = N;
	}
}
		
