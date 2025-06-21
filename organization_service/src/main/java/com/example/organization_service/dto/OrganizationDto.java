package com.example.organization_service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description="OrganizationDto Model object")
public class OrganizationDto {

    private Long id;

    @Schema(description = "Organization Name")
    private String organizationName;

    @Schema(description = "Organization description")
    private String organizationDescription;

    @Schema(description = "Organization code")
    private String organizationCode;

    @Schema(description = "Organization create date time")
    private LocalDateTime organizationCreatedDate;
}
