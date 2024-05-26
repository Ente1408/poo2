package com.ppooii.trabajot1.Config;

import static com.ppooii.trabajot1.Config.Model.Constans.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Configuration
public class JWTAuthtenticationConfig {
	
		
	public String getJWTToken(String username) {
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts.builder()
				.setId("PPOOII_JWT")
				.setSubject(username)
				.claim("authorities", grantedAuthorities.stream()
							.map(GrantedAuthority::getAuthority)
							.collect(Collectors.toList())
							)
				.setIssuedAt(new Date (System.currentTimeMillis()))
				.setExpiration(new Date  (System.currentTimeMillis()+ TOKEN_EXPIRATION_TIME))
				.signWith(getSigningkey(SUPER_SECRET_KEY),SignatureAlgorithm.HS512).compact();
		
		return "Bearer: "+ token;
		
	}
}
