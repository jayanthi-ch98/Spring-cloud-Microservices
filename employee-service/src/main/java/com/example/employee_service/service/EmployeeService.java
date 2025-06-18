package com.example.employee_service.service;

import com.example.employee_service.dto.APIResponseDto;
import com.example.employee_service.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto createEmoployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long Id);
}
