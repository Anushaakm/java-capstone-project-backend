package com.anu.capstone.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JobApplicationDto {

    private Long id;
    @NotEmpty(message = "jobPostId cant be empty")
    @NotNull(message = "jobPostId cant be null")
    @NotBlank(message = "jobPostId cant be blank")

    private Long jobPostId;
    @NotEmpty(message = "applicantName cant be empty")
    @NotNull(message = "applicantName cant be null")
    @NotBlank(message = "applicantName cant be blank")
    private String applicantName;
    @NotEmpty(message = "applicantEmail cant be empty")
    @NotNull(message = "applicantEmail cant be null")
    @NotBlank(message = "applicantEmail cant be blank")
    private String applicantEmail;
}
