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
	<form id="event" method="post" action="auth/InscriptionEvent" >
			<fieldset id="inputs">
				<legend>Inscription à ${event.nom }</legend>
							
				<label for="adresse">Adresse</label>
				<p id="adresse">
				${event.adresse}
				</p>
				
				<label for="debut">Début</label>
				<p id="debut">
				${event.datedebut},${event.heuredebut}    
				</p>
				
				
				<label for="fin">Fin</label>
				<p id="fin">
				${event.datefin},${event.heurefin} 
				</p>
				</br>
				
				<p> Remplir:<p>
				
				<label for="email">Email<span class="requis">*</span></label>
				<input id="email" name="email"  type="text" palceholder="email" size="20" maxlength="60" autofocus required>
				 <br />
				
				<label for="nom">Nom<span class="requis">*</span></label>
				<input id="nom" name="nom" type="text" palceholder="nom" size="20" maxlength="60"required>
				 <br />
				
				<label for="prenom">Prénom<span class="requis">*</span></label>
				<input id="prenom" name="prenom" type="text" palceholder="Prénom"size="20" maxlength="60" required>
				 <br />
				
				<label for="societe">Société<span class="requis">*</span></label>
				<input id="societe"  name="societe" type="societe" palceholder="Société" size="20" maxlength="60"required>
				 <br />
			
		        <input type="submit" id="submit" value="Inscription" class="sansLabel">
		        <input type="hidden" name="idEvent" value="${event.id}" class="sansLabel" >
				 <br />
				 
				 <c:if test="${param.erreur == \"true\" }">
				<p>Erreur donnée invalide</p>
				</c:if>
				<c:if test="${param.erreur == \"false\" }">
				<p>Vous êtes inscrit à l'évenements</p>
				</c:if>
			</fieldset>
		</form>
</body>
</html>