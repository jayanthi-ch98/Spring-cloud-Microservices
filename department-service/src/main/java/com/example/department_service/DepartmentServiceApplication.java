package com.example.department_service;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@OpenAPIDefinition(
		info=@Info(title="department-service Rest API's",
				   description="Department Service Rest APIs documentation",
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
public class DepartmentServiceApplication {

	@Bean
	public ModelMapper modelmapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
