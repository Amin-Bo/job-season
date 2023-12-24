package com.injob.back.repository;

import com.injob.back.model.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobOfferRepository   extends JpaRepository<JobOffer, Long> {
}
