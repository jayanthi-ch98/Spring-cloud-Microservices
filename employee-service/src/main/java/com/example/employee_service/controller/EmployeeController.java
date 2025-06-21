package com.example.employee_service.controller;

import com.example.employee_service.dto.APIResponseDto;
import com.example.employee_service.dto.EmployeeDto;
import com.example.employee_service.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
@Tag(
        name="Employee Service-Employee Controller",
        description="Employee Controller exposes API's for Employee Service"
)
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    @Operation(
            summary = "Save Employee Rest API",
            description="Save the Employee to Employee entity")
    @ApiResponse(
            responseCode="201",
            description = "HTTP Status 201 created"
    )
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody @Valid EmployeeDto employeeDto){
        EmployeeDto createdEmployeeDto = employeeService.createEmoployee(employeeDto);
        return new ResponseEntity<>(createdEmployeeDto, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    @Operation(
            summary = "Get Employee Rest API by Employee Id",
            description="Get the Employee Object from Employee entity based on Employee Id")
    @ApiResponse(
            responseCode="200",
            description = "HTTP Status 200 OK"
    )
    public ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable Long id){
        APIResponseDto apiResponseDtoDto=employeeService.getEmployeeById(id);
        return ResponseEntity.ok(apiResponseDtoDto);
    }

}
