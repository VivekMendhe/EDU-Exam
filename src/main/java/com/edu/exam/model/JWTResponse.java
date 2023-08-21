package com.edu.exam.model;

public class JWTResponse {
	
	String token;

	public JWTResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JWTResponse(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
