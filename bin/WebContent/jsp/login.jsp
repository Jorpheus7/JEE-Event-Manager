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
		<form id="login">
		    <h1>Log In</h1>
		    <% 
		    // Display a message if wrong password or redirected from unauthorized zone
			if(new Boolean(request.getParameter("redirected")).booleanValue()){
				; 
			}
			%>
		    <fieldset id="inputs">
		        <input id="username" type="text" placeholder="Username" autofocus required>   
		        <input id="password" type="password" placeholder="Password" required>
		    </fieldset>
		    <fieldset id="actions">
		        <input type="submit" id="submit" value="Log in">
		        <a href="">Forgot your password?</a><a href="">Register</a>
		    </fieldset>
		</form>
	</div>
</body>
</html>