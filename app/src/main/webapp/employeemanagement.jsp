<%@page import="com.exercise8.core.service.EmployeeService"%>
<%@page import="com.exercise8.core.model.Employee"%>
<%@page import="java.util.Date"%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
     <title>Employee Management</title>
</head>
<body>
    <h3>Employee Management</h3>
    <h4>Current Employees</h4><br/>
    <div>
    <a href=empregsystem.jsp>Back to Employee <br/> Registration System</a></td>
    &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a align="right" href=addemployee.jsp>Add Employee</a>
    </div>
    <br/>
    <br/>    
    <table border='1' align='left'>
        <thead>
            <tr>
                <th>Employee ID</th>
                <th>Full Name</th>
                <th>Address</th>
                <th>Birthdate</th>
                <th>Grade</th>
                <th>Employed</th>
                <th>Hire Date</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <%  List <Employee> allEmployee = EmployeeService.listEmployees(1,1);
                for(Employee employee : allEmployee) { 
                    String employed = null;

                    if(employee.getEmployed().equals(true)) {
                        employed = "Yes";
                    } else {
                        employed = "No";
                    } %>
            <tr>
                <td style="text-align:center"><%=employee.getId()%></td>
                <td style="text-align:center"><%=employee.getName().getTitle()%> <%=employee.getName().getFirstName()%> <%=employee.getName().getMiddleName()%> <%=employee.getName().getLastName()%> <%=employee.getName().getSuffix()%></td>
                <td style="text-align:center"><%=employee.getAddress().getStreetNumber()%> <%=employee.getAddress().getBarangay()%> <%=employee.getAddress().getCity()%> <%=employee.getAddress().getCountry()%> <%=employee.getAddress().getZipcode()%></td>
                <td style="text-align:center"><%=employee.getBirthday().toString().substring(0,10)%></td>
                <td style="text-align:center"><%=employee.getGradeWeightAverage()%></td>
                <td style="text-align:center"><%=employed%></td>
                <td style="text-align:center">
                    <% if(employed.equals("Yes")) {
                        out.print(employee.getHireDate().toString().substring(0,10));
                    } else {
                        out.print("N/A");
                    }%>
                </td>
                <td style="text-align:center">
                    <form action="showemproles.jsp" method="post">
                        <input type="hidden" name="employeeId" value="<%=employee.getId()%>"/>
                        <input type="submit" value="Show Roles"/>
                    </form>    
                    <form action="empcontact.jsp" method="post">
                        <input type="hidden" name="employeeId" value="<%=employee.getId()%>"/>
                        <input type="submit" value="Show Contact Info"/>
                    </form>
                    <a href="updateemployee.jsp">Update Employee</a><br/>
                    <form action="DeleteEmployeeServlet" method="post">
                        <input type="hidden" name="employeeId" value="<%=employee.getId()%>"/>
                        <input type="submit" value="Delete"/>
                    </form>
                </td>
            </tr>
            <%}%>
        </tbody>
    </table>
</body>
</html>