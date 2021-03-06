package appristoranti.web;


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
 * Servlet implementation class EliminaPrenotazioneServlet
 */
@WebServlet("/EliminaPrenotazioneServlet")
public class EliminaPrenotazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminaPrenotazioneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
ObjectMapper om = new ObjectMapper();
		
		Utente utente = om.readValue("Utente", Utente.class);
		Ristorante r = om.readValue("Ristorante", Ristorante.class);
		Prenotazione prenotazione = om.readValue("Prenotazione", Prenotazione.class);
		
		GestorePrenotazioni gp = new GestorePrenotazioni();
		
		Boolean eliminato = gp.eliminaPrenotazione(utente, prenotazione, r);
		
		response.getWriter().append(eliminato.toString());
		doGet(request, response);
	}

}
