package com.example.department_service.service;

import com.example.department_service.dto.DepartmentDto;
import com.example.department_service.entity.Department;
import com.example.department_service.exception.ResourceNotFoundException;
import com.example.department_service.mapper.AutoDepartmentMapper;
import com.example.department_service.mapper.DepartmentMapper;
import com.example.department_service.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

//    private DepartmentMapper departmentMapper;

    //Using ModelMapper class
    private ModelMapper modelMapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
//        Department department = DepartmentMapper.mapToDepartment(departmentDto);


        //using ModelMapper instead of Manual UserMapper
//        Department department = modelMapper.map(departmentDto,Department.class);

        //Using MapStruct to Mapping
        Department department = AutoDepartmentMapper.MAPPER.departmentDtoToDepartment(departmentDto);

        Department departmentCreated = departmentRepository.save(department);
//      DepartmentDto departmentdtoCreated = DepartmentMapper.mapToDepartmentDto(departmentCreated)

        //using ModelMapper instead of Manual UserMapper
//        DepartmentDto departmentdtoCreated = modelMapper.map(departmentCreated,DepartmentDto.class);

        //Using MapStruct for Mapping
        DepartmentDto departmentdtoCreated = AutoDepartmentMapper.MAPPER.departmentToDepartmentDTO(departmentCreated);

        return departmentdtoCreated;
    }

    @Override
    public List<DepartmentDto> getDepartmentByCode(String departmentCode) {
        List<Department> departmentList = departmentRepository.findByDepartmentCode(departmentCode);
        System.out.println(departmentList);
        if(departmentList==null || departmentList.isEmpty() ){
            throw new ResourceNotFoundException("Department Doesn't exists","Department Code",departmentCode);
        }

//        List<DepartmentDto> departmentDtoList= departmentList.stream().map(department->DepartmentMapper.mapToDepartmentDto(department))
//                .collect(Collectors.toList());

        //using ModelMapper instead of Manual UserMapper
//        List<DepartmentDto> departmentDtoList= departmentList.stream().map(department->modelMapper.map(department,DepartmentDto.class))
//                .collect(Collectors.toList());

        //Using Mapstruct for Mapping
        List<DepartmentDto> departmentDtoList= departmentList.stream().map(department->AutoDepartmentMapper.MAPPER.departmentToDepartmentDTO(department))
                .collect(Collectors.toList());

        return departmentDtoList;
    }
}
