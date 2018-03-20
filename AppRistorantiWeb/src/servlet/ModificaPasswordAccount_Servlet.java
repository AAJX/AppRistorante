package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.GestoreAccount;



/**
 * Servlet implementation class ModificaEmail_Servlet
 */
@WebServlet("/modificaPasswordAccount")
public class ModificaPasswordAccount_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
      private GestoreAccount ga = new GestoreAccount();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaPasswordAccount_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		
		Boolean modificata = ga.modificaPasswordUtente(email, password);
		response.getWriter().append(modificata.toString());
	}

}
