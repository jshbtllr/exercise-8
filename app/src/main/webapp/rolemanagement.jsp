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
    <div>
    <a href=empregsystem.jsp>Back to Employee <br/> Registration System</a></td>
    &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a align="right" href=addrole.jsp>Add Role</a>
    </div>
    <br/>
    <br/>
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
                <td style="text-align:center">
                    <form action="updateroleform.jsp" method="post">
                        <input type="hidden" name="roleId" value="<%=list.getId()%>"/>
                        <input type="submit" value="Update"/>
                    </form>               
                    <form action="DeleteRoleServlet" method="post">
                        <input type="hidden" name="roleId" value="<%=list.getId()%>"/>
                        <input type="submit" value="Delete"/>
                    </form>
                </td>
            </tr>
            <%}%>
        </tbody>
    </table>
</body>
</html>