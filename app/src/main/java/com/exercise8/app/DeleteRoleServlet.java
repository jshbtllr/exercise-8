package com.exercise8.app;

import com.exercise8.core.service.RoleService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteRoleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    											throws ServletException, IOException {
 		response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    String input = request.getParameter("roleId");
	    Long roleId = Long.parseLong(input);
	    Integer success = null;
	            
	    try { 
	        success = RoleService.removeRoles(roleId);     
	        out.println("<html>");
	        out.println("<head>");      
	        out.println("<title>Role Deletion</title>");    
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<center>");
	        if (success == 1) {
	        	out.println("<h1>Role successfully deleted</h1><br/><br/>");
	        } else {
	        	out.println("<h1>Role still belongs to an Employee</h1><br/><h3>Role was not deleted</h3><br/><br/>");
	        }
            out.println("<a href=rolemanagement.jsp>Back to Role Management</a>");
	        out.println("</center>");
        	out.println("</body>");
        	out.println("</html>");
    	} finally {       
        	out.close();
    	}
    }
}