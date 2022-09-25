package com.arnav.StudentInfo.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.arnav.StudentInfo.domain.Users;
import com.arnav.StudentInfo.web.dto.UserRegistrationDto;

public interface UsersService extends UserDetailsService{
	List<Users> getAllUsers();
	//void saveUser(Users user);
	
	Users save(UserRegistrationDto registrationDto);
}
