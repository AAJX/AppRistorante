package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.GestoreNuovoUtente;
import model.Utente;

/**
 * Servlet implementation class ProvaNuovoAccount
 */
@WebServlet("/ProvaNuovoAccount")
public class ProvaNuovoAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private GestoreNuovoUtente gnu = new GestoreNuovoUtente();
       
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProvaNuovoAccount() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ObjectMapper om = new ObjectMapper(); 
		Utente utente = om.readValue(request.getParameter("utente"), Utente.class);
		
		
		Boolean registrato = gnu.nuovoUtente(utente);
		response.getWriter().append(registrato.toString());
	}
	

			
}
