
/*
 * Created on 20 oct. 2014 ( Time 17:03:50 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package fr.jee.mock;

import java.util.LinkedList;
import java.util.List;

import fr.jee.model.jpa.ParticipantsEntity;
import fr.jee.mock.tool.MockValues;

public class ParticipantsEntityMock {

	private MockValues mockValues = new MockValues();
	
	/**
	 * Creates an instance with random Primary Key
	 * @return
	 */
	public ParticipantsEntity createInstance() {
		// Primary Key values

		return createInstance( mockValues.nextInteger(), mockValues.nextString(255) );
	}
	
	/**
	 * Creates an instance with a specific Primary Key
	 * @param id1
	 * @return
	 */
	public ParticipantsEntity createInstance( Integer idevent, String mail ) {
		ParticipantsEntity entity = new ParticipantsEntity();
		// Init Primary Key fields
		entity.setIdevent( idevent) ;
		entity.setMail( mail) ;
		// Init Data fields
		entity.setNom( mockValues.nextString(100) ) ; // java.lang.String 
		entity.setPrenom( mockValues.nextString(100) ) ; // java.lang.String 
		entity.setSociete( mockValues.nextString(255) ) ; // java.lang.String 
		// Init Link fields (if any)
		// setEvents( TODO ) ; // Events 
		return entity ;
	}
	
	/**
	 * Creates a list of instances
	 * @param count number of instances to be created
	 * @return
	 */
	public List<ParticipantsEntity> createList(int count) {
		List<ParticipantsEntity> list = new LinkedList<ParticipantsEntity>();		
		for ( int i = 1 ; i <= count ; i++ ) {
			list.add( createInstance() );
		}
		return list;
	}
}
