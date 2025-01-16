package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SpringBootUserWithJpaDtoH2LoggingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootUserWithJpaDtoH2LoggingApplication.class, args);
		log.info("Logger Info");
	}

}
