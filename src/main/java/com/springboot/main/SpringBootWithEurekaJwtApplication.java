package com.springboot.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude=SecurityAutoConfiguration.class)
@EnableDiscoveryClient
public class SpringBootWithEurekaJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithEurekaJwtApplication.class, args);
		System.out.println("My Spring Boot with Eureka and JWT Token is running...!!!");
	}

}
