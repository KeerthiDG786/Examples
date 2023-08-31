package com.mob.sts.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mob.sts.controller.StudentController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtService {
    
	
	private final static Logger logger=LoggerFactory.getLogger(JwtService.class.getName());
	
	public static final String SECRET=	"f3Zf+xW8cjBlDTTJX+dseZC4np7BrUafiV0MW9RrT1tEefGFX8yW/guSpnZME66H";

			
	public String getToken(String userName)
	{
		HashMap<String,Object> claims=new HashMap<>();
		
		 return createToke(claims,userName);
	}

	private String createToke(HashMap<String, Object> claims, String userName) {
		
		logger.error("error here");
		return Jwts.builder().
				setClaims(claims)
				.setSubject(userName)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+1000*60+30))
				.signWith(getSignKey(),SignatureAlgorithm.HS256)
				.compact();
	}

	private Key getSignKey() {
		byte[] keyBytes=Decoders.BASE64.decode(SECRET);
		return Keys.hmacShaKeyFor(keyBytes);
	}
}
