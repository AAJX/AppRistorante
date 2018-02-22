package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.GestoreRistoranti;
import model.Ristorante;

/**
 * Servlet implementation class EliminaRistorante_Servlet
 */
@WebServlet("/eliminaRistorante")
public class EliminaRistorante_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminaRistorante_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ObjectMapper om = new ObjectMapper();
		
		Ristorante r = om.readValue(request.getParameter("r"), Ristorante.class);
		GestoreRistoranti gr = new GestoreRistoranti();
		
		Boolean eliminata = gr.eliminaRistorante(r);
		
		response.getWriter().append(eliminata.toString());
	}

}