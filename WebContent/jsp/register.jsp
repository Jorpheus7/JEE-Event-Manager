<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/Prolog.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/css/base.css"/>">
<title>Login</title>
</head>
<body>
	<div id="global">
		<form id="register" method="POST" action="<c:url value="/doRegister"/>">
			<h1>Compte</h1>
			<% 
		    // Display a message if wrong password or redirected from unauthorized zone
		    String mail = "";
			if(request.getParameter("status") != null){
				if("differentPasswords".equals(request.getParameter("status"))){
					out.println("<h5 class=\"errorMessage\">Les deux mots de passe ne concordent pas !</h5>");
					if(request.getParameter("mail") != null){
						mail = request.getParameter("mail");
					}
				}
			}
			%>
			<fieldset id="inputs">
				<input id="mail" name="mail" type="email" placeholder="Email" value="<%=mail%>" autofocus required>
				<input id="password" name="password" type="password" placeholder="Mot de passe"
					required>
				<input id="confirmPassword" name="confirmPassword" type="password" placeholder="Confirmer le mot de passe"
					required>
			</fieldset>
			<fieldset id="actions">
				<input type="submit" id="submit" value="Créer le compte"> 
				<a href="<c:url value="/login"/>">Déjà un compte ? Se connecter</a>
			</fieldset>
		</form>
	</div>
</body>
</html>