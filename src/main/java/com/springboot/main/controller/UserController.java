package com.springboot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.entities.UserName;
import com.springboot.main.jwttoken.JwtTokenUtil;
import com.springboot.main.model.JwtPojo;
import com.springboot.main.model.JwtRequest;
import com.springboot.main.model.JwtResponse;
import com.springboot.main.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		authentication(authenticationRequest.getUserName(), authenticationRequest.getUserPassword() );
		final UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getUserName() );
		final String token = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new JwtResponse(token) );
	}
	
	
	private void authentication(String userName, String userPassword) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
		}
		catch(DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		}
		catch(BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
	@PostMapping("RegisterUser") 
	public UserName saveUserName(@RequestBody JwtPojo user) {
		return userService.saveUser(user);
	}

}
