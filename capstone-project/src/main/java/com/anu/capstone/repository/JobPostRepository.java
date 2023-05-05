package com.anu.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anu.capstone.domain.JobPosting;

public interface JobPostRepository extends JpaRepository<JobPosting,Long> {
    
}
