package com.springboot.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.main.entities.UserName;

@Repository
public interface UserRepository extends JpaRepository<UserName, Integer> {

	public UserName findByUserName(String userName);
}
