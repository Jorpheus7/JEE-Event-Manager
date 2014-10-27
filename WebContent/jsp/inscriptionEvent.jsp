<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ include file="/WEB-INF/jspf/Prolog.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/css/event.css"/>">
<title>Inscription</title>
</head>
<body>
	<div id="global">
		<form id="event" method="post" action="creation">
			<h1>Inscription à <%=request.getParameter("name")%></h1>
			<fieldset id="inputs">
				<input id="mail" 	type="text" palceholder="Adresse mail" required>
				<input id="nom" 	type="text" palceholder="Nom" required>
				<input id="prenom"  type="text" palceholder="Prénom" required>
				<input id="societe" type="text" palceholder="Société" required>
			</fieldset>
			<fieldset id="actions">
		        <input type="submit" id="submit" value="Inscription">
		    </fieldset>
		</form>
	</div>
</body>
</html>