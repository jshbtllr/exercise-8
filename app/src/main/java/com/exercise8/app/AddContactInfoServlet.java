package com.exercise8.app;

import com.exercise8.core.model.ContactInfo;
import com.exercise8.core.service.ContactInfoService;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddContactInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    											throws ServletException, IOException {
 		response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    String infoType = request.getParameter("infoType");
	    String infoDetail = request.getParameter("infoDetail");
	    String input = request.getParameter("employeeId");
	    Long employeeId = Long.parseLong(input);
	    Integer success = null;
	    ContactInfo contact = new ContactInfo(infoType, infoDetail);
	            
	    try { 
	    	success = ContactInfoService.addContactInfo(employeeId, contact);
	        out.println("<html>");
	        out.println("<head>");      
	        out.println("<title>Add Contact Info</title>");    
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<center>");
	        if (success == 1) {
	        	out.println("<h2>Contact Info successfully added</h2><br/><br/>");
	        } else {
	        	out.println("<h2>Contact Info was not added</h2><br/><br/>");
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