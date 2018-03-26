package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.GestoreAccount;
import business.GestoreListaRistoranti;

/**
 * Servlet implementation class chiamaUtente
 */
@WebServlet("/chiamaUtente")
public class chiamaUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chiamaUtente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			GestoreAccount ga = new GestoreAccount();
			ObjectMapper m = new ObjectMapper();
			response.setContentType("application/json");
			String email = request.getParameter("email");
			

				
				response.getWriter().append(m.writeValueAsString(ga.chiamaUtente(email)));
			
			}catch(Exception ioe) {
				ioe.printStackTrace();
			
			}
	}

}
