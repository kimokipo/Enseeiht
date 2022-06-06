package pack;

import java.util.Collection;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Singleton
public class Facade {
	@PersistenceContext
	private EntityManager em;
	
	
	
	void ajouterCampagne(String n, String dd, String df, String obj,String context) {
		Campagne c = new Campagne(n,dd,df,obj,context);
		em.persist(c);
	}
    void ajouterGroupe(int id, String nom, String nombreMembres, String theme, String type, String reglementation,
			String url, String frequence, String format, String lieu) {
    	Groupe g = new Groupe(id,nom,nombreMembres, theme, type, reglementation, url, frequence, format, lieu);
    	em.persist(g);
    }
    void ajouterManager(int id, String nom, String prenom, String login, String motDePasse, String logFacebook, String passefacebook) {
          Manager m = new Manager(id,nom,prenom, login, motDePasse, logFacebook, passefacebook );
          em.persist(m);
    }
    void ajouterPost(int id, String titre, String url, String contenu) {
    	Post p = new Post(id, titre, url, contenu);
    	em.persist(p);
    }
    void ajouterReleve(int id, String date, int nbLikes, int nbComments, int nbShares, Post post) {
    	Releve r = new Releve(id, date, nbLikes, nbComments, nbShares, post);
    	em.persist(r);
    }
    void associerPostCampagne(int pid, int cid) {
    	Post p = em.find(Post.class, pid);
    	Campagne c = em.find(Campagne.class, cid);	
    	c.getPosts().add(p);
    	
    }
    void associerManagerGroupe(int mid, int gid) {
    	Manager m = em.find(Manager.class, mid);
    	Groupe g = em.find(Groupe.class, gid);	
    	m.getGroupes().add(g);
    	
    } 
    Collection<Campagne> listerCampagnes(){
    	TypedQuery<Campagne> req = em.createQuery("select a from Campagne a",Campagne.class);
		return req.getResultList();
    }
    Collection<Groupe> listerGroupes(){
    	TypedQuery<Groupe> req = em.createQuery("select a from Groupe a",Groupe.class);
		return req.getResultList();
    }
    Collection<Post> listerPosts(){
    	TypedQuery<Post> req = em.createQuery("select a from Post a",Post.class);
		return req.getResultList();
    }
   

}
