package com.arnav.StudentInfo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arnav.StudentInfo.domain.Student;
import com.arnav.StudentInfo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository repo;
	
	@Override
	public List<Student> getAllStudent() {
		return repo.findAll();
	}
	
	@Override
	public void saveStudent(Student student) {
		this.repo.save(student);
	}

	@Override
	public Student getStudentById(long id) {
		Optional<Student>  optional = repo.findById(id);
		Student student = null;
		if(optional.isPresent()) {
			student = optional.get();
		}else {
			throw new RuntimeException("Student not found :: "+id);
		}
		return student;
	}
	
	@Override
	public void deleteStudentById(long id) {
		this.repo.deleteById(id);
	}

}
