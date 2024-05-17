package com.ppooii.trabajot1.Config.Model;

import java.io.Serializable;

public class JwtRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	
	public JwtRequest () {}
	public JwtRequest (String username,String password) {
		this.password = password;
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
