<%@page import="com.exercise8.core.service.RoleService"%>
<%@page import="com.exercise8.core.model.Roles"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
     <title>Role Management</title>
</head>
<body>
    <h3>Role Management</h3>
    <h4>Current Roles</h4><br/>
    <table border='1' align='left'>
        <thead>
            <tr>
                <th>Role ID</th>
                <th>Role Code</th>
                <th>Role Name</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <%  List <Roles> allRoles = RoleService.listRoles(1,1);
                for(Roles list : allRoles) { %>
            <tr>
                <td style="text-align:center"><%=list.getId()%></td>
                <td style="text-align:center"><%=list.getRoleCode()%></td>
                <td style="text-align:center"><%=list.getRoleName()%></td>
                <td style="text-align:center"><a href="updaterole.jsp">Update Role</a><br/><a href="deleterole.jsp">Delete Role</a></td>
            </tr>
            <%}%>
        </tbody>
    </table>
</body>
</html>