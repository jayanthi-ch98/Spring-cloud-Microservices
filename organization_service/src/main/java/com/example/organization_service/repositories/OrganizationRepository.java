package com.example.organization_service.repositories;

import com.example.organization_service.entities.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization,Long> {

    public Organization findByOrganizationCode(String OrganizationCode);
}
