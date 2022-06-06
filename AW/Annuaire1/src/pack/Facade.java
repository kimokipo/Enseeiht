package pack;

import java.sql.*;
import java.util.*;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.persistence.*;

@Singleton
public class Facade {
	
	//Connection con;
	
	@PersistenceContext
	private EntityManager em;
	
	/**@PostConstruct
	public void init() {
		try {
			String db_url = "jdbc:hsqldb:hsql://localhost/xdb";
			String db_user = "sa";
			Class.forName("org.hsqldb.jdbcDriver");
			con = DriverManager.getConnection(db_url, db_user, null);
			System.out.println("connexion à la base réussite");
		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}*/
	
	
	public void ajoutPersonne(String nom , String prenom) {
		Personne p = new Personne(nom,prenom);
		em.persist(p);
		/**try {
			PreparedStatement ps;
			ps = con.prepareStatement("INSERT INTO Personne VALUES(?,?,?)");
			ps.setNull(1, Types.INTEGER);
			ps.setString(2, nom);
			ps.setString(3, prenom);
			ps.executeUpdate();
		}catch (Exception ex) {
			ex.printStackTrace();
		}*/
		System.out.println(nom + " " + prenom);
	}
	
	public void ajoutAdresse(String rue, String ville) {
		Adresse a = new Adresse(rue,ville);
		em.persist(a);
		/**try {
			PreparedStatement ps;
			ps = con.prepareStatement("INSERT INTO Adresse VALUES(?,?,?,?)");
			ps.setNull(1, Types.INTEGER);
			ps.setString(2, rue);
			ps.setString(3, ville);
			ps.setNull(4, Types.INTEGER);
			ps.executeUpdate();
		}catch (Exception ex) {
			ex.printStackTrace();
		}*/
		System.out.println(rue + " " + ville);
	}

	public Collection<Personne> getPersonnes() {
		TypedQuery<Personne> req = em.createQuery("select p from Personne p",Personne.class);
		return req.getResultList();
		/**try {
			ArrayList<Personne> liste = new ArrayList<Personne>();
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("SELECT * FROM Personne");
			while(res.next()) {
				//Personne p = new Personne(res.getString("nom"),res.getString("prenom"),res.getInt("id"));
				//liste.add(p);
			}
			//return liste;
			
		}catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}*/
	
	}
	
	public Collection<Adresse> getAdresses() {
		TypedQuery<Adresse> req = em.createQuery("select a from Adresse a",Adresse.class);
		return req.getResultList();
		/**try {
			ArrayList<Adresse> liste = new ArrayList<Adresse>();
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("SELECT * FROM Adresse");
			while(res.next()) {
				//Adresse a = new Adresse(res.getString("rue"),res.getString("ville"),res.getInt("id"));
				//liste.add(a);
			}
			//return liste;
			
		}catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}*/
	}
	
	public void associer(int idPer, int idAdr) {
		Personne p = em.find(Personne.class, idPer);
		if (p == null) throw new RuntimeException("Compte introuvable");
		Adresse a = em.find(Adresse.class, idAdr);
		if (a == null) throw new RuntimeException("Compte introuvable");
		//p.getAdresses().add(a);
		Adresse old = p.getAdresse();
		if (old != null) old.setPersonne(null);
		a.setPersonne(p);
		/**try {
			PreparedStatement ps;
			ps = con.prepareStatement("UPDATE Adresse SET personneid = ? WHERE id = ?");
			ps.setInt(1, idPer);
			ps.setInt(2, idAdr);
			ps.executeUpdate();
		}catch (Exception ex) {
			ex.printStackTrace();
		}*/
		System.out.println(idPer + " est a associé a " + idAdr);
		
	}
	
	public HashMap<Personne,Collection<Adresse>> listeTout(){
		HashMap<Personne,Collection<Adresse>> result = new HashMap<Personne,Collection<Adresse>>();
		Collection<Personne> personnes = this.getPersonnes();
		for (Personne p: personnes) {
			ArrayList<Adresse> list = new ArrayList<Adresse>();
			Adresse a = p.getAdresse();
			if (a != null) {
				list.add(a);
			}
			result.put(p, list);
		}
		return result;
		/**try {
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("SELECT * FROM Personne");
			while(res.next()) {
				int idPer = res.getInt("id");
				Personne p = new Personne(res.getString("nom"),res.getString("prenom"),idPer);
				ArrayList<Adresse> adresses = new ArrayList<Adresse>();
				Statement stmt2 = con.createStatement();
				ResultSet res2 = stmt2.executeQuery("SELECT * FROM Adresse WHERE personneid = "+idPer);
				while(res2.next()) {
					Adresse a = new Adresse(res2.getString("rue"),res2.getString("ville"),res2.getInt("id"));
					adresses.add(a);
				}
				result.put(p, adresses);
			}
			return result;
			
		}catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}*/
	}
}
