package com.example.department_service.repository;

import com.example.department_service.dto.DepartmentDtoList;
import com.example.department_service.dto.DepartmentList;
import com.example.department_service.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {


     List<Department> findByDepartmentCode(String departmentCode);

}
