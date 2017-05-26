package com.exercise8.app;

import com.exercise8.core.model.Roles;
import com.exercise8.core.service.RoleService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddRoleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    											throws ServletException, IOException {
 		response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    String roleCode = request.getParameter("roleCode");
	    String roleName = request.getParameter("roleName");
	    Roles role = new Roles(roleName, roleCode);
	    Integer success = null;
	            
	    try { 
	    	success = RoleService.addRoles(role);
	        out.println("<html>");
	        out.println("<head>");      
	        out.println("<title>Add Role</title>");    
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<center>");
	        if (success == 1) {
	        	out.println("<h2>Role successfully added</h2><br/><br/>");
	        } else {
	        	out.println("<h2>Role Code already exists</h2><br/><h3>Role was not added</h3><br/><br/>");
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