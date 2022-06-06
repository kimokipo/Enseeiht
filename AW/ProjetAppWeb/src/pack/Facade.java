package pack;

import java.awt.List;
import java.util.*;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Singleton
public class Facade {
	
	@PersistenceContext
	private EntityManager em;
	
	@PostConstruct
	public void init() {
		ajouterManager("root","root","admin","admin","","");
	}
	
	public Campagne getCampagneById(int idc) {
    	return em.find(Campagne.class, idc);
	}
	
	public Post getPostByUrl(String url) {
		Collection<Post> cm = (Collection<Post> ) em.createQuery("select a from Post a",Post.class).getResultList();
		for (Post p:cm) {
    		if(p.getUrl().equals(url)) {
				return p;
			}
		}
		return null;
	}
	public boolean UserExiste(String login, String mdp) {
		Collection<Utilisateur> cm = (Collection<Utilisateur> ) em.createQuery("select a from Utilisateur a",Utilisateur.class).getResultList();
		for (Utilisateur u:cm) {
    		if(u.getLogin().equals(login) && u.getMotDePasse().equals(mdp)) {
				return true;
			}
		}
		return false;
	}
	
	public Integer getNombreLikes(int idcampagne){
    	Campagne c = em.find(Campagne.class, idcampagne);
		int result = 0;
		Collection<Post> ps = c.getPosts();
		for (Post p:ps) {
			ArrayList<Releve> rs = new ArrayList<Releve>(p.getReleves());
			Collections.reverse(rs);
				result = result + rs.get(0).getNbLikes();
		}
		return result;
	}
	
	public Integer getNombreComments(int idcampagne){
    	Campagne c = em.find(Campagne.class, idcampagne);
		int result = 0;
		Collection<Post> ps = c.getPosts();
		for (Post p:ps) {
			ArrayList<Releve> rs = new ArrayList<Releve>(p.getReleves());
			Collections.reverse(rs);
				result = result + rs.get(0).getNbComments();
		}
		return result;
	}
	
	public Integer getNombreShares(int idcampagne){
    	Campagne c = em.find(Campagne.class, idcampagne);
		int result = 0;
		Collection<Post> ps = c.getPosts();
		for (Post p:ps) {
			ArrayList<Releve> rs = new ArrayList<Releve>(p.getReleves());
			Collections.reverse(rs);
				result = result + rs.get(0).getNbShares();
		}
		return result;
	}
	
	public void supprimerRoot() {
		em.createQuery("delete from Utilisateur where id = 1",Utilisateur.class).executeUpdate();
	}
	
	public void ajouterCampagne(String n, String dd, String df, String obj,String context) {
		Campagne c = new Campagne(n,dd,df,obj,context);
		em.persist(c);
	}
	public void ajouterGroupe(String nom, int nombreMembres, String theme, String type, String reglementation,
			String url, int frequence, String format, String lieu) {
    	Groupe g = new Groupe(nom,nombreMembres, theme, type, reglementation, url, frequence, format, lieu);
    	em.persist(g);
    }
	public void ajouterManager(String nom, String prenom, String login, String motDePasse, String logFacebook, String passefacebook) {
          Manager m = new Manager(nom,prenom, login, motDePasse, logFacebook, passefacebook );
          em.persist(m);
    }
	public void ajouterPost(String titre, String url, String contenu) {
    	Post p = new Post(titre, url, contenu);
    	em.persist(p);
    }
	public void ajouterReleve(String date, int nbLikes, int nbComments, int nbShares, Post post) {
    	Releve r = new Releve(date, nbLikes, nbComments, nbShares);
    	r.setPost(post);
    	em.persist(r);
    }
	public void associerPostCampagne(int pid, int cid) {
    	Post p = em.find(Post.class, pid);
    	Campagne c = em.find(Campagne.class, cid);	
    	p.setCampagne(c);
    	
    }
	public void associerManagerGroupe(int mid, int gid) {
    	Manager m = em.find(Manager.class, mid);
    	Groupe g = em.find(Groupe.class, gid);	
    	m.getGroupes().add(g);
    	
    } 
	public Collection<Campagne> listerCampagnes(){
    	TypedQuery<Campagne> req = em.createQuery("select c from Campagne c",Campagne.class);
    	Collection<Campagne> lcs = req.getResultList();
    	/*for(Campagne c :lcs) {
    		System.out.println(c.getNom());
    	}*/
    	return lcs;
    }
	public Collection<Groupe> listerGroupes(){
    	TypedQuery<Groupe> req = em.createQuery("select a from Groupe a",Groupe.class);
		return req.getResultList();
    }
	public Collection<Post> listerPosts(){
    	TypedQuery<Post> req = em.createQuery("select a from Post a",Post.class);
		return req.getResultList();
    }
	public Collection<Manager> listerManagers(){
    	TypedQuery<Manager> req = em.createQuery("select a from Manager a",Manager.class);
		return req.getResultList();
    }
	public void ajouterUtilisateur(String nom, String prenom, String login, String motDePasse) {
        Utilisateur m = new Utilisateur(nom,prenom, login, motDePasse);
        em.persist(m);
  }
   

}
