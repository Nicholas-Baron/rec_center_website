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

	<form action="${pageContext.request.contextPath}/login" method="post">
		<table bgcolor="#00ffff" width="500" height="80" align="center">
			<tr>
				<td><c:out value="Username: "></c:out></td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td align="right"><input type="submit" name="Submit"
					value="Submit"></td>
				<td><input type="reset" name="Clean" value="Clean"></td>
			</tr>
		</table>
	</form>

	<h1 style="color: red;">
		<c:out value="${requestScope.ErrorLogin}" />
	</h1>

</body>

</html>