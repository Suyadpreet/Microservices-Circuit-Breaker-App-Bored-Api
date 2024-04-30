package com.suyad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroservicesCircuitBreakerAppBoredApiApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(MicroservicesCircuitBreakerAppBoredApiApplication.class, args);
		System.out.println("Circuit Breaker class has been started Successfully..........");
	}

}
