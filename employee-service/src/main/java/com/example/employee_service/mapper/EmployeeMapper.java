package com.example.employee_service.mapper;

import com.example.employee_service.dto.EmployeeDto;
import com.example.employee_service.entity.Employee;

public class EmployeeMapper {

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(employeeDto.getEmployeeId(), employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getEmail(),employeeDto.getDepartmentCode(),employeeDto.getOrganizationCode());
    }
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(employee.getEmployeeId(), employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getDepartmentCode(),employee.getOrganizationCode());
    }

}
