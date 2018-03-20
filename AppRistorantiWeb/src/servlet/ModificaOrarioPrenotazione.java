package servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.GestorePrenotazioni;

/**
 * Servlet implementation class ModificaOrarioPrenotazione
 */
@WebServlet(name = "ModificaOrarioPrenotazione_Servlet", urlPatterns = { "/modificaOrarioPrenotazione" })
public class ModificaOrarioPrenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaOrarioPrenotazione() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
		try {
			String email = request.getParameter("email");
			int idPrenotazione  = Integer.parseInt(request.getParameter("idPrenotazione"));
			
			String orario = request.getParameter("orario");
			
			GestorePrenotazioni gp = new GestorePrenotazioni();
			
			Boolean modificata = gp.modificaOraPrenotazione(email, idPrenotazione, orario);
			
			response.getWriter().append(modificata.toString());
		}catch(Exception ioe) {
			System.out.println(ioe.getMessage());
		}
		
	}

}
