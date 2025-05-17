package com.example.department_service.mapper;


import com.example.department_service.dto.DepartmentDto;
import com.example.department_service.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoDepartmentMapper {

    AutoDepartmentMapper MAPPER = Mappers.getMapper( AutoDepartmentMapper.class );

    DepartmentDto departmentToDepartmentDTO(Department department);

    Department departmentDtoToDepartment(DepartmentDto departmentDto);
}
