package servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.GestorePrenotazioni;

/**
 * Servlet implementation class ModificaDataPrenotazione_Servlet
 */
@WebServlet("/modificaDataPrenotazione")
public class ModificaDataPrenotazione_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaDataPrenotazione_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idPrenotazione  = Integer.parseInt(request.getParameter("idPrenotazione"));
		String email = request.getParameter("email");
		int idRistorante = Integer.parseInt(request.getParameter("ristorante"));
		String data = request.getParameter("data");
		DateFormat df = new SimpleDateFormat ("yyyy-MM-dd");
		Date dataPrenotazione = new Date();
		try {
			dataPrenotazione = df.parse(data);
			
		}catch ( ParseException e) {
			e.printStackTrace();
		}
		GestorePrenotazioni gp = new GestorePrenotazioni();
		
		Boolean modificata = gp.modificaDataPrenotazione(email, idRistorante, idPrenotazione, dataPrenotazione);
		
		response.getWriter().append(modificata.toString());
	}

}
