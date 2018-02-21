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
 * Servlet implementation class EliminaAccountServlet
 */
@WebServlet("/eliminaAccount")
public class EliminaAccount_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminaAccount_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ObjectMapper om = new ObjectMapper();

		Utente utente = om.readValue(request.getParameter("utente"), Utente.class);
		
		GestoreNuovoUtente gnu = new GestoreNuovoUtente();

		Boolean eliminato = gnu.eliminaUtente(utente);
		response.getWriter().append(eliminato.toString());
	}

}
