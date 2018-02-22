package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.GestoreRistoranti;
import model1.Citta;
import model1.Regione;
import model1.Ristorante;

/**
 * Servlet implementation class NuovoRistorante_Servlet
 */
@WebServlet("/nuovoRistorante")
public class NuovoRistorante_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuovoRistorante_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ObjectMapper om = new ObjectMapper();

		
		Regione regione = om.readValue(request.getParameter("regione"), Regione.class);
		Citta citta = om.readValue(request.getParameter("citta"), Citta.class);
		Ristorante ristorante = om.readValue(request.getParameter("r"), Ristorante.class);
		
		GestoreRistoranti gr = new GestoreRistoranti();

		Boolean registrato = gr.aggiungiRistorante(regione, citta, ristorante);
		response.getWriter().append(registrato.toString());
	}

}
