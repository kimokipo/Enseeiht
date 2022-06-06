package pack;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
@Entity
public class Manager extends Utilisateur {
	String loginFacebook;
	String motDePasseFacebook;
    @ManyToMany
    Collection<Groupe> groupes;
	public Manager(int id, String nom, String prenom, String login, String motDePasse, String logFacebook, String passefacebook) {
		super(id, nom, prenom, login, motDePasse);
		this.loginFacebook = logFacebook;
		this.motDePasseFacebook = passefacebook;
	}

	public String getLoginFacebook() {
		return loginFacebook;
	}

	public void setLoginFacebook(String loginFacebook) {
		this.loginFacebook = loginFacebook;
	}

	public String getMotDePasseFacebook() {
		return motDePasseFacebook;
	}

	public void setMotDePasseFacebook(String motDePasseFacebook) {
		this.motDePasseFacebook = motDePasseFacebook;
	}

	public Collection<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(Collection<Groupe> groupes) {
		this.groupes = groupes;
	}
	

}
