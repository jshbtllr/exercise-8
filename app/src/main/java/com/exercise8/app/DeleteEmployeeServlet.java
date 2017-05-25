package com.exercise8.app;

import com.exercise8.core.service.EmployeeService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    											throws ServletException, IOException {
 		response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    String input = request.getParameter("employeeId");
	    Long employeeId = Long.parseLong(input);
	            
	    try { 
	        EmployeeService.deleteEmployee(employeeId);     
	        out.println("<html>");
	        out.println("<head>");      
	        out.println("<title>Employee Deletion</title>");    
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<center>");
            out.println("<h1>Employee Successfully deleted</h1><br/><br/>");
            out.println("<a href=employeemanagement.jsp>Back to Employee Management</a>");
	        out.println("</center>");
        	out.println("</body>");
        	out.println("</html>");
    	} finally {       
        	out.close();
    	}
    }
}