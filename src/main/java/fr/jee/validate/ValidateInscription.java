package fr.jee.validate;

import java.util.List;

import fr.jee.model.jpa.EventsEntity;
import fr.jee.model.jpa.ParticipantsEntity;
import fr.jee.model.jpa.UsersEntity;
import fr.jee.persistence.services.jpa.EventsPersistenceJPA;
import fr.jee.persistence.services.jpa.ParticipantsPersistenceJPA;
import fr.jee.persistence.services.jpa.UsersPersistenceJPA;

public class ValidateInscription {

	public ParticipantsEntity validationInscription(String email,String nom,String prenom,String societe,int idEvent){
		ParticipantsEntity participant = new ParticipantsEntity();
		EventsEntity event = new EventsPersistenceJPA().load(idEvent);
		
		if(event == null)
			return null;
		participant.setIdevent(idEvent);
		
		if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) )
			return null;
		
		ParticipantsPersistenceJPA participantJpa = new ParticipantsPersistenceJPA();
		List<ParticipantsEntity> results = participantJpa.loadAll();
		for(ParticipantsEntity entity : results){
			if(email.equals(entity.getMail())){
				return null;
			}
		}		
		
		participant.setMail(email);
		
		if(nom.length() < 3 || prenom.length() < 3 || societe.length() < 3)
			return null;
		participant.setNom(nom);
		participant.setPrenom(prenom);
		participant.setSociete(societe);
		
		return participant;
	}
}
