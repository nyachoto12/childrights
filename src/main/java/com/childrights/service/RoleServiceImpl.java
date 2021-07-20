package com.childrights.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.childrights.model.Role;
import com.childrights.repo.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepo;
	@Override
	public List<Role> getAllRole() {
		// TODO Auto-generated method stub
		return roleRepo.findAll();
	}

	@Override
	public void saveRole(Role Role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRoleById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Role findRoleById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
