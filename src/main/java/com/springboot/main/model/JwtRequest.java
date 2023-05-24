package com.springboot.main.model;

import java.io.Serializable;

public class JwtRequest implements Serializable {
	private static final long serialVersionUID = 4767630522341606601L;
	
	private String userName;
	private String userPassword;
	
	public JwtRequest() {
		// TODO Auto-generated constructor stub
	}
	public JwtRequest(String userName, String userPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
