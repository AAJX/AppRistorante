package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * Servlet implementation class NuovaPrenotazione_Servlet
 */
@WebServlet("/nuovaPrenotazione")
public class NuovaPrenotazione_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuovaPrenotazione_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ObjectMapper om = new ObjectMapper();
		
		Utente utente = om.readValue(request.getParameter("utente"), Utente.class);
		Ristorante ristorante = om.readValue(request.getParameter("r"), Ristorante.class);
		Prenotazione prenotazione = om.readValue(request.getParameter("prenotazione"), Prenotazione.class);
		


		
		GestorePrenotazioni gp = new GestorePrenotazioni();
		
		Boolean andataBuonFine = gp.nuovaPrenotazione(utente, ristorante, prenotazione);
		
		response.getWriter().append(andataBuonFine.toString());
	}

}
