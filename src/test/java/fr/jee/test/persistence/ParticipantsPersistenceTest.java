/*
 * Created on 27 oct. 2014 ( Time 17:10:26 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package fr.jee.test.persistence;


import fr.jee.model.jpa.ParticipantsEntity;
import fr.jee.mock.ParticipantsEntityMock;
import fr.jee.persistence.PersistenceServiceProvider;
import fr.jee.persistence.services.ParticipantsPersistence;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for Participants persistence service
 * 
 * @author Telosys Tools Generator
 *
 */
public class ParticipantsPersistenceTest 
{
	@Test
	public void test1() {
		
		System.out.println("Test count ..." );
		
		ParticipantsPersistence service = PersistenceServiceProvider.getService(ParticipantsPersistence.class);
		System.out.println("CountAll = " + service.countAll() );
	}
	
	@Test
	public void test2() {
		
		System.out.println("Test Participants persistence : delete + load ..." );
		
		ParticipantsPersistence service = PersistenceServiceProvider.getService(ParticipantsPersistence.class);
		
		ParticipantsEntityMock mock = new ParticipantsEntityMock();
		
		// TODO : set primary key values here 
		process( service, mock, 0 , "A"  );
		// process( service, mock, ... );
	}

	private void process(ParticipantsPersistence service, ParticipantsEntityMock mock, Integer idevent, String mail ) {
		System.out.println("----- "  );
		System.out.println(" . load : " );
		ParticipantsEntity entity = service.load( idevent, mail );
		if ( entity != null ) {
			// Found 
			System.out.println("   FOUND : " + entity );
			
			// Save (update) with the same values to avoid database integrity errors  
			System.out.println(" . save : " + entity );
			service.save(entity);
			System.out.println("   saved : " + entity );
		}
		else {
			// Not found 
			System.out.println("   NOT FOUND" );
			// Create a new instance 
			entity = mock.createInstance( idevent, mail ) ;
			Assert.assertNotNull(entity);

			// This entity references the following entities : 
			// . Events
			/* Insert only if references are OK
			// Try to insert the new instance
			System.out.println(" . insert : " + entity );
			service.insert(entity);
			System.out.println("   inserted : " + entity );
			*/

			System.out.println(" . delete : " );
			boolean deleted = service.delete( idevent, mail );
			System.out.println("   deleted = " + deleted);
		}		
	}
}
