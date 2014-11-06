package fr.jee.oneshot;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import fr.jee.model.jpa.EventsEntity;
import fr.jee.model.jpa.ParticipantsEntity;
import fr.jee.model.jpa.UsersEntity;
import fr.jee.persistence.services.jpa.EventsPersistenceJPA;
import fr.jee.persistence.services.jpa.ParticipantsPersistenceJPA;
import fr.jee.persistence.services.jpa.UsersPersistenceJPA;

public class InjectionDonnees {
	
	UsersPersistenceJPA persistenceUser = new UsersPersistenceJPA();
	EventsPersistenceJPA persistenceEvent = new EventsPersistenceJPA();
	ParticipantsPersistenceJPA persistenceParticipant = new ParticipantsPersistenceJPA();
	int idCrea1;
	int idCrea2;
	int idEvent1;
	int idEvent2;
	
	public void run() {
		nettoyageBase();
		creationUsers();
		creationEvents();
		creationParticipants();
	}

	private void nettoyageBase() {
		List<ParticipantsEntity> participantsADelete = persistenceParticipant.loadAll();
		for(ParticipantsEntity participant : participantsADelete){
			persistenceParticipant.delete(participant);
		}
		
		List<EventsEntity> eventsADelete = persistenceEvent.loadAll();
		for(EventsEntity event : eventsADelete){
			persistenceEvent.delete(event);
		}
		
		List<UsersEntity> usersADelete = persistenceUser.loadAll();
		for(UsersEntity user : usersADelete){
			persistenceUser.delete(user);
		}
		
		
	}

	private void creationUsers() {
		UsersEntity user1 = creationDUnUser("user1@mail.fr", "passwd1");
		UsersEntity user2 = creationDUnUser("user2@mail.fr", "passwd2");
		UsersEntity user3 = creationDUnUser("user3@mail.fr", "passwd3");
		persistenceUser.save(user1);
		persistenceUser.save(user2);
		persistenceUser.save(user3);
		List<UsersEntity> liste = persistenceUser.loadAll();
		idCrea1 = liste.get(0).getId();
		idCrea2 = liste.get(1).getId();
	}

	private UsersEntity creationDUnUser(String mail, String passwd) {
		UsersEntity userACreer = new UsersEntity();
		userACreer.setMail(mail);
		userACreer.setPasswd(passwd);
		return userACreer;
	}

	private void creationEvents() {
		List<EventsEntity> listeASave = new ArrayList<EventsEntity>();
		listeASave.add(creationDUnEvent("event1", "addresse1", 0, idCrea1));
		listeASave.add(creationDUnEvent("event2", "addresse2", 1, idCrea1));
		listeASave.add(creationDUnEvent("event3", "addresse3", 0, idCrea2));
		EventsPersistenceJPA persistenceEvent = new EventsPersistenceJPA();
		for (EventsEntity event : listeASave) {
			persistenceEvent.save(event);
		}
		List<EventsEntity> liste = persistenceEvent.loadAll();
		idEvent1 = liste.get(0).getId();
		idEvent2 = liste.get(1).getId();
	}

	private EventsEntity creationDUnEvent(String nomEvent, String addresse,
			int actif, int idCreateur) {
		EventsEntity eventACreer = new EventsEntity();
		Calendar dateDebut = Calendar.getInstance();
		dateDebut.set(Calendar.YEAR, 2014);
		dateDebut.set(Calendar.MONTH, 10);
		dateDebut.set(Calendar.DAY_OF_MONTH, 28);
		Calendar heureDebut = Calendar.getInstance();
		heureDebut.set(Calendar.HOUR_OF_DAY, 1);
		heureDebut.set(Calendar.MINUTE, 35);
		heureDebut.set(Calendar.SECOND, 56);
		Calendar dateFin = Calendar.getInstance();
		dateFin.set(Calendar.YEAR, 2014);
		dateFin.set(Calendar.MONTH, 10);
		dateFin.set(Calendar.DAY_OF_MONTH, 29);
		Calendar heureFin = Calendar.getInstance();
		heureFin.set(Calendar.HOUR_OF_DAY, 19);
		heureFin.set(Calendar.MINUTE, 50);
		heureFin.set(Calendar.SECOND, 35);
		eventACreer.setNom(nomEvent);
		eventACreer.setAdresse(addresse);
		eventACreer.setDatedebut(dateDebut.getTime());
		eventACreer.setHeuredebut(heureDebut.getTime());
		eventACreer.setDatefin(dateFin.getTime());
		eventACreer.setHeurefin(heureFin.getTime());
		eventACreer.setActif(actif);
		eventACreer.setUsers(persistenceUser.load(idCreateur));
		return eventACreer;
	}

	private void creationParticipants() {
		List<ParticipantsEntity> listeASave = new ArrayList<ParticipantsEntity>();
		listeASave.add(creationDUnParticipant(idEvent1,"user1@mail.fr", "nom1", "prenom1", "societe1"));
		listeASave.add(creationDUnParticipant(idEvent1,"user4@mail.fr", "nom4", "prenom4", "societe4"));
		listeASave.add(creationDUnParticipant(idEvent2,"user2@mail.fr", "nom2", "prenom2", "societe2"));
		for(ParticipantsEntity participant : listeASave) {
			persistenceParticipant.save(participant);
		}
	}

	private ParticipantsEntity creationDUnParticipant(int idEvent, String mail, String nom, String prenom, String societe) {
		ParticipantsEntity participant = new ParticipantsEntity();
		participant.setIdevent(idEvent);
		participant.setMail(mail);
		participant.setNom(nom);
		participant.setPrenom(prenom);
		participant.setSociete(societe);
		return participant;
	}

	public static void main(String[] args) {
		new InjectionDonnees().run();
	}

}
