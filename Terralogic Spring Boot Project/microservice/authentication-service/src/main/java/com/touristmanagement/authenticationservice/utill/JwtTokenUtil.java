package com.touristmanagement.authenticationservice.utill;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenUtil {

	@Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;
    
    
    public String generateToken(String userName) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userName);
    }

	@SuppressWarnings("deprecation")
	public String createToken(Map<String, Object> claims, String userName) {
    	System.out.println("generateToken");
    	
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }
	
    public boolean validateToken(final String token) {
    	System.out.println("validateToken(String token)");
        try {
            Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException | MalformedJwtException | UnsupportedJwtException | IllegalArgumentException e) {
            return false;
        }
    }
    
    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    /*
	 * public boolean validateToken(String token, UserDetails userDetails) {
	 * System.out.println("validateToken(String token, UserDetails userDetails)");
	 * 
	 * final String username = getUsernameFromToken(token); return
	 * (username.equals(userDetails.getUsername()) && !isTokenExpired(token)); }
	 */
    
	/*
	 * public String getUsernameFromToken(String token) {
	 * System.out.println("getUsernameFromToken"); return
	 * getClaimsFromToken(token).getSubject(); }
	 */

	/*
	 * private Claims getClaimsFromToken(String token) { return
	 * Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody(); }
	 * 
	 * private boolean isTokenExpired(String token) { return
	 * getClaimsFromToken(token).getExpiration().before(new Date()); }
	 */    
}
