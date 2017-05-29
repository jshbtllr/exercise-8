<%@page import="com.exercise8.core.dao.EmployeeDAO"%>
<%@page import="com.exercise8.core.model.Employee"%>
<%@page import="java.util.List"%>
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
	Employee employee = EmployeeDAO.get(Employee.class, employeeId);
	%>
	<h3>Update Employee <%=employee.getName().getFirstName()%> <%=employee.getName().getLastName()%>'s Details</h3>
	<br/>
    <div>
    <a href=employeemanagement.jsp>Back to Employee <br/> Management</a></td>
    </div>
    <br/>
    <br/>	
	<h4>Choose below Employee Details to update</h4>
	<form action="UpdateEmployeeServlet" method="POST">
		<table align="left" cellpadding="8">
			<tr>
				<td>
					<input type="checkbox" name="editDetail" value="name" 
					onclick="document.getElementByName('firstName').disabled = false; 
					document.getElementByName('lastName').disabled = false;
					document.getElementByName('middleName').disabled = false; 
					document.getElementByName('title').disabled = false; 
					document.getElementByName('suffix').disabled = false;">Name<br/>
					<input type="checkbox" name="editDetail" value="address" 
					onclick="document.getElementByName('address').disabled = false;
					document.getElementByName('streetNumber').disabled = false;
					document.getElementByName('barangay').disabled = false;
					document.getElementByName('city').disabled = false;
					document.getElementByName('zipcode').disabled = false;
					document.getElementByName('country').disabled = false;">Address<br/>
					<input type="checkbox" name="editDetail" value="birthday" onclick="document.getElementById('birthday').disabled = false;">Birthday<br/>
					<input type="checkbox" name="editDetail" value="gwa" onclick="document.getElementById('gwa').disabled = false;">Grade Weight Average<br/>
					<input type="checkbox" name="editDetail" value="employment" onclick="document.getElementById('employment').disabled = false;">Employment Status<br/>
				</td>
			</tr>

			<tr>
				<td>Title</td>
				<td>
					<input type="text" name="title" maxlength="255" required disabled/>
				</td>
			</tr>

			<tr>
				<td>First Name</td>
				<td>
					<input type="text" name="firstName" maxlength="255" required disabled/>
				</td>
			</tr>

			<tr>
				<td>Middle Name</td>
				<td>
					<input type="text" name="middleName" maxlength="255" required disabled/>
				</td>
			</tr>

			<tr>
				<td>Last Name</td>
				<td>
					<input type="text" name="lastName" maxlength="255" required disabled/>
				</td>
			</tr>

			<tr>
				<td>Suffix</td>
				<td>
					<input type="text" name="suffix" maxlength="255" disabled/>
				</td>
			</tr>

			<tr>
				<td>Street Number</td>
				<td>
					<input type="text" name="streetNumber" maxlength="255" required disabled/>
				</td>
			</tr>	

			<tr>
				<td>Barangay</td>
				<td>
					<input type="text" name="barangay" maxlength="255" required disabled/>
				</td>
			</tr>

			<tr>
				<td>City</td>
				<td>
					<input type="text" name="city" maxlength="255" required disabled/>
				</td>
			</tr>

			<tr>
				<td>Country</td>
				<td>
					<input type="text" name="country" maxlength="255" required disabled/>
				</td>
			</tr>

			<tr>
				<td>Zipcode</td>
				<td>
					<input type="text" name="zipcode" maxlength="255" required disabled/>
				</td>
			</tr>			

			<tr>
				<td>Birthdate</td>
				<td>
					<input type="text" id="birthday" name="birthdate" maxlength="10" required disabled/> (dd/mm/yyyy)
				</td>
			</tr>														

			<tr>
				<td>Grade</td>
				<td>
					<input type="text" id="gwa" name="grade" maxlength="6" required disabled/> 
				</td>
			</tr>

			<tr>
				<td>Employed?</td>
				<td>
					<input type="radio" id="employment" name="employed" value="true" onclick="document.getElementById('hiredate').disabled = false;" required disabled>
						Yes
					</input>
					<input type="radio" id="employment" name="employed" value="false" onclick="document.getElementById('hiredate').disabled = true;" disabled>No</input>
				</td>
			</tr>
			<tr>
				<td>Hire Date</td>
				<td>
					<input type="text" name="hiredate" id="hiredate" required maxlength="10" disabled> (dd/mm/yyyy)
				</td>
			</tr>
		</table>
	</form>
</body>
</html>