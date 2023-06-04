package com.asoft.pms.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@Entity
@Table(name="project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long id;
    private LocalDate plannedStartDate;
    private LocalDate plannedEndDate;

    private LocalDate actualStartDate;
    private LocalDate actualEndDate;

    private String projectDescription;

    @ManyToOne
    @JoinColumn(name = "client_partner_id")
    private ClientPartner clientPartner;

    /*@JoinTable(name = "team_member",joinColumns = @JoinColumn(name = "employee_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))*/

    @ManyToMany
    @JoinTable(name = "project_team",
                joinColumns = @JoinColumn(name = "project_id"),
                inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private List<Employee> employees;
}
