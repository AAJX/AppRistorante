package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.GestoreNuovoUtente;
import business.GestoreRistoranti;
import model1.Citta;
import model1.Regione;
import model1.Ristorante;
import model1.Utente;

/**
 * Servlet implementation class NuovoAccountServlet
 */
@WebServlet("/nuovoAccount")
public class NuovoAccount_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuovoAccount_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ObjectMapper om = new ObjectMapper();

		Utente utente = om.readValue(request.getParameter("utente"), Utente.class);
		
		GestoreNuovoUtente gnu = new GestoreNuovoUtente();

		Boolean registrato = gnu.nuovoUtente(utente);
		response.getWriter().append(registrato.toString());
	}

}
