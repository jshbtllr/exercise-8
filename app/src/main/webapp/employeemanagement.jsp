<%@page import="com.exercise8.core.service.EmployeeService"%>
<%@page import="com.exercise8.core.model.Employee"%>
<%@page import="com.exercise8.core.model.Address"%>
<%@page import="com.exercise8.core.model.Name"%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
     <title>Employee Management</title>
</head>
<body>
    <h3>Employee Management</h3>
    <h4>Current Employee</h4><br/>
    <table border='1' align='left'>
        <thead>
            <tr>
                <th>Employee ID</th>
                <th>Full Name</th>
            </tr>
        </thead>
        <tbody>
            <%  List <Employee> allEmployee = EmployeeService.listEmployees(1,1);
                for(Employee employee : allEmployee) { %>
            <tr>
                <td style="text-align:center"><%=employee.getId()%></td>
                <td style="text-align:center"><%=employee.getName().getTitle()%> <%=employee.getName().getFirstName()%> <%=employee.getName().getMiddleName()%> <%=employee.getName().getLastName()%> <%=employee.getName().getSuffix()%></td>
            </tr>
            <%}%>
        </tbody>
    </table>
</body>
</html>