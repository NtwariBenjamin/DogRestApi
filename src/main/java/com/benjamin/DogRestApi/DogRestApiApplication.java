package com.benjamin.DogRestApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DogRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DogRestApiApplication.class, args);
	}

}
