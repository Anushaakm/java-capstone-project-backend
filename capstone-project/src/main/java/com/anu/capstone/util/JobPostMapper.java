package com.anu.capstone.util;

import org.springframework.stereotype.Component;

import com.anu.capstone.domain.JobPosting;
import com.anu.capstone.dto.JobpostingDto;

@Component
public class JobPostMapper {
    public JobPosting toDomain(JobpostingDto jobpostingDto){
        

            return JobPosting.builder()
            .id(jobpostingDto.getId())
            .jobTitle(jobpostingDto.getJobTitle())
            .jobDescription(jobpostingDto.getJobDescription())
            .location(jobpostingDto.getLocation())
            .industry(jobpostingDto.getIndustry())
            .qualification(jobpostingDto.getQualification())
            .applicationRequirement(jobpostingDto.getApplicationRequirement())
            .postedDate(jobpostingDto.getPostedDate())
            .build();

    }
    public JobpostingDto toDto(JobPosting domain){
        return new JobpostingDto(
            domain.getId(),
            domain.getJobTitle(),
            domain.getJobDescription(),
            domain.getLocation(),
            domain.getIndustry(),
            domain.getQualification(),
            domain.getApplicationRequirement(),
            domain.getPostedDate()
            
            );
    }

}
