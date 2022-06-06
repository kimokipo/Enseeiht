package pack;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Serv
 */
@WebServlet("/Serv")
public class Serv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	Facade facade;
    /**
     * Default constructor. 
     */
    public Serv() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String op = request.getParameter("op");
		if (op.equals("ajoutpersonne")) {
					String nom = request.getParameter("nom");
					String prenom = request.getParameter("prenom");
					facade.ajoutPersonne(nom,prenom);
					request.getRequestDispatcher("ajoutpersonne.html").forward(request, response);
		}
		
		else if (op.equals("ajoutadresse")) {
			String rue = request.getParameter("rue");
			String ville = request.getParameter("ville");
			facade.ajoutAdresse(rue,ville);
			request.getRequestDispatcher("ajoutadresse.html").forward(request, response);
			
		}
		
		else if (op.equals("associer")) {
			request.setAttribute("listePersonnes", facade.getPersonnes());
			request.setAttribute("listeAdresses", facade.getAdresses());
			request.getRequestDispatcher("associer.jsp").forward(request, response);
			
			int idPer = Integer.parseInt(request.getParameter("idPer"));
			int idAdr = Integer.parseInt(request.getParameter("idAdr"));
			facade.associer(idPer,idAdr);
			request.getRequestDispatcher("index.html");
			
		}

		else if (op.equals("lister")) {
			request.setAttribute("listeTout", facade.listeTout());
			request.getRequestDispatcher("lister.jsp").forward(request, response);
			
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
