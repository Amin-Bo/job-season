package com.injob.back.service.impl;

import com.injob.back.model.JobOffer;
import com.injob.back.repository.JobOfferRepository;
import com.injob.back.service.JobOfferService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class JobOfferServiceImpl implements JobOfferService {

    private final JobOfferRepository jobOfferRepository;


    public JobOffer addJobOffer(JobOffer jobOffer) {
        return jobOfferRepository.save(jobOffer);
    }

    public List<JobOffer> jobOfferList() {
        return jobOfferRepository.findAll();
    }


}
