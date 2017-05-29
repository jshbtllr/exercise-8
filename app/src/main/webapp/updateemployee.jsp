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
	Employee employee = EmployeeDAO.getEmployeeCollection(employeeId);
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
					<input type="radio" name="editDetail" value="name" 
					onclick="document.getElementById('firstName').disabled = false; 
						document.getElementById('lastName').disabled = false;
						document.getElementById('middleName').disabled = false; 
						document.getElementById('title').disabled = false; 
						document.getElementById('suffix').disabled = false;
						document.getElementById('streetNumber').disabled = true;
						document.getElementById('barangay').disabled = true;
						document.getElementById('city').disabled = true;
						document.getElementById('zipcode').disabled = true;
						document.getElementById('country').disabled = true;
						document.getElementById('birthday').disabled = true;
						document.getElementById('gwa').disabled = true;
						document.getElementById('employed').disabled = true;
						document.getElementById('unemployed').disabled = true;">
						Name <br/>
					<input type="radio" name="editDetail" value="address" 
					onclick="document.getElementById('firstName').disabled = true; 
						document.getElementById('lastName').disabled = true;
						document.getElementById('middleName').disabled = true; 
						document.getElementById('title').disabled = true; 
						document.getElementById('suffix').disabled = true;
						document.getElementById('streetNumber').disabled = false;
						document.getElementById('barangay').disabled = false;
						document.getElementById('city').disabled = false;
						document.getElementById('zipcode').disabled = false;
						document.getElementById('country').disabled = false;
						document.getElementById('birthday').disabled = true;
						document.getElementById('gwa').disabled = true;
						document.getElementById('employed').disabled = true;
						document.getElementById('unemployed').disabled = true;">
						Address<br/>
					<input type="radio" name="editDetail" value="birthday" 
					onclick="document.getElementById('firstName').disabled = true; 
						document.getElementById('lastName').disabled = true;
						document.getElementById('middleName').disabled = true; 
						document.getElementById('title').disabled = true; 
						document.getElementById('suffix').disabled = true;
						document.getElementById('streetNumber').disabled = true;
						document.getElementById('barangay').disabled = true;
						document.getElementById('city').disabled = true;
						document.getElementById('zipcode').disabled = true;
						document.getElementById('country').disabled = true;
						document.getElementById('birthday').disabled = false;
						document.getElementById('gwa').disabled = true;
						document.getElementById('employed').disabled = true;
						document.getElementById('unemployed').disabled = true;">
						Birthday<br/>
					<input type="radio" name="editDetail" value="gwa" 
					onclick="document.getElementById('firstName').disabled = true; 
						document.getElementById('lastName').disabled = true;
						document.getElementById('middleName').disabled = true; 
						document.getElementById('title').disabled = true; 
						document.getElementById('suffix').disabled = true;
						document.getElementById('streetNumber').disabled = true;
						document.getElementById('barangay').disabled = true;
						document.getElementById('city').disabled = true;
						document.getElementById('zipcode').disabled = true;
						document.getElementById('country').disabled = true;
						document.getElementById('birthday').disabled = true;
						document.getElementById('gwa').disabled = false;
						document.getElementById('employed').disabled = true;
						document.getElementById('unemployed').disabled = true;">
					Grade Weight Average<br/>
					<input type="radio" name="editDetail" value="employment" 
					onclick="document.getElementById('firstName').disabled = true; 
						document.getElementById('lastName').disabled = true;
						document.getElementById('middleName').disabled = true; 
						document.getElementById('title').disabled = true; 
						document.getElementById('suffix').disabled = true;
						document.getElementById('streetNumber').disabled = true;
						document.getElementById('barangay').disabled = true;
						document.getElementById('city').disabled = true;
						document.getElementById('zipcode').disabled = true;
						document.getElementById('country').disabled = true;
						document.getElementById('birthday').disabled = true;
						document.getElementById('gwa').disabled = true;
						document.getElementById('employed').disabled = false;
						document.getElementById('unemployed').disabled = false;">
					Employment Status<br/>
				</td>
			</tr>

			<tr>
				<td>Title</td>
				<td>
					<input type="text" id="title" name="title" maxlength="255" value=<%=employee.getName().getTitle()%> disabled/>
				</td>
			</tr>

			<tr>
				<td>First Name</td>
				<td>
					<input type="text" id="firstName" name="firstName" maxlength="255" value=<%=employee.getName().getFirstName()%> required disabled/>
				</td>
			</tr>

			<tr>
				<td>Middle Name</td>
				<td>
					<input type="text" id="middleName" name="middleName" maxlength="255" value=<%=employee.getName().getMiddleName()%> required disabled/>
				</td>
			</tr>

			<tr>
				<td>Last Name</td>
				<td>
					<input type="text" id="lastName" name="lastName" maxlength="255" value=<%=employee.getName().getLastName()%> required disabled/>
				</td>
			</tr>

			<tr>
				<td>Suffix</td>
				<td>
					<input type="text" id="suffix" name="suffix" maxlength="255" value=<%=employee.getName().getSuffix()%> disabled/>
				</td>
			</tr>

			<tr>
				<td>Street Number</td>
				<td>
					<input type="text" id="streetNumber" name="streetNumber" maxlength="255" value=<%=employee.getAddress().getStreetNumber()%> required disabled/>
				</td>
			</tr>	

			<tr>
				<td>Barangay</td>
				<td>
					<input type="text" id="barangay" name="barangay" maxlength="255" value=<%=employee.getAddress().getBarangay()%> required disabled/>
				</td>
			</tr>

			<tr>
				<td>City</td>
				<td>
					<input type="text" id="city" name="city" maxlength="255" value=<%=employee.getAddress().getCity()%> required disabled/>
				</td>
			</tr>

			<tr>
				<td>Country</td>
				<td>
					<input type="text" id="country" name="country" maxlength="255" value=<%=employee.getAddress().getCountry()%> required disabled/>
				</td>
			</tr>

			<tr>
				<td>Zipcode</td>
				<td>
					<input type="text" id="zipcode" name="zipcode" maxlength="255" value=<%=employee.getAddress().getZipcode()%> required disabled/>
				</td>
			</tr>			

			<tr>
				<td>Birthdate</td>
				<td>
					<input type="text" id="birthday" name="birthdate" maxlength="10" value=<%=employee.getBirthday()%> required disabled/> (dd/mm/yyyy)
				</td>
			</tr>														

			<tr>
				<td>Grade</td>
				<td>
					<input type="text" id="gwa" name="grade" maxlength="6" value=<%=employee.getGradeWeightAverage()%> required disabled/> 
				</td>
			</tr>

			<tr>
				<td>Employed?</td>
				<td>
					<input type="radio" id="employed" name="employed" value="true" onclick="document.getElementById('hiredate').disabled = false;" required disabled>
						Yes
					</input>
					<input type="radio" id="unemployed" name="employed" value="false" onclick="document.getElementById('hiredate').disabled = true;" disabled>No</input>
				</td>
			</tr>
			<tr>
				<td>Hire Date</td>
				<td>
					<input type="text" name="hiredate" id="hiredate" required maxlength="10" disabled> (dd/mm/yyyy)
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