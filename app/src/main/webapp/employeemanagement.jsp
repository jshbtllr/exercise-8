<%@page import="com.exercise8.core.service.EmployeeService"%>
<%@page import="com.exercise8.core.model.Employee"%>
<%@page import="com.exercise8.core.model.Roles"%>
<%@page import="com.exercise8.core.model.ContactInfo"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Set"%>
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

    <table width=100%>
        <td width=50% align="left">
            <a href=empregsystem.jsp>Back to Employee <br/> Registration System</a>
        </td>
        <td width=50% align="right">
            <%
                Set <Roles> roles = null;
                Set <ContactInfo> contacts = null;
                session.setAttribute("roleSet", roles);
                session.setAttribute("contactSet", contacts);
            %>
            <a href=addemployee.jsp>Add Employee</a>
            <br/>
            Sort by <form action="employeemanagement.jsp" method="GET">
                <select name="orderBy"  onchange="this.form.submit()">
                    <option disabled selected value>Select Sort Option</option>
                    <option value="lastasc">Last Name Ascending</option>
                    <option value="lastdesc">Last Name Descending</option>
                    <option value="gwaasc">Grades Ascending</option>
                    <option value="gwadesc">Grades Descending</option>
                    <option value="hiredateasc">Hire Date Ascending</option>
                    <option value="hiredatedesc">Hire Date Descending</option>
                </select>
            </form>
        </td>
    </table>
    <div style = "clear:both;"></div>
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
            <%  
                String sortOption = request.getParameter("orderBy");
                Integer sort = null;
                Integer order = null;
                try {                
                    if(sortOption.equals("lastasc")) {
                        sort = 1;
                        order = 1;
                    } else if(sortOption.equals("lastdesc")) {
                        sort = 1;
                        order = 2;
                    } else if(sortOption.equals("gwaasc")) {
                        sort = 2;
                        order = 1;
                    } else if(sortOption.equals("gwadesc")) {
                        sort = 2;
                        order = 2;
                    } else if(sortOption.equals("hiredateasc")) {
                        sort = 3;
                        order = 1;
                    } else if(sortOption.equals("hiredatedesc")) {
                        sort = 3;
                        order = 2;
                    } else {
                        sort = 4;
                        order = 0;
                    }
                } catch (NullPointerException npe) {
                    sort = 4;
                    order = 0;
                }

                List <Employee> allEmployee = EmployeeService.listEmployees(sort,order);
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
                        <input type="submit" value="Roles"/>
                    </form>    
                    <form action="empcontact.jsp" method="post">
                        <input type="hidden" name="employeeId" value="<%=employee.getId()%>"/>
                        <input type="submit" value="Contact Info"/>
                    </form>
                    <form action="updateemployee.jsp" method="post">
                        <input type="hidden" name="employeeId" value="<%=employee.getId()%>"/>
                        <input type="submit" value="Update"/>
                    </form>                    
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