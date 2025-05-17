package com.example.department_service.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class DepartmentDto {

    private Long departmentid;

    @NotEmpty(message="Department Name Cannot be empty")
    @NotNull(message="Department Name field is missing")
    private String departmentName;

    private String departmentDescription;

    @NotNull(message="Department Code Field is missing")
    @NotEmpty(message="Department Code Cannot be empty")
    private String departmentCode;

}
