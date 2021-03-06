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
 * Servlet implementation class NuovaPrenotazioneServlet
 */
@WebServlet("/NuovaPrenotazioneServlet")
public class NuovaPrenotazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuovaPrenotazioneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		
		Utente utente = om.readValue(request.getParameter("utente"), Utente.class);
		Ristorante r = om.readValue(request.getParameter("r"), Ristorante.class);
		Prenotazione prenotazione = om.readValue(request.getParameter("prenotazione"), Prenotazione.class);
		
		GestorePrenotazioni gp = new GestorePrenotazioni();
		
		Boolean andataBuonFine = gp.nuovaPrenotazione(utente, prenotazione, r);
		
		response.getWriter().append(andataBuonFine.toString());
		
		
		
	}

}
