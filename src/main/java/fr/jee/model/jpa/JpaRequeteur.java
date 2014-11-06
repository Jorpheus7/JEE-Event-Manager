package fr.jee.model.jpa;

import javax.persistence.PersistenceException;

import fr.jee.persistence.PersistenceConfig;
import fr.jee.persistence.commons.jpa.JpaEnvironment;
import fr.jee.persistence.commons.jpa.JpaEnvironments;
import fr.jee.persistence.commons.jpa.JpaOperation;


public class JpaRequeteur<A> {
	
	public A executer(JpaOperation req) throws PersistenceException {
		return execute(req, false);
	}
		
	public A execute(JpaOperation req, boolean transactional) throws PersistenceException {
		JpaEnvironment jpaEnvironment = JpaEnvironments.getInstance().getJpaEnvironment(PersistenceConfig.JPA_PERSISTENCE_UNIT_NAME);
		if ( transactional ) {
			return (A)jpaEnvironment.executeWithTransaction(req) ;
		}
		else {
			return (A)jpaEnvironment.executeWithoutTransaction(req) ;	
		}
	}
}
