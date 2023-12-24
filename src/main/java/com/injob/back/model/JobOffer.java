package com.injob.back.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Table(name = "job_offer")
@Getter
@Setter
public class JobOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(name = "date_publication", nullable = false)
    private LocalDate datePublication;

    @Column(name = "date_cloture")
    private LocalDate  dateCloture;

    @Column(name = "date_debut", nullable = false)
    private LocalDate  dateDebut;
}
