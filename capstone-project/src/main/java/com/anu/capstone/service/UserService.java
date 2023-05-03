package com.anu.capstone.service;

import com.anu.capstone.dto.CreateUserDto;
import com.anu.capstone.dto.LoginDto;
import com.anu.capstone.dto.UserDto;
import com.anu.capstone.exception.UserNotFoundException;

public interface UserService {
    Integer signup(CreateUserDto dto);

    UserDto login(LoginDto dto) throws UserNotFoundException;
}
