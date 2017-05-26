<%@page import="com.exercise8.core.model.Employee"%>
<%@page import="com.exercise8.core.dao.RoleDAO"%>
<%@page import="com.exercise8.core.service.RoleService"%>
<%@page import="com.exercise8.core.dao.EmployeeDAO"%>
<%@page import="com.exercise8.core.model.Roles"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
     <title>Add Employee Role</title>
</head>
<body>
	<%
	String empId = (String)session.getAttribute("empId");
	Long employeeId = Long.parseLong(empId);
	Employee employee = EmployeeDAO.getEmployeeCollection(employeeId);
	List <Roles> roles = RoleService.listRoles(1,1);
	%>
	<h3>Add Role to <%=employee.getName().getFirstName()%> <%=employee.getName().getLastName()%>'s Role List</h3>
	<br/>
    <div>
    <a href=employeemanagement.jsp>Back to Employee <br/> Management</a></td>
    </div>
    <br/>
    <br/>	
	<h4>Input a valid Role ID below</hr>
	<form action="UpdateEmployeeRoleServlet" method="POST">
		<table align="left" cellpadding="8">
			<tr>
				<td>Role ID</td>
				<td>
					<input type="text" name="roleId" maxlength="255"/>
				</td>
			</tr>

			<tr rowspan="2" align="center">
				<td colspan="2" align="center">
					<input type="hidden" name="employeeId" value="<%=employeeId%>"/>
					<input type="hidden" name="status" value="1"/>
					<input type="submit" value="Add Role to Employee"/>
				</td>
			</tr>
		</table>
	</form>

    <div style = "clear:both;"></div>

	<table border="1" align="left" cellpadding="5">
		<thead>
			<tr>
				<th>Role ID</th>
				<th>Role Code</th>
				<th>Role Name</th>
			</tr>
		</thead>
		<tbody>
			<%for(Roles list : roles) {%>
			<tr>
				<td style="text-align:center"><%=list.getId()%></td>
                <td style="text-align:center"><%=list.getRoleCode()%></td>
                <td style="text-align:center"><%=list.getRoleName()%></td>
            </tr>
            <%}%>
		</tbody>
	</table>
</body>
</html>