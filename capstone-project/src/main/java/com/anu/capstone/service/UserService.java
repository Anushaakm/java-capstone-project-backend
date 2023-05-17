package com.anu.capstone.service;

import java.util.List;

import com.anu.capstone.dto.ApplicationDto;
import com.anu.capstone.dto.CreateUserDto;
import com.anu.capstone.dto.LoginDto;
import com.anu.capstone.dto.UserDto;
import com.anu.capstone.exception.UserNotFoundException;

public interface UserService {
    Integer signup(CreateUserDto dto);

    UserDto login(LoginDto dto) throws UserNotFoundException;

    Integer createJobApplication(Long userId, Long jobPostingId);

    List <ApplicationDto> getAllApplicattions(Long userId);

    List<ApplicationDto> getApplicationHistory(Long userId);
    
    


}
