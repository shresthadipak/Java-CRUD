package com.arnav.StudentInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arnav.StudentInfo.domain.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>  {
	
}
