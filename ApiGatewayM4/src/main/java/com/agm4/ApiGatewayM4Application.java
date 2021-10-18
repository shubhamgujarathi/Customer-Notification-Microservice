package com.agm4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApiGatewayM4Application {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayM4Application.class, args);
	}

}
