package com.arnav.StudentInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arnav.StudentInfo.domain.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
	Users findByEmail(String email);
}
