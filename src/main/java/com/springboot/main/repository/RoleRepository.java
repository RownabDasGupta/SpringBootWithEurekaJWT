package com.springboot.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.main.entities.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<RoleName, Integer> {
	
}
