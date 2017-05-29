package com.exercise8.core.service;
import com.exercise8.core.model.Roles;
import com.exercise8.core.model.Address;
import com.exercise8.core.model.ContactInfo;
import com.exercise8.core.model.Employee;
import com.exercise8.core.model.Name;
import com.exercise8.util.InputUtil;
import com.exercise8.core.dao.RoleDAO;
import com.exercise8.core.dao.EmployeeDAO;
import com.exercise8.core.service.EmployeeRoleService;
import com.exercise8.core.service.ContactInfoService;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Collections;
import java.util.Comparator;

public class EmployeeService {
	public static Integer createEmployee(Employee employee) {
		EmployeeDAO.add(employee);
		return 1;
	}

	public static List <Employee> listEmployees(Integer sortFunction, Integer orderFunction) {
		List <Employee> list = EmployeeDAO.showEmployees(sortFunction, orderFunction);
		Set <Roles> roles;
		Set <ContactInfo> contacts;

		if(!list.isEmpty()) {
			if(sortFunction == 2) {
				Collections.sort(list, new gwaComparator());

				if(orderFunction == 2) {
					Collections.sort(list, Collections.reverseOrder(new gwaComparator()));						
				}
			}
		}

		return list;
	}	

	public static void deleteEmployee(Long employeeId) {
		Employee employee = new Employee();
		employee = EmployeeDAO.get(Employee.class, employeeId);

		EmployeeDAO.delete(employee);
	}

	public static void updateEmployee() {
		String lastName = new String();
		String firstName = new String();
		String middleName = new String();
		String suffix = new String();
		String title = new String();
		String streetNumber = new String();
		String barangay = new String();
		String city = new String();
		String zipcode = new String();
		String country = new String();
		Date birthdate = null;
		Date hireDate = null;
		Float gradeWeightAverage = new Float(0.0f);
		Boolean employed = false;
		Set <ContactInfo> contacts = new HashSet <ContactInfo>();
		Set <Roles> role = new HashSet <Roles>();

		System.out.println("Update Employee");
		listEmployees(4, 0);
		System.out.print("Choose Employee ID to be updated: ");
		Long employeeId = InputUtil.inputOptionCheck().longValue();
		
		while (!(EmployeeDAO.employeeCheck(employeeId))) {
			System.out.print("Employee ID chosen does not exist. Enter a valid Employee ID: ");
			employeeId = InputUtil.inputOptionCheck().longValue();
		}	

		Employee employee = EmployeeDAO.get(Employee.class, employeeId);

		System.out.println("Update Employee: ");
		System.out.println("[1]    Full Name");
		System.out.println("[2]    Address");
		System.out.println("[3]    Birthday");
		System.out.println("[4]    GWA");
		System.out.println("[5]    Employment Status");
		System.out.print("Choose information to edit: ");
		Integer option = InputUtil.inputOptionCheck(5);		

		if(option == 1) {
			System.out.print("Input New First Name: ");
			employee.getName().setFirstName(InputUtil.getRequiredInput());
			System.out.print("Input New Last Name: ");
			employee.getName().setLastName(InputUtil.getRequiredInput());
			System.out.print("Input New Middle Name: ");
			employee.getName().setMiddleName(InputUtil.getRequiredInput());
			System.out.print("Input New Suffix Name (optional): ");
			employee.getName().setSuffix(InputUtil.getOptionalInput());
			System.out.print("Input New Title Name (optional): ");
			employee.getName().setTitle(InputUtil.getOptionalInput());
		} else if(option == 2) {
			System.out.print("Input New Street Number: ");
			streetNumber = InputUtil.getRequiredInput();
			System.out.print("Input New Barangay: ");
			barangay = InputUtil.getRequiredInput();
			System.out.print("Input New City: ");
			city = InputUtil.getRequiredInput();
			System.out.print("Input New Country: ");
			country = InputUtil.getRequiredInput();
			System.out.print("Input New Zipcode: ");
			zipcode = InputUtil.getRequiredInput();	
			employee.setAddress(new Address(streetNumber, barangay, city, country, zipcode));
		} else if (option == 3) {
			System.out.print("Input New Birthdate (dd/mm/yyyy): ");
		//	employee.setBirthday(InputUtil.getDate());
		} else if (option == 4) {
			System.out.print("Input new GWA: ");
			//employee.setGradeWeightAverage(InputUtil.getGrade());
		} else {
			System.out.print("Input New Employee Status Y if Name is employed, N if not: ");
			employed = InputUtil.getStatus();
			employee.setEmployed(employed);
			hireDate = null;
			if (employed == true) {
				System.out.print("Enter Employee Hire Date in format dd/mm/yyyy: ");
				//employee.setHireDate(InputUtil.getDate());
			} else {
				try {
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					employee.setHireDate(format.parse("12/31/9999"));
				} catch(ParseException pe) {
					pe.printStackTrace();
				}
			}	
		}
		EmployeeDAO.update(employee);
	}
}

class gwaComparator implements Comparator <Employee> {
	public int compare(Employee a, Employee b) {
		return a.getGradeWeightAverage() < b.getGradeWeightAverage() ? -1 : a.getGradeWeightAverage() == b.getGradeWeightAverage() ? 0 : 1;
	}
}