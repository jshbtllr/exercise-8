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
	public static void createEmployee(Employee employee) {
		EmployeeDAO.add(employee);
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

	public static Integer updateEmployee(Employee employee) {
		EmployeeDAO.update(employee);
		return 1;
	}
}

class gwaComparator implements Comparator <Employee> {
	public int compare(Employee a, Employee b) {
		return a.getGradeWeightAverage() < b.getGradeWeightAverage() ? -1 : a.getGradeWeightAverage() == b.getGradeWeightAverage() ? 0 : 1;
	}
}