package com.injob.back.controller;

import com.injob.back.dto.JobApplyDto;
import com.injob.back.enums.JobApplyStatusEnum;
import com.injob.back.model.JobApply;
import com.injob.back.roles.hasAdminRole;
import com.injob.back.service.JobApplyService;
import com.injob.back.service.impl.JobApplyServiceImpl;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobapplies")
@AllArgsConstructor
@SecurityRequirement(name = "basicAuth")

public class JobApplyController {
    private final JobApplyServiceImpl jobApplyService;

    @PostMapping("/add/{jobOfferId}")
    public ResponseEntity<JobApplyDto> addJobApply( @PathVariable Long jobOfferId) {
            JobApplyDto addedJobApply = jobApplyService.addJobApply( jobOfferId);
            return new ResponseEntity<>(addedJobApply, HttpStatus.CREATED);

    }
    @PatchMapping("/update-status/{jobApplyId}")
    @hasAdminRole
    public ResponseEntity<JobApplyDto> updateJobApplyStatus(
            @PathVariable Long jobApplyId,
            @RequestParam JobApplyStatusEnum newStatus) {

            JobApplyDto updatedJobApply = jobApplyService.updateJobApplyStatus(jobApplyId, newStatus);
            return ResponseEntity.ok(updatedJobApply);

    }

    @GetMapping("/{jobApplyId}")
    public ResponseEntity<JobApplyDto> getJobApplyById(@PathVariable Long jobApplyId) {

             JobApplyDto jobApplyDto = jobApplyService.getJobApplyById(jobApplyId);
            return new ResponseEntity<>(jobApplyDto, HttpStatus.OK);

    }
    @GetMapping("/all")
    public ResponseEntity<List<JobApplyDto>> getAllJobApplies() {

        List<JobApplyDto> jobApplies = jobApplyService.getAllJobApplies();
        return new ResponseEntity<>(jobApplies, HttpStatus.OK);
    }
}
