package com.uproad.util;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.uproad.Application;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

public class JwtUtil {
	private final Logger logger=LoggerFactory.getLogger(Application.class);
	public String jwtBuilder(String name,String subject,String secret,long timeOver){
		JwtBuilder jb=Jwts.builder()
				.setIssuer(name)
				.setSubject(subject)
				.setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime()+timeOver))
				.signWith(SignatureAlgorithm.HS256, secret);
		String token=jb.compact();
		return token;
	}
	public String jwtVerify(String token,String secret){
		try{
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		}catch(SignatureException e){
			return "token verify fail";
		}catch(JwtException e){
			logger.error(e.toString());
			return "token is illegal";
		}
		return "token pass";
	}

}
