package com.arnav.StudentInfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.arnav.StudentInfo.domain.Course;
import com.arnav.StudentInfo.service.CourseService;

@Controller
public class CourseController {
	
	@Autowired
	private CourseService cservice;
	
	@GetMapping("/course")
	public String viewCoursePage(Model model) {
		model.addAttribute("listcourse", cservice.getAllCourse());
		return "course";
	}
	
	@GetMapping("/showCourseForm")
	public String showCourseForm(Model model) {
		Course course = new Course();
		model.addAttribute("course", course);
		return "new_course";
	}
	
	@PostMapping("/addNewCourse")
	public String addNewCourse(@ModelAttribute("course") Course course) {
		cservice.saveCourse(course);
		return "redirect:/course";
	}
	
	@GetMapping("/showUpdateCourseForm/{id}")
	public String showUpdateCourseForm(@PathVariable (value="id") long id, Model model) {
		Course course = cservice.getCourseById(id);
		model.addAttribute("course", course);
		return "update_course";
	}
	
	@GetMapping("/deleteCourse/{id}")
	public String deleteCourse(@PathVariable (value="id") long id, Model model) {
		this.cservice.deleteCourseById(id);
		return "redirect:/course";
		
	}
	
}
