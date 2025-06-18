package com.example.employee_service.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long employeeId;

    @NotEmpty(message="First Name Cannot be Empty")
    @NotNull(message="First Name Field is missing")
    private String firstName;
    private String lastName;

    @Email(message="Not a valid Email Id")
    @NotNull(message="Email field is missing")
    @NotEmpty(message="Emaild Id cannot be empty")
    private String email;
    private String departmentCode;
    private String OrganizationCode;
}
