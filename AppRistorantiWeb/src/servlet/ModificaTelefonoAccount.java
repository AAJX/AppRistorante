package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.GestoreAccount;

/**
 * Servlet implementation class ModificaTelefonoAccount
 */
@WebServlet("/ModificaTelefonoAccount")
public class ModificaTelefonoAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private GestoreAccount ga = new GestoreAccount();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaTelefonoAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String email= request.getParameter("email");
		String numeroTelefono = request.getParameter("telefono");
		

		
		Boolean modificata = ga.modificaTelefonoUtente(email, numeroTelefono );
		response.getWriter().append(modificata.toString());
	}
	
	

}
