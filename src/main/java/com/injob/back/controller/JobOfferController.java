package com.injob.back.controller;

import com.injob.back.model.JobOffer;
import com.injob.back.service.JobOfferService;
import com.injob.back.service.impl.JobOfferServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/joboffers")
public class JobOfferController {
    private final JobOfferServiceImpl jobOfferService;


    @PostMapping
    public ResponseEntity<JobOffer> addJobOffer(@RequestBody JobOffer jobOffer) {
        JobOffer addedJobOffer = jobOfferService.addJobOffer(jobOffer);

        return new ResponseEntity<>(addedJobOffer, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<JobOffer>> JobOffers() {

        List<JobOffer> jobOfferList = jobOfferService.jobOfferList();

        return new ResponseEntity<>(jobOfferList, HttpStatus.OK);
    }
}
