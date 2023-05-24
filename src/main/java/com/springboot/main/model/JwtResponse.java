package com.springboot.main.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -2331841396235378510L;
	
	private final String jwttokens;
	
	public JwtResponse(String jwttokens) {
		this.jwttokens = jwttokens;
	}
	
	public String getJwttokens() {
		return jwttokens;
	}
	
}
