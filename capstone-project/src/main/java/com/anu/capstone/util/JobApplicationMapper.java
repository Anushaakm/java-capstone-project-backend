package com.anu.capstone.util;

import org.springframework.stereotype.Component;

import com.anu.capstone.domain.JobApplication;
import com.anu.capstone.dto.JobApplicationDto;

@Component
public class JobApplicationMapper {

    public JobApplication toDomain(JobApplicationDto dto) {
        JobApplication jobApplication = new JobApplication();
        jobApplication.setId(dto.getId());
        jobApplication.setApplicantName(dto.getApplicantName());
        jobApplication.setApplicantEmail(dto.getApplicantEmail());
        return jobApplication;
    }

    public JobApplicationDto toDto(JobApplication domain) {
        JobApplicationDto jobApplicationDto = new JobApplicationDto();
        jobApplicationDto.setId(domain.getId());
       // jobApplicationDto.setJobPostId(domain.getJobPostId().getId());
        jobApplicationDto.setApplicantName(domain.getApplicantName());
        jobApplicationDto.setApplicantEmail(domain.getApplicantEmail());
        return jobApplicationDto;
    }
}
