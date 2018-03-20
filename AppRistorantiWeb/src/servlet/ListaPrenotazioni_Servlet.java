package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.GestoreListaPrenotazioni;
import business.GestoreListaRistoranti;
import model.Utente;


/**
 * Servlet implementation class ListaPrenotazioni_Servlet
 */
@WebServlet("/listaPrenotazioni")
public class ListaPrenotazioni_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaPrenotazioni_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
		try {
		GestoreListaPrenotazioni glp = new GestoreListaPrenotazioni();
		ObjectMapper m = new ObjectMapper();
		response.setContentType("application/json");
		String email = request.getParameter("email");
		if (email != null) {
			
			response.getWriter().append(m.writeValueAsString(glp.prenotazioniUtente(email)));
		}
		}catch(Exception ioe) {
			ioe.printStackTrace();
		
		}	
		
	}

}
