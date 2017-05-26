<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
     <title>Update Contact Info</title>
</head>
<body>
    <%
    String id = request.getParameter("employeeId");
    Long employeeId = Long.parseLong(id);
    String infoType = request.getParameter("infoType");
    String infoDetail = request.getParameter("infoDetail");
    String status = request.getParameter("status");
    %>
    <h3>Update Role Form</h3>
    <form action="ContactInfoServlet" method="POST">
        <table align="left" cellpadding="8">
            <tr>
                <td>Contact Info Type</td>
                <td>
                    <%=infoType%>
                </td>
            </tr>
            <tr>
                <td>Contact Info Detail</td>
                <td>
                    <input type="text" name="newInfoDetail" value=<%=infoDetail%> maxlength="255"/>
                </td>
            </tr>
            <tr rowspan="2" align="center">
                <td colspan="2" align="center">
                    <input type="hidden" name="employeeId" value="<%=employeeId%>"/>
                    <input type="hidden" name="infoDetail" value="<%=infoDetail%>"/>
                    <input type="hidden" name="infoType" value="<%=infoType%>"/>
                    <input type="hidden" name="status" value="<%=status%>"/>
                    <input type="submit" value="Update"/>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>