/*
 * Created on 19 oct. 2014 ( Date ISO 2014-10-19 - Time 18:46:08 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package fr.jee.persistence.commons.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

/**
 * JPA operation interface
 * Provided by Telosys Tools for JPA testing
 *
 */
public interface JpaOperation {

	/**
	 * Executes a JPA operation using the given EntityManager
	 * @param em the EntityManager to be used
	 * @return
	 * @throws PersistenceException
	 */
	public Object exectue(EntityManager em) throws PersistenceException;
	
}
