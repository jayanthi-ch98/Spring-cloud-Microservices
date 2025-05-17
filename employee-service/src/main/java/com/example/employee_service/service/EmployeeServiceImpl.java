package com.example.employee_service.service;

import com.example.employee_service.dto.EmployeeDto;
import com.example.employee_service.entity.Employee;
import com.example.employee_service.exception.ResourceNotFoundException;
import com.example.employee_service.mapper.AutoEmployeeMapper;
import com.example.employee_service.mapper.EmployeeMapper;
import com.example.employee_service.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private ModelMapper modelMapper;

    @Override
    public EmployeeDto createEmoployee(EmployeeDto employeeDto) {
//        Employee employee = employeeRepository.save(EmployeeMapper.mapToEmployee(employeeDto));

        //using ModelMapper instead of manual User Mapper
//        Employee employee = employeeRepository.save(modelMapper.map(employeeDto,Employee.class));

        //using MapStruct
        Employee employee = employeeRepository.save(AutoEmployeeMapper.MAPPER.employeeDtoToEmployee(employeeDto));


//        return EmployeeMapper.mapToEmployeeDto(employee);
        //using ModelMapper instead of manual mapper
//        return modelMapper.map(employee,EmployeeDto.class);

        //using MapStruct
        return AutoEmployeeMapper.MAPPER.employeeToEmployeeDTO(employee);


    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->
                new ResourceNotFoundException("Employee Id","Employee ",employeeId.toString()));
//        return EmployeeMapper.mapToEmployeeDto(employee);

        //Using ModelMapper
//        return modelMapper.map(employee,EmployeeDto.class);

        //using mapStruct for mapping
        return AutoEmployeeMapper.MAPPER.employeeToEmployeeDTO(employee);


    }
}
