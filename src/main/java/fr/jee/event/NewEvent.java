package fr.jee.event;

import java.io.IOException;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.jee.model.jpa.EventsEntity;
import fr.jee.model.jpa.UsersEntity;
import fr.jee.persistence.services.jpa.EventsPersistenceJPA;
import fr.jee.persistence.services.jpa.UsersPersistenceJPA;
import fr.jee.validate.validateEvent;


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
	private Map<String, String> erreurs      = new HashMap<String, String>();
	
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
		//Recupération des paramètres
		String nom = request.getParameter(CHAMP_NOM);
		String adresse = request.getParameter(CHAMP_ADRESSE);
		String hdebut = request.getParameter(CHAMP_HDEBUT);
		String hfin = request.getParameter(CHAMP_HFIN);
		String ddebut = request.getParameter(CHAMP_DDEBUT);
		String dfin = request.getParameter(CHAMP_DFIN);
		
		//Création des dates
		validateEvent v = new validateEvent();
		Boolean valide = true;
		Date dd , df ,hd , hf = new Date();
		dd = df = hd = hf = null;
		
		
		HttpSession session = request.getSession(false);
		int id;
		UsersEntity user = new UsersEntity();
		UsersPersistenceJPA jpaUser = new UsersPersistenceJPA();
		EventsPersistenceJPA jpaEvent = new EventsPersistenceJPA();
		EventsEntity event = new EventsEntity();
		
		//Formats des dates
		SimpleDateFormat spDate = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat spHeure = new SimpleDateFormat("HH:mm");
		
		// On récupère le useur grâce à l'id dans la session
		//id = (int) session.getAttribute("id");
		//user = jpaUser.load(id);
		//event.setUsers(user);
		
		//Evénement non visible
		event.setActif(0);
		
		//Test sur le nom
		try {
			v.validationNom(nom);
		}
		 catch ( Exception e ) {
			 erreurs.put(CHAMP_NOM, e.getMessage());
			 valide=false;
		 }
		event.setNom(nom);
		
		//Test sur l'adresse
		try {
			v.validationAdresse(adresse);
		}
		 catch ( Exception e ) {
			 erreurs.put(CHAMP_ADRESSE, e.getMessage());
			 valide=false;
		 }
		event.setAdresse(adresse);
		
		
		// parse des dates
		try {
			dd=spDate.parse(ddebut);
			df=spDate.parse(dfin);
			hd=spHeure.parse(hdebut);
			hf=spHeure.parse(hfin);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		try {
			v.validationDate(ddebut,dfin,dd,df);
			
		}
		
		//test sur les dates
		 catch ( Exception e ) {
			 erreurs.put(CHAMP_DDEBUT, e.getMessage());
			 erreurs.put(CHAMP_DFIN, e.getMessage());
			 valide=false;
		 }
		event.setDatedebut(dd );
		event.setDatefin(df);
		
		//test sur les heures
		try {
			v.validationHeure(hdebut,hfin,hd,hf);
			
		}
		 catch ( Exception e ) {
			 erreurs.put(CHAMP_HDEBUT, e.getMessage());
			 erreurs.put(CHAMP_HFIN, e.getMessage());
			 valide=false;
		 }
		event.setHeurefin(hf);
		event.setHeuredebut(hf);
		
		//On Insert dans la base si tout les tests sont valides
		if(valide){
			jpaEvent.insert(event);
		}
		
		process(request, response);
		
	}

}
