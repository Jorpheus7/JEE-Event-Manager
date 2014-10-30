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
		<form id="event" method="post" action="auth/ListEvent">
		<fieldset id="inputs">
				<legend>Vos événements : </legend>
				<c:forEach items="${requestScope.events}" var="event">
				
				<label for="eventname">Nom de l'événement</label>
				<p id="eventname">
				${event.nom}
				</p>
				
				<label for="adresse">Adresse</label>
				<p id="adresse">
				${event.adresse}
				</p>
				
				<label for="debut">Début</label>
				<p id="debut">
				${event.datedebut},${event.heuredebut},     
				</p>
				
				
				<label for="fin">Fin</label>
				<p id="fin">
				${event.datefin},${event.heurefin} 
				</p>

				<c:if test="${event.actif == 0 }">
				<input type="hidden" type="text" value="${event.id}" name="id">
		        <input type="submit" id="submit" name ="publier" value="Publier" class="sansLabel">
		        </c:if>
		        <c:if test="${event.actif == 1 }">
		        <a href="InscriptionEvent?id=${event.id}">${pageContext.request.contextPath}/InscriptionEvent?id=${event.id}</a>
		         <br />
		         </c:if>
				 <br />
				</c:forEach>
				</fieldset>
		</form>
		<a href="NewEvent">Créer un événement</a>
</body>
</html>