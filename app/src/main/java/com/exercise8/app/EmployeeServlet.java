package com.exercise8.app;

import com.exercise8.core.model.Roles;
import com.exercise8.core.model.Address;
import com.exercise8.core.model.ContactInfo;
import com.exercise8.core.model.Employee;
import com.exercise8.core.model.Name;
import com.exercise8.core.service.EmployeeService;
import com.exercise8.core.service.EmployeeRoleService;
import com.exercise8.core.service.ContactInfoService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Set;
import java.util.List;
import java.util.HashSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    											throws ServletException, IOException {
 		response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    //HttpSession session = request.getSession();
	    String sortOption = null;
	    String orderOption = null;
	    Integer sort = null;
	    Integer order = null;
	    List <Employee> allEmployee;
	    String employed = null;


	    try { 
		    out.println("<html>");
		    out.println("<head>");      
		    out.println("<title>Employee Management</title>");    
		    out.println("</head>");
		    out.println("<body>");
		    out.println("<h3>Employee Management</h3><h4>Current Employees</h4>");	        
			out.println("<table width=100%>");
			out.println("<td width=30% align=\"left\">");
			out.println("<a href=employee/add> Add Employee </a></td>");
			out.println("<td width=30% align=\"center\">");
			out.println("<a href=roles> Role Management </a></td>");			
			out.println("<td width=40% align=\"right\">");
			out.println("<form action=\"employee\" method=\"GET\">");
			out.println("Sort by: <select name=\"sort\">");
			out.println("<option value=\"lastname\"> Last Name </option>");
			out.println("<option value=\"gwa\"> Grade </option>");
			out.println("<option value=\"hiredate\"> Hire Date </option></select>");
			out.println("<select name=\"order\">");
			out.println("<option value=\"ascending\"> Ascending </option>");
			out.println("<option value=\"descending\"> Descending </option></select>");
			out.println("<input type=\"hidden\" name=\"status\" value=\"sort\"/>");
			out.println("<input type=\"submit\" value=\"sort\"/>");
			out.println("</form></table>");

			sortOption = request.getParameter("sort");
			orderOption = request.getParameter("order");
			if(sortOption == null) {
				sort = 4;
			} else if(sortOption.equals("lastname")) {
				sort = 1;
			} else if(sortOption.equals("gwa")) {
				sort = 2;
			} else if(sortOption.equals("hiredate")) {
				sort = 3;
			}

			if(orderOption == null) {
				order = 0;
			} else if(orderOption.equals("ascending")) {
				order = 1;
			} else if(orderOption.equals("descending")) {
				order = 2;
			}

			out.println("<div style=\"clear:both;\"></div><br/>");
			out.println("<table border =\"1\" align=\"left\"><thead><tr>");
			out.println("<th>Employee ID</th><th>Full Name</th><th>Address</th>");
			out.println("<th>Birthdate</th><th>Grade</th><th>Employed</th>");
			out.println("<th>Hire Date</th><th>Contact Info</th><th>Roles</th><th>Actions</th>");
			out.println("</tr></thead></tbody>");

			allEmployee = EmployeeService.listEmployees(sort, order);
			for(Employee employee : allEmployee) {
				out.println("<tr><td align=\"center\">" + employee.getId() + "</td>");
				out.println("<td align=\"center\">" + employee.getName().getTitle() + " " + employee.getName().getFirstName()
							+ " " + employee.getName().getMiddleName() + " " + employee.getName().getLastName() + " " 
							+ employee.getName().getSuffix() + "</td>");
				out.println("<td align=\"center\">" + employee.getAddress().getStreetNumber() + " " + employee.getAddress().getBarangay()
							+ " " + employee.getAddress().getCity() + " " + employee.getAddress().getCountry() + " " 
							+ employee.getAddress().getZipcode() + "</td>");
				out.println("<td align=\"center\">" + employee.getBirthday().toString().substring(0,10) + "</td>");
				out.println("<td align=\"center\">" + employee.getGradeWeightAverage() + "</td>");

				if(employee.getEmployed().equals(true)) {
					employed = "Yes";
					out.println("<td align=\"center\">" + employed + "</td>");
					out.println("<td align=\"center\">" + employee.getHireDate().toString().substring(0,10) + "</td>");
				} else {
					employed = "No";
					out.println("<td align=\"center\">" + employed + "</td>");
					out.println("<td align=\"center\">N/A</td>");
				}
				out.println("<td align=\"center\">None</td>");
				out.println("<td align=\"center\">None</td>");
				out.println("<td align=\"center\"><form action=\"employee\" method=\"POST\">");
				out.println("<input type=\"hidden\" name=\"employeeId\" value=\"" + employee.getId() + "\"/>");
				out.println("<input type=\"hidden\" name=\"sort\" value=\"" + sortOption + "\"/>");
				out.println("<input type=\"hidden\" name=\"order\" value=\"" + orderOption + "\"/>");
				out.println("<input type=\"submit\" value=\"Delete\"/>");
				out.println("</form></td></tr>");
			}

			out.println("</tbody></table>");
	        out.println("</body>");
	        out.println("</html>");
    	} finally {       
        	out.close();
    	}
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    											throws ServletException, IOException {
 		response.setContentType("text/html;charset=UTF-8");
 		String sortOption = request.getParameter("sort");
		String orderOption = request.getParameter("order");
		String input = null;
	    Long employeeId = null;

		input =request.getParameter("employeeId");
		employeeId = Long.parseLong(input);
		EmployeeService.deleteEmployee(employeeId);  
 	}    
}