package com.injob.back.service.impl;

import com.injob.back.dto.JobApplyDto;
import com.injob.back.enums.JobApplyStatusEnum;
import com.injob.back.mapper.JobApplyMapper;
import com.injob.back.model.JobApply;
import com.injob.back.model.JobOffer;
import com.injob.back.repository.JobApplyRepository;
import com.injob.back.repository.JobOfferRepository;
import com.injob.back.utils.AuthenticationUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class JobApplyServiceImpl {
    private final JobApplyRepository jobApplyRepository;
    private final JobOfferRepository jobOfferRepository;
    private final JobApplyMapper jobApplyMapper;

    public JobApplyDto addJobApply( Long jobOfferId) {
        // Retrieve the corresponding JobOffer
        Optional<JobOffer> optionalJobOffer = jobOfferRepository.findById(jobOfferId);
        if (optionalJobOffer.isPresent()) {
            JobOffer jobOffer = optionalJobOffer.get();
            JobApply jobApply= new  JobApply();
            // Set the JobOffer in the JobApply
            jobApply.setJobOffer(jobOffer);
            jobApply.setStatus(JobApplyStatusEnum.PENDING);
            String jobSeekerEmail = AuthenticationUtils.getEmailFromCurrentAuthentication();
            jobApply.setEmail(jobSeekerEmail);
            jobApply.setDateEnvoi(LocalDateTime.now());
            boolean exist = jobApplyRepository.existsByJobOfferIdAndEmail(jobOfferId,jobSeekerEmail);
            if(exist){
                throw new IllegalArgumentException("You have already applied for the current JobOffer.");

            }
            else {
                return jobApplyMapper.jobApplyToDto(jobApplyRepository.save(jobApply));
            }
            // Save the JobApply
        } else {
            throw new IllegalArgumentException("JobOffer with ID " + jobOfferId + " not found.");
        }
    }
    public JobApplyDto updateJobApplyStatus(Long jobApplyId, JobApplyStatusEnum newStatus) {
        // Retrieve the JobApply from the database
        Optional<JobApply> optionalJobApply = jobApplyRepository.findById(jobApplyId);
        if (optionalJobApply.isPresent()) {
            JobApply jobApply = optionalJobApply.get();

            // Update the status
            jobApply.setStatus(newStatus);

            // Save the updated JobApply
            JobApply updatedJobApply = jobApplyRepository.save(jobApply);

            // Map and return the updated JobApplyDto
            return jobApplyMapper.jobApplyToDto(updatedJobApply);
        } else {
            throw new IllegalArgumentException("JobApply with ID " + jobApplyId + " not found.");
        }
    }

    public JobApplyDto getJobApplyById(Long jobApplyId) {
        Optional<JobApply> optionalJobApply = jobApplyRepository.findById(jobApplyId);
        if (optionalJobApply.isPresent()) {
            JobApply jobApply = optionalJobApply.get();
            return jobApplyMapper.jobApplyToDto(jobApply);
        } else {
            throw new IllegalArgumentException("JobApply with ID " + jobApplyId + " not found.");
        }
    }
    public List<JobApplyDto> getAllJobApplies() {
        List<JobApply> jobApplies = new ArrayList<>();
        if (AuthenticationUtils.isAdmin()){
            jobApplies = jobApplyRepository.findAll();
        }else {
            jobApplies = jobApplyRepository.findByEmail(AuthenticationUtils.getEmailFromCurrentAuthentication());
        }
        return jobApplies.stream()
                .map(jobApplyMapper::jobApplyToDto)
                .collect(Collectors.toList());
    }

}
