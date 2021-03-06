
/*
 * Created on 27 oct. 2014 ( Time 17:10:25 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package fr.jee.mock;

import java.util.LinkedList;
import java.util.List;

import fr.jee.model.jpa.EventsEntity;
import fr.jee.mock.tool.MockValues;

public class EventsEntityMock {

	private MockValues mockValues = new MockValues();
	
	/**
	 * Creates an instance with random Primary Key
	 * @return
	 */
	public EventsEntity createInstance() {
		// Primary Key values

		return createInstance( mockValues.nextInteger() );
	}
	
	/**
	 * Creates an instance with a specific Primary Key
	 * @param id1
	 * @return
	 */
	public EventsEntity createInstance( Integer id ) {
		EventsEntity entity = new EventsEntity();
		// Init Primary Key fields
		entity.setId( id) ;
		// Init Data fields
		entity.setNom( mockValues.nextString(255) ) ; // java.lang.String 
		entity.setAdresse( mockValues.nextString(255) ) ; // java.lang.String 
		entity.setActif( mockValues.nextInteger() ) ; // java.lang.Integer 
		entity.setDatedebut( mockValues.nextDate() ) ; // java.util.Date 
		entity.setHeuredebut( mockValues.nextDate() ) ; // java.util.Date 
		entity.setDatefin( mockValues.nextDate() ) ; // java.util.Date 
		entity.setHeurefin( mockValues.nextDate() ) ; // java.util.Date 
		// Init Link fields (if any)
		// setListOfParticipants( TODO ) ; // List<Participants> 
		// setUsers( TODO ) ; // Users 
		return entity ;
	}
	
	/**
	 * Creates a list of instances
	 * @param count number of instances to be created
	 * @return
	 */
	public List<EventsEntity> createList(int count) {
		List<EventsEntity> list = new LinkedList<EventsEntity>();		
		for ( int i = 1 ; i <= count ; i++ ) {
			list.add( createInstance() );
		}
		return list;
	}
}
