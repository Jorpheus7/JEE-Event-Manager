/*
 * Created on 19 oct. 2014 ( Time 18:44:29 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package fr.jee.persistence.services;

import java.util.List;
import java.util.Map;

import fr.jee.model.jpa.RencontresEntity;

/**
 * Basic persistence operations for entity "Rencontres"
 * 
 * This Bean has a basic Primary Key : Integer
 *
 * @author Telosys Tools Generator
 *
 */
public interface RencontresPersistence {

	/**
	 * Deletes the given entity <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param rencontres
	 * @return true if found and deleted, false if not found
	 */
	public boolean delete(RencontresEntity rencontres) ;

	/**
	 * Deletes the entity by its Primary Key <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param idevent
	 * @return true if found and deleted, false if not found
	 */
	public boolean delete(Integer idevent) ;

	/**
	 * Inserts the given entity and commit <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param rencontres
	 */
	public void insert(RencontresEntity rencontres) ;

	/**
	 * Loads the entity for the given Primary Key <br>
	 * @param idevent
	 * @return the entity loaded (or null if not found)
	 */
	public RencontresEntity load(Integer idevent) ;

	/**
	 * Loads ALL the entities (use with caution)
	 * @return
	 */
	public List<RencontresEntity> loadAll() ;

	/**
	 * Loads a list of entities using the given "named query" without parameter 
	 * @param queryName
	 * @return
	 */
	public List<RencontresEntity> loadByNamedQuery(String queryName) ;

	/**
	 * Loads a list of entities using the given "named query" with parameters 
	 * @param queryName
	 * @param queryParameters
	 * @return
	 */
	public List<RencontresEntity> loadByNamedQuery(String queryName, Map<String, Object> queryParameters) ;

	/**
	 * Saves (create or update) the given entity <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param rencontres
	 * @return
	 */
	public RencontresEntity save(RencontresEntity rencontres) ;

	/**
	 * Search the entities matching the given search criteria
	 * @param criteria
	 * @return
	 */
	public List<RencontresEntity> search( Map<String, Object> criteria ) ;

	/**
	 * Count all the occurrences
	 * @return
	 */
	public long countAll();
	
}