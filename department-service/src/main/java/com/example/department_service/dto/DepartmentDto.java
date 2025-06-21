package com.example.department_service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description="DepartmentDto Model object")
public class DepartmentDto {

    private Long departmentid;

    @NotEmpty(message="Department Name Cannot be empty")
    @NotNull(message="Department Name field is missing")
    @Schema(description = "Department Name")
    private String departmentName;

    @Schema(description = "Department Description")
    private String departmentDescription;

    @NotNull(message="Department Code Field is missing")
    @NotEmpty(message="Department Code Cannot be empty")
    @Schema(description = "Department Code")
    private String departmentCode;

}
