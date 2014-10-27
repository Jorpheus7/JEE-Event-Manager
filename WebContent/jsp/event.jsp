<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ include file="/WEB-INF/jspf/Prolog.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/css/event.css"/>">
<title>Création d'un événement</title>
</head>
<body>
	<div id="global">
		<form id="event" method="post" action="creation">
			<h1>Créer un événement</h1>
			<fieldset id="inputs">
				<input id="eventname"   type="text" palceholder="Nom de l'événement" autofocus required>
				<input id="adresse" type="text" palceholder="Adresse" required>
				<input id="dhdebut" type="text" palceholder="Date Heure Début" required>
				<input id="dhfin"   type="text" palceholder="Date Heure Fin" required>
			</fieldset>
			<fieldset id="actions">
		        <input type="submit" id="submit" value="Publier">
		    </fieldset>
		</form>
	</div>
</body>
</html>