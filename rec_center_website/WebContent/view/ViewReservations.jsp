<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bronco Recreation Complex Management (BRCM) Online System</title>
<style>
#list {
	max-width: 500px;
	max-height: 200px;
	overflow: scroll;
	margin: auto;
}
</style>
</head>
<body>

	<h1>Current Reservations</h1>

	<div id="list">
		<c:forEach var="reservation" items="${requestScope.reservations}">
			<table>
				<caption>${reservation[0]}</caption>
				<tr>
					<td>Date</td>
					<td>${reservation[1]}</td>
				</tr>
				<tr>
					<td>Time</td>
					<td>${reservation[2]}</td>
				</tr>
				<tr>
					<td>Status</td>
					<td>${reservation[3]}</td>
				</tr>
			</table>
		</c:forEach>
	</div>
	<button type="button" onclick="window.history.back();">Main
		Menu</button>
</body>
</html>