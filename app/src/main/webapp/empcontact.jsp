<%@page import="com.exercise8.core.model.Employee"%>
<%@page import="com.exercise8.core.dao.EmployeeDAO"%>
<%@page import="com.exercise8.core.model.ContactInfo"%>
<%@page import="java.util.Set"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
     <title>Employee Contact Info</title>
</head>
<body>
	<%
	String id = request.getParameter("employeeId");
	Long employeeId = Long.parseLong(id);
	Employee employee = EmployeeDAO.getEmployeeCollection(employeeId);
	Set <ContactInfo> list = employee.getContactInfo();
	session.setAttribute("id", id);
	%>
	<h3>Employee <%=employee.getName().getFirstName()%> <%=employee.getName().getLastName()%>'s Contact Information List</h3>
	<br/>
    <div>
    <a href=employeemanagement.jsp>Back to Employee <br/> Management</a></td>
    &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a align="right" href=addempcontact.jsp>Add Contacts</a>
    </div>
    <br/>
    <br/>		
	<table border="1" align="left" cellpadding="5">
		<thead>
			<tr>
				<th>Info Type</th>
				<th>Info Details</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<%for(ContactInfo contact : list) {%>
			<tr>
				<td style="text-align:center"><%=contact.getInfoType()%></td>
                <td style="text-align:center"><%=contact.getInfoDetail()%></td>
                <td style="text-align:center">
                    <form action="DeleteContactInfoServlet" method="post">
                        <input type="submit" value="Delete"/>
                    </form>
                    <form action="UpdateContactInfoServlet" method="post">
                        <input type="submit" value="Update"/>
                    </form>                    
                </td>
            </tr>
            <%}%>
		</tbody>
	</table>
</body>
</html>