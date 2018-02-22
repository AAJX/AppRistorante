package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.GestorePrenotazioni;
import model.Prenotazione;
import model.Ristorante;
import model.Utente;

/**
 * Servlet implementation class EliminaPrenotazione_Servlet
 */
@WebServlet("/EliminaPrenotazione")
public class EliminaPrenotazione_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminaPrenotazione_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ObjectMapper om = new ObjectMapper();
		
		Utente utente = om.readValue(request.getParameter("utente"), Utente.class);
		Ristorante r = om.readValue(request.getParameter("r"), Ristorante.class);
		Prenotazione prenotazione = om.readValue(request.getParameter("prenotazione"), Prenotazione.class);
		
		GestorePrenotazioni gp = new GestorePrenotazioni();
		
		Boolean eliminata = gp.eliminaPrenotazione(utente, prenotazione, r);
		
		response.getWriter().append(eliminata.toString());
	}

}
