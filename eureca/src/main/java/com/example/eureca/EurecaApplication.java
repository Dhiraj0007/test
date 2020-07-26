package com.example.eureca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
 * @author Dhiraj
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class EurecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurecaApplication.class, args);
	}

}
