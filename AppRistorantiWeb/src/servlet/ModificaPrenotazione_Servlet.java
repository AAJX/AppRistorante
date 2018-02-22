package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.GestorePrenotazioni;
import model1.Prenotazione;
import model1.Ristorante;
import model1.Utente;

/**
 * Servlet implementation class ModificaPrenotazione_Servlet
 */
@WebServlet("/modificaPrenotazione")
public class ModificaPrenotazione_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaPrenotazione_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ObjectMapper om = new ObjectMapper();
		
		Utente utente = om.readValue(request.getParameter("utente"), Utente.class);
		Ristorante ristorante = om.readValue(request.getParameter("r"), Ristorante.class);
		Prenotazione prenotazione = om.readValue(request.getParameter("prenotazione"), Prenotazione.class);
		
		GestorePrenotazioni gp = new GestorePrenotazioni();
		
		Boolean modificata = gp.modificaPrenotazione(utente, ristorante, prenotazione);
		
		response.getWriter().append(modificata.toString());
	}

}
