package com.example.employee_service.controller;

import com.example.employee_service.dto.APIResponseDto;
import com.example.employee_service.dto.EmployeeDto;
import com.example.employee_service.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody @Valid EmployeeDto employeeDto){
        EmployeeDto createdEmployeeDto = employeeService.createEmoployee(employeeDto);
        return new ResponseEntity<>(createdEmployeeDto, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable Long id){
        APIResponseDto apiResponseDtoDto=employeeService.getEmployeeById(id);
        return ResponseEntity.ok(apiResponseDtoDto);
    }

}
