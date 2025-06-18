package com.example.organization_service.service;

import com.example.organization_service.dto.OrganizationDto;
import com.example.organization_service.entities.Organization;
import com.example.organization_service.mapper.OrganizationMapper;
import com.example.organization_service.repositories.OrganizationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto createOrganization(OrganizationDto organizationDto) {

        Organization organization = OrganizationMapper.maptoOrganization(organizationDto);
        Organization savedOrganization = organizationRepository.save(organization);
        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String OrganizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(OrganizationCode);
        OrganizationDto organizationDto = OrganizationMapper.mapToOrganizationDto(organization);
        return organizationDto;
    }
}
