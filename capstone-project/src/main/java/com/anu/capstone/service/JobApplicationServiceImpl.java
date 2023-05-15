package com.anu.capstone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anu.capstone.domain.JobApplication;
import com.anu.capstone.dto.JobApplicationDto;
import com.anu.capstone.exception.JobApplicationException;
import com.anu.capstone.repository.JobApplicationRepository;
import com.anu.capstone.util.JobApplicationMapper;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {

    @Autowired
    private JobApplicationRepository jobApplicationRepository;
    
    @Autowired
    private JobApplicationMapper jobApplicationMapper;

    @Override
    public Integer applyJob(JobApplicationDto dto) throws JobApplicationException {
        Long jobPostingId = dto.getJobPostId();
        String candidateEmail = dto.getApplicantEmail();

        JobApplication jobApplication = jobApplicationMapper.toDomain(dto);
        jobApplicationRepository.save(jobApplication);

        return 1;
    }

}
