package com.example.department_service.controller;

import com.example.department_service.dto.DepartmentDto;
import com.example.department_service.dto.DepartmentDtoList;
import com.example.department_service.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(
        name="Department Service-Department Controller",
        description="Department Controller exposes API's for Department Service"
)
public class DepartmentController {

    private DepartmentService departmentService;

//    private static final Log log = LogFactory.getLog(DepartmentController.class);

    @Operation(
            summary = "Save department Rest API",
            description="Save the department to department entity")
    @ApiResponse(
            responseCode="201",
            description = "HTTP Status 201 created"
    )
    @PostMapping()
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody @Valid DepartmentDto departmentDto){
        DepartmentDto departmentDto1 = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(departmentDto1, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get department Rest API by department Code",
            description="Get the department from department entity based on department code")
    @ApiResponse(
            responseCode="200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping("/{code}")
    public ResponseEntity<DepartmentDtoList> getDepartment(@PathVariable("code") String departmentCode){
        DepartmentDtoList departmentDtoList = departmentService.getDepartmentByCode(departmentCode);
        return ResponseEntity.ok(departmentDtoList);
    }
}
