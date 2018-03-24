package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.JPAUtility;
import model.Citta;

/**
 * Servlet implementation class ListaCittà
 */
@WebServlet("/ListaCitta")
public class ListaCittà extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaCittà() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Citta> citta =JPAUtility.getInstance().getEm().createQuery("select c from Citta c",Citta.class).getResultList();
		ObjectMapper om= new ObjectMapper();
		String json = om.writeValueAsString(citta);
		response.setContentType("application/json");
		
		
		response.getWriter().append(json);
	}


}
