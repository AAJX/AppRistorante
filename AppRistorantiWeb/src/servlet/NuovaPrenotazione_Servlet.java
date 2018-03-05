package servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * Servlet implementation class NuovaPrenotazione_Servlet
 */
@WebServlet("/nuovaPrenotazione")
public class NuovaPrenotazione_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	GestorePrenotazioni gp = new GestorePrenotazioni();
	
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
		
		
		
		String email = request.getParameter("email");
		int idRistorante = Integer.parseInt(request.getParameter("ristorante"));
		
	//	int idPrenotazione = Integer.parseInt(request.getParameter("id"));
		String orario = request.getParameter("orario");
		int numeroPrenotati = Integer.parseInt(request.getParameter("numeroPrenotati"));
		String data = request.getParameter("data");
		DateFormat df = new SimpleDateFormat ("yyyy-MM-dd");
		Date dataPrenotazione = new Date();
		try {
			dataPrenotazione = df.parse(data);
			
		}catch ( ParseException e) {
			e.printStackTrace();
		}
		
		
		
		Boolean andataBuonFine = gp.nuovaPrenotazione(email, idRistorante, /*idPrenotazione,*/ orario, numeroPrenotati, dataPrenotazione);
		
		response.getWriter().append(andataBuonFine.toString());
	}

}
