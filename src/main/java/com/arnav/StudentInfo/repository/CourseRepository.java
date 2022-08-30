package com.arnav.StudentInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arnav.StudentInfo.domain.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
