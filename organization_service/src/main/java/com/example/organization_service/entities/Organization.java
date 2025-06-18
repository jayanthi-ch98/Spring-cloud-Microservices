package com.example.organization_service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Table(name="Organization")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String organizationName;

    private String organizationDescription;

    @Column(nullable = false,unique = true)
    private String organizationCode;

    @CreationTimestamp
    private LocalDateTime organizationCreatedDate;
}
