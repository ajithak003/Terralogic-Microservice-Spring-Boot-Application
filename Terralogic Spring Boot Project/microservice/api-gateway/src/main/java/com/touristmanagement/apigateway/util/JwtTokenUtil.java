package com.touristmanagement.apigateway.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.touristmanagement.apigateway.exceptions.TokenExpiredException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenUtil {

	@Value("${jwt.secret}")
	private String secret;

	public void validateToken(final String token) {

		
		Claims claims = extractAllClaims(token);
		
		if(claims.getExpiration().before(new Date())) {
			System.err.println("Token has expired : "+claims.getExpiration()+" : "+new Date());
	        throw new TokenExpiredException("Token has expired at " + claims.getExpiration());
		}
		
		//if you want to check username also same do that.
		String username = claims.getSubject();
		System.out.println("Username : "+ username);
		

	}

	private Claims extractAllClaims(String token) {

		return Jwts
				.parserBuilder()
				.setSigningKey(getSignKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
	}

	private Key getSignKey() {
		byte[] keyBytes = Decoders.BASE64.decode(secret);
		return Keys.hmacShaKeyFor(keyBytes);
	}

}
