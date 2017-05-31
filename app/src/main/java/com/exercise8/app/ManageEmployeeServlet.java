package com.exercise8.app;

import com.exercise8.core.model.Roles;
import com.exercise8.core.model.Address;
import com.exercise8.core.model.ContactInfo;
import com.exercise8.core.model.Employee;
import com.exercise8.core.model.Name;
import com.exercise8.util.InputUtil;
import com.exercise8.core.service.EmployeeService;
import com.exercise8.core.service.EmployeeRoleService;
import com.exercise8.core.service.ContactInfoService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManageEmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    											throws ServletException, IOException {
 		response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();

	    try { 
		    out.println("<html>");
		    out.println("<head>");      
		    out.println("<title>Add Employee</title>");
		    out.println("</head>");
		    out.println("<body>");
		    out.println("<h3>Add Employee</h3><br/>");	        
	        out.println("</body>");
	        out.println("</html>");
    	} finally {       
        	out.close();
    	}
    }
}