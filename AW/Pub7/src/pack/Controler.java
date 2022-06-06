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
		if( op.equals("listerCampagnes")){
			
			request.setAttribute("listerCampagnes", facade.listerCampagnes());
			request.getRequestDispatcher("listerCampagnes.jsp").forward(request, response);	
			
		}else if(op.equals("ajoutCompagne")){
			
			String nom = request.getParameter("nom");
			String date_debut = request.getParameter("date_debut");
			String date_fin = request.getParameter("date_fin");
			String contexte = request.getParameter("contexte");
			String objectif = request.getParameter("objectifs");
			
            facade.ajouterCampagne(nom,date_debut,date_fin,objectif,contexte);
            request.getRequestDispatcher("ajoutCampagne.html");
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
