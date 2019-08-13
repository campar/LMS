package com.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.model.University;
import com.lms.service.UniversityService;

@RestController
public class UniversityController {
	
	@Autowired
	private UniversityService universityService;
	
	@GetMapping("/university")
	public List<University> getAllUniversity(){
		return universityService.getAllUniversity();
	}
}
