package com.example.employee_service.service;

import com.example.employee_service.dto.*;
import com.example.employee_service.entity.Employee;
import com.example.employee_service.exception.ResourceNotFoundException;
import com.example.employee_service.mapper.AutoEmployeeMapper;
import com.example.employee_service.mapper.EmployeeMapper;
import com.example.employee_service.repository.EmployeeRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private EmployeeRepository employeeRepository;

    private ModelMapper modelMapper;

    private APIFeignClient apiFeignClient;

//    private RestTemplate restTemplate;

    private WebClient webClient;

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
//    @CircuitBreaker(name="${spring.application.name}",fallbackMethod="getdefaultDepartmentName")
    @Retry(name="${spring.application.name}",fallbackMethod="getdefaultDepartmentName")
    public APIResponseDto getEmployeeById(Long employeeId) {
        LOGGER.info("inside getEmployeeById method");
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->
                new ResourceNotFoundException("Employee Id","Employee ",employeeId.toString()));
        EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.employeeToEmployeeDTO(employee);


//        ResponseEntity<DepartmentDtoList> responseEntity= restTemplate.getForEntity("http://localhost:8080/api/departments/"+employee.getDepartmentCode(), DepartmentDtoList.class);
//
//        DepartmentDtoList departmentDtoList = responseEntity.getBody();

//        DepartmentDtoList departmentDtoList = webClient.get().uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode()).retrieve().bodyToMono(DepartmentDtoList.class).block();

        DepartmentDtoList departmentDtoList=apiFeignClient.getDepartment(employee.getDepartmentCode());

        OrganizationDto organizationDto = webClient.get().uri("http://localhost:8083/api/organization/"+employee.getOrganizationCode()).retrieve().bodyToMono(OrganizationDto.class).block();

        APIResponseDto apiResponseDto=new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDtoList.getDepartmentDtoList().get(0));
        apiResponseDto.setOrganizationDto(organizationDto);

//        return EmployeeMapper.mapToEmployeeDto(employee);

        //Using ModelMapper
//        return modelMapper.map(employee,EmployeeDto.class);

        //using mapStruct for mapping
        return apiResponseDto;


    }
    public APIResponseDto getdefaultDepartmentName(Long employeeId,Throwable t){
        LOGGER.info("inside getEmployeeById method inside fallback");
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->
                new ResourceNotFoundException("Employee Id","Employee ",employeeId.toString()));
        EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.employeeToEmployeeDTO(employee);

        DepartmentDto department = new DepartmentDto();
        department.setDepartmentName("R&D department");
        department.setDepartmentCode("R&D");
        department.setDepartmentDescription("Reserach and Development Department");


//        DepartmentDtoList departmentDtoList=apiFeignClient.getDepartment(employee.getDepartmentCode());
        List<DepartmentDto> defaultDepartmentList = new ArrayList<>();
        defaultDepartmentList.add(department);
        DepartmentDtoList departmentDtoList= new DepartmentDtoList(defaultDepartmentList);


        APIResponseDto apiResponseDto=new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDtoList.getDepartmentDtoList().get(0));

        return apiResponseDto;
    }
}
