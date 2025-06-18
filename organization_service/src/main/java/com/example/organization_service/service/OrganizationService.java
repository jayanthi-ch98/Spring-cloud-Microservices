package com.example.organization_service.service;

import com.example.organization_service.dto.OrganizationDto;

public interface OrganizationService {

     OrganizationDto createOrganization(OrganizationDto organizationDto);

     OrganizationDto getOrganizationByCode(String OrganizationCode);

}
