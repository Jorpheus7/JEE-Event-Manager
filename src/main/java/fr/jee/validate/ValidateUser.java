package fr.jee.validate;

import fr.jee.model.jpa.UsersEntity;



public class ValidateUser {

	public UsersEntity validationUser(String mail ,String password){
			
		UsersEntity user = new UsersEntity();
		user.setMail(mail);
		user.setPasswd(password);
		
		return user;
	}
}
	

