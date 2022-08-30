package com.arnav.StudentInfo.service;

import java.util.List;

import com.arnav.StudentInfo.domain.Course;

public interface CourseService {
	
	List<Course> getAllCourse();
	void saveCourse(Course course);
	Course getCourseById(long id);
	void deleteCourseById(long id);
}
