package com.session.tutorials_dto;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title="Spring Boot Open API",
				description="Open Api basic project for sample",
				version = "1.0",
				contact = @Contact(
						name="Syed Uzair",
						email = "suzair@gmail.com",
						url="http://localhost:8081/swagger-ui/index.html"
				),
				license = @License(
						name="Apache 2.0",
						url = "http://localhost:8081/swagger-ui/index.html"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Spring Boot User Management System",
				url="http://localhost:8081/swagger-ui/index.html"
		)
)
public class TutorialsDtoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutorialsDtoApplication.class, args);
		System.out.println("Application is running....");
	}
}
