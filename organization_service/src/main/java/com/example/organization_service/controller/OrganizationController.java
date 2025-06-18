package com.example.organization_service.controller;

import com.example.organization_service.dto.OrganizationDto;
import com.example.organization_service.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organization")
@AllArgsConstructor
public class OrganizationController {

    private OrganizationService organizationService;

    @PostMapping()
    public ResponseEntity<OrganizationDto> createOrganization(@RequestBody OrganizationDto organizationDto){

        OrganizationDto savedOrganizationDto = organizationService.createOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganizationDto, HttpStatus.CREATED);

    }
    @GetMapping("{code}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable(value="code") String organizationCode){
        OrganizationDto organizationDto = organizationService.getOrganizationByCode(organizationCode);
        return ResponseEntity.ok(organizationDto);
    }
}
