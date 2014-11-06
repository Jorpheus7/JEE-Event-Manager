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
		<form id="event" method="post" action="NewEvent">
			<fieldset id="inputs">
				<legend>Créer un événement</legend>
				<label for="eventname">Nom de l'événement<span class="requis">*</span></label>
				<input id="eventname" name="eventname"  type="text" palceholder="Nom de l'événement" size="20" maxlength="60" autofocus required>
				 <br />
				
				<label for="adresse">Adresse<span class="requis">*</span></label>
				<input id="adresse" name="adresse" type="text" palceholder="Adresse" size="20" maxlength="60"required>
				 <br />
				
				<label for="hdebut">Heure Début<span class="requis">*</span></label>
				<input id="hdebut" name="hdebut" type="text" palceholder="Heure Début"size="20" maxlength="60" required>
				 <br />
				
				<label for="hfin">Heure Fin<span class="requis">*</span></label>
				<input id="hfin"  name="hfin" type="text" palceholder="Heure Fin" size="20" maxlength="60"required>
				 <br />
				
				<label for="ddebut">Date Début<span class="requis">*</span></label>
				<input id="ddebut" name="ddebut" type="text" palceholder="Date Début" size="20" maxlength="60"required>
				 <br />
				
				<label for="dfin">Date Fin<span class="requis">*</span></label>
				<input id="dfin" name="dfin"  type="text" palceholder="Date Fin" size="20" maxlength="60"required>
				 <br />
			
		        <input type="submit" id="submit" value="Créer" class="sansLabel">
				 <br />
				 
				 <c:if test="${param.erreur == \"true\" }">
				<p >Erreur donnée invalide</p>
				</c:if>
			</fieldset>
		</form>
</body>
</html>