package fr.jee.event;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.jee.model.jpa.EventsEntity;
import fr.jee.persistence.services.jpa.EventsPersistenceJPA;
import fr.jee.validate.ValidateEvent;


/**
 * Servlet implementation class Event
 */
public class NewEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String CHAMP_NOM = "eventname";
	public static final String CHAMP_ADRESSE = "adresse";
	public static final String CHAMP_HDEBUT = "hdebut";
	public static final String CHAMP_HFIN = "hfin";
	public static final String CHAMP_DDEBUT = "ddebut";
	public static final String CHAMP_DFIN = "dfin";
	
	
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
		//Recup�ration des param�tres
		String nom = request.getParameter(CHAMP_NOM);
		String adresse = request.getParameter(CHAMP_ADRESSE);
		String hdebut = request.getParameter(CHAMP_HDEBUT);
		String hfin = request.getParameter(CHAMP_HFIN);
		String ddebut = request.getParameter(CHAMP_DDEBUT);
		String dfin = request.getParameter(CHAMP_DFIN);
		HttpSession session = request.getSession();
		ValidateEvent v = new ValidateEvent();
		int id;
		EventsPersistenceJPA jpaEvent = new EventsPersistenceJPA();
		EventsEntity event = new EventsEntity();
		
		// On r�cup�re le useur gr�ce � l'id dans la session
		id = (int) session.getAttribute("userID");
		event=v.validationEvenement(nom, adresse, hdebut, hfin, ddebut, dfin,id);
		
		//Si il y a une erreur
		if(event!= null){
			jpaEvent.insert(event);
			response.sendRedirect(request.getContextPath()+"/auth/ListEvent");
		}
		else{
			response.sendRedirect(request.getContextPath()+"/auth/NewEvent?erreur=true");
		}
		
	}

}
