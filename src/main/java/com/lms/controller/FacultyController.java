package com.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.lms.model.Faculty;
import com.lms.service.FacultyService;
import com.lms.utils.View;

@CrossOrigin
@RestController
@RequestMapping("/faculties")
public class FacultyController {

	@Autowired
	private FacultyService facultyService;

	@GetMapping("/")
	@JsonView(View.Faculty.class)
	public List<Faculty> getAllFaculties() {
		return facultyService.getAllFaculties();
	}

	@JsonView(View.Faculty.class)
	@GetMapping("/{id}")
	public Faculty getFacultyById(@PathVariable int id) {
		return facultyService.findById(id);
	}

}
