package com.anu.capstone.util;

import org.springframework.stereotype.Component;

import com.anu.capstone.domain.JobPosting;
import com.anu.capstone.dto.JobpostingDto;

@Component
public class JobPostMapper {
    public JobPosting toDomain(JobpostingDto jobpostingDto){
        return new JobPosting(
            jobpostingDto.getId(),
            jobpostingDto.getApplicationRequirement(),
            jobpostingDto.getIndustry(),
            jobpostingDto.getJobDescription(),
            jobpostingDto.getJobTitle(),
            jobpostingDto.getLocation(),
            jobpostingDto.getQualification(),
            jobpostingDto.getPostedDate()
            );

    }
    public JobpostingDto toDto(JobPosting domain){
        return new JobpostingDto(
           domain.getId(),
           domain.getApplicationRequirement(),
           domain.getIndustry(),
           domain.getJobDescription(),
           domain.getJobTitle(),
           domain.getLocation(),
           domain.getQualification(),
           domain.getPostedDate()
            
            );
    }

}
