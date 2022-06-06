package pack;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controler
 */
@WebServlet("/Controler")
public class Controler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB Facade facade;  
	
	private String t = "m";
    /**
     * Default constructor. 
     */
    public Controler() {
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String op = request.getParameter("op");
		String lien = "";
		if(op.equals("ConnectionManager")) {
			String login = request.getParameter("login");
			String mdp = request.getParameter("mdp");
			boolean existe = facade.UserExiste(login,mdp);
			lien = "connectionManager.jsp";
			if (existe) {
				t = "m";
				lien = "managerConnect.html";
			}else {
				String message = " Login ou Mot de passe incorrect";
				request.setAttribute("message", message);
			}
		}
		else if(op.equals("ConnectionUser")) {
			String login = request.getParameter("login");
			String mdp = request.getParameter("mdp");
			boolean existe = facade.UserExiste(login,mdp);
			lien = "connectionUser.jsp";
			if (existe) {
				t = "u";
				lien = "userConnect.html";
			}else {
				String message = " Login ou Mot de passe incorrect";
				request.setAttribute("message", message);
			}
		}
		else if( op.equals("listerCampagnes")){
			
			request.setAttribute("t", t);
			request.setAttribute("listercampagnes", facade.listerCampagnes());
			lien = "listerCampagnes.jsp";
			
		}else if(op.equals("ajoutCampagne")){

			String nom = request.getParameter("nom");
			String date_debut = request.getParameter("date_debut");
			String date_fin = request.getParameter("date_fin");
			String contexte = request.getParameter("contexte");
			String objectif = request.getParameter("objectifs");
			facade.ajouterCampagne(nom,date_debut,date_fin,objectif,contexte);
            lien = "ajoutCampagne.html";
			
		}else if( op.equals("listerGroupes")){

			request.setAttribute("t", t);
			request.setAttribute("listergroupes", facade.listerGroupes());
			lien = "listerGroupes.jsp";	
			
		}else if(op.equals("ajoutGroup")){
			
			String nom = request.getParameter("nom");
			int nombre_membre = Integer.parseInt(request.getParameter("nombre_membres"));
			String theme = request.getParameter("theme");
			String type = request.getParameter("type");
			String reglementation = request.getParameter("reglementation");
			String url = request.getParameter("url");
			int frequence = Integer.parseInt(request.getParameter("frequence_posts"));
			String format = request.getParameter("format");
			String lieu = request.getParameter("lieu");
			
            facade.ajouterGroupe(nom,nombre_membre,theme,type,reglementation,url,frequence,format,lieu);
            lien = "ajoutGroup.html";
			
		}else if(op.equals("ajoutPost")){
			
			String titre = request.getParameter("titre");
			String url = request.getParameter("url");
			String contenu = request.getParameter("contenu");
			
            facade.ajouterPost(titre,url,contenu);
            lien = "ajoutPost.html";
			
		}else if( op.equals("listerPosts")){

			request.setAttribute("t", t);
			request.setAttribute("listerposts", facade.listerPosts());
			lien = "listerPosts.jsp";	
			
		}else if (op.equals("associerPostCampagne")) {
			String op_associer = request.getParameter("op_associer");
			if (op_associer == null || op_associer.equals("")) {
				request.setAttribute("listePosts", facade.listerPosts());
				request.setAttribute("listeCampagnes", facade.listerCampagnes());
				lien = "associerPostCampagne.jsp";
			}
			
			try {
				int idPost = Integer.parseInt(request.getParameter("idpost"));
				int idCamp = Integer.parseInt(request.getParameter("idcampagne"));
				facade.associerPostCampagne(idPost,idCamp);
				lien = "managerConnect.html";
			}catch(NumberFormatException e) {
				
			}
		}else if (op.equals("ajoutManager")) {
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String login = request.getParameter("login");
			String mdp = request.getParameter("mot_de_passe");
			String login_fb = request.getParameter("login_Facebook");
			String mdp_fb = request.getParameter("mot_de_passe_Facebook");

            facade.ajouterManager(nom,prenom,login,mdp,login_fb,mdp_fb);
            //facade.supprimerRoot();
            lien = "ajoutManager.html";
			
		}else if (op.equals("associerManagerGroupe")) {
			String op_associer = request.getParameter("op_associer");
			if (op_associer == null || op_associer.equals("")) {
				request.setAttribute("listeManagers", facade.listerManagers());
				request.setAttribute("listeGroupes", facade.listerGroupes());
				lien = "associerManagerGroupe.jsp";
			}
			
			try {
				int idm = Integer.parseInt(request.getParameter("idmanager"));
				int idg = Integer.parseInt(request.getParameter("idgroupe"));
				facade.associerManagerGroupe(idm,idg);
				lien = "managerConnect.html";
			}catch(NumberFormatException e) {
				
			}
		}else if (op.equals("register")) {
			
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String login = request.getParameter("login");
			String mdp = request.getParameter("mot_de_passe");
			
			facade.ajouterUtilisateur(nom,prenom,login,mdp);
			lien = "connectionUser.jsp";
		
			
		}else if (op.equals("deconnecter")) {
				t = "";
				lien = "index.html";
			
		}else if (op.contentEquals("relevecampagne")) {
			String op_releve = request.getParameter("op_releve");
			request.setAttribute("t", t);
			lien = "releveCampagne.jsp";
			if (op_releve == null || op_releve.equals("")) {
				request.setAttribute("listercampagnes", facade.listerCampagnes());
			}
			try {
				int idcampagne = Integer.parseInt(request.getParameter("idcampagne"));
				request.setAttribute("campagne", facade.getCampagneById(idcampagne));
				request.setAttribute("nl",facade.getNombreLikes(idcampagne));
				request.setAttribute("nc",facade.getNombreComments(idcampagne));
				request.setAttribute("ns",facade.getNombreShares(idcampagne));
			}catch(NumberFormatException e) {
				
			}
		}else if (op.equals("ajoutReleve")) {
			String url = request.getParameter("url_post");
			String date = request.getParameter("date_releve");
			int nbl = Integer.parseInt(request.getParameter("nb_likes"));
			int nbc = Integer.parseInt(request.getParameter("nb_comments"));
			int nbs = Integer.parseInt(request.getParameter("nb_shares"));
			Post p = facade.getPostByUrl(url);
			lien = "ajoutReleve.jsp";
			if (p == null) {
				String message = "Url du Post incorrect";
				request.setAttribute("message", message);
			}else {
				facade.ajouterReleve(date,nbl,nbc,nbs,p);
			}
			
		}
		request.getRequestDispatcher(lien).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
