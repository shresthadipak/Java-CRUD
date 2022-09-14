package com.arnav.StudentInfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arnav.StudentInfo.domain.Roles;
import com.arnav.StudentInfo.repository.RolesRepository;

@Service
public class RolesServiceImpl implements RolesService{

	@Autowired
	private RolesRepository rolesrepo;
	
	@Override
	public List<Roles> getAllRoles() {
		return rolesrepo.findAll();
	}

}
