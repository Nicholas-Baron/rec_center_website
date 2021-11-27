<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bronco Recreation Complex Management (BRCM) Online System</title>
</head>
<body>

	<h1>Current Reservations</h1>

	<div height="200" style="overflow: scroll;">
		<c:forEach var="reservation" items="${requestScope.reservations}">
			<div>${reservation}</div>

		</c:forEach>
	</div>
	<button type="button" onclick="window.history.back();">Main
		Menu</button>
</body>
</html>