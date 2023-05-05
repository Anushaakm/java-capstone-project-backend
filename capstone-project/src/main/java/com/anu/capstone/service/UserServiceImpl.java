package com.anu.capstone.service;

import java.time.LocalDate;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.anu.capstone.domain.User;
import com.anu.capstone.dto.CreateUserDto;
import com.anu.capstone.dto.LoginDto;
import com.anu.capstone.dto.UserDto;
import com.anu.capstone.exception.UserNotFoundException;
import com.anu.capstone.repository.UserRepository;

import lombok.AllArgsConstructor;
@Transactional
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    
    @Override
    public Integer signup(CreateUserDto dto) {
        User user = new User();
        user.setCreated(LocalDate.now());
        BeanUtils.copyProperties(dto, user);
        repository.save(user);
        return 1;
    }

    @Override
    public UserDto login(LoginDto dto) throws UserNotFoundException {
        Optional<User> op = repository.findByUserNameAndPassword(dto.getUserName(), dto.getPassword());
        User user = op.orElseThrow(() -> new UserNotFoundException("User Not Found"));
          
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);

        return userDto;
    }
}
