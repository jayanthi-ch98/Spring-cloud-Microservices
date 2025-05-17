package com.example.employee_service.mapper;

import com.example.employee_service.dto.EmployeeDto;
import com.example.employee_service.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoEmployeeMapper {

    AutoEmployeeMapper MAPPER = Mappers.getMapper( AutoEmployeeMapper.class );

        EmployeeDto employeeToEmployeeDTO(Employee employee);

        Employee employeeDtoToEmployee(EmployeeDto employeedto);
    }

