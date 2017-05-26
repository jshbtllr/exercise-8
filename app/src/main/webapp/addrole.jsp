<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
     <title>Add Role</title>
</head>
<body>
	<h3>Add Role Form</h3>
	<form action="AddRoleServlet" method="POST">
		<table align="left" cellpadding="8">
			<tr>
				<td>Role Code</td>
				<td>
					<input type="text" name="roleCode" maxlength="255"/>
				</td>
			</tr>
			<tr>
				<td>Role Name</td>
				<td>
					<input type="text" name="roleName" maxlength="255"/>
				</td>
			</tr>
			<tr rowspan="2" align="center">
				<td colspan="2" align="center">
					<input type="submit" value="Add Role"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>