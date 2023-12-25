package com.injob.back.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.injob.back.enums.JobApplyStatusEnum;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class JobApplyDto {

    private Long id;
    private JobApplyStatusEnum status= JobApplyStatusEnum.PENDING;
    private String email;
    private String jobDescription;

    @JsonProperty(value = "date_envoi",defaultValue = "2023-12-25T18:14:34.017Z")
    private String dateEnvoi;
}
