<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/Prolog.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/css/base.css"/>">
<title>Login</title>
</head>
<body>
	<div id="global">
		<form id="login" method="POST" action="<c:url value="/doLogin"/>">
		    <h1>Log In</h1>
		    <% 
		    // Display a message if wrong password or redirected from unauthorized zone
			if(new Boolean(request.getParameter("redirected")).booleanValue()){
				; 
			}
			%>
		    <fieldset id="inputs">
		        <input id="mail" type="mail" placeholder="Email" name="mail" autofocus required>   
		        <input id="password" type="password" placeholder="Mot de passe" name="password" required>
		    </fieldset>
		    <fieldset id="actions">
		        <input type="submit" id="submit" value="Log in">
		        <a href="<c:url value="/register"/>">Créer un compte</a>
		    </fieldset>
		</form>
	</div>
</body>
</html>