<%@page import="com.exercise8.core.dao.EmployeeDAO"%>
<%@page import="com.exercise8.core.model.Employee"%>
<%@page import="com.exercise8.core.model.Roles"%>
<%@page import="com.exercise8.core.model.ContactInfo"%>
<%@page import="com.exercise8.core.service.RoleService"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
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
    <%
    	Set <Roles> roles = (Set <Roles>) session.getAttribute("roleSet");
    	Set <ContactInfo> contacts = (Set <ContactInfo>) session.getAttribute("contactSet");
    %>
	<form action="AddEmployeeServlet" method="POST">
		<table align="left" cellpadding="8" onLoad="document.getElementById('hiredate').disabled = true;">
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
				<td>Grade</td>
				<td>
					<input type="text" name="grade" maxlength="6" required/> 
				</td>
			</tr>

			<tr>
				<td>Employed?</td>
				<td>
					<input type="radio" name="employed" value="true" onclick="document.getElementById('hiredate').disabled = false;" required>
						Yes
					</input>
					<input type="radio" name="employed" value="false" onclick="document.getElementById('hiredate').disabled = true;">
						No
					</input>
				</td>
			</tr>
			<tr>
				<td>Hire Date</td>
				<td>
					<input type="text" name="hiredate" id="hiredate" required maxlength="10" disabled> (dd/mm/yyyy)
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
                    <form action="createroleset.jsp" method="post">
                    	Add Role ID: <input type="text" id="newrole" name="role">
                    	<br/>
                        <input type="button" value="Add Roles"/>
                    </form>
			
					<br/>
				    <table border='1' align='center'>
				        <thead>
				            <tr>
				                <th>Role ID</th>
				                <th>Role Code</th>
				                <th>Role Name</th>
				            </tr>
				        </thead>
				        <tbody>
						<%
							List <Roles> allRoles = RoleService.listRoles(1, 1);
			            	for(Roles list : allRoles) { 
            			%>				        	
			            	<tr>
			                	<td style="text-align:center"><%=list.getId()%></td>
			                	<td style="text-align:center"><%=list.getRoleCode()%></td>
			                	<td style="text-align:center"><%=list.getRoleName()%></td>
							</tr>
						<%
							}
						%>							
						</tbody>
					</table>
				</td>
			<tr rowspan="2" align="center">
				<td colspan="2" align="center">
					<input type="hidden" name="status" value="add"/>
					<input type="submit" value="Add Employee"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>