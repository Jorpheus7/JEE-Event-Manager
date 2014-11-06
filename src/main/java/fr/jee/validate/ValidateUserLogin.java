package fr.jee.validate;

import java.util.List;

import fr.jee.model.jpa.UsersEntity;
import fr.jee.persistence.services.jpa.UsersPersistenceJPA;



public class ValidateUserLogin {

	public UsersEntity validationUserLogin(String mail, String password){
		
		UsersPersistenceJPA userJpa = new UsersPersistenceJPA();
		List<UsersEntity> results = userJpa.loadAll();
		UsersEntity user = null;
		for(UsersEntity entity : results){
			if(mail.equals(entity.getMail()) && password.equals(entity.getPasswd())){
				user = entity;
				break;
			}
		}		
		return user;	
	}
}
	

