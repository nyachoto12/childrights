package com.childrights.service;

import java.util.List;

import com.childrights.model.Role;

public interface RoleService {
	public List<Role> getAllRole();
	void saveRole(Role Role);
	
	void deleteRoleById(Long id);

    Role findRoleById(Long id);
}
