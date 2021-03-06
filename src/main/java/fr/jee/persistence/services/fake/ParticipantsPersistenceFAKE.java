/*
 * Created on 27 oct. 2014 ( Time 17:10:26 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package fr.jee.persistence.services.fake;

import java.util.List;
import java.util.Map;

import fr.jee.model.jpa.ParticipantsEntity;
import fr.jee.persistence.commons.fake.GenericFakeService;
import fr.jee.persistence.services.ParticipantsPersistence;

/**
 * Fake persistence service implementation ( entity "Participants" )
 *
 * @author Telosys Tools Generator
 */
public class ParticipantsPersistenceFAKE extends GenericFakeService<ParticipantsEntity> implements ParticipantsPersistence {

	public ParticipantsPersistenceFAKE () {
		super(ParticipantsEntity.class);
	}
	
	protected ParticipantsEntity buildEntity(int index) {
		ParticipantsEntity entity = new ParticipantsEntity();
		// Init fields with mock values
		entity.setNom( nextString() ) ;
		entity.setPrenom( nextString() ) ;
		entity.setSociete( nextString() ) ;
		entity.setMail( nextString() ) ;
		return entity ;
	}
	
	
	public boolean delete(ParticipantsEntity entity) {
		log("delete ( ParticipantsEntity : " + entity + ")" ) ;
		return true;
	}

	public boolean delete( Integer idevent, String mail ) {
		log("delete ( PK )") ;
		return true;
	}

	public void insert(ParticipantsEntity entity) {
		log("insert ( ParticipantsEntity : " + entity + ")" ) ;
	}

	public ParticipantsEntity load( Integer idevent, String mail ) {
		log("load ( PK )") ;
		return buildEntity(1) ; 
	}

	public List<ParticipantsEntity> loadAll() {
		log("loadAll()") ;
		return buildList(40) ;
	}

	public List<ParticipantsEntity> loadByNamedQuery(String queryName) {
		log("loadByNamedQuery ( '" + queryName + "' )") ;
		return buildList(20) ;
	}

	public List<ParticipantsEntity> loadByNamedQuery(String queryName, Map<String, Object> queryParameters) {
		log("loadByNamedQuery ( '" + queryName + "', parameters )") ;
		return buildList(10) ;
	}

	public ParticipantsEntity save(ParticipantsEntity entity) {
		log("insert ( ParticipantsEntity : " + entity + ")" ) ;
		return entity;
	}

	public List<ParticipantsEntity> search(Map<String, Object> criteria) {
		log("search (criteria)" ) ;
		return buildList(15) ;
	}

	@Override
	public long countAll() {
		return 0 ;
	}

}
