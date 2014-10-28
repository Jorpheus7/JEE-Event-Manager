<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ include file="/WEB-INF/jspf/Prolog.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/css/event.css"/>">
<title>Vos événements</title>
</head>
<body>
		<form id="event" method="post" action="listEvent">
				<legend>Vos événements : </legend>
				<c:forEach items="${requestScope.events}" var="event">
				<label for="eventname">Nom de l'événement</label>
				<p id="eventname">
				${event.nom}
				</p>
				 <br />
				
				<label for="adresse">Adresse</label>
				<p id="adresse">
				${event.adresse}
				</p>
				 <br />
				
				<label for="hdebut">Heure Début</label>
				<p id="hdebut">
				${event.heuredebut}
				</p>
				 <br />
				
				<label for="hfin">Heure Fin</label>
				<p id="hfin">
				${event.heurefin}
				</p>
				 <br />
				
				<label for="ddebut">Date Début</label>
				<p id="ddebut">
				${event.datedebut}
				</p>
				 <br />
				
				<label for="dfin">Date Fin</label>
				<p id="dfin">
				${event.datefin}
				</p>
				 <br />
				<c:if test="${event.actif == 0 }">
				<input class="hidden" type="text" value="${event.id}" name="id">
		        <input type="submit" id="submit" name ="publier" value="Publier" class="sansLabel">
		        </c:if>
				 <br />
				</c:forEach>
		</form>
		<a href="NewEvent">Créer un événement</a>
</body>
</html>