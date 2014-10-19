/*
 * Created on 19 oct. 2014 ( Time 18:44:29 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package fr.jee.model.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;


import javax.persistence.*;

/**
 * Persistent class for entity stored in table "RENCONTRES"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="RENCONTRES", schema="ROOT" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="RencontresEntity.countAll", query="SELECT COUNT(x) FROM RencontresEntity x" )
} )
public class RencontresEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="IDEVENT", nullable=false)
    private Integer    idevent      ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
	// "idparticipants" (column "IDPARTICIPANTS") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="IDPARTICIPANTS", referencedColumnName="ID")
    private UsersEntity users       ;

    @ManyToOne
    @JoinColumn(name="IDEVENT", referencedColumnName="ID", insertable=false, updatable=false)
    private EventsEntity events      ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public RencontresEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setIdevent( Integer idevent ) {
        this.idevent = idevent ;
    }
    public Integer getIdevent() {
        return this.idevent;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setUsers( UsersEntity users ) {
        this.users = users;
    }
    public UsersEntity getUsers() {
        return this.users;
    }

    public void setEvents( EventsEntity events ) {
        this.events = events;
    }
    public EventsEntity getEvents() {
        return this.events;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(idevent);
        sb.append("]:"); 
        return sb.toString(); 
    } 

}
