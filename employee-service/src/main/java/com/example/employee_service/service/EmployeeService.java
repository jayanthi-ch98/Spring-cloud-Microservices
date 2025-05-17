package com.example.employee_service.service;

import com.example.employee_service.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto createEmoployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long Id);
}
