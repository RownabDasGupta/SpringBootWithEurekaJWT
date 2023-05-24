package com.springboot.main.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.main.entities.RoleName;
import com.springboot.main.repository.RoleRepository;
import com.springboot.main.service.RoleService;

public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleRepository roleRepository;
		
	@Override
	public RoleName saveRole(RoleName roleName) {
		// TODO Auto-generated method stub
		return roleRepository.save(roleName);
	}

	@Override
	public List<RoleName> getRole() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}
	
}
