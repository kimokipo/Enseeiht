package pack;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	String titre;
	String url;
	String contenu;
	@ManyToOne(fetch=FetchType.EAGER)
	Campagne campagne;
	@ManyToOne(fetch=FetchType.EAGER)
	Groupe groupe;
	@OneToMany(mappedBy ="post",fetch=FetchType.EAGER)
	Collection<Releve> releves;
	public Post() {}
	public Post(String titre, String url, String contenu) {
		super();
		this.titre = titre;
		this.url = url;
		this.contenu = contenu;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Campagne getCampagne() {
		return campagne;
	}
	public void setCampagne(Campagne campagne) {
		this.campagne = campagne;
	}
	public Groupe getGroupe() {
		return groupe;
	}
	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}
	public Collection<Releve> getReleves() {
		return releves;
	}
	public void setReleves(Collection<Releve> releves) {
		this.releves = releves;
	}
	

}
