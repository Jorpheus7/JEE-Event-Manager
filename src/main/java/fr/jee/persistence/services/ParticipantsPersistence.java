/*
 * Created on 27 oct. 2014 ( Time 17:10:26 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package fr.jee.persistence.services;

import java.util.List;
import java.util.Map;

import fr.jee.model.jpa.ParticipantsEntity;

/**
 * Basic persistence operations for entity "Participants"
 * 
 * This Bean has a composite Primary Key : ParticipantsEntityKey
 *
 * @author Telosys Tools Generator
 *
 */
public interface ParticipantsPersistence {

	/**
	 * Deletes the given entity <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param participants
	 * @return true if found and deleted, false if not found
	 */
	public boolean delete(ParticipantsEntity participants) ;

	/**
	 * Deletes the entity by its Primary Key <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param idevent
	 * @param mail
	 * @return true if found and deleted, false if not found
	 */
	public boolean delete(Integer idevent, String mail) ;

	/**
	 * Inserts the given entity and commit <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param participants
	 */
	public void insert(ParticipantsEntity participants) ;

	/**
	 * Loads the entity for the given Primary Key <br>
	 * @param idevent
	 * @param mail
	 * @return the entity loaded (or null if not found)
	 */
	public ParticipantsEntity load(Integer idevent, String mail) ;

	/**
	 * Loads ALL the entities (use with caution)
	 * @return
	 */
	public List<ParticipantsEntity> loadAll() ;

	/**
	 * Loads a list of entities using the given "named query" without parameter 
	 * @param queryName
	 * @return
	 */
	public List<ParticipantsEntity> loadByNamedQuery(String queryName) ;

	/**
	 * Loads a list of entities using the given "named query" with parameters 
	 * @param queryName
	 * @param queryParameters
	 * @return
	 */
	public List<ParticipantsEntity> loadByNamedQuery(String queryName, Map<String, Object> queryParameters) ;

	/**
	 * Saves (create or update) the given entity <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param participants
	 * @return
	 */
	public ParticipantsEntity save(ParticipantsEntity participants) ;

	/**
	 * Search the entities matching the given search criteria
	 * @param criteria
	 * @return
	 */
	public List<ParticipantsEntity> search( Map<String, Object> criteria ) ;

	/**
	 * Count all the occurrences
	 * @return
	 */
	public long countAll();
	
}
