package fr.jee.event;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.jee.model.jpa.EventsEntity;
import fr.jee.model.jpa.ParticipantsEntity;
import fr.jee.persistence.services.jpa.EventsPersistenceJPA;
import fr.jee.persistence.services.jpa.ParticipantsPersistenceJPA;
import fr.jee.validate.validateInscription;



/**
 * Servlet implementation class InscriptionEvent
 */
public class InscriptionEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String CHAMP_EMAIL = "email";
	public static final String CHAMP_NOM = "nom";
	public static final String CHAMP_PRENOM= "prenom";
	public static final String CHAMP_SOCIETE = "societe";
	public static final String CHAMP_IDEVENT = "idEvent";

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionEvent() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		if (id!=null){
			int idE = Integer.parseInt(id);
			EventsEntity event = new EventsPersistenceJPA().load(idE);
			
			if(event.getActif()==0)
				response.sendRedirect("PageErreur.html");	
			else{
				request.setAttribute("event", event);
				process(request, response);
			}
		
		}	
		else	
			response.sendRedirect("PageErreur.html");
		
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recupération 
		String nom = request.getParameter(CHAMP_NOM);
		String prenom = request.getParameter(CHAMP_PRENOM);
		String email = request.getParameter(CHAMP_EMAIL);
		String societe = request.getParameter(CHAMP_SOCIETE);
		int idEvent =Integer.parseInt(request.getParameter(CHAMP_IDEVENT));
		ParticipantsPersistenceJPA jpa = new ParticipantsPersistenceJPA();
		ParticipantsEntity participant = new ParticipantsEntity();
		validateInscription v          = new validateInscription();
		participant = v.validationInscription(email, nom, prenom, societe, idEvent);
		
		if (participant!=null){
			jpa.insert(participant);
			response.sendRedirect("auth/InscriptionEvent?id="+idEvent+"&erreur=false");
		}
		else{
			response.sendRedirect("auth/InscriptionEvent?id="+idEvent+"&erreur=true");
		}
		
	}
	
	private void process(HttpServletRequest request,HttpServletResponse response)  throws ServletException, IOException{
	

		
		getServletContext().getRequestDispatcher("/jsp/inscriptionEvent.jsp").forward(request, response);
		
	}

}
