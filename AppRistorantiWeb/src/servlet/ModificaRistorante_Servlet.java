package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.GestoreRistoranti;
import business.JPAUtility;
import model.Citta;
import model.Ristorante;

/**
 * Servlet implementation class ModificaRistorante_Servlet
 */
@WebServlet("/modificaRistorante")
public class ModificaRistorante_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaRistorante_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ObjectMapper om = new ObjectMapper();
		Citta citta = om.readValue(request.getParameter("citta"), Citta.class);
		citta = JPAUtility.getInstance().getEm().find(Citta.class, citta.getIdCitta());
		
		Ristorante ristorante = om.readValue(request.getParameter("r"), Ristorante.class);
		ristorante.setCitta(citta);
		
		GestoreRistoranti gr = new GestoreRistoranti();
		
		Boolean modifica = gr.modificaRistorante(ristorante);
		
		response.getWriter().append(modifica.toString());
	}

}
