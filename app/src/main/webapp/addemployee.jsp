<%@page import="com.exercise8.core.dao.EmployeeDAO"%>
<%@page import="com.exercise8.core.model.Employee"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
     <title>Add Employee</title>
</head>
<body>
	<h3>Add New Employee</h3>
	<br/>
    <div>
    <a href=employeemanagement.jsp>Back to Employee <br/> Management</a></td>
    </div>
    <br/>
    <br/>	
	<form action="AddEmployeeServlet" method="POST">
		<table align="left" cellpadding="8">
			<tr>
				<td>Title</td>
				<td>
					<input type="text" name="title" maxlength="255"/>
				</td>
			</tr>

			<tr>
				<td>First Name</td>
				<td>
					<input type="text" name="firstName" maxlength="255" required/>
				</td>
			</tr>

			<tr>
				<td>Middle Name</td>
				<td>
					<input type="text" name="middleName" maxlength="255" required/>
				</td>
			</tr>

			<tr>
				<td>Last Name</td>
				<td>
					<input type="text" name="lastName" maxlength="255" required/>
				</td>
			</tr>

			<tr>
				<td>Suffix</td>
				<td>
					<input type="text" name="suffix" maxlength="255"/>
				</td>
			</tr>

			<tr>
				<td>Street Number</td>
				<td>
					<input type="text" name="streetNumber" maxlength="255" required/>
				</td>
			</tr>	

			<tr>
				<td>Barangay</td>
				<td>
					<input type="text" name="barangay" maxlength="255" required/>
				</td>
			</tr>

			<tr>
				<td>City</td>
				<td>
					<input type="text" name="city" maxlength="255" required/>
				</td>
			</tr>

			<tr>
				<td>Country</td>
				<td>
					<input type="text" name="country" maxlength="255" required/>
				</td>
			</tr>

			<tr>
				<td>Zipcode</td>
				<td>
					<input type="text" name="zipcode" maxlength="255" required/>
				</td>
			</tr>			

			<tr>
				<td>Birthdate</td>
				<td>
					<input type="text" name="birthdate" maxlength="10" required/> (dd/mm/yyyy)
				</td>
			</tr>														

			<tr>
				<td>grade</td>
				<td>
					<input type="text" name="grade" maxlength="6" required/> 
				</td>
			</tr>														

			<tr rowspan="2" align="center">
				<td colspan="2" align="center">
					<input type="submit" value="Add Employee"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>