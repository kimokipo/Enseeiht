package pack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Releve {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	String date;
	int nbLikes;
	int nbComments;
	int nbShares;
	@ManyToOne
	Post post;
	public Releve(int id, String date, int nbLikes, int nbComments, int nbShares, Post post) {
		super();
		this.id = id;
		this.date = date;
		this.nbLikes = nbLikes;
		this.nbComments = nbComments;
		this.nbShares = nbShares;
		this.post = post;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getNbLikes() {
		return nbLikes;
	}
	public void setNbLikes(int nbLikes) {
		this.nbLikes = nbLikes;
	}
	public int getNbComments() {
		return nbComments;
	}
	public void setNbComments(int nbComments) {
		this.nbComments = nbComments;
	}
	public int getNbShares() {
		return nbShares;
	}
	public void setNbShares(int nbShares) {
		this.nbShares = nbShares;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	
	
}
