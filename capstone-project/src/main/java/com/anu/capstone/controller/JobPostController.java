package com.anu.capstone.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anu.capstone.dto.JobpostingDto;
import com.anu.capstone.service.JobPostingService;
import com.anu.capstone.util.AppResponse;

import lombok.AllArgsConstructor;

@CrossOrigin
@AllArgsConstructor
@RequestMapping(value ="/jobpost")
@RestController
public class JobPostController {
    private final JobPostingService service;

    @CrossOrigin
    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> createNewJob(@RequestBody JobpostingDto jobpostingDto) {
        final Integer sts = service.createNewJob(jobpostingDto);
        final AppResponse<Integer> response = AppResponse.<Integer>builder()
                .sts("success")
                .msg("Job Added Successfully")
                .bd(sts)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @CrossOrigin
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<List<JobpostingDto>>> all() {
        List<JobpostingDto> jobpostingDtos = service.all();

        AppResponse<List<JobpostingDto>> response = AppResponse.<List<JobpostingDto>>builder()
                .sts("success")
                .msg("JobPost")
                .bd(jobpostingDtos)
                .build();

        return ResponseEntity.ok().body(response);
    }

    @CrossOrigin
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> deleteInvoice(@PathVariable Long id) {

        final Integer sts = service.deleteJobPost(id);

        final AppResponse<Integer> response = AppResponse.<Integer>builder()
                .sts("success")
                .msg("Invoice Deleted Successfully")
                .bd(sts)
                .build();

        return ResponseEntity.status(200).body(response);
    }

    @CrossOrigin
    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> updateNewInvoice(@RequestBody JobpostingDto dto) {

        final Integer sts = service.updateJobPost(dto);

        final AppResponse<Integer> response = AppResponse.<Integer>builder()
                .sts("success")
                .msg("Job Updated Successfully")
                .bd(sts)
                .build();

        return ResponseEntity.ok().body(response);
    }
}
