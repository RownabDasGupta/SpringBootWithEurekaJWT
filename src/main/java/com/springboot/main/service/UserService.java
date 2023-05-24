package com.springboot.main.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.main.entities.UserName;
import com.springboot.main.model.JwtPojo;
import com.springboot.main.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserName user = userRepository.findByUserName(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("user not found with user name" + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getUserPassword(), new ArrayList<>() );
		
	}
	
	
	public UserName saveUser(JwtPojo user) {
		UserName users = new UserName();
		users.setUserName(user.getUserName() );
		users.setUserPassword(passwordEncoder.encode(user.getUserPassword() ));
		
		return userRepository.save(users);
	}
	
	
	
	
}
