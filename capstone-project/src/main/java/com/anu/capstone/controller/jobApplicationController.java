package com.anu.capstone.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anu.capstone.dto.JobApplicationDto;
import com.anu.capstone.service.JobApplicationService;
import com.anu.capstone.util.AppResponse;

import lombok.AllArgsConstructor;

@CrossOrigin
@AllArgsConstructor
@RequestMapping(value = "/jobapplications")
@RestController
class JobApplicationController {
    private final JobApplicationService service;

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> applyForJob(@RequestBody JobApplicationDto jobApplicationDto) {
       
            final Integer sts = service.applyJob(jobApplicationDto);
            final AppResponse<Integer> response = AppResponse.<Integer>builder()
                    .sts("success")
                    .msg("Job Application Added Successfully")
                    .bd(sts)
                    .build();
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
       
    }

   
}

