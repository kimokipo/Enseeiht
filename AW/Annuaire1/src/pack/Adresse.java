package pack;

import java.util.*;

import javax.persistence.*;

@Entity
public class Adresse {
	
	private String rue;
	private String ville;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	//@ManyToMany(mappedBy="adresses")
	@OneToOne(fetch=FetchType.EAGER)
	Personne personne;

	public Personne getPersonne() {
		return personne;
	}


	public void setPersonne(Personne personne) {
		this.personne = personne;
	}


	public Adresse() {}
	
	
	public Adresse(String rue, String ville) {
		this.rue = rue;
		this.ville = ville;
	}
	
	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
