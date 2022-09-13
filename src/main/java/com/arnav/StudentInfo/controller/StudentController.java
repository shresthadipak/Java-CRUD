package com.arnav.StudentInfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.arnav.StudentInfo.domain.Student;
import com.arnav.StudentInfo.service.CourseService;
import com.arnav.StudentInfo.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	public StudentService service;
	
	@Autowired
	public CourseService cservice;
	
	
	@GetMapping("/student")
	public String viewHomePage(Model model) {
		model.addAttribute("liststudent", service.getAllStudent());
		return "student/index";
	}
	

	@GetMapping("/showStudentForm")
	public String showStudentForm(Model model) {
		//create model attribute to bind form data
		Student student = new Student();
		model.addAttribute("student", student);
		model.addAttribute("listCourse", cservice.getAllCourse());
		return "student/add";
	}
	
	@PostMapping("/addNewStudent")
	public String addNewStudent(@ModelAttribute("student") Student student) {
		// save student to database
		service.saveStudent(student);
		return "redirect:/student";
	}
	
	@GetMapping("/showUpdateStudentForm/{id}")
	public String showUpdateStudentForm(@PathVariable (value = "id") long id, Model model) {
		//get student from the service
		Student student = service.getStudentById(id);
		model.addAttribute("student", student);
		model.addAttribute("listCourse", cservice.getAllCourse());
		return "student/edit";
	}
	
	@GetMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable (value = "id") long id, Model model) {
		//get delete student method from service
		this.service.deleteStudentById(id);
		return "redirect:/student";
	}
	
	@GetMapping("/assignCourses/{id}")
	public String assignCourses(@PathVariable (value="id") long id, Model model) {
		Student student = service.getStudentById(id);
		model.addAttribute("student", student);
		model.addAttribute("listCourse", cservice.getAllCourse());
		return "student/courses/assign";
	}
		
}
