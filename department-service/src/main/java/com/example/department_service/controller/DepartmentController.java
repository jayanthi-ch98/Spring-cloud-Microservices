package com.example.department_service.controller;

import com.example.department_service.dto.DepartmentDto;
import com.example.department_service.dto.DepartmentDtoList;
import com.example.department_service.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/departments")
public class DepartmentController {

    private DepartmentService departmentService;

//    private static final Log log = LogFactory.getLog(DepartmentController.class);

    @PostMapping()
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody @Valid DepartmentDto departmentDto){
        DepartmentDto departmentDto1 = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(departmentDto1, HttpStatus.CREATED);
    }

    @GetMapping("/{code}")
    public ResponseEntity<DepartmentDtoList> getDepartment(@PathVariable("code") String departmentCode){
        DepartmentDtoList departmentDtoList = departmentService.getDepartmentByCode(departmentCode);
        return ResponseEntity.ok(departmentDtoList);
    }
}
