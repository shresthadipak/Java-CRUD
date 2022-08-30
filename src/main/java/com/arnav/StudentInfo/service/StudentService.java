package com.arnav.StudentInfo.service;

import java.util.List;

import com.arnav.StudentInfo.domain.Student;


public interface StudentService {
	
	List<Student> getAllStudent();
	void saveStudent(Student student);
	Student getStudentById(long id);
	void deleteStudentById(long id);
}
