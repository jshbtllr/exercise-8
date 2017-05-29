package com.exercise8.app;

import com.exercise8.core.model.Roles;
import com.exercise8.core.model.Address;
import com.exercise8.core.model.ContactInfo;
import com.exercise8.core.model.Employee;
import com.exercise8.core.model.Name;
import com.exercise8.core.dao.EmployeeDAO;
import com.exercise8.util.InputUtil;
import com.exercise8.core.service.EmployeeService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    											throws ServletException, IOException {
 		response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    Integer success = new Integer(0);
	    Boolean dateFlag = true;
		Set <ContactInfo> contacts = null;
		Set <Roles> role = null;
		Address address = null;
		Name name = null;
		Employee employee = null;
	    String title = request.getParameter("title");
	    String firstName = request.getParameter("firstName");
	    String middleName = request.getParameter("middleName");
	    String lastName = request.getParameter("lastName");
	    String suffix = request.getParameter("suffix");
	    String streetNumber = request.getParameter("streetNumber");
	    String barangay = request.getParameter("barangay");
	    String city = request.getParameter("city");
	    String country = request.getParameter("country");
	    String zipcode = request.getParameter("zipcode");
	    Float gradeWeightAverage = null;
	    Date birthdate = null;
		String date = null;


		String id = request.getParameter("employeeId");
		Long employeeId = Long.parseLong(id);
		employee = EmployeeDAO.getEmployeeCollection(employeeId);
		String updateDetail = request.getParameter("editDetail");

		if(updateDetail.equals("name")) {
			employee.getName().setFirstName(firstName);
			employee.getName().setLastName(lastName);
			employee.getName().setTitle(title);
			employee.getName().setSuffix(suffix);
			employee.getName().setMiddleName(middleName);
		} else if(updateDetail.equals("address")) {
			employee.getAddress().setStreetNumber(streetNumber);
			employee.getAddress().setBarangay(barangay);
			employee.getAddress().setCity(city);
			employee.getAddress().setCountry(country);
			employee.getAddress().setZipcode(zipcode);
		} else if(updateDetail.equals("birthday")) {
		    date = request.getParameter("birthdate");
		    dateFlag = InputUtil.checkDate(date);
		    if(dateFlag == true) {
				birthdate = InputUtil.getDate(date);	    	
		    } else {
		    	success = 4;
		    }			
			employee.setBirthday(birthdate);
		} else if(updateDetail.equals("gwa")) {
		    try {
			    String grade = request.getParameter("grade");
			    gradeWeightAverage = Float.parseFloat(grade);
			    Boolean check = InputUtil.checkGrade(gradeWeightAverage);
			    if (check == false) {
			    	success = 3;
			    } 
			} catch (NumberFormatException npe) {
				success = 3;
			}			
			employee.setGradeWeightAverage(gradeWeightAverage);
		} else if(updateDetail.equals("employment")) {
		    String employ = request.getParameter("employed");
		    Boolean employed = Boolean.parseBoolean(employ);
		    Date hireDate = null;
		    
		    if(employed == true) {
		    	date = request.getParameter("hiredate");
		    } else if (employed == false) {
		    	date = "31/12/9999";
		    }

		    dateFlag = InputUtil.checkDate(date);
		    if(dateFlag == true) {
		    	hireDate= InputUtil.getDate(date);
		    } else {
		    	success = 2;
		    }  			
			employee.setEmployed(employed);
			employee.setHireDate(hireDate);
		}	  
	            
	    try { 
			if(success == 0) {
				success = EmployeeService.updateEmployee(employee);
			}	    	
	        out.println("<html>");
	        out.println("<head>");      
	        out.println("<title>Add Employee</title>");    
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<center>");
	        if (success == 1) {
	        	out.println("<h2>Employee successfully updated</h2><br/><br/>");
	        } else if(success == 2) {
	        	out.println("<h2>Invalid Hire Date input. Employee not updated</h2><br/><br/>");
	        } else if(success == 3) {
	        	out.println("<h2>Invalid Grade input. Employee not updated</h2><br/><br/>");
	        } else if (success == 4) {
	        	out.println("<h2>Invalid Birthday input. Employee not updated</h2><br/><br/>");
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