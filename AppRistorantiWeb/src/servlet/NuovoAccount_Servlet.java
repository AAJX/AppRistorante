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
 * Servlet implementation class NuovoAccountServlet
 */
@WebServlet("/nuovoAccount")
public class NuovoAccount_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private GestoreAccount ga = new GestoreAccount();
       private ObjectMapper om = new ObjectMapper();    
       /**
     * @see HttpServlet#HttpServlet()
     */
    public NuovoAccount_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		String email = request.getParameter("email");
		String nome = request.getParameter("nome");
		String cognome =request.getParameter("cognome");
		String numeroTelefono = request.getParameter("numeroTelefono");
		String password = request.getParameter("password");
		
		EsitoOperazioni eo = ga.registraUtente(email, cognome, nome, numeroTelefono, password);
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.append(om.writeValueAsString(eo));
		
		
	}

}
