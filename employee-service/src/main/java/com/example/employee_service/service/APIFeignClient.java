package com.example.employee_service.service;

import com.example.employee_service.dto.DepartmentDtoList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "department-service")
public interface APIFeignClient {
    @GetMapping("api/departments/{code}")
    DepartmentDtoList getDepartment(@PathVariable("code") String departmentCode);

}
