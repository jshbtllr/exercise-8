<!DOCTYPE html>
<html>
<head>
	<title>Employee Registration System</title>
</head>

<body>
	<h2>Employee Registration System</h2>
	<br>
	<%
	String sort = new String("2");
	String order = new String("2");
	session.setAttribute("sort", sort);
	session.setAttribute("order", order);
	%>
	<a href="employeemanagement.jsp">Employee Management</a>
	<br>
	<a href="rolemanagement.jsp">Role Management</a>
</body>
