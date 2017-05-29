<%@page import="com.exercise8.core.model.Employee"%>
<%@page import="com.exercise8.core.dao.EmployeeDAO"%>
<%@page import="com.exercise8.core.model.Roles"%>
<%@page import="java.util.Set"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
     <title>Employee Role</title>
</head>
<body>
	<%
	String id = request.getParameter("employeeId");
	Long employeeId = Long.parseLong(id);
	Employee employee = EmployeeDAO.getEmployeeCollection(employeeId);
	Set <Roles> roles = employee.getRole();
	session.setAttribute("empId", id);
	%>
	<h3>Employee <%=employee.getName().getFirstName()%> <%=employee.getName().getLastName()%>'s Role List</h3><br/>
    <table width=50%>
        <td width=25% align="left">
            <a href=employeemanagement.jsp>Back to Employee <br/> Management</a>
        </td>
        <td width=25% align="right">
  			<a href=addemployeerole.jsp>Add Role</a>
  		</td>
  	</table>
    <div style = "clear:both;"></div>
    <br/>
    <br/>	
	<table border="1" align="left" cellpadding="5">
		<thead>
			<tr>
				<th>Role ID</th>
				<th>Role Code</th>
				<th>Role Name</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<%
			for(Roles list : roles) {
			%>
			<tr>
				<td style="text-align:center"><%=list.getId()%></td>
                <td style="text-align:center"><%=list.getRoleCode()%></td>
                <td style="text-align:center"><%=list.getRoleName()%></td>
                <td style="text-align:center">
                    <form action="UpdateEmployeeRoleServlet" method="post">
                    	<input type="hidden" name="employeeId" value="<%=employeeId%>"/>
                        <input type="hidden" name="roleId" value="<%=list.getId()%>"/>
                        <input type="hidden" name="status" value="2"/>
                        <input type="submit" value="Delete"/>
                    </form>
                </td>
            </tr>
            <%
        	}
        	%>
		</tbody>
	</table>
</body>
</html>