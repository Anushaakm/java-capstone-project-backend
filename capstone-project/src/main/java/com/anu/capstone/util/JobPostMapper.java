package com.anu.capstone.util;

import org.springframework.stereotype.Component;

import com.anu.capstone.domain.JobPosting;
import com.anu.capstone.dto.JobpostingDto;

@Component
public class JobPostMapper {
    public JobPosting toDomain(JobpostingDto jobpostingDto){
        return new JobPosting(
            jobpostingDto.getId(),
            jobpostingDto.getJobTitle(),
            jobpostingDto.getJobDescription(),
            jobpostingDto.getLocation(),
            jobpostingDto.getIndustry(),
            jobpostingDto.getQualification(),
            jobpostingDto.getApplicationRequirement(),
            jobpostingDto.getPostedDate()
            );

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
