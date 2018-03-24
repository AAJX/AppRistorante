package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.GestoreListaRistoranti;

/**
 * Servlet implementation class ListaRistorantiPerNome
 */
@WebServlet("/ListaRistorantiPerNome")
public class ListaRistorantiPerNome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaRistorantiPerNome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			GestoreListaRistoranti glr = new GestoreListaRistoranti();
			ObjectMapper m = new ObjectMapper();
			response.setContentType("application/json");
			String nome = request.getParameter("citta");
				response.getWriter().append(m.writeValueAsString(glr.ristorantiNome(nome)));
		
			}catch(Exception ioe) {
				ioe.printStackTrace();
			
			}

	}
}
