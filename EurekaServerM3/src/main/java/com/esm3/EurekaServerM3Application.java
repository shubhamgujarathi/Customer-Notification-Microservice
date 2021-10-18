package com.esm3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerM3Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerM3Application.class, args);
	}

}
