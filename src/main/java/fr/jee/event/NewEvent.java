package fr.jee.event;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.jee.model.jpa.EventsEntity;


/**
 * Servlet implementation class Event
 */
public class NewEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String CHAMP_NOM = "eventname";
	public static final String CHAMP_ADRESSE = "adresse";
	public static final String CHAMP_DHDEBUT = "dhdebut";
	public static final String CHAMP_DHFIN = "dhfin";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewEvent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request,HttpServletResponse response)  throws ServletException, IOException{
		getServletContext().getRequestDispatcher("/jsp/event.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter(CHAMP_NOM);
		String adresse = request.getParameter(CHAMP_ADRESSE);
		String dhdebut = request.getParameter(CHAMP_DHDEBUT);
		String dhfin = request.getParameter(CHAMP_DHDEBUT);
		
		EventsEntity event = new EventsEntity();
		event.setNom(nom);
	
		
	}

}
