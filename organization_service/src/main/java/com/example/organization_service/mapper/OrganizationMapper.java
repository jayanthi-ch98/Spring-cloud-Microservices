package com.example.organization_service.mapper;

import com.example.organization_service.dto.OrganizationDto;
import com.example.organization_service.entities.Organization;

public class OrganizationMapper {

    public static OrganizationDto mapToOrganizationDto(Organization organization){
        return new OrganizationDto(organization.getId(), organization.getOrganizationName(), organization.getOrganizationDescription(), organization.getOrganizationCode(), organization.getOrganizationCreatedDate());
    }
    public static Organization maptoOrganization(OrganizationDto organizationdto){
        return new Organization(organizationdto.getId(),organizationdto.getOrganizationName(), organizationdto.getOrganizationDescription(), organizationdto.getOrganizationCode(), organizationdto.getOrganizationCreatedDate());
    }

}
