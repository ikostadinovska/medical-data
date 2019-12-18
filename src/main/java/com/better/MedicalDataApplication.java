package com.better;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@OpenAPIDefinition(
		info = @Info(description = "Backend application for medical data management via REST API.",
				title = "Medical Data API",
				version = "v1",
				contact = @Contact(name = "Ivana Kostadinovska",
						email = "iki.kostadinovska@gmail.com")))
@SpringBootApplication
@EnableScheduling
@ConfigurationPropertiesScan("com.better.config")
public class MedicalDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicalDataApplication.class, args);
	}

}
