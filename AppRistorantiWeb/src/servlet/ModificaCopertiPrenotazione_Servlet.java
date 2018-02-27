package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.GestorePrenotazioni;

/**
 * Servlet implementation class ModificaCopertiPrenotazione_Servlet
 */
@WebServlet("/modificaCopertiPrenotazione")
public class ModificaCopertiPrenotazione_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaCopertiPrenotazione_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idPrenotazione  = Integer.parseInt(request.getParameter("idPrenotazione"));
		String email = request.getParameter("email");
		int idRistorante = Integer.parseInt(request.getParameter("ristorante"));
		int numeroPrenotati = Integer.parseInt(request.getParameter("coperti"));
		
		GestorePrenotazioni gp = new GestorePrenotazioni();
		
		Boolean modificata = gp.modificaCopertiPrenotazione(email, idRistorante, idPrenotazione, numeroPrenotati);
		
		response.getWriter().append(modificata.toString());
	}

}
