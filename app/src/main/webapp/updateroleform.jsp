<%@page import="com.exercise8.core.dao.RoleDAO"%>
<%@page import="com.exercise8.core.model.Roles"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
     <title>Update Role</title>
</head>
<body>
	<%String id = request.getParameter("roleId");
	Long roleId = Long.parseLong(id);
	Roles role = RoleDAO.get(Roles.class, roleId);%>
	<h3>Update Role Form</h3>
	<form action="UpdateRoleServlet" method="POST">
		<table align="left" cellpadding="5">
			<tr>
				<td>Role Code</td>
				<td>
					<input type="text" name="roleCode" value=<%=role.getRoleCode()%> maxlength="255"/>
				</td>
			</tr>
			<tr>
				<td>Role Name</td>
				<td>
					<input type="text" name="roleName" value=<%=role.getRoleName()%> maxlength="255"/>
				</td>
			</tr>
			<tr rowspan="2" align="center">
				<td colspan="2" align="center">
					<input type="hidden" name="roleId" value="<%=roleId%>"/>
					<input type="submit" value="Update"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>