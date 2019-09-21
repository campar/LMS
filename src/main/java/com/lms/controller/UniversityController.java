package com.lms.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.lms.model.Faculty;
import com.lms.model.University;
import com.lms.service.UniversityService;
import com.lms.utils.View;

@CrossOrigin
@RequestMapping("/api/university")
@RestController
public class UniversityController {

	@Autowired
	private UniversityService universityService;

	@GetMapping("")
	@JsonView(View.UniversityWithFaculties.class)
	public List<University> getAllUniversity() {
		return universityService.getAllUniversity();
	}

	@GetMapping("/{id}")
	@JsonView(View.UniversityWithFaculties.class)
	public University getUniversityById(@PathVariable int id) {
		return universityService.getUniversityById(id);
	}

	@GetMapping("/{id}/faculties")
	@JsonView(View.UniversityWithFaculties.class)
	public Set<Faculty> getFacultiesByUniversityId(@PathVariable int id) {
		return universityService.getFacultiesByUniversityId(id);
	}
}
