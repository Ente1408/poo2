package com.ppooii.trabajot1.Config.Model;

import java.io.Serializable;

public class JwtResponse implements Serializable{
	private static final long serialVersionUID = -8091879091924046844L;
	
	private final String jwttoken;
	
	public JwtResponse (String Token)
	{
		this.jwttoken = Token;
	}
	public String getJwttoken() {
		return jwttoken;
	}
	
}
