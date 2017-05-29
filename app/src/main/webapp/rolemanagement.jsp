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
    
    <table width=50%>
        <td width=25% align="left">
            <a href=empregsystem.jsp>Back to Employee <br/> Registration System</a>
        </td>
        <td width=25% align="right">
            <a href=addrole.jsp>Add Role</a>
            <br/>
            Sort by <form action="rolemanagement.jsp" method="GET">
                <select name="orderBy"  onchange="this.form.submit()">
                    <option disabled selected value>Select Sort Option</option>
                    <option value="idasc">Role ID Ascending</option>
                    <option value="iddesc">Role ID Descending</option>
                    <option value="codeasc">Role Code Ascending</option>
                    <option value="codedesc">Role Code Descending</option>
                    <option value="nameasc">Role Name Ascending</option>
                    <option value="namedesc">Role Name Descending</option>
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
                <th>Role ID</th>
                <th>Role Code</th>
                <th>Role Name</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <% 
            String sortOption = request.getParameter("orderBy");
            Integer sort = null;
            Integer order = null;
            try {                
                if(sortOption.equals("idasc")) {
                    sort = 1;
                    order = 1;
                } else if(sortOption.equals("iddesc")) {
                    sort = 1;
                    order = 2;
                } else if(sortOption.equals("codeasc")) {
                    sort = 2;
                    order = 1;
                } else if(sortOption.equals("codedesc")) {
                    sort = 2;
                    order = 2;
                } else if(sortOption.equals("nameasc")) {
                    sort = 3;
                    order = 1;
                } else if(sortOption.equals("namedesc")) {
                    sort = 3;
                    order = 2;
                }
            } catch (NullPointerException npe) {
                sort = 1;
                order = 1;
            }            
            List <Roles> allRoles = RoleService.listRoles(sort, order);
            for(Roles list : allRoles) { 
            %>
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
            <%
            }
            %>
        </tbody>
    </table>
</body>
</html>