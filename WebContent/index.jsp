<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
	</head>
	<body>
		<form action="./DisplayTeams" method="get">
			UserName: <br><input type="text" name="username"/><br>	
			Password: <br><input type="password" name="password"/><br><br>			
			<input type="submit" value="Submit"/>
		</form>
		<h3 style="color:red"><c:out value="${error}"/></h3>
	</body>
</html>