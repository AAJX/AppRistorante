package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.EsitoOperazioni;
import business.GestoreAccount;



/**
 * Servlet implementation class EliminaAccountServlet
 */
@WebServlet("/eliminaAccount")
public class EliminaAccount_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private	GestoreAccount ga = new GestoreAccount();

    /**
     * @see HttpServlet#HttpServlet()
     * 
     * 
     */
    public EliminaAccount_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password= request.getParameter("password");
		
		
		
		Boolean eo =  ga.rimuoviUtente(email, password);
		response.getWriter().append(eo.toString());
	}

}
