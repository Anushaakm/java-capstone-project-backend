package com.anu.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anu.capstone.domain.JobPosting;
import java.util.List;


public interface JobPostRepository extends JpaRepository<JobPosting,Long> {
    List<JobPosting> findByUsers(Long id);
}
