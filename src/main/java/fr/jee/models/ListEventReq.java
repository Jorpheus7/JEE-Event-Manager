package fr.jee.models;

import java.util.List;







import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.hibernate.Hibernate;

import fr.jee.model.jpa.EventsEntity;
import fr.jee.model.jpa.JpaRequeteur;
import fr.jee.model.jpa.UsersEntity;
import fr.jee.persistence.commons.jpa.JpaOperation;


public class ListEventReq {

	
	public List<EventsEntity> execute(final int id) {
		return new JpaRequeteur<List<EventsEntity>>().executer(
				new JpaOperation() {
					
					@Override
					public Object exectue(EntityManager em) throws PersistenceException {
						UsersEntity user=em.find(UsersEntity.class, id);
						List<EventsEntity> events= user.getListOfEvents();
						Hibernate.initialize(events);
						return events;
					}
				}
			);	
	}
}
