package servlet;

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
 * Servlet implementation class EliminaPrenotazione_Servlet
 */
@WebServlet("/EliminaPrenotazione")
public class EliminaPrenotazione_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminaPrenotazione_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//ObjectMapper om = new ObjectMapper();
		
		String email = request.getParameter("email");
		//Ristorante ristorante = om.readValue(request.getParameter("r"), Ristorante.class);
		int idPrenotazione  = Integer.parseInt(request.getParameter("idPrenotazione"));
		
		GestorePrenotazioni gp = new GestorePrenotazioni();
		
		Boolean eliminata = gp.eliminaPrenotazione(email, idPrenotazione/*, ristorante*/);
		
		response.getWriter().append(eliminata.toString());
	}

}
