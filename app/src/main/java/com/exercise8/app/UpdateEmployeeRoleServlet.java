package com.exercise8.app;

import com.exercise8.core.model.Roles;
import com.exercise8.core.service.EmployeeRoleService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateEmployeeRoleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    											throws ServletException, IOException {
 		response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    String input = request.getParameter("roleId");
	    Long roleId = Long.parseLong(input);
	    input = request.getParameter("employeeId");
	    Long employeeId = Long.parseLong(input);
	    String status = request.getParameter("status");
	    Integer success = null;
	            
	    try { 
	    	if(status.equals("1")) {
	    		success = EmployeeRoleService.addRemoveEmployeeRoles(1, employeeId, roleId);
	        	out.println("<html>");
	        	out.println("<head>");      
	        	out.println("<title>Add Employee Role</title>");    
		        out.println("</head>");
		        out.println("<body>");
	    	    out.println("<center>");
		        if (success == 1) {
		        	out.println("<h2>Role successfully added to Employee</h2><br/><br/>");
	    	    } else {
	        		out.println("<h2>Role not added to Employee</h2><br/><br/>");
	        	}
	        } else {
	        	EmployeeRoleService.addRemoveEmployeeRoles(2, employeeId, roleId);
	        	out.println("<html>");
	        	out.println("<head>");      
	        	out.println("<title>Remove Employee Role</title>");    
		        out.println("</head>");
		        out.println("<body>");
	    	    out.println("<center>");
		        out.println("<h2>Role successfully removed</h2><br/><br/>");

	        }
	        out.println("<a href=employeemanagement.jsp>Back to Employee Management</a>");
	        out.println("</center>");	        
        	out.println("</body>");
        	out.println("</html>");
    	} finally {       
        	out.close();
    	}
    }
}