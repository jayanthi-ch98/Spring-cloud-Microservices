package com.example.department_service.service;

import com.example.department_service.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    List<DepartmentDto> getDepartmentByCode(String departmentCode);
}
