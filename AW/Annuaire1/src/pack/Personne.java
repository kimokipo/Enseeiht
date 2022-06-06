package pack;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Personne {

	private String nom;
	private String prenom;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	//@ManyToMany(fetch=FetchType.EAGER)
	@OneToOne(mappedBy="personne")
	Adresse adresse;
	
	public Personne() {}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Personne(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	
	
	
	
}
