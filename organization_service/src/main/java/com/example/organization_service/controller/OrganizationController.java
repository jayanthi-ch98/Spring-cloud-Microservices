package com.example.organization_service.controller;

import com.example.organization_service.dto.OrganizationDto;
import com.example.organization_service.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organization")
@AllArgsConstructor
@Tag(
        name="Organization Service-Organization Controller",
        description="Organization Controller exposes API's for Organization Service"
)
public class OrganizationController {

    private OrganizationService organizationService;

    @PostMapping()
    @Operation(
            summary = "Save Organization Rest API",
            description="Save the organization to Organization entity")
    @ApiResponse(
            responseCode="201",
            description = "HTTP Status 201 created"
    )
    public ResponseEntity<OrganizationDto> createOrganization(@RequestBody OrganizationDto organizationDto){

        OrganizationDto savedOrganizationDto = organizationService.createOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganizationDto, HttpStatus.CREATED);

    }
    @Operation(
            summary = "Get organization Rest API by organization Code",
            description="Get the organization from organization entity based on organization code")
    @ApiResponse(
            responseCode="200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping("{code}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable(value="code") String organizationCode){
        OrganizationDto organizationDto = organizationService.getOrganizationByCode(organizationCode);
        return ResponseEntity.ok(organizationDto);
    }
}
