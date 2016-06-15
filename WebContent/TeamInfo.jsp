<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Team Info</title>
	</head>
	<body>
		<h2>Team Roster</h2>
		<table border="1">
			<tr>
				<th>Name</th>
				<th>Position</th>
				<th>Jersey Number</th>
			</tr>
			<c:forEach items="${Roster}" var="team">
				<tr>
					<td><c:out value="${team.getName()}"/></td>
					<td><c:out value="${team.getPosition()}"/></td>
					<td><c:out value="${team.getJersey()}"/></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>