package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.GestoreNuovoUtente;
import business.GestorePrenotazioni;
import model.Prenotazione;
import model.Ristorante;
import model.Utente;

/**
 * Servlet implementation class ModificaEmail_Servlet
 */
@WebServlet("/modificaAccount")
public class ModificaAccount_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaAccount_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
ObjectMapper om = new ObjectMapper();
		
		Utente utente = om.readValue(request.getParameter("utente"), Utente.class);
		
		
		GestoreNuovoUtente gnu = new GestoreNuovoUtente();
		
		Boolean modificata = gnu.modificaUtente(utente);
		response.getWriter().append(modificata.toString());
	}

}
