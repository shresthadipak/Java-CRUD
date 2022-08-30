package com.arnav.StudentInfo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arnav.StudentInfo.domain.Teacher;
import com.arnav.StudentInfo.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService{
	
	@Autowired
	private TeacherRepository trepo;
	
	@Override
	public List<Teacher> getAllTeacher() {
		return trepo.findAll();
	}

	@Override
	public void saveTeacher(Teacher teacher) {
		this.trepo.save(teacher);
	}

	@Override
	public Teacher getTeacherById(long id) {
		Optional<Teacher> optional = trepo.findById(id);
		Teacher teacher = null;
		if(optional.isPresent()) {
			teacher = optional.get();
		}else {
			throw new RuntimeException("Teacher not found:: "+id);
		}
		return teacher;
	}

	@Override
	public void deleteTeacherById(long id) {
		this.trepo.deleteById(id);
	}

}
