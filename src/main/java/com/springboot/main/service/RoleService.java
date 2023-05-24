package com.springboot.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.main.entities.RoleName;

@Service
public interface RoleService {
	public RoleName saveRole(RoleName roleName);
	
	List<RoleName> getRole();
}
