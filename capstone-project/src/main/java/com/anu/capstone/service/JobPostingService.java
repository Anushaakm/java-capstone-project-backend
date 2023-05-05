package com.anu.capstone.service;

import java.util.List;

import com.anu.capstone.dto.JobpostingDto;
import com.anu.capstone.exception.JobNotFoundException;

public interface JobPostingService {
    Integer createNewJob(JobpostingDto jobpostingDto);
    List<JobpostingDto> all();
    Integer deleteJobPost(Long id) throws JobNotFoundException;
    Integer updateJobPost(JobpostingDto jobpostingDto);
    
}
