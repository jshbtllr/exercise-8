package com.exercise8.core.service;
import com.exercise8.core.model.ContactInfo;
import com.exercise8.core.model.Employee;
import com.exercise8.util.InputUtil;
import com.exercise8.core.dao.EmployeeDAO;
import java.util.Set;
import java.util.Iterator;
import org.apache.commons.validator.routines.EmailValidator;

public class ContactInfoService {
	public static Integer addContactInfo(Long employeeId, ContactInfo addInfo) {
		Employee employee = null;
		Set <ContactInfo> contacts;
		Integer contactCount = null;

		employee = EmployeeDAO.getEmployeeCollection(employeeId);
		contacts = employee.getContactInfo();	
		contactCount = contacts.size();

		contacts = addContactSet(contacts, employee, addInfo);

		employee.setContactInfo(contacts);
		EmployeeDAO.update(employee);
		
		if(contacts.size() == contactCount) {
			return 0;
		} else {
			return 1;
		}		
	}


	public static Set <ContactInfo> addContactSet(Set <ContactInfo> contacts, Employee employee, ContactInfo addInfo) {	
		Boolean exist = false;

		addInfo = checkInfo(addInfo);

		if(addInfo.getInfoType().equals(" ")) {
			return contacts;
		} else {

			if(contacts.isEmpty()) {
				contacts.add(addInfo); 			
			} else {
				for(ContactInfo list : contacts) {
					if(list.getInfoDetail().equals(addInfo.getInfoDetail())) {
						exist = true;
					}
				}
				if(!exist) {
					contacts.add(addInfo);		
				}
			}
		}
		return contacts;
	}

	public static ContactInfo checkInfo(ContactInfo addInfo) {
		if(addInfo.getInfoType().equals("email")) {
			if(!EmailValidator.getInstance().isValid(addInfo.getInfoDetail())) {
				addInfo.setInfoType(" ");
			}
		} else if(addInfo.getInfoType().equals("telephone")) {
			if(!addInfo.getInfoDetail().matches("^[1-9]{1}\\d{6}")) {
				addInfo.setInfoType(" ");
			}
		} else if(addInfo.getInfoType().equals("cellphone")) {
			if(!addInfo.getInfoDetail().matches("^09\\d{9}")) {
				addInfo.setInfoType(" ");
			}			
		}

		return addInfo;		
	}

	public static void removeContactInfo() {
		EmployeeService.listEmployees(4, 0);
		String information;
		Long employeeId;
		Employee employee;
		Boolean exist = false;
		Set <ContactInfo> contacts = null;
		Iterator <ContactInfo> iterator = null;

		System.out.print("Delete a contact info from which employee: ");
		employeeId = InputUtil.inputOptionCheck().longValue();

		while (!(EmployeeDAO.employeeCheck(employeeId))) {
			System.out.print("Employee ID chosen does not exist. Enter a new employee id to delete: ");
			employeeId = InputUtil.inputOptionCheck().longValue();
		}

		employee = EmployeeDAO.getEmployeeCollection(employeeId);
		contacts = employee.getContactInfo();

		System.out.print("Employee has ");

		if(!contacts.isEmpty()) {
			System.out.println("the below Contact Info: ");
			for(ContactInfo list : contacts) {
				System.out.println("Contact Info Type: " + list.getInfoType());
				System.out.println("Contact Info: " + list.getInfoDetail());
				System.out.println("-------------------");
			}
			System.out.print("Input the Contact Info to remove: ");
			information = InputUtil.getRequiredInput();

			iterator = contacts.iterator();
			while(iterator.hasNext()) {
				if(information.equals(iterator.next().getInfoDetail())) {
					exist = true;
					iterator.remove();
				}
			}

			employee.setContactInfo(contacts);
			EmployeeDAO.update(employee);

			if(!exist) {
				System.out.println("Contact Info given not assigned to employee");
			}	
		} else {
			System.out.println("no Contact Info to delete");
		}

	}

	public static void updateContactInfo() {
		EmployeeService.listEmployees(4, 0);
		Long employeeId;
		Employee employee;
		Boolean exist = false;
		String information;
		ContactInfo newInfo = null;
		Set <ContactInfo> contacts = null;
		Iterator <ContactInfo> iterator = null;		

		EmployeeService.listEmployees(4, 0);
		System.out.print("Add contact info to which employee: ");
		employeeId = InputUtil.inputOptionCheck().longValue();

		while (!(EmployeeDAO.employeeCheck(employeeId))) {
			System.out.print("Employee ID chosen does not exist. Enter a new employee id to delete: ");
			employeeId = InputUtil.inputOptionCheck().longValue();
		}	

		employee = EmployeeDAO.getEmployeeCollection(employeeId);
		contacts = employee.getContactInfo();

		System.out.print("Employee has ");

		if(!contacts.isEmpty()) {
			System.out.println("the below Contact Info: ");
			for(ContactInfo list : contacts) {
				System.out.println("Contact Info Type: " + list.getInfoType());
				System.out.println("Contact Info: " + list.getInfoDetail());
				System.out.println("-------------------");
			}
			System.out.print("Input the Contact Info to update: ");
			information = InputUtil.getRequiredInput();
			
			for(ContactInfo list : contacts) {
				if(information.equals(list.getInfoDetail())) {
					Integer option = null;
					if (list.getInfoType().equals("email")) {
						option = 1;
					} else if (list.getInfoType().equals("telephone")) {
						option = 2;
					} else {
						option = 3;
					}

					exist = true;
					System.out.print("Input new contact detail: ");
					String infoDetail = InputUtil.getRequiredInput();
					//newInfo = checkInfo(infoDetail, option);					
					list.setInfoDetail(newInfo.getInfoDetail());
				}
			}

			employee.setContactInfo(contacts);
			EmployeeDAO.update(employee);

			if(!exist) {
				System.out.println("Contact Info not assigned to employee");
			}

		} else {
			System.out.println("no contact information");
		}		
	}

	public static void listContactInfo() {
		EmployeeService.listEmployees(4, 0);
		Long employeeId;
		Employee employee = null;
		Set <ContactInfo> contacts = null;
		System.out.print("Show Contact Information of which EmployeeId: ");
		employeeId = InputUtil.inputOptionCheck().longValue();

		while (!(EmployeeDAO.employeeCheck(employeeId))) {
			System.out.print("Employee ID chosen does not exist. Enter a new employee id to delete: ");
			employeeId = InputUtil.inputOptionCheck().longValue();
		}			

		employee = EmployeeDAO.getEmployeeCollection(employeeId);	
		contacts = employee.getContactInfo();

		if(!contacts.isEmpty()) {
			System.out.println("Employee has below Contact Info: ");
			for(ContactInfo list : contacts) {
				System.out.println("Contact Info Type: " + list.getInfoType());
				System.out.println("Contact Info: " + list.getInfoDetail());
				System.out.println("-------------------");
			}
		} else {
			System.out.println("Employee has no Contact Info");
		}
	}
}