package com.example.organization_service;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info=@Info(title="Organization-service Rest API's",
				description="Organization Service Rest APIs documentation",
				version="v1.0",
				contact=@Contact(
						name="jayanthi",
						url="https://github.com/jayanthi-ch98",
						email="jayanthi.ch98"
				),
				license=@License(
						name="Apache Tomcat v2.0",
						url="https://github.com/jayanthi-ch98"
				)
		)
)
public class OrganizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

}
