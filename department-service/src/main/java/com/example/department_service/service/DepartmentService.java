package com.example.department_service.service;

import com.example.department_service.dto.DepartmentDto;
import com.example.department_service.dto.DepartmentDtoList;

import java.util.List;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDtoList getDepartmentByCode(String departmentCode);
}
