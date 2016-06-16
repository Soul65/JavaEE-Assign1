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
		<h1><c:out value="${teamName}"/></h1>
		<h2>Team Roster</h2>
		<table border="1">
			<tr>
				<th>Name</th>
				<th>Position</th>
				<th>Jersey Number</th>
			</tr>
			<c:forEach items="${Roster}" var="player">
				<tr>
					<td><c:out value="${player.getName()}"/></td>
					<td><c:out value="${player.getPosition()}"/></td>
					<td><c:out value="${player.getJersey()}"/></td>
				</tr>
			</c:forEach>
		</table>
		<h2>Games</h2>
		<table border="1">
			<tr>
				<th>GameDate</th>
				<th>GameTime</th>
				<th>Arena</th>
				<th>Home</th>
				<th>Visitor</th>
				<th>HomeScore</th>
				<th>VisitorScore</th>
				<th>Overtime</th>
				<th>ShootOut</th>
			</tr>
			<c:forEach items="${Games}" var="game">
				<tr>
					<td><c:out value="${game.getGameDate()}"/></td>
					<td><c:out value="${game.getGameTime()}"/></td>
					<td><c:out value="${game.getArena()}"/></td>
					<td><c:out value="${game.getHome()}"/></td>
					<td><c:out value="${game.getVisitor()}"/></td>
					<td><c:out value="${game.getHomeScore()}"/></td>
					<td><c:out value="${game.getVisitorScore()}"/></td>
					<td><c:out value="${game.getOvertime()}"/></td>
					<td><c:out value="${game.getShootOut()}"/></td>
				</tr>
			</c:forEach>
		</table>
		<h2>Scheduled Games</h2>
		<table border="1">
			<tr>
				<th>GameDate</th>
				<th>GameTime</th>
				<th>Arena</th>
				<th>Home</th>
				<th>Visitor</th>
			</tr>
			<c:forEach items="${ScheduledGames}" var="game">
				<tr>
					<td><c:out value="${game.getGameDate()}"/></td>
					<td><c:out value="${game.getGameTime()}"/></td>
					<td><c:out value="${game.getArena()}"/></td>
					<td><c:out value="${game.getHome()}"/></td>
					<td><c:out value="${game.getVisitor()}"/></td>
				</tr>
			</c:forEach>
		</table>
		<h2>Standings</h2>
		<table border="1">
			<tr>
				<th>Wins</th>
				<th>Losses</th>
				<th>Overtimes</th>
				<th>Shoot-Outs</th>
			</tr>
			<tr>
				<td><c:out value="${Wins}"/></td>
				<td><c:out value="${Losses}"/></td>
				<td><c:out value="${OTs}"/></td>
				<td><c:out value="${SOs}"/></td>
			</tr>
		</table>
	</body>
</html>