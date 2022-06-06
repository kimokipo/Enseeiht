package pack;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
public class Campagne {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	String nom;
	String dateDebut;
	String dateFin;
	String objectif;
	String contexte;
	@OneToMany(mappedBy="campagne", fetch=FetchType.EAGER)
	Collection<Post> posts;
	@ManyToMany(mappedBy="campagnes", fetch=FetchType.EAGER)
	Collection<Groupe> groupes;
	public Campagne() {}
	public Campagne(String n, String dd, String df, String obj, String context) {
		this.nom = n;
		this.dateDebut = dd;
		this.dateFin = df;
		this.contexte = context;
		this.objectif = obj;

	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}
	public String getDateFin() {
		return dateFin;
	}
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}
	public String getObjectif() {
		return objectif;
	}
	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}
	public String getContexte() {
		return contexte;
	}
	public void setContexte(String contexte) {
		this.contexte = contexte;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Collection<Post> getPosts() {
		return posts;
	}
	public void setPosts(Collection<Post> posts) {
		this.posts = posts;
	}
	public Collection<Groupe> getGroupes() {
		return groupes;
	}
	public void setGroupes(Collection<Groupe> groupes) {
		this.groupes = groupes;
	}
	
	

}
