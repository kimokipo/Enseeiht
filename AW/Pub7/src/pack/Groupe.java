package pack;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Groupe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	String nom;
	String nombreMembres;
	String theme;
	String type;
	String reglementation;
	String url;
	String frequence;
	String format;
	String lieu;
	@ManyToMany
	Collection<Campagne> campagnes;
	@OneToMany(mappedBy ="groupe")
	Collection<Post> posts;
	@ManyToMany(mappedBy ="groupes")
	Collection<Manager> managers;
	public Groupe() {}
	public Groupe(int id, String nom, String nombreMembres, String theme, String type, String reglementation,
			String url, String frequence, String format, String lieu) {
		super();
		this.id = id;
		this.nom = nom;
		this.nombreMembres = nombreMembres;
		this.theme = theme;
		this.type = type;
		this.reglementation = reglementation;
		this.url = url;
		this.frequence = frequence;
		this.format = format;
		this.lieu = lieu;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNombreMembres() {
		return nombreMembres;
	}
	public void setNombreMembres(String nombreMembres) {
		this.nombreMembres = nombreMembres;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getReglementation() {
		return reglementation;
	}
	public void setReglementation(String reglementation) {
		this.reglementation = reglementation;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getFrequence() {
		return frequence;
	}
	public void setFrequence(String frequence) {
		this.frequence = frequence;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public Collection<Campagne> getCampagnes() {
		return campagnes;
	}
	public void setCampagnes(Collection<Campagne> campagnes) {
		this.campagnes = campagnes;
	}
	public Collection<Post> getPosts() {
		return posts;
	}
	public void setPosts(Collection<Post> posts) {
		this.posts = posts;
	}
	public Collection<Manager> getManagers() {
		return managers;
	}
	public void setManagers(Collection<Manager> managers) {
		this.managers = managers;
	}
	
	
	
	
}
