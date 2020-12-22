package co.simplon.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.simplon.dao.*;
import co.simplon.model.Pays;

/**
 * Servlet implementation class Helloworld
 */
@WebServlet(urlPatterns = "/Helloworld", loadOnStartup = 1)
public class Helloworld extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PaysDAO paysDao;

	public void init() throws ServletException {
		DAOContext.init(getServletContext());
		DAOContext daoContext = new DAOContext();

		this.paysDao = daoContext.getPaysDao();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Helloworld() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Utilise la fonction lister pour afficher la liste de ma table pays dans ma jsp (acceuil.jsp)
		request.setAttribute("Lpays", paysDao.lister());
		this.getServletContext().getRequestDispatcher("/WEB-INF/acceuil.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String nomp = request.getParameter("nomP");
		

		// Vérification des bouton saisie et utilise la fonction désiré
		if (request.getParameter("add") != null || request.getParameter("add1") != null) {

			if (nomp != null && nomp != "") {

				Pays pays = new Pays();
				pays.setNom(nomp);
				paysDao.ajouter(pays);

			}

			request.setAttribute("Lpays", paysDao.lister());
			this.getServletContext().getRequestDispatcher("/WEB-INF/addpays.jsp").forward(request, response);

		} else if (request.getParameter("modi") != null || request.getParameter("modi1") != null) {

			String num = request.getParameter("idP");
			String nomp1 = request.getParameter("modiP");
			if (num != null && num != "" && nomp1 != null && nomp1 != "") {

				Pays pays = new Pays();
				pays.setId(Integer.parseInt(num));
				pays.setNom(nomp1);
				paysDao.modifier(pays);

			}
			request.setAttribute("Lpays", paysDao.lister());
			this.getServletContext().getRequestDispatcher("/WEB-INF/modifierP.jsp").forward(request, response);

				} else if (request.getParameter("delete") != null || request.getParameter("delete1") != null) {

					String num = request.getParameter("idP");
					String nomp2 = request.getParameter("del");
			if (num != null && num != "") {

				Pays pays = new Pays();
				pays.setId(Integer.parseInt(num));
				pays.setNom(nomp2);

				paysDao.effacer(pays);

			}
			request.setAttribute("Lpays", paysDao.lister());
			this.getServletContext().getRequestDispatcher("/WEB-INF/deleteP.jsp").forward(request, response);

		} else if (request.getParameter("menu") != null || request.getParameter("menu2") != null || request.getParameter("menu3") != null) {

			request.setAttribute("Lpays", paysDao.lister());
		this.getServletContext().getRequestDispatcher("/WEB-INF/acceuil.jsp").forward(request, response);

	}
	}
}
