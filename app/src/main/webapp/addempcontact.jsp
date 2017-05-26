<%@page import="com.exercise8.core.dao.EmployeeDAO"%>
<%@page import="com.exercise8.core.model.Employee"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
     <title>Add Employee Contact Info</title>
</head>
<body>
	<%
	String empId = (String)session.getAttribute("id");
	Long employeeId = Long.parseLong(empId);
	Employee employee = EmployeeDAO.getEmployeeCollection(employeeId);
	%>
	<h3>Add Role to <%=employee.getName().getFirstName()%> <%=employee.getName().getLastName()%>'s Role List</h3>
	<br/>
    <div>
    <a href=employeemanagement.jsp>Back to Employee <br/> Management</a></td>
    </div>
    <br/>
    <br/>	
	<h4>Add email, telephone or cellphone</hr>
	<form action="AddContactInfoServlet" method="POST">
		<table align="left" cellpadding="8">
			<tr>
				<td>Contact Info Type</td>
				<td>
					<select name="infoType">
						<option value="email">email</option>
						<option value="telephone">telephone</option>
						<option value="cellphone">cellphone</option>
					</select>
				</td>
			</tr>

			<tr>
				<td>Contact Info Detaills</td>
				<td>
					<input type="text" name="infoDetail" maxlength="255"/> (input information details)
				</td>
			</tr>

			<tr rowspan="2" align="center">
				<td colspan="2" align="center">
					<input type="hidden" name="employeeId" value="<%=employeeId%>"/>
					<input type="submit" value="Add Contact Info to Employee"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>