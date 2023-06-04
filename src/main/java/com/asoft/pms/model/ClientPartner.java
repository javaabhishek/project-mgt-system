package com.asoft.pms.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@Entity
@Table(name="clientPartner")
public class ClientPartner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long id;

    private String clientName;
    private String address;
    private String details;

    @OneToMany(mappedBy = "clientPartner")
    private List<Project> projects;
}
