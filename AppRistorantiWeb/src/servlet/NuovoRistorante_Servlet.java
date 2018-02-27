package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.GestoreRistoranti;
import model.Citta;
import model.Regione;
import model.Ristorante;

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

		
		int idRegione = Integer.parseInt(request.getParameter("regione"));
		int idCitta = Integer.parseInt(request.getParameter("citta"));
		int idRistorante = Integer.parseInt(request.getParameter("idRistorante"));
		String categoria = request.getParameter("categoria");
		String indirizzo = request.getParameter("indirizzo");
		String nome = request.getParameter("nome");
		int numeroPosti = Integer.parseInt(request.getParameter("numeroPosti"));
		float prezzoMenu = Float.parseFloat(request.getParameter("prezzoMenu"));
		String telefonoRistorante = request.getParameter("telefonoRistorante");
		
		GestoreRistoranti gr = new GestoreRistoranti();

		Boolean registrato = gr.aggiungiRistorante(idRegione, idCitta, idRistorante, categoria, indirizzo, nome, numeroPosti, prezzoMenu, telefonoRistorante);
		response.getWriter().append(registrato.toString());
	}

}
