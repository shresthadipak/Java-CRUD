package com.arnav.StudentInfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.arnav.StudentInfo.domain.Teacher;
import com.arnav.StudentInfo.service.CourseService;
import com.arnav.StudentInfo.service.TeacherService;

@Controller
public class TeacherController {
	
	@Autowired
	private TeacherService tservice;
	
	@Autowired
	private CourseService cservice;
	
	@GetMapping("/teacher")
	public String viewTeacherMainPage(Model model) {
		model.addAttribute("listteacher", tservice.getAllTeacher());
		return "teacher/index";
	}
	
	@GetMapping("/showTeacherForm")
	public String showTeacherForm(Model model) {
		Teacher teacher = new Teacher();
		model.addAttribute("teacher",teacher);
		model.addAttribute("course", cservice.getAllCourse());
		return "teacher/add";
	}
	
	@PostMapping("/addNewTeacher")
	public String addNewTeacher(@ModelAttribute("teacher") Teacher teacher) {
		tservice.saveTeacher(teacher);
		return "redirect:/teacher";
	}
	
	@GetMapping("/showUpdateTeacherForm/{id}")
	public String showUpdateTeacherForm(@PathVariable(value="id") long id, Model model) {
		Teacher teacher = tservice.getTeacherById(id);
		model.addAttribute("teacher", teacher);
		model.addAttribute("course", cservice.getAllCourse());
		return "teacher/edit";
	}
	
	@GetMapping("/deleteTeacher/{id}")
	public String deleteTeacher(@PathVariable(value="id") long id, Model model) {
		this.tservice.deleteTeacherById(id);
		return "redirect:/teacher";
		
	}
}
