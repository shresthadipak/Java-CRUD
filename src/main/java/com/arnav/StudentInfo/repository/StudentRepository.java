package com.arnav.StudentInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arnav.StudentInfo.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}

