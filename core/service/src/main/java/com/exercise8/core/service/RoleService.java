package com.exercise8.core.service;
import com.exercise8.core.model.Roles;
import com.exercise8.util.InputUtil;
import com.exercise8.core.dao.RoleDAO;
import java.util.List;

public class RoleService {
	public static Integer addRoles(Roles role) {
		if (RoleDAO.checkDuplicateRole(role, 1)) {
			return 0;
		} else {
			RoleDAO.add(role);
			return 1;
		}
	}

	public static List <Roles> listRoles(Integer sortRule, Integer orderRule) {
		List <Roles> list = RoleDAO.showRoles(sortRule, orderRule);
		return list;
	}	

	public static Integer updateRoles(Roles role) {
		if(RoleDAO.checkDuplicateRole(role, 2)) {
			return 0;
		} else {
			RoleDAO.update(role);
			return 1;
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