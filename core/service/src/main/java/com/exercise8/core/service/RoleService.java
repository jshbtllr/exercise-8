package com.exercise8.core.service;
import com.exercise8.core.model.Roles;
import com.exercise8.util.InputUtil;
import com.exercise8.core.dao.RoleDAO;
import java.util.List;

public class RoleService {
	public static void addRoles(Roles role) {
		if (RoleDAO.checkDuplicateRole(role, 1)) {
			System.out.println("RoleCode: " + role.getRoleCode() + " already exists in the database");
		} else {
			RoleDAO.add(role);
			System.out.println("New Role has been added");
		}
	}

	public static List <Roles> listRoles(Integer sortRule, Integer orderRule) {
		List <Roles> list = RoleDAO.showRoles(sortRule, orderRule);
		return list;
	}	

	public static void updateRoles() {
		String roleCode = new String();
		String roleName = new String();
		Roles role = new Roles();

		System.out.println("Update Roles");
		listRoles(1, 1);
		System.out.print("\nInput RoleID of the role to edit: ");
		Long roleId = InputUtil.inputOptionCheck().longValue();
		role.setId(roleId);
	

		role = new Roles();

		System.out.println("\nEdit: ");
		System.out.println("[1]    RoleCode");
   		System.out.println("[2]    RoleName");
		System.out.println("[3]    Both");
		System.out.print("Choose Option above: ");
		Integer option = InputUtil.inputOptionCheck(3);		
		
		if(option == 1) {
			System.out.print("Input New RoleCode: ");
			roleCode = InputUtil.getRequiredInput();

			role = new Roles(" ", roleCode);
			if(RoleDAO.checkDuplicateRole(role, 1)){
				System.out.println("Chosen RoleCode already exists. Exiting Role Update");
			} else {
				role = RoleDAO.get(Roles.class, roleId);
				role.setRoleCode(roleCode);
				RoleDAO.update(role);
			}
		} else if(option == 2) {
			System.out.print("Input New RoleName: ");
			roleName = InputUtil.getRequiredInput();
			role = RoleDAO.get(Roles.class, roleId);
			role.setRoleName(roleName);
			RoleDAO.update(role);
		} else if(option == 3) {
			System.out.print("Input New RoleCode: ");
			roleCode = InputUtil.getRequiredInput();
			System.out.print("Input New RoleName: ");
			roleName = InputUtil.getRequiredInput();

			role = new Roles(roleName, roleCode);
			if(RoleDAO.checkDuplicateRole(role, 2)) {
				System.out.println("Chosen RoleCode already exists. Exiting Role Update");
			} else {
				role = RoleDAO.get(Roles.class, roleId);
				role.setRoleCode(roleCode);
				role.setRoleName(roleName);
				RoleDAO.update(role);
			}
		} else {
			System.out.println("Invalid option chosen, exiting Update Role");
			return;
		}
	}		

	public static Integer removeRoles(Long roleId) {
		Roles role = new Roles();
		role.setId(roleId);

		if (!(RoleDAO.checkDuplicateRole(role, 3))) {
			role = RoleDAO.get(Roles.class, roleId);
			RoleDAO.delete(role);
			return 1;
		} else {
			return 0;
		}
	}
}	