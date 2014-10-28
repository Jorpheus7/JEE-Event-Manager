package fr.jee.validate;

import java.text.SimpleDateFormat;
import java.util.Date;



public class validateEvent {

	public void validationNom(String nom) throws Exception{
		if(nom.length() < 3 )
			throw new Exception( "Le nom de création doit contenir au moins 3 caractères." );
	}
	
	public void validationAdresse(String adresse) throws Exception{
		if(adresse.length() < 10)
			throw new Exception( "L'adresse de l'évenement doit contenir au moins 10 caractères." );
	}
	
	public void validationDate(String dDebut,String dFin,Date dateDebut,Date dateFin) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setLenient(true);
		String td = sdf.format(dateDebut);
		String tf = sdf.format(dateFin);
		if(td.compareTo(dDebut)!=0)
			throw new Exception( "La date de début n'est pas au format dd-MM-yyyy" );
		if(tf.compareTo(dFin)!=0)
			throw new Exception( "La date de fin n'est pas au format dd-MM-yyyy" );
		if (dateDebut.after(dateFin))
			throw new Exception( "La date de début ne peut être après la date de fin" );
	}
	
	public void validationHeure(String HDebut,String HFin,Date HeureDebut,Date HeureFin) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		sdf.setLenient(true);
		String td = sdf.format(HeureDebut);
		String tf = sdf.format(HeureFin);
		if(td.compareTo(HDebut)!=0)
			throw new Exception( "L'heure de début n'est pas au format HH:mm" );
		if(tf.compareTo(HFin)!=0)
			throw new Exception( "L'heure de fin n'est pas au format HH:mm" );
		if (HeureDebut.after(HeureFin))
			throw new Exception( "L'heure de début ne peut être après l'heure de fin" );
	}
	

}

	

