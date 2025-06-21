package com.example.employee_service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description="EmployeeDto Model object")
public class EmployeeDto {

    private Long employeeId;

    @NotEmpty(message="First Name Cannot be Empty")
    @NotNull(message="First Name Field is missing")
    @Schema(description = "Employee firstName")
    private String firstName;

    @Schema(description = "Employee lastName")
    private String lastName;

    @Email(message="Not a valid Email Id")
    @NotNull(message="Email field is missing")
    @NotEmpty(message="Emaild Id cannot be empty")
    @Schema(description = "Employee email")
    private String email;

    @Schema(description = "Employee department Code")
    private String departmentCode;

    @Schema(description = "Employee OrganizationCode")
    private String OrganizationCode;
}
