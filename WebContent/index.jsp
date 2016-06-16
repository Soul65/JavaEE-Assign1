<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<%-- 		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script> --%>
		<title>Login</title>
	</head>
	<body>
		<form action="./DisplayTeams" method="get">
			UserName: <br><input type="text" name="username"/><br>	
			Password: <br><input type="password" name="password"/><br><br>
			<input type="submit" value="Submit"/>
		</form>
	</body>
</html>