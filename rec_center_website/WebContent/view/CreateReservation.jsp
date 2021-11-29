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

	<h1>Create Reservation</h1>

	<form action="${pageContext.request.contextPath}/create_reservation"
		method="post">
		<input type="hidden" name="username"
			value="<%=session.getAttribute("username")%>" />
		<table bgcolor="#00ffff" width="600" height="80" align="center"
			border="0">
			<tr>
				<td>Choose a date and time for the reservation:</td>
				<td><input type="datetime-local" name="datetime" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Confirm"
					onclick="window.location.href = 'view/WelcomeView.jsp'" /></td>
				<td align="right">
					<button type="button" class="btn btn-primary"
						onclick="window.history.back();">Cancel</button>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>