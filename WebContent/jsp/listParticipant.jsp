<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ include file="/WEB-INF/jspf/Prolog.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/css/event.css"/>">
<title>Liste des participants</title>
</head>
<body>
<form id="participants" method="post" action="ListParticipant">
		<fieldset id="inputs">
				<legend>Participants à l'événement ${event.nom} </legend>
				<c:forEach items="${requestScope.participants}" var="participant">
				
				<label for="nom">Nom</label>
				<p id="nom">
				${participant.nom}
				</p>
				
				<label for="prenom">Prénom</label>
				<p id="prenom">
				${participant.prenom}
				</p>
				
				<label for="societe">Société</label>
				<p id="societe">
				${participant.societe}  
				</p>
				
				
				<label for="email">Email</label>
				<p id="email">
				${participant.mail} 
				</p>
				<br/>
				
				</c:forEach>
				</fieldset>
		</form>
		<a href="ListEvent">Liste des événements</a>
</body>
</html>