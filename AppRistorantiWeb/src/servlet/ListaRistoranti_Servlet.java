package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.GestoreListaRistoranti;
import model.Ristorante;

/**
 * Servlet implementation class ListaRistoranti_Servlet
 */
@WebServlet("/listaRistoranti")
public class ListaRistoranti_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaRistoranti_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestoreListaRistoranti glr = new GestoreListaRistoranti();
		ObjectMapper m = new ObjectMapper();
		response.setContentType("application/json");
		String citta = request.getParameter("citta");
		if (citta == null) {
			response.getWriter().append(m.writeValueAsString(glr.tuttiRistoranti()));
		} else {
			int idCitta = Integer.parseInt(citta);
			response.getWriter().append(m.writeValueAsString(glr.ristorantiCitta(idCitta )));
		}
		
	}
	
	}


