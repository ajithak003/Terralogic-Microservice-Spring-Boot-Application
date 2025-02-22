package com.touristmanagement.apigateway.authfilter;

import org.apache.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.touristmanagement.apigateway.exceptions.TokenExpiredException;
import com.touristmanagement.apigateway.util.JwtTokenUtil;


@Component
public class JwtAuthFilter extends AbstractGatewayFilterFactory<JwtAuthFilter.Config>{
	
	@Autowired
    private RouteValidator validator;

	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
    public JwtAuthFilter() {
    	 super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config){
    	
    	 return ((exchange, chain) -> {
             if (validator.isSecured.test(exchange.getRequest())) {
                 //header contains token or not
                 if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                     throw new RuntimeException("missing authorization header");
                 }

                 String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                 if (authHeader != null && authHeader.startsWith("Bearer ")) {
                     authHeader = authHeader.substring(7);
                 }
                 try {
                	 //boolean isAuth = client.validateToken(authHeader);
                	 jwtTokenUtil.validateToken(authHeader);

                 } catch (TokenExpiredException ex) {
                	    throw ex; // Re-throw to be handled globally
                 } catch (Exception e) {
						/*
						 * System.out.println("invalid access...!"); throw new
						 * RuntimeException("un authorized access to application");
						 */
                	 exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                	 return exchange.getResponse().setComplete();

                 }
             }
             return chain.filter(exchange);
         });
      
    }
    
    public static class Config {

    }

}

