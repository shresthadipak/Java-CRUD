package com.arnav.StudentInfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.arnav.StudentInfo.service.RolesService;

@Controller
public class RolesController {
	
	@Autowired
	private RolesService rolesService;
	
	@GetMapping("/roles")
	public String roles(Model model) {
		model.addAttribute("listRoles", rolesService.getAllRoles());
		return "roles/index";
	}
}
