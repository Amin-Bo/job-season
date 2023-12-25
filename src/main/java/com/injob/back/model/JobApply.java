package com.injob.back.model;

import com.injob.back.enums.JobApplyStatusEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "job_apply")
@Data
public class JobApply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "job_offer_id", nullable = false)
    private JobOffer jobOffer;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private JobApplyStatusEnum status;

    @Column(nullable = false)
    private String email;

    @Column(name = "date_envoi", nullable = false)
    private LocalDateTime dateEnvoi;
}
