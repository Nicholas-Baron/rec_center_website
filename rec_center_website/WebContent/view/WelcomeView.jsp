<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bronco Recreation Complex Management (BRCM) Online System</title>
</head>

<body>
	<h1 style="color: black;">
		<c:out value="Welcome ${requestScope.username}!" />
	</h1>

	<input type="button" value="New Reservation"
		onclick="window.location='view/CreateReservation.jsp'" />
	<form action="${pageContext.request.contextPath}/view_reservations"
		method="get">
		<input type="hidden" name="username"
			value="<%=session.getAttribute("username")%>" /> <input
			type="submit" value="Current Reservations" />
	</form>

</body>

</html>