<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>NHL Teams</title>
	</head>
	<body>
		<table border="1">
			<tr>
				<th>Team Name</th>
				<th>Head Coach</th>
				<th>Assistant Coach</th>
				<th>Manager</th>
			</tr>
			<c:forEach items="${Teams}" var="team">
				<tr>
					<td>
						<c:url value="./DisplayTeamInfo" var="teamUrl">
							<c:param name="username" value="${username}"/>
							<c:param name="password" value="${password}"/>
							<c:param name="teamID" value="${team.getTeamID()}"/>
						</c:url>
						<a href="<c:url value="${teamUrl}"/>">${team.getName()}</a>
					</td>
					<td><c:out value="${team.getHeadCoach()}"/></td>
					<td><c:out value="${team.getAsstCoach()}"/></td>
					<td><c:out value="${team.getManager()}"/></td>
				</tr>
			</c:forEach>
		</table>		
	</body>
</html>