package fr.jee.models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.hibernate.Hibernate;

import fr.jee.model.jpa.EventsEntity;
import fr.jee.model.jpa.JpaRequeteur;
import fr.jee.model.jpa.ParticipantsEntity;
import fr.jee.persistence.commons.jpa.JpaOperation;

public class ListParticipantsReq {
	public List<ParticipantsEntity> execute(final String id) {
		
		return new JpaRequeteur<List<ParticipantsEntity>>().executer(
				
						new JpaOperation() {
							
							public Object exectue(EntityManager em) throws PersistenceException {
								EventsEntity event = em.find(EventsEntity.class,Integer.parseInt(id));
								List<ParticipantsEntity> participants = event.getListOfParticipants();
								Hibernate.initialize(participants);
								return participants;
							}
				}
			);
	}
}

