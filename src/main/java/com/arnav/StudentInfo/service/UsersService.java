package com.arnav.StudentInfo.service;

import java.util.List;

import com.arnav.StudentInfo.domain.Users;

public interface UsersService {
	List<Users> getAllUsers();
	void saveUser(Users user);
}
