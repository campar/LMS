package com.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lms.model.Faculty;
import com.lms.service.FacultyService;

@RestController
public class FacultyController {

	@Autowired
	private FacultyService facultyService;

	@GetMapping("/faculties")
	public List<Faculty> getAllFaculties() {
		return facultyService.getAllFaculties();
	}

	@GetMapping("/faculties/{id}")
	public Faculty getFacultyById(@PathVariable int id) {
		return facultyService.findById(id);
	}
}
