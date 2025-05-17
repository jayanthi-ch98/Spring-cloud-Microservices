package com.example.department_service.mapper;

import com.example.department_service.dto.DepartmentDto;
import com.example.department_service.entity.Department;

public class DepartmentMapper {

    public static Department mapToDepartment(DepartmentDto departmentdto){
        Department department = new Department(departmentdto.getDepartmentid(), departmentdto.getDepartmentName(), departmentdto.getDepartmentDescription(), departmentdto.getDepartmentCode());
        return department;
    }
    public static DepartmentDto mapToDepartmentDto(Department department){
        DepartmentDto departmentDto= new DepartmentDto(department.getDepartmentid(), department.getDepartmentName(), department.getDepartmentDescription(), department.getDepartmentCode());
        return departmentDto;
    }
}
