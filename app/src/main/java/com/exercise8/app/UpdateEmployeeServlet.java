package com.exercise8.app;

import com.exercise8.core.model.Roles;
import com.exercise8.core.model.Address;
import com.exercise8.core.model.ContactInfo;
import com.exercise8.core.model.Employee;
import com.exercise8.core.model.Name;
import com.exercise8.util.InputUtil;
import com.exercise8.core.service.EmployeeService;
import com.exercise8.core.dao.EmployeeDAO;
import java.util.Date;
import java.util.Set;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateEmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    											throws ServletException, IOException {
 		response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    String id = request.getParameter("employeeId");
	    Long employeeId = Long.parseLong(id);
	    Employee employee = EmployeeDAO.getEmployeeCollection(employeeId);
	    String checked = null;
	    String hire = null;


	    out.println("<html><head><title>Update Employee</title></head><body>");
	    out.println("<h3> Update Employee " + employee.getName().getFirstName() + 
	    			" " + employee.getName().getLastName() + "'s Details</h3><br/>");
	    out.println("<a href=\"/employee\">Back to Employee<br/>Management</a><br/>");
	    out.println("<form action=\"/employee/update\" method=\"POST\">");
	    out.println("<table align=left cellpadding=8>");

	    out.println("<tr><td>Title</td><td><input type=\"text\" name=\"title\"" +
	    			"maxlength=\"255\" value=\"" + employee.getName().getTitle() +
	    			"\"/></td></tr>");
	    
	    out.println("<tr><td>First Name</td><td><input type=\"text\" name=\"firstName\"" +
	    			"maxlength=\"255\" value=\"" + employee.getName().getFirstName() +
	    			"\" required/></td></tr>");

	    out.println("<tr><td>Middle Name</td><td><input type=\"text\" name=\"middleName\"" +
	    			"maxlength=\"255\" value=\"" + employee.getName().getMiddleName() +
	    			"\" required/></td></tr>");

	    out.println("<tr><td>Last Name</td><td><input type=\"text\" name=\"lastName\"" +
	    			"maxlength=\"255\" value=\"" + employee.getName().getLastName() +
	    			"\" required/></td></tr>");

	    out.println("<tr><td>Suffix</td><td><input type=\"text\" name=\"suffix\"" +
	    			"maxlength=\"255\" value=\"" + employee.getName().getSuffix() +
	    			"\"/></td></tr>");

	    out.println("<tr><td>Street Number</td><td><input type=\"text\" name=\"streetNumber\"" +
	    			"maxlength=\"255\" value=\"" + employee.getAddress().getStreetNumber() +
	    			"\" required/></td></tr>");

	    out.println("<tr><td>Barangay</td><td><input type=\"text\" name=\"barangay\"" +
	    			"maxlength=\"255\" value=\"" + employee.getAddress().getBarangay() +
	    			"\" required/></td></tr>");

	    out.println("<tr><td>City</td><td><input type=\"text\" name=\"city\"" +
	    			"maxlength=\"255\" value=\"" + employee.getAddress().getCity() +
	    			"\" required/></td></tr>");

	    out.println("<tr><td>Country</td><td><input type=\"text\" name=\"country\"" +
	    			"maxlength=\"255\" value=\"" + employee.getAddress().getCountry() +
	    			"\" required/></td></tr>");

	    out.println("<tr><td>Zipcode</td><td><input type=\"text\" name=\"zipcode\"" +
	    			"maxlength=\"255\" value=\"" + employee.getAddress().getZipcode() +
	    			"\" required/></td></tr>");

	    out.println("<tr><td>Birthdate</td><td><input type=\"text\" name=\"birthdate\"" +
	    			"maxlength=\"255\" value=\"" + employee.getBirthday().toString().substring(0,10) + "\" required/> (dd/mm/yyyy)</td></tr>");

		out.println("<tr><td>Grade</td><td><input type=\"text\" name=\"gwa\"" + "maxlength=\"255\" value=\"" + 
					employee.getGradeWeightAverage() + "\" required/></td></tr>");	    

		if(employee.getEmployed() == true) {
			hire = employee.getHireDate().toString().substring(0,10);
		} else {
			hire = "";
		} 
		
		out.println("<tr><td>Employed?</td><td><input type=\"radio\" name=\"employed\"" +
					"value =\"true\" required>Yes</input> <input type=\"radio\" value=\"false\" name=\"employed\"" +
					">No</input></td></tr>");
		


		out.println("<tr><td>Hire Date</td><td><input type=\"text\" id=\"hiredate\" name=\"hireDate\"" +
	    			"maxlength=\"255\" value=\"" + hire + "\"/> (dd/mm/yyyy)</td></tr>");


		out.println("<tr rowspan=\"2\" align=\"center\"><td colspan=\"2\" align=\"center\">");
		out.println("<input type=\"hidden\" name=\"employeeId\" value=\"" + employeeId + "\"/>");
		out.println("<input type=\"submit\" value=\"Update\"/>");
		out.println("</td></tr></table></form></body></html>");
	}

    /*protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    											throws ServletException, IOException {
 		PrintWriter out = response.getWriter();
 		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("employeeId");
	    Long employeeId = Long.parseLong(id);

	    Integer success = new Integer(1);
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
	    String employmentStatus = request.getParameter("employed");
	    Boolean employed = Boolean.parseBoolean(request.getParameter(employed));
	    String birth = request.getParameter(birthdate);
	    String hire = request.getParameter("hireDate");
	    String grade = request.getParameter("gwa");
	    Float gradeWeightAverage = null;
	    Date birthdate = null;
	    Date hireDate = null;

	    try {
	    	gradeWeightAverage = Long.parseLong(grade);
	    } catch (NumberFormatException nfe) {
	    	success = 2;
	    }

	    if(success != 2) {
	    	if(!InputUtil.checkGrade(gradeWeightAverage)) {
	    		success = 2;
	    	}
	    }

	    if(employed) {
	    	if(InputUtil.checkDate(hire)) {
	    		hireDate = InputUtil.getDate(hire);
	    	} else {
	    		success = 3;
	    	}
	    } else {
	    	hireDate = InputUtil.getDate("31/12/9999");
	    }

	    if(InputUtil.checkDate(birth)) {
	    	birthdate = InputUtil.getDate(birth);
	    } else {
	    	success = 4;
	    }
	    
	    try { 
	        out.println("<html>");
	        out.println("<head>");      
	        out.println("<title>Employee Update</title>");    
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<center>");
            out.println("<h1>Employee Successfully deleted</h1><br/><br/>");
            out.println("<a href=employee>Back to Employee Management</a>");
	        out.println("</center>");
        	out.println("</body>");
        	out.println("</html>");
    	} finally {       
        	out.close();
    	}		
 	} */  		
}