package com.arnav.StudentInfo.service;

import java.util.List;

import com.arnav.StudentInfo.domain.Teacher;

public interface TeacherService {
	List<Teacher> getAllTeacher();
	void saveTeacher(Teacher teacher);
	Teacher getTeacherById(long id);
	void deleteTeacherById(long id);
}
