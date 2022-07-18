<%@page import="ua.com.foxminded.db.DatabaseFacade"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>List of books 2</h1>

	<%
	for (String name : DatabaseFacade.getBooks()) {

		out.print(name + "<br/>");

	}
	%>

	<form
		action="C:\Workspace\DynamicWeb\src\main\webapp\postFormHandler.jsp"
		method="POST">
		<label for="id">id:</label><br> <input type="text" id="id"
			name="id"><br> <label for="name">Name:</label><br>
		<input type="text" id="name" name="name"><br> <input
			type="submit" value="Submit">

	</form>

</body>
</html>