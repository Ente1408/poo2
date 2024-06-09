package com.ppooii.trabajot1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ppooii.trabajot1.Config.JWTAuthtenticationConfig;
import com.ppooii.trabajot1.Config.Model.JwtRequest;
import com.ppooii.trabajot1.Config.Model.JwtResponse;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	JWTAuthtenticationConfig jwtAuthtenticationConfig;
	
	@Autowired
	private UserDetailsService jwtInMemoryUserDetailsService;
	
	@RequestMapping(
			value	 = "/authenticate",
			method   = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception{
		System.out.println("****************	********************************************************");
		System.out.println("Authentication.getUsername(): ["+ authenticationRequest.getUsername()+"]");
		System.out.println("Authentication.getPassword(): ["+ authenticationRequest.getPassword()+"]");
		System.out.println("************************************************************************");
		

		final UserDetails userDetails = jwtInMemoryUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String Token = jwtAuthtenticationConfig.getJWTToken(userDetails.getUsername());
		
		System.out.println("************************************************************************");
		System.out.println("Token(): ["+Token+"]");
		System.out.println("************************************************************************");
		
		return ResponseEntity.ok(new JwtResponse(Token));
	}
	
}
