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
		<form id="login" method="post" action="<c:url value="/doLogin"/>">
		    <h1>Log in</h1>
		    <% 
		    // Display a message if wrong password or redirected from unauthorized zone
			if(request.getParameter("invalid") != null
					&& new Boolean(request.getParameter("invalid")).booleanValue()){
				out.println("<h5 class=\"errorMessage\">Identifiant ou mot de passe invalide</h5>"); 
			}else if(request.getParameter("redirected") != null
					&& new Boolean(request.getParameter("redirected")).booleanValue()){
				out.println("<h5 class=\"errorMessage\">Vous devez vous identifier pour accéder à cette section</h5>"); 
			} 
			%>
		    <fieldset id="inputs">
		        <input id="mail" type="text" placeholder="Email" autofocus required>   
		        <input id="password" type="password" placeholder="Mot de passe" required>
		    </fieldset>
		    <fieldset id="actions">
		        <input type="submit" id="submit" value="Se connecter">
		        <a href="<c:url value="/register"/>">Créer un compte</a>
		    </fieldset>
		</form>
	</div>
</body>
</html>