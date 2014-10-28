package fr.jee.validate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;






import fr.jee.model.jpa.EventsEntity;
import fr.jee.model.jpa.UsersEntity;
import fr.jee.persistence.services.jpa.UsersPersistenceJPA;



public class validateEvent {

	public EventsEntity validationEvenement(String nom ,String adresse,String hdebut ,String hfin,String ddebut,String dfin,int id){
		if(nom.length() < 3 || adresse.length() < 3 )
			return null;
			
		EventsEntity event = new EventsEntity();
		event.setNom(nom);
		event.setAdresse(adresse);
		
		UsersEntity user = new UsersPersistenceJPA().load(id);
		if(user==null)
			return null;
		event.setUsers(user);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat heureFormat = new SimpleDateFormat("hh:mm");
		
		Date dd , df , hd ,hf;
		try {
			dd = dateFormat.parse(ddebut);
			df = dateFormat.parse(dfin);
			hd = heureFormat.parse(hdebut);
			hf = heureFormat.parse(hfin);
		} catch (ParseException e) {return null;}
		
		if(dd.after(df))
			return null;
		if(dd.equals(df) && hd.after(hf))
			return null;
		
		event.setDatedebut(dd);
		event.setDatefin(df);
		event.setHeuredebut(hd);
		event.setHeurefin(hf);
		// Non publier
		event.setActif(0);
		
		return event;
	}
}
	

