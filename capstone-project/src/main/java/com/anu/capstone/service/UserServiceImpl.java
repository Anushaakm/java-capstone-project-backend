package com.anu.capstone.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.anu.capstone.domain.JobPosting;
import com.anu.capstone.domain.User;
import com.anu.capstone.dto.ApplicationDto;
import com.anu.capstone.dto.CreateUserDto;
import com.anu.capstone.dto.LoginDto;
import com.anu.capstone.dto.UserDto;
import com.anu.capstone.exception.JobNotFoundException;
import com.anu.capstone.exception.UserNotFoundException;
import com.anu.capstone.repository.JobPostRepository;
import com.anu.capstone.repository.UserRepository;
import com.anu.capstone.util.DynamicMapper;

import lombok.AllArgsConstructor;
@Transactional
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final JobPostRepository jobPostRepository;
    private final DynamicMapper dynamicMapper;
    
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

    @Override
    public Integer createJobApplication(Long userId, Long jobPostingId) {
        
        User user= repository.findById(userId)
        .orElseThrow(()->new UserNotFoundException("User Not Found "+userId+"ID"));
        
        JobPosting booking=jobPostRepository.findById(jobPostingId)
        .orElseThrow(()->new JobNotFoundException("Job not found"+jobPostingId+"ID"));

        if(booking.getUsers().contains(user))
        throw new UserNotFoundException("already booked");
        booking.getUsers().add(user);
        jobPostRepository.save(booking);
        return 1;
    }

    @Override
    public List<ApplicationDto> getAllApplicattions(Long userId) {
        User user= repository.findById(userId)
        .orElseThrow(()->new UserNotFoundException("User Not Found "+userId+"ID"));
        
        List<ApplicationDto> collect = user.getJobPosting()
        .stream()
        .map(bookings -> dynamicMapper.convertor(bookings, new ApplicationDto()))
        .collect(Collectors.toList());

        if (collect.isEmpty())
        throw new JobNotFoundException("No Jobs found ");

    return collect;
    }

    @Override
    public List<ApplicationDto> getApplicationHistory(Long userId) {
        User user= repository.findById(userId)
        .orElseThrow(()->new UserNotFoundException("User Not Found "+userId+"ID"));
        
        List<ApplicationDto> applicationHistory = user.getJobPosting()
        .stream()
        .map(bookings -> dynamicMapper.convertor(bookings, new ApplicationDto()))
        .collect(Collectors.toList());

        if (applicationHistory.isEmpty())
        throw new JobNotFoundException("No Jobs found ");

        return applicationHistory;

    }
}
