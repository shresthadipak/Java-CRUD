package com.arnav.StudentInfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.arnav.StudentInfo.domain.Users;
import com.arnav.StudentInfo.service.RolesService;
import com.arnav.StudentInfo.service.UsersService;

@Controller
public class UsersController {
	
	@Autowired
	private UsersService userService;
	
	@Autowired
	private RolesService rolesService;
	
	@GetMapping("/")
	public String loginPage(Model model) {
		return "loginRegister/login";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		Users users = new Users();
		model.addAttribute("users", users);
		model.addAttribute("listRoles", rolesService.getAllRoles());
		return "loginRegister/register";
	}
	
	@GetMapping("/users")
	public String users(Model model) {
		model.addAttribute("listUsers", userService.getAllUsers());
		return "users/index";
	}
	
	@PostMapping("/addUser")
	public String addUser(@ModelAttribute("user") Users user) {
		userService.saveUser(user);
		return "redirect:/";
	}
	
}
