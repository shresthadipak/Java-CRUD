package com.arnav.StudentInfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arnav.StudentInfo.domain.Users;
import com.arnav.StudentInfo.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersRepository usersrepo;
	
	@Override
	public List<Users> getAllUsers() {
		return usersrepo.findAll();
	}

	@Override
	public void saveUser(Users user) {
		this.usersrepo.save(user);
	}

}
