package com.example.department_service.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="department")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentid;

    @Column(name="department_name")
    private String departmentName;

    @Column(name="department_description")
    private String departmentDescription;

    @Column(name="department_code")
    private String departmentCode;
}
