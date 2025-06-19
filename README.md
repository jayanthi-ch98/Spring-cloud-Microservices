# Spring-cloud-Microservices
Spring Boot Microservices project created using Spring Cloud 

<strong>Pre Requisites:</strong><br>
1.Intellij idea <br>
2.Docker desktop<br>
3.MySQL workbench<br>

Built a fullstack microservices project using Spring Boot and React JS

<strong>Dependencies used:</strong><br>
Spring Boot 3.4.x with Spring Cloud 2022.0.x <br>
Spring Cloud API gateway  ---> To have a API gateway to route to all the services <br>
Spring Cloud Eureka server --->For registering the services <br>
Spring Cloud Eureka Client-----> For registering microservices as client <br>
Spring cloud starter config----> To use config server repo in github for managing all the peroperties <br>
Spring cloud bus    -----> To automate the updation of properties from config server instead of hitting spring actuator/refresh for all the services manually <br>
micrometer with zipkin---> For distribution tracing of the services calls using trace ID <br>
Spring Doc rest Open API documentation ---> To generate swagger documentation for all the Rest APIS <br>
React with axios library <br>
