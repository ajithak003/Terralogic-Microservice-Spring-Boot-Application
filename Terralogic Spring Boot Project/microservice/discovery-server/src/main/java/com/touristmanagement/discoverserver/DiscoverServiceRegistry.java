package com.touristmanagement.discoverserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoverServiceRegistry {

	public static void main(String[] args) {
		
		SpringApplication.run(DiscoverServiceRegistry.class, args);

	}

}
