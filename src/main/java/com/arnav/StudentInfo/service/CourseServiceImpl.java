package com.arnav.StudentInfo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arnav.StudentInfo.domain.Course;
import com.arnav.StudentInfo.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseRepository crepo;
	
	@Override
	public List<Course> getAllCourse() {
		return crepo.findAll();
	}

	@Override
	public void saveCourse(Course course) {
		this.crepo.save(course);
	}

	@Override
	public Course getCourseById(long id) {
		Optional<Course> optional = crepo.findById(id);
		Course course = null;
		if(optional.isPresent()) {
			course = optional.get();
		}else {
			throw new RuntimeException("Course not found:: "+ id);
		}
		return course;
	}

	@Override
	public void deleteCourseById(long id) {
		this.crepo.deleteById(id);
	}

}
