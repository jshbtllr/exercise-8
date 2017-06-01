package com.exercise8.app;

import com.exercise8.core.model.Roles;
import com.exercise8.core.model.Address;
import com.exercise8.core.model.ContactInfo;
import com.exercise8.core.model.Employee;
import com.exercise8.core.model.Name;
import com.exercise8.util.InputUtil;
import com.exercise8.core.service.EmployeeService;
import com.exercise8.core.service.RoleService;
import com.exercise8.core.service.ContactInfoService;
import com.exercise8.core.dao.EmployeeDAO;
import com.exercise8.core.dao.RoleDAO;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Arrays;
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
	    String bday = employee.getBirthday().toString().substring(0,10);
	    bday = bday.substring(8,10) + "/" + bday.substring(5,7) + "/" +  bday.substring(0,4);




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
	    			"maxlength=\"255\" value=\"" + bday + "\" required/> (dd/mm/yyyy)</td></tr>");

		out.println("<tr><td>Grade</td><td><input type=\"text\" name=\"gwa\"" + "maxlength=\"255\" value=\"" + 
					employee.getGradeWeightAverage() + "\" required/></td></tr>");	    

		if(employee.getEmployed() == true) {
			hire = employee.getHireDate().toString().substring(0,10);
			hire = hire.substring(8,10) + "/" + hire.substring(5,7) + "/" + hire.substring(0,4);
		} else {
			hire = "";
		} 
		
		out.println("<tr><td>Employed?</td><td><input type=\"radio\" name=\"employed\"" +
					"value =\"true\" onclick=\"document.getElementById('hiredate').disabled = false;\" required>Yes</input>");
		out.println("<input type=\"radio\" value=\"false\" name=\"employed\" onclick=\"document.getElementById('hiredate').disabled = true;\">No</input></td></tr>");
		


		out.println("<tr><td>Hire Date</td><td><input type=\"text\" id=\"hiredate\" name=\"hireDate\"" +
	    			"maxlength=\"255\" value=\"" + hire + "\"/> (dd/mm/yyyy)</td></tr>");

		out.println("<tr><td colspan=\"2\" align=\"left\">Tick the Checkbox to update current role list<br/>");
		out.println("<table border=\"1\" align=\"center\"><thead><tr><th>Role Code</th><th>Role Name</th></tr>");
		out.println("</thead><tbody>");

		List <Roles> allRoles = RoleService.listRoles(1,1);
		Set <Roles> employeeRoles = EmployeeDAO.getEmployeeCollection(employeeId).getRole();
		for(Roles list : allRoles) {
			out.println("<tr><td align=\"left\"><input type=\"checkbox\" name=\"roles\" value=" + list.getId() + " ");
			for(Roles role : employeeRoles) {
				if(list.getId().equals(role.getId())) {
					out.println("checked");
				}
			}
			out.println(">" + list.getRoleCode() + "</td>");
			out.println("<td align=\"center\">" + list.getRoleName() + "</td></tr>");
		}
		out.println("</tbody></table></td></tr><br/>");

		Set <ContactInfo> contacts = EmployeeDAO.getEmployeeCollection(employeeId).getContactInfo();

		out.println("<tr><td colspan=\"2\" align=\"left\">Edit Current Contact Info</td></tr>");
		for(ContactInfo list : contacts) {
			out.println("<tr><td><select name=\"infoType\"><option value=\"email\"");
			if(list.getInfoType().equals("email")){
				out.println("selected");
			}
			out.println(">email</option>");
			out.println("<option value=\"telephone\"");
			if(list.getInfoType().equals("telephone")){
				out.println("selected");
			}
			out.println(">telephone</option>");
			out.println("<option value=\"cellphone\"");
			if(list.getInfoType().equals("cellphone")){
				out.println("selected");
			}
			out.println(">cellphone</option>");
			out.println("</select></td><td> <input type=\"text\" name=\"infoDetail\"");
			out.println("value=\"" + list.getInfoDetail() + "\" maxlength=\"255\"/></td></tr>");
		}


		out.println("<tr rowspan=\"2\" align=\"center\"><td colspan=\"2\" align=\"center\">");
		out.println("<input type=\"hidden\" name=\"employeeId\" value=\"" + employeeId + "\"/>");
		out.println("<input type=\"submit\" value=\"Update\"/>");
		out.println("</td></tr></table></form></body></html>");
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    											throws ServletException, IOException {
 		PrintWriter out = response.getWriter();
 		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("employeeId");
	    Long employeeId = Long.parseLong(id);

	    Integer success = new Integer(1);
		Set <ContactInfo> contacts = new HashSet <ContactInfo>();
		Set <Roles> role = new HashSet <Roles>();
		Address address = null;
		Name name = null;
		Employee employee = null;
		ContactInfo info = null;
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
	    Boolean employed = Boolean.parseBoolean(request.getParameter("employed"));
	    String birth = request.getParameter("birthdate");
	    String hire = request.getParameter("hireDate");
	    String grade = request.getParameter("gwa");
	    Float gradeWeightAverage = null;
	    Date birthdate = null;
	    Date hireDate = null;
		String infoType = request.getParameter("infoType");
	    String infoDetail = request.getParameter("infoDetail");	   
	    List <String> addedRole = Arrays.asList(request.getParameterValues("roles"));



	    try {
	    	gradeWeightAverage = Float.parseFloat(grade);
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

	    info = new ContactInfo(infoType, infoDetail);
	    if(!info.getInfoDetail().equals("")) {
	    	info = ContactInfoService.checkInfo(info);
		    if(info.getInfoType().equals(" ")) {
		    	success = 5;
		    }	    	
	    }

	    if(success == 1) {
	    	name = new Name(firstName, lastName, middleName, suffix, title);
	    	address = new Address(streetNumber, barangay, city, country, zipcode);
	    	contacts.add(info);
	    	for(String add : addedRole) {
	    		Long roleId = Long.parseLong(add);
	    		Roles in = RoleDAO.get(Roles.class, roleId);
	    		role.add(in);
	    	}
	    	employee = new Employee(name, address, birthdate, gradeWeightAverage, hireDate, employed, 
					contacts, role);

	    	employee.setId(employeeId);
	    }	    
	    
	    try { 
	        out.println("<html>");
	        out.println("<head>");      
	        out.println("<title>Add Employee</title>");    
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<center>");
	        if(success == 1) {
	        	EmployeeService.updateEmployee(employee);
            	out.println("<h3>Employee Successfully added</h3>");
            } else {
            	out.println("<h3>Employee not added</h3>");
            	if(success == 2) {
            		out.println("<h3>Invalid GWA input</h3>");
            	} else if(success == 3) {
            		out.println("<h3>Invalid Hire Date input</h3>");
            	} else if(success == 4) {
            		out.println("<h3>Invalid Birthday input</h3>");
            	} else if (success == 5) {
            		out.println("<h3>Invalid Contact Info input</h3>");
            	}
            }
            out.println("<a href=/employee>Back to Employee Management</a>");
	        out.println("</center>");
        	out.println("</body>");
        	out.println("</html>");
    	} finally {       
        	out.close();
    	}			
 	}  		
}