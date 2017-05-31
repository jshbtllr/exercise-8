<%@page import="com.exercise8.core.dao.EmployeeDAO"%>
<%@page import="com.exercise8.core.model.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
     <title>Update Employee</title>
</head>
<body>
	<%
		String id = request.getParameter("employeeId");
		Long employeeId = Long.parseLong(id);
		Employee employee = EmployeeDAO.getEmployeeCollection(employeeId);
	%>
	<h3>Update Employee <%=employee.getName().getFirstName()%> <%=employee.getName().getLastName()%>'s Details</h3>
	<br/>
    <div>
    <a href=/employee>Back to Employee <br/> Management</a></td>
    </div>
    <br/>
    <br/>	
	<h4>Choose below Employee Details to update</h4>
	<form action="UpdateEmployeeServlet" method="POST">
		<table align="left" cellpadding="8">
			<tr>
				<td>Title</td>
				<td>
					<input type="text" id="title" name="title" maxlength="255" value="<%=employee.getName().getTitle()%>" />
				</td>
			</tr>

			<tr>
				<td>First Name</td>
				<td>
					<input type="text" id="firstName" name="firstName" maxlength="255" value=<%=employee.getName().getFirstName()%> required/>
				</td>
			</tr>

			<tr>
				<td>Middle Name</td>
				<td>
					<input type="text" id="middleName" name="middleName" maxlength="255" value=<%=employee.getName().getMiddleName()%> required/>
				</td>
			</tr>

			<tr>
				<td>Last Name</td>
				<td>
					<input type="text" id="lastName" name="lastName" maxlength="255" value="<%=employee.getName().getLastName()%>" required/>
				</td>
			</tr>

			<tr>
				<td>Suffix</td>
				<td>
					<input type="text" id="suffix" name="suffix" maxlength="255" value="<%=employee.getName().getSuffix()%>" />
				</td>
			</tr>

			<tr>
				<td>Street Number</td>
				<td>
					<input type="text" id="streetNumber" name="streetNumber" maxlength="255" value=<%=employee.getAddress().getStreetNumber()%> required/>
				</td>
			</tr>	

			<tr>
				<td>Barangay</td>
				<td>
					<input type="text" id="barangay" name="barangay" maxlength="255" value=<%=employee.getAddress().getBarangay()%> required/>
				</td>
			</tr>

			<tr>
				<td>City</td>
				<td>
					<input type="text" id="city" name="city" maxlength="255" value=<%=employee.getAddress().getCity()%> required/>
				</td>
			</tr>

			<tr>
				<td>Country</td>
				<td>
					<input type="text" id="country" name="country" maxlength="255" value=<%=employee.getAddress().getCountry()%> required/>
				</td>
			</tr>

			<tr>
				<td>Zipcode</td>
				<td>
					<input type="text" id="zipcode" name="zipcode" maxlength="255" value=<%=employee.getAddress().getZipcode()%> required/>
				</td>
			</tr>			

			<tr>
				<td>Birthdate</td>
				<td>
					<input type="text" id="birthday" name="birthdate" maxlength="10" value=<%=employee.getBirthday()%> required/> (dd/mm/yyyy)
				</td>
			</tr>														

			<tr>
				<td>Grade</td>
				<td>
					<input type="text" id="gwa" name="grade" maxlength="6" value=<%=employee.getGradeWeightAverage()%> required/> 
				</td>
			</tr>

			<tr>
				<td>Employed?</td>
				<td>
					<input type="radio" id="employed" name="employed" value="true" onclick="document.getElementById('hiredate'). = false;" required>
						Yes
					</input>
					<input type="radio" id="unemployed" name="employed" value="false" onclick="document.getElementById('hiredate'). = true;" >No</input>
				</td>
			</tr>
			<tr>
				<td>Hire Date</td>
				<td>
					<input type="text" name="hiredate" id="hiredate" requiredmaxlength="10" > (dd/mm/yyyy)
				</td>
			</tr>
			<tr rowspan="2" align="center">
				<td colspan="2" align="center">
					<input type="hidden" name="employeeId" value="<%=employeeId%>"/>
					<input type="hidden" name="status" value="update"/>
					<input type="submit" value="Update"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>